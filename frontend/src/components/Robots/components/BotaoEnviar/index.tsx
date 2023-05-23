type Props = {
  handleOnClick: Function;
};
const BotaoEnviar = ({ handleOnClick }: Props) => {
  return (
    <input
      type="submit"
      value="Enviar"
      className="btn-custom btn-custom--enviar"
      onClick={() => handleOnClick()}
      style={{ marginTop: "10px" }}
    />
  );
};
export default BotaoEnviar;
