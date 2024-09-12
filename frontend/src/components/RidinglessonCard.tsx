import {Ridinglesson} from "../models/Ridinglesson.ts";
import {useState} from "react";
import axios from "axios";
import {allPossibleRidinglessons} from "../RidinglessonStatus.ts";

type Props = {
    ridinglesson: Ridinglesson;
    onRidinglessonSaved: () => void;
    deleteData: (id:string) => void;
}

export default function RidinglessonCard(props: Props) {

    const [horse, setHorse] = useState(props.ridinglesson.horse)
    const [instructor, setInstructor] = useState(props.ridinglesson.ridinginstructor)
    const [ridingtype, setRidingtype] = useState(props.ridinglesson.ridingtype)
    const [date, setDate] = useState(props.ridinglesson.date)
    const [time, setTime] = useState(props.ridinglesson.time)
    const [status, setStatus] = useState(props.ridinglesson.status)



    function changeTextHorse(event: React.ChangeEvent<HTMLSelectElement>) {
        setHorse(event.target.value)
    }

    function changeTextInstructor(event: React.ChangeEvent<HTMLSelectElement>) {
        setInstructor(event.target.value)
    }

    function changeTextRidingtype(event: React.ChangeEvent<HTMLSelectElement>) {
        setRidingtype(event.target.value)
    }
    function changeTextDate(event: React.ChangeEvent<HTMLInputElement>) {
        setDate(event.target.value)
    }
    function changeTextTime(event: React.ChangeEvent<HTMLInputElement>) {
        setTime(event.target.value)
    }
    function changeTextStatus() {
        setStatus("BOOKED_LESSON")
        console.log(status);
    }

    function deleteThisItem(id:string){
        props.deleteData(id)
    }

    function saveupdate(){
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            horse: horse,
            ridingtype: ridingtype,
            ridinginstructor: instructor,
            date: date,
            time: time,
            status: status,
        } as Ridinglesson)
            .then(props.onRidinglessonSaved)

    }

    function booklesson(){
        changeTextStatus()
        alert("booking succeed");
    }

    return (
        <div className="ridinglesson-card">
            <ul>
                <li>
                    <select value={horse} onChange={changeTextHorse}>
                        <option>Quini</option>
                        <option>Lui</option>
                        <option>Asmano</option>
                    </select>
                </li>
                <li>
                    <select value={instructor} onChange={changeTextInstructor}>
                        <option>Stefka</option>
                        <option>Daniela</option>
                        <option>Lena</option>
                    </select>
                </li>
                <li>
                    <select value={ridingtype} onChange={changeTextRidingtype}>
                        <option>Dressage</option>
                        <option>Jumping</option>
                        <option>Liberty Dressage</option>
                    </select>
                </li>
                <li>
                    <input type="date" value={date} onChange={changeTextDate}/>
                </li>
                <li>
                    <input type="time" value={time} onChange={changeTextTime}/>
                </li>
            </ul>
            <button onClick={() => deleteThisItem(props.ridinglesson.id)}>cancel</button>
            <button onClick={saveupdate}>update</button>
            <button onClick={booklesson}>book lesson</button>
        </div>

    );
}
