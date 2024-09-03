import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import RidinglessonColumn from "./RidinglessonColumn.tsx";
import {allPossibleRidinglessons} from "./RidinglessonStatus.ts";
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
    console.log(ridinglessons)
  return (
      <>
          <h1>Riding lesson booking system</h1>
          {
              allPossibleRidinglessons.map(status =>{
                  const filteredRidinglessons : Ridinglesson[] =
                      ridinglessons.filter(ridinglesson => ridinglesson.status === status)
                      return <RidinglessonColumn status={status} ridinglessons={filteredRidinglessons}/>
                  })

          }

          <h2>TO_CREATE</h2>

          <ul>
              {ridinglessons.filter(lesson => lesson.status == "TO_CREATE").map((ridinglesson, index) =>
                  <RidinglessonCard key={ridinglesson.id} ridinglesson={ridinglesson}/>)}
          </ul>
          <h2>TO_BOOK</h2>
          <ul>
              {ridinglessons.filter(lesson => lesson.status == "TO_BOOK").map((ridinglesson, index) =>
                  <RidinglessonCard key={ridinglesson.id} ridinglesson={ridinglesson}/>)}
          </ul>
          <h2>BOOKED_LESSON</h2>
          <ul>
              {ridinglessons.filter(lesson => lesson.status == "BOOKED_LESSON").map((ridinglesson, index) =>
                  <RidinglessonCard key={ridinglesson.id} ridinglesson={ridinglesson}/>)}
          </ul>
      </>
  )
}


