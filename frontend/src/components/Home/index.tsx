import UI from "../UI";
import transformes from "../../assets/img/transformes.jpeg";

const Home = () => {
  return (
    <>
      <UI>
        <img
          src={transformes}
          alt="Em construção"
          style={{
            position: "relative",
            objectFit: "cover",
            width: "100%",
            height: "400px",
          }}
        />
      </UI>
    </>
  );
};
export default Home;
