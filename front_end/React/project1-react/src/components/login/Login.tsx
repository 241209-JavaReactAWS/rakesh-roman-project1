import { Link } from "react-router-dom";
import "./Login.css";

function Login() {
  return (
    <>
      <h1 className="logInBar">Log In</h1>
      <br /> <br /> <br /> <br />
      <hr />
      <br />
      <div className="loggingIn"> 
        <label>
            Username: <input type="text" id="usernameField" />
        </label>
        <br /> <br />
        <label>
            Password: <input type="text" id="passwordField" />
        </label>
        <br /> <br />
        {/* TODO: Check username and password in database using a function before redirection */}
        <Link to="/home"><button id="logInUserButton">Log In</button></Link>
      </div>
    </>
  );
}

export default Login;
