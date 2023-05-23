import { Fragment } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

type Props = {
  data: Date;
  setDados: Function;
};

const InputData = ({ data, setDados }: Props) => {
  return (
    <Fragment>
      <DatePicker
        selected={data}
        onChange={(date: Date) => {
          console.log(date);
          setDados(date);
        }}
        className="dsmeta-form-control"
        dateFormat="dd/MM/yyyy"
      />
    </Fragment>
  );
};
export default InputData;
