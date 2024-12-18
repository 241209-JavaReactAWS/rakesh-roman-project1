import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Nav from "./components/nav/Nav";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/home/Home";
import Footer from "./components/footer/Footer";
import Login from "./components/login/Login";
import Create from "./components/creator/Create";
import Search from "./components/search/Search";
import Profile from "./components/profile/Profile";

function App() {

  return (
    <>
      <BrowserRouter>
        <Nav></Nav>

        <Routes>
          <Route path="/" element={<Login></Login>}></Route>
          <Route path="/home" element={<Home></Home>}></Route>
          <Route path="create" element={<Create></Create>}></Route>
          <Route path="search" element={<Search></Search>}></Route>
          <Route path="profile" element={<Profile></Profile>}></Route>
        </Routes>
      </BrowserRouter>

      <Footer></Footer>
    </>
  );
}

export default App;
