import axios from "axios";
import { useEffect, useState } from "react";
import { Person, PersonDto } from "../../types/person";
import { sleep } from "../../utils/clock";
import { BASE_URL } from "../../utils/request";
import UI from "../UI";

type Dados = {
  nome: string;
  cpf: string;
  cep: string;
  cidade: string;
  uf: string;
  ramal00: string;
  telefone00: string;
  ramal01: string;
  telefone01: string;
  ramal02: string;
  telefone: string;
};

const LoadFile = () => {
  const [registro, setRegistro] = useState(0);
  const [enviado, setEnviado] = useState(0);
  const [rejeitado, setRejeitado] = useState(0);
  const [file, setFile] = useState();
  const [array, setArray] = useState<Person[]>([]);
  const fileReader = new FileReader();

  const csvFileToArray = async (string: string) => {
    const csvHeader = string.slice(0, string.indexOf("\n")).split(";");
    const csvRows = string.slice(string.indexOf("\n") + 1).split("\n");
    var count = 0;
    /**CASE:1 */
    let arrays: Person[] = [];
    //Ponto const sleep
    let registros = 0,
      enviados = 0,
      rejeitados = 0;
    for (const item of csvRows) {
      const values = item.split(";");
      const obj = csvHeader.reduce((object: any, header: any, index: any) => {
        object[header.replace("\r", "")] = values[index].replace("\r", "");
        return object;
      }, {});
      console.log(obj);
      registros++;
      setRegistro(registros);

      await sleep(100);

      if (typeof obj.cpf === "undefined" || obj.nome === "") {
        console.log("Saiu.: ", obj);
        continue;
      }
      const data = obj as Person;
      await axios
        .post(`${BASE_URL}/api/person`, data)
        .then((response) => {
          console.log(response.data);
          enviados++;
          setEnviado(enviados);
        })
        .catch((error) => {
          rejeitados++;
          setRejeitado(rejeitados);
          console.log(error);
        });
      arrays.push(data); //to simulate the behavior of Array.map();
    }
    setArray(arrays);
  };

  const handleChange = (e: any) => {
    setFile(e.target.files[0]);
  };

  const handleSubmit = (e: any) => {
    e.preventDefault();
    if (file) {
      fileReader.onload = function (event: any) {
        const csvOutput = event.target.result;
        csvFileToArray(csvOutput);
      };
      fileReader.readAsText(file);
    }
  };

  const headerKeys = Object.keys(Object.assign({}, ...array));

  useEffect(() => {
    const middle = document.getElementById("controle-middle") as HTMLElement;
    const begin = document.getElementById("controle-begin") as HTMLElement;
    const end = document.getElementById("controle-end") as HTMLElement;

    begin.innerText = registro.toString();
    middle.innerText = enviado.toString();
    end.innerText = rejeitado.toString();
    /*
    const test = axios.get(`${BASE_URL}/api/person`).then((res) => {
      console.log(res.data);
    });*/
  }, [registro, enviado, rejeitado]);

  return (
    <UI>
      <div style={{ textAlign: "center", marginBottom: "2rem" }}>
        <h1 style={{ position: "relative", zIndex: "0" }} className="load-file">
          REACTJS CSV IMPORT EXAMPLE
        </h1>
        <form style={{ position: "relative" }}>
          <input
            type={"file"}
            id={"csvFileInput"}
            accept={".csv"}
            onChange={handleChange}
          />
          <button
            onClick={(e) => {
              console.log("botao", e);
              handleSubmit(e);
            }}
          >
            IMPORT CSV
          </button>
        </form>

        <br />

        <section className="controle">
          <div className="controle-round controle-round--begin">
            <p className="controle-text" id="controle-begin">
              {registro}
            </p>
          </div>
          <div className="controle-round controle-round--middle">
            <p className="controle-text" id="controle-middle">
              {enviado}
            </p>
          </div>
          <div className="controle-round controle-round--end">
            <p className="controle-text" id="controle-end">
              {rejeitado}
            </p>
          </div>
        </section>

        <table>
          <thead>
            <tr key={"header"}>
              {headerKeys.map((key) => (
                <th>{key}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {array.map((item, index) => (
              <tr key={index}>
                {Object.values(item).map((val) => (
                  <td>{val}</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </UI>
  );
};

export default LoadFile;

/** CASE:1 
 * /*const arrays: Dados[] = await Promise.all(
      csvRows.map((i) => {
        const values = i.split(";");
        const obj = csvHeader.reduce((object: any, header: any, index: any) => {
          object[header] = values[index];
          return object;
        }, {});        
        return obj;
      })
    );*/
