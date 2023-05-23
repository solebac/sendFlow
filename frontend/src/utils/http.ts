import axios from "axios";
import { BASE_URL } from "./request";

const http = axios.create({
    baseURL: BASE_URL
});

export default http;

