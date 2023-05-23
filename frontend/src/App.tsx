import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import Contact from "./components/Contact";
import Header from "./components/Header";
import Home from "./components/Home";
import ListCard from "./components/ListCard";
import LoadFile from "./components/LoadFile";
import Robots from "./components/Robots";

function App() {
  return (
    <>
      <BrowserRouter>
        <ToastContainer />
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/loadfile" element={<LoadFile />} />
          <Route path="/listclient" element={<Robots />} />
          <Route path="/listcard" element={<ListCard />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

/**
 * 
       
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />

        <Routes />
        <BrowserRouter />
 */
