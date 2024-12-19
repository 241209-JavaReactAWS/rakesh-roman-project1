import { Link } from "react-router-dom"
import "./Nav.css"

function Nav() {
  return (
    <div className="menu">
        <Link to="/home">Home</Link>
        <Link to="/create">Create</Link>
        <Link to="/search">Search</Link>
        <Link to="/profile">Profile</Link>
        <Link to="/">Log In</Link>
    </div>
  )
}

export default Nav
