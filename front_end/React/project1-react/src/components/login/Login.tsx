import { Link } from "react-router-dom";
import "./Login.css";
import { SyntheticEvent, useContext, useState } from "react";
import axios from "axios";
import { authContext } from "../../App";


function Login() {

  //Access the information about who is logged in
  const auth = useContext(authContext)

  const [username, setUsername] = useState<string>("")
  const [password, setPassword] = useState<string>("")

  let register = () => {
    //Ensure that neither field is blank
    if(!username){
      alert("Please enter a username")
      return;
    }
    if(!password){
      alert("Please enter a password");
      return;
    }
    //In case of terrible error, try adding this first: , {withCredentials:true}
    axios.post("http://localhost:8080/users/register", 
              {username, password})
              .then((res) => {console.log(res.data)}) 
              .catch((err) => {console.log(err)}) //Print error
  }

  let login = () => {
    //Ensure that neither field is blank
    if(!username){
      alert("Please enter a username")
      return;
    }
    if(!password){
      alert("Please enter a password");
      return;
    }
    //In case of terrible error, try adding this first: , {withCredentials:true}
    axios.post("http://localhost:8080/users/login",
              {username, password}, {withCredentials:true})
              .then((res) => {
                console.log(res.data)
                auth?.setUsername(res.data.username)
                auth?.setRole(res.data.role)
              }) 
              .catch((err) => {console.log(err)}) //Print error
  }

  return (
    <>
      <h1 className="logInBar">Log In</h1>
      <br/> <br/> <br/> <br/>
      <hr/>
      <br/>
      <div className="loggingIn"> 
        <label>{/*Whenever thte text inside the username or password fields change, it will update the state variable*/}
            Username: <input type="text" id="usernameField" value={username} onChange={(e:SyntheticEvent) => {setUsername((e.target as HTMLInputElement).value)}}/>
        </label>
        <br/> <br/>
        <label>
            Password: <input type="text" id="passwordField" value={password} onChange={(e:SyntheticEvent) => {setPassword((e.target as HTMLInputElement).value)}}/>
        </label>
        <br/> <br/>
        {/* TODO: Check username and password in database using a function before redirection */}
        <Link to="/home"><button id="logInUserButton" onClick={login}>Log In</button></Link>
        <Link to="/home"><button id="registerNewUser" onClick={register}>New User</button></Link>
      </div>
    </>
  );
}

export default Login;
