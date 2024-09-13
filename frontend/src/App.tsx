import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import RidinglessonColumn from "./RidinglessonColumn.tsx";
import {allPossibleRidinglessons} from "./RidinglessonStatus.ts";



export default function App() {

    const [ridinglessons, setRidinglesson] = useState<Ridinglesson[]>()

    function fetchRidinglessons() {
        axios.get(`api/ridinglessons`)
            .then(response => {
                setRidinglesson(response.data);
            })
    }
    function deleteRidinglesson(id: string) {
        axios.delete(`api/ridinglessons/${id}`)
            .then(() => {
                setRidinglesson(ridinglessons?.filter(ridinglesson => ridinglesson.id!== id));

            })
    }
    useEffect(fetchRidinglessons, []);

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
                      return <RidinglessonColumn deleteData={deleteRidinglesson} status={status} ridinglessons={filteredRidinglessons}
                                                 onNewRidinglessonItemSaved={fetchRidinglessons}/>
                  })

          }
      </>
  )
}


