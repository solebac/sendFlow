type Props = {
  handleOnClick: Function;
};
const BotaoGerar = ({ handleOnClick }: Props) => {
  return (
    <input
      type="submit"
      value="Gerar Lote"
      className="btn-custom btn-custom--lote"
      onClick={() => handleOnClick()}
    />
  );
};
export default BotaoGerar;
