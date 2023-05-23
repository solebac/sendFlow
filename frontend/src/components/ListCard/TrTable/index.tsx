import { Person } from "../../../types/person";
import NotificationButton from "../../NotificationButton";

type Props = {
  person: Person;
};

const TrTable = ({ person }: Props) => {
  return (
    <>
      <tr key={person.id}>
        <td className="show992">#{person.id}</td>
        <td className="show576">{person.nome}</td>
        <td className="show992">{person.cpf}</td>
        <td className="show992">{person.cep}</td>
        <td className="show992">{person.cidade}</td>
        <td className="show992">{person.uf}</td>
        <td className="show992">+{person.ramal00 + person.telefone00}</td>
        <td className="show992">+{person.ramal01 + person.telefone01}</td>
        <td className="show992">+{person.ramal02 + person.telefone02}</td>
        <td>
          <div className="dsmeta-red-btn-container">
            <div className="dsmeta-red-btn">
              <NotificationButton personId={person.id} />
            </div>
          </div>
        </td>
      </tr>
    </>
  );
};

export default TrTable;
