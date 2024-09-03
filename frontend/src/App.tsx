import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import RidinglessonColumn from "./RidinglessonColumn.tsx";
import {allPossibleRidinglessons} from "./RidinglessonStatus.ts";


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
              allPossibleRidinglessons.map(status => {
                  const filteredRidinglessons =
                      ridinglessons.filter(ridinglessons => ridinglessons.status === status);
                  return <RidinglessonColumn status={status} ridinglessons={filteredRidinglessons} />})
          }
          </>
  )
}


