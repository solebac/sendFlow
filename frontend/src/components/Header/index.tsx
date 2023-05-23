import { Link } from "react-router-dom";
import logo from "../../assets/img/logo.svg";
const Header = () => {
  return (
    <header>
      <div className="dsmeta-logo-container">
        <img src={logo} alt="DSMeta" />
        <h1>Send Flow</h1>
        <p>
          Desenvolvido por
          <a
            href="https://www.linkedin.com/in/fl%C3%A1vio-rog%C3%A9rio-722a56159/"
            target="_blank"
            rel="noopener noreferrer"
          >
            {" "}
            @FlavioRogerio
          </a>
        </p>
        <ul className="cabecalho__itens">
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/">
              Home
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/loadfile">
              Load-File
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/listcard">
              CRM
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/listclient">
              Work-Academic
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/contact">
              Contato
            </Link>
          </li>
        </ul>
      </div>
    </header>
  );
};
export default Header;
