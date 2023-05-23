import { useEffect, useState } from "react";
import "react-datepicker/dist/react-datepicker.css";
import http from "../../utils/http";
import UI from "../UI";
import "../../assets/css/contato.css";
import BotaoEnviar from "./components/BotaoEnviar";
import BotaoGerar from "./components/BotaoGerar";
import axios from "axios";
import { BASE_URL } from "../../utils/request";
import { Person } from "../../types/person";
import Dashboard from "./components/Dashboard";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { sleep } from "../../utils/clock";

const Robots = () => {
  const [registro, setRegistro] = useState(0);
  const [enviado, setEnviado] = useState(0);
  const [rejeitado, setRejeitado] = useState(0);
  const [visible, setVisible] = useState(false);
  const [selectCity, setSelectCity] = useState("");
  const [city, setCity] = useState([{ cidade: "", contador: "" }]);
  const [lote, setLote] = useState(0);
  const [register, setRegister] = useState(0);
  const [person, setPerson] = useState<Person[]>([]);
  const [file, setFile] = useState();
  const [mensagem, setMensagem] = useState("");
  const notify = () => toast("Wow so easy!");
  const handleChange = (e: any) => {
    setFile(e.target.files[0]);
  };

  const handleGerarLote = () => {
    if (!(lote === 0)) {
      return;
    }
    toast.success("Gera lote...");
    setLote(1); //test
  };
  const handleSendMensagem = async () => {
    const textmsg = document.getElementById("mensagem")!;
    const optioncity = document.getElementById("optioncity")!;

    //Test console.log("Dados-Person", person);
    //Test console.log("Envio-Msg", mensagem);

    if (person.length > 0) {
      if (mensagem.length === 0) {
        toast.error("Nenhum mensagem capiturada para o envio da mensagem.");
        return;
      }
      let registros = 0;
      let enviados = 0;
      let rejeitados = 0;

      toast.info("Favor não interromper o procedimento...");
      //Close elements
      optioncity.setAttribute("disabled", "");
      textmsg.setAttribute("readonly", "true");

      for (const array_person of person) {
        await sleep(1000);

        await axios
          .get(
            `${BASE_URL}/api/person/whatsapp?personId=${array_person.id}&strMsg=${mensagem}`
          )
          .then((response) => {
            registros++;
            setRegistro(registros);

            console.log("Send.: ", response.data);
            //Test.: toast.info("SMS Enviando dados...");

            enviados++;
            setEnviado(enviados);
          })
          .catch((error) => {
            console.log("Erro.: ", error.data);
            const errado = "Erro .: " + array_person.nome;
            toast.error(errado);
            rejeitados++;
            setRejeitado(rejeitados);
          });
      }

      optioncity.removeAttribute("disabled");
      textmsg.removeAttribute("readonly");
      toast.success("Finalizado com sucesso...");
    } else {
      toast.error("Erro não há dados a enviar...");
    }
  };

  const handleCaptureMsg = (e: any) => {
    const msg = e.target.value;
    setMensagem(msg);
  };

  useEffect(() => {
    if (lote !== 0) {
      setVisible(true);
    }
    if (!visible) {
      axios.get(`${BASE_URL}/api/person/selectcity`).then((res) => {
        //select cidade, count(*)  from tb_pessoas where trim(cidade) not in('') group by cidade having count(*) > 1 order by cidade;
        setCity(res.data);
      });
      axios.get(`${BASE_URL}/api/person/count`).then((res) => {
        setRegister(res.data);
      });
      if (selectCity === "") {
        http.get(`/api/person/`).then((response) => {
          //test.:http.get(`/api/person/limit`).then((response) => {
          const data = response.data;
          setPerson(data);
          console.log("Person", data);
        });
      } else {
        http.get(`/api/person/city?town=${selectCity}`).then((response) => {
          const data = response.data;
          setPerson(data);
          console.log("Person-City", data);
        });
      }
    }
  }, [lote, visible, selectCity, registro, enviado, rejeitado]);

  return (
    <UI>
      {/*<button onClick={notify}>Notify!</button>*/}
      <div className="dsmeta-card">
        <h2 className="dsmeta-sales-title">Dashboard</h2>
        <div style={{ display: "flex" }}>
          <div style={{ width: "50%" }}>
            <h1>Total de registros.: {register}</h1>
          </div>
          <div
            style={{ width: "50%", textAlign: "right", marginRight: "10px" }}
          >
            <h1>Lote.: {lote}</h1>
          </div>
        </div>
      </div>
      <br />
      <div className="dsmeta-card">
        <h2 className="dsmeta-sales-title">Cidade</h2>
        <select
          id="optioncity"
          className="contato__form--input-padrao"
          onChange={(e) => {
            setSelectCity(e.target.value);
          }}
        >
          <option value="">Todas</option>
          {city.map((item, index) => {
            return (
              <option key={index} value={item.cidade}>
                {item.cidade} - [ {item.contador} ]
              </option>
            );
          })}
        </select>
        <h2 className="dsmeta-sales-title">Mensagem</h2>
        <textarea
          name="mensagem"
          id="mensagem"
          rows={6}
          className="contato__form--input-padrao"
          onChange={handleCaptureMsg}
        ></textarea>

        <input
          type={"file"}
          id={"csvFileInput"}
          accept={".png"}
          className="contato__form--input-padrao"
          onChange={handleChange}
        />

        <BotaoGerar handleOnClick={handleGerarLote} />
        {visible ? <BotaoEnviar handleOnClick={handleSendMensagem} /> : ""}
      </div>
      <Dashboard register={registro} send={enviado} reject={rejeitado} />
    </UI>
  );
};
export default Robots;
