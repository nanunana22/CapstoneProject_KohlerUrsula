import './App.css'
import {Horse} from "./models/Horse.ts";
import HorseCard from "./components/HorseCard.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import RidinglessonCard from "./components/RidinglessonCard.tsx";

export default function App() {

    const [ridinglessons, setRidinglesson] = useState<Ridinglesson[]>()

    useEffect(
        () => {
        axios.get(`api/ridinglessons`)
            .then(response => {
            setRidinglesson(response.data);
        })
        }, []
    )
    if (!ridinglessons){
        return "Please wait =)..."
    }
  return (
      <>
          <h1>Riding lesson booking system</h1>
          {
              ridinglessons.map(ridinglesson=> <RidinglessonCard ridinglesson={ridinglesson} key={ridinglesson.id}/>)

          }

      </>
  )
}


