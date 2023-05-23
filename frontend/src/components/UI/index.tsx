interface AuxProps {
  children: JSX.Element[] | JSX.Element;
}
const UI = ({ children }: AuxProps) => {
  return (
    <>
      <main>
        <section id="sales">
          <div className="dsmeta-container">{children}</div>
        </section>
      </main>
    </>
  );
};

export default UI;
