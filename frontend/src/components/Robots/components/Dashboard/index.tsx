type Props = {
  register: number;
  send: number;
  reject: number;
};
const Dashboard = ({ register, send, reject }: Props) => {
  return (
    <>
      <div className="dsmeta-card controle" style={{ marginTop: "1rem" }}>
        <div className="controle-round controle-round--begin">
          <p className="controle-text" id="controle-begin">
            {register}
          </p>
        </div>
        <div className="controle-round controle-round--middle">
          <p className="controle-text" id="controle-middle">
            {send}
          </p>
        </div>
        <div className="controle-round controle-round--end">
          <p className="controle-text" id="controle-end">
            {reject}
          </p>
        </div>
      </div>
    </>
  );
};
export default Dashboard;
