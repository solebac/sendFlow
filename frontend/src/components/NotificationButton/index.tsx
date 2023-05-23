import { toast } from "react-toastify";
import icon from "../../assets/img/notification-icon.svg";
import http from "../../utils/http";

type Props = {
  personId: number;
};

const NotificationButton = ({ personId }: Props) => {
  const handleClick = (id: number) => {
    http(`/person/${id}/notification`).then((response) => {
      toast.info("SMS enviado com sucesso...");
    });
  };
  return (
    <>
      <div className="dsmeta-red-btn" onClick={() => handleClick(personId)}>
        <img src={icon} alt="Notificar" />
      </div>
    </>
  );
};
export default NotificationButton;
