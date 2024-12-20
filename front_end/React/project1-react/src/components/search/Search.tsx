
import "./Search.css";
import { SyntheticEvent, useContext, useState } from "react";
import { authContext } from "../../App";
import { OgChar } from "../interfaces/OgChar";
import axios from "axios";
import { User } from "../interfaces/User";
 
function Search() {

  const auth = useContext(authContext)

  const [userSearchResult, setUserSearchResult] = useState<User[]>([])
  const [charSearchResult, setCharSearchResult] = useState<OgChar[]>([])
  const [searchType, setSearchType] = useState<string>("")
  const [searchText, setSearchText] = useState<string>("")

  let search = () => {
    console.log(searchType)
    console.log(searchText)
    console.log(auth?.role)

    if(searchType == "character")
    {
      //User Search
      axios.get<OgChar[]>(`http://localhost:8080/users/search/character/${searchText}`, {withCredentials:true})
      .then((res) => {
        setCharSearchResult(res.data)
        console.log(res.data)
        console.log(charSearchResult)
      })
    }
    if(searchType == "user")
    {
      axios.get<User[]>(`http://localhost:8080/users/search/user/${searchText}`, {withCredentials:true})
      .then((res) => {
        setUserSearchResult(res.data)
        console.log(res.data)
        console.log(userSearchResult)
      })
    }
  }

  return (
  <>
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
            <button 
              id="doSearch"
              onClick={search}
              >
                Search
            </button>
          <br />
          <br />
        </div>
      </main>
    </div>
      {/*Render the list of returned values*/}
      <div>
      {
        searchType == "user"?
        <table>
        <thead>
          <th>Username</th>
          <th>Account Type</th>
        </thead>
        <tbody>
          {
            userSearchResult.map((result) => {
            return(
                  <tr key={result.userId}>
                    <td>{result.username}</td>
                    <td>{result.accType}</td>
                  </tr>
              )
            })
          }
          </tbody>
        </table>
        :
        <table>
        <thead>
          <th>Name</th>
          <th>Age</th>
          <th>Description</th>
        </thead>
        <tbody>
          {
            charSearchResult.map((result) => {
            return(
                  <tr key={result.characterId}>
                    <td>{result.characterName}</td>
                    <td>{result.characterAge}</td>
                    <td>{result.description}</td>
                  </tr>
              )
            })
          }
          </tbody>
        </table>
      }
      </div>
 </>
);
}

export default Search;
