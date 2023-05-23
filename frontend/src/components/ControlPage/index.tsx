import { useEffect, useState } from "react";
import Pagination from "./Pagination";
type Props = {
  page: any;
  onChange: Function;
};
const ControlPage = ({ page, onChange }: Props) => {
  const [visible, setVisible] = useState(false);
  useEffect(() => {
    if (page.totalPages > 1) {
      setVisible(true);
    }
    //eslint-disable-next-line react-hooks/exhaustive-deps
  }, [page.totalPages]);
  return <>{visible ? <Pagination page={page} onChange={onChange} /> : ""}</>;
};

export default ControlPage;
