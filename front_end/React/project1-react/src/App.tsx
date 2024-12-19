
import "./App.css";
import Nav from "./components/nav/Nav";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/home/Home";
import Footer from "./components/footer/Footer";
import Login from "./components/login/Login";
import Create from "./components/creator/Create";
import Search from "./components/search/Search";
import Profile from "./components/profile/Profile";
import { createContext, useState } from "react";

//This context will store the username and role of someone who is logged in
export interface AuthContextType{
  userId: number,
  setUserId: (userId: number) => void,
  username: string,
  setUsername: (username: string) => void,
  role: "unauthenticated" | "USER" | "ADMIN",
  setRole: (role: "unauthenticated" | "USER" | "ADMIN") => void
}

export const authContext = createContext<AuthContextType | null>(null);

function App() {
  const [userId, setUserId] = useState<number>(0)
  const [username, setUsername] = useState<string>('')
  const [role, setRole] = useState<"unauthenticated" | "USER" | "ADMIN">("unauthenticated")

  return (
    <>
    <authContext.Provider value = 
    {
      {
        userId,
        setUserId,
        username,
        setUsername,
        role,
        setRole
      }
    }>
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
    </authContext.Provider>
    </>
  );
}

export default App;
