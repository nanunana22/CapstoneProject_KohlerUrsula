import './App.css'
import {Horse} from "./models/Horse.ts";
import HorseCard from "./components/HorseCard.tsx";
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";

export default function App() {

    const [horses, setHorses] = useState<Horse[]>()

    useEffect(
        () => {
        axios.get(`api/horses`)
            .then(response => {
            setHorses(response.data);
        })
        }, []
    )
    if (!horses){
        return "Lade.."
    }
  return (
      <>
          <h1>Riding lesson booking system</h1>
          {
              horses.map(horse=> <HorseCard horse={horse} key={horse.id}/>)

          }

      </>
  )
}


