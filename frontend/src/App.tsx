import './App.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import RidinglessonColumn from "./RidinglessonColumn.tsx";
import {allPossibleRidinglessons} from "./RidinglessonStatus.ts";
import AllForms from "./components/AllForms.tsx";
import {Route, Routes} from "react-router-dom";
import ProtectedRoute from "./ProtectedRoute.tsx";

export default function App() {

    const [ridinglessons, setRidinglesson] = useState<Ridinglesson[]>()
    const [user, setUser] = useState<string>()

    useEffect(() => {
        getUser()
    }, []);


    function login() {
        const host = window.location.host === 'localhost:5173' ? 'http://localhost:8080': window.location.origin
        window.open(host + '/oauth2/authorization/github', '_self')
    }
    function logout() {
        axios.post("/api/users/logout")
            .then(() => getUser())
    }

    function getUser(){
        axios.get("api/users/me")
            .then((response) => {
                console.log(response.data)
                setUser(response.data)
            })
    }

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

  return (
      <>

          <h1 className={"überschrift"}>Riding lesson booking system</h1>
          <img width={200} src="/src/rosi.jpg" alt={"not found"}/>
          <img width={200} src="/src/lui.jpg" alt={"not found"}/>
          <img width={200} src="/src/Asmano.jpg" alt={"not found"}/>
          <button className={"mybutton"} role={"button"} onClick={login}>Login</button>
          <button className={"mybutton"} role={"button"} onClick={getUser}>Me</button>
          <button className={"mybutton"} role={"button"} onClick={logout}>Logout</button>


          <p>{user}</p>
          <Routes>
              <Route element={<ProtectedRoute user={user}/>}>
                  <Route path={"/"}
                         element={<AllForms allPossibleRidinglessons={allPossibleRidinglessons} ridinglessons=
                             {ridinglessons} deleteRidinglesson={deleteRidinglesson}
                                            fetchRidinglessons={fetchRidinglessons}/>}/>
              </Route>
          </Routes>


      </>
  )
}


