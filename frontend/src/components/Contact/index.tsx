import simpsons from "../../assets/img/images.jpeg";
import UI from "../UI";

const Contact = () => {
  return (
    <>
      <UI>
        <div style={{ textAlign: "center" }}>
          <h1 style={{ marginBottom: "15px" }}>
            <a
              href="https://araxaprojetosweb.com.br/portifolio"
              target="_blank"
              rel="noopener noreferrer"
            >
              SOBRE MIM
            </a>
          </h1>
          <a
            href="https://araxaprojetosweb.com.br/portifolio"
            target="_blank"
            rel="noopener noreferrer"
          >
            <img src={simpsons} alt="" style={{ minWidth: "380px" }} />
          </a>
        </div>
      </UI>
    </>
  );
};
export default Contact;
