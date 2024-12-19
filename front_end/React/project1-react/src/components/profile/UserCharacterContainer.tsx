import { useState } from "react"
import { OgChar } from "../interfaces/OgChar"


function UserCharacterContainer() {
    const[userCharacters, setUserCharacters] = useState<OgChar[]>([])

  return (
    <div>
      <h1> Your Characters </h1>

    </div>
  )
}

export default UserCharacterContainer
