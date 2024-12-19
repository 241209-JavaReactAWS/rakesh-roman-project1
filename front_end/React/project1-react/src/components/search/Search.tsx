import { Link } from "react-router-dom";
import "./Search.css";
import { SyntheticEvent, useContext, useState } from "react";
import { authContext } from "../../App";

function Search() {

  const auth = useContext(authContext)

  const [searchType, setSearchType] = useState<string>("")
  const [searchText, setSearchText] = useState<string>("")

  let search = () => {
    console.log(searchType)
    console.log(searchText)

    auth?.role == "ADMIN" ?
    console.log("admin search")
    :
    console.log("something went wrong")
  }

  return (
    <div>
      <main>
        <br /> <br />
        <h1>Search</h1>
        <hr />
        <br />
        <div className="infor">
          <div className="searchTypeSelector">
            {/* TODO: Make checkboxes next to each other and with some spacing between them*/}
            <div>
              <input 
                id="characterSearchInput" 
                type="radio" 
                name="searchType" 
                value="character"
                onClick={(e:SyntheticEvent) => {setSearchType((e.target as HTMLInputElement).value)}}
                />
              <label htmlFor="userSearchInput">Search for Character</label> <br/>
              <input 
                id="userSearchInput" 
                type="radio" 
                name="searchType" 
                value="user"
                onClick={(e:SyntheticEvent) => {setSearchType((e.target as HTMLInputElement).value)}}
                />
              <label htmlFor="userSearchInput">Search for User</label>
            </div>
          </div>
          <br />
          <br />
            <label>
              Search: 
              <input 
                id="searchTextInput"
                type="text"
                value={searchText}
                onChange={(e:SyntheticEvent) => { setSearchText((e.target as HTMLInputElement).value)}}
                />
            </label>
          <br /> <br />
          {/* TODO: Search for Character (or User) in Character table (or User Table) depending on criteria */}
          <Link to="/home">
            <button 
              id="doSearch"
              onClick={search}
              >
                Search
            </button>
          </Link>
          <br />
          <br />
        </div>
      </main>
    </div>
  );
}

export default Search;
