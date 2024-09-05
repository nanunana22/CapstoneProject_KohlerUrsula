import {useState} from "react";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import axios from "axios";

type Props = {
    ridinglesson: Ridinglesson;
    onNewRidinglessonSaved: () => void

}

export default function NewRidinglessonCard(props: Props): JSX.Element {

    const[teacher, setTeacher ] = useState('');
    function changeteacher(event: React.ChangeEvent<HTMLInputElement>) {
        setTeacher(event.target.value)
    }
    const[type, setType ] = useState('');
    function changetype(event: React.ChangeEvent<HTMLInputElement>) {
        setType(event.target.value)
    }
    const[instructor, setInstructor ] = useState('');
    function changeinstructor(event: React.ChangeEvent<HTMLInputElement>) {
        setInstructor(event.target.value)
    }
    const[date, setDate ] = useState('');
    function changeDate(event: React.ChangeEvent<HTMLInputElement>) {
        setDate(event.target.value)
    }
    const[time, setTime ] = useState('');
    function changeTime(event: React.ChangeEvent<HTMLInputElement>) {
        setTime(event.target.value)
    }




    function saveRidinglesson(){
        setTeacher("")
        axios.post("/api/ridinglessons", {
            ridinginstructor: teacher,
            ridingtype: type,
            horse: instructor,
            time: date,
            date: time,
            status: "TO_BOOK"
        } as Ridinglesson)
        .then(props.onNewRidinglessonSaved)

    }
    return(
        <div className="ridinglesson-card new-ridinglesson">
            <input type="teacher" onInput={changeteacher}/>
            <input type="type" onInput={changetype}/>
            <input type="instructor" onInput={changeinstructor}/>
            <input type="date" onInput={changeDate}/>
            <input type="time" onInput={changeTime}/>
            <button onClick={saveRidinglesson}>save</button>
        </div>
    );
}