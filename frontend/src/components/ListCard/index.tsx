import { useEffect, useState } from "react";
import "react-datepicker/dist/react-datepicker.css";
import http from "../../utils/http";
import TrTable from "./TrTable";
import UI from "../UI";
import { PersonPage, ResetPersonPage } from "../../types/person";
import ControlPage from "../ControlPage";
import "../ControlPage/style.css";

const ListCard = () => {
  const [line, setLine] = useState<PersonPage>(ResetPersonPage);
  const [pageNumber, setPageNumber] = useState(0);

  const handlerPageNumber = (newPager: number) => {
    setPageNumber(newPager);
  };

  useEffect(() => {
    http
      .get(`/api/person/paginacao?size=6&page=${pageNumber}&sort=id,desc`)
      .then((response) => {
        const data = response.data as PersonPage;
        console.log(data);
        setLine(data);
      });
  }, [pageNumber]);

  return (
    <UI>
      <div className="dsmeta-card">
        <h2 className="dsmeta-sales-title">CRM</h2>
        <div>
          <h3>Cadastro</h3>
        </div>

        <div>
          <table className="dsmeta-sales-table">
            <thead>
              <tr>
                <th className="show992">ID</th>
                <th className="show576">Nome</th>
                <th>CPF</th>
                <th className="show992">CEP</th>
                <th className="show992">Cidade</th>
                <th className="show992">UF</th>
                <th className="show992">Fone01</th>
                <th className="show992">Fone02</th>
                <th className="show992">Fone03</th>
                <th>SMS</th>
              </tr>
            </thead>
            <tbody>
              {line.content.map((pepleo) => {
                return <TrTable key={pepleo.id} person={pepleo} />;
              })}
            </tbody>
          </table>
          <ControlPage page={line} onChange={handlerPageNumber} />
        </div>
      </div>
    </UI>
  );
};
export default ListCard;
