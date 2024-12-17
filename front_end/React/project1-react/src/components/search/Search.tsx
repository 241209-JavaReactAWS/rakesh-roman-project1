import { Link } from "react-router-dom";
import "./Search.css";

function Search() {
  return (
    <div>
      <main>
        <br /> <br />
        <h1>Search</h1>
        <hr />
        <br />
        <div className="infor">
          <div className="checkboxes">
            <div>
              <label style={{color: "red"}}>Search for Character</label>
              <input id="characterSearchInput" type="checkbox" />
            </div>
            <div>
              <label>Search for User</label>
              <input id="userSearchInput" type="checkbox" />
            </div>
          </div>
          <br />
          <br />
          <label>
            Name: <input type="text" />
          </label>
          <br /> <br />
          {/* TODO: Search for Character (or User) in Character table (or User Table) depending on criteria */}
          <Link to="/home">
            <button id="createChar">Search</button>
          </Link>
          <br />
          <br />
        </div>
      </main>
    </div>
  );
}

export default Search;
