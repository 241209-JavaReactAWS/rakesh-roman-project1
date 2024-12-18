import { Link } from "react-router-dom";
import "./Login.css";
import { SyntheticEvent, useState } from "react";



function Login() {

  const [username, setUsername] = useState<string>("")
  const [password, setPassword] = useState<string>("")

  let login = () => {
    
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
        <Link to="/home"><button id="logInUserButton">Log In</button></Link>
      </div>
    </>
  );
}

export default Login;
