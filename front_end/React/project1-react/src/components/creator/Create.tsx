import { Link } from 'react-router-dom'
import "./Create.css"

function Create() {
  return (
    <main>
      <br /> <br />
      <h1>Create a Character!</h1>
      <hr />
      <br />
      <div className="infor"> 
        <label> 
            Character: <input type="text" />
        </label>
        <br /> <br />
        <label> 
            Age: <input type="text" />
        </label>
        <br /> <br />
        <label> 
            Description: 
            <br /> <br />
            <textarea name="description" rows={20} cols={70}/>
        </label>
        <br /> <br />
        <label> 
            Setting: <input type="text" />
        </label>
        <br /> <br />
        <label> 
            Private? <input type="checkbox" />
        </label>
        <br /> <br />
        <label> 
            18+? <input type="checkbox" />
        </label>
        <br /> <br />

        {/* TODO: Make a new character with this information and append it to the table */}
        <Link to="/home"><button id="createChar">Create Character!</button></Link>
      </div>
    </main>
  )
}

export default Create
