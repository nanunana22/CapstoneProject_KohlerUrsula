import {useState} from "react";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import axios from "axios";

type Props = {
    onNewRidinglessonSaved: () => void

}

export default function NewRidinglessonCard(props: Props): JSX.Element {

    const[horse, setHorse ] = useState('');
    function changehorse(event: React.ChangeEvent<HTMLSelectElement>) {
        setHorse(event.target.value)
    }
    const[type, setType ] = useState('');
    function changetype(event: React.ChangeEvent<HTMLSelectElement>) {
        setType(event.target.value)
    }
    const[instructor, setInstructor ] = useState('');
    function changeinstructor(event: React.ChangeEvent<HTMLSelectElement>) {
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
        setHorse("")
        setInstructor("")
        setTime("")
        setDate("")
        setType("")
        axios.post("/api/ridinglessons", {
            horse: horse,
            ridingtype: type,
            ridinginstructor: instructor,
            date:date,
            time:time,
            status: "TO_BOOK"
        } as Ridinglesson)
        .then(props.onNewRidinglessonSaved)
            .then(()=>alert("lesson successfully added"))
            .catch(()=>alert("booking is not possible as the horse has reached the maximum daily contigent"))

    }
    return(
        <div className="ridinglesson-card new-ridinglesson">
                <select value={horse} onChange={changehorse}>
                    <option>Rosi</option>
                    <option>Lui</option>
                    <option>Asmano</option>
                </select>
                <select value={instructor} onChange={changeinstructor}>
                    <option>Stefka</option>
                    <option>Daniela</option>
                    <option>Lena</option>
                </select>
                <select value={type} onChange={changetype}>
                    <option>Dressage</option>
                    <option>Jumping</option>
                    <option>Liberty Dressage</option>
                </select>
                <input type="date" value={date} onInput={changeDate}/>
                <input type="time" value={time} onInput={changeTime}/>
                <button onClick={saveRidinglesson}>save</button>
        </div>
);
}