import {Ridinglesson} from "../models/Ridinglesson.ts";
import {useState} from "react";
import axios from "axios";

type Props = {
    ridinglesson: Ridinglesson;
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
        const newHorse = event.target.value;
        setHorse(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            horse: newHorse,
        } as Ridinglesson)
    }

    function changeTextInstructor(event: React.ChangeEvent<HTMLSelectElement>) {
        const newInstructor = event.target.value;
        setInstructor(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            ridinginstructor: newInstructor,
        } as Ridinglesson)
    }

    function changeTextRidingtype(event: React.ChangeEvent<HTMLSelectElement>) {
        const newRidingtype = event.target.value;
        setRidingtype(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            ridingtype: newRidingtype,
        } as Ridinglesson)
    }
    function changeTextDate(event: React.ChangeEvent<HTMLSelectElement>) {
        const newDate = event.target.value;
        setDate(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            date: newDate,
        } as Ridinglesson)
    }
    function changeTextTime(event: React.ChangeEvent<HTMLSelectElement>) {
        const newTime = event.target.value;
        setTime(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            time: newTime,
        } as Ridinglesson)
    }
    function changeTextStatus(event: React.ChangeEvent<HTMLSelectElement>) {
        const newStatus = event.target.value;
        setStatus(event.target.value as "TO_CREATE" | "TO_BOOK" | "BOOKED_LESSON")
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            status: newStatus,
        } as Ridinglesson)
    }

    function deleteThisItem(id:string){
        props.deleteData(id)
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
                    <select value={date} onChange={changeTextDate}>
                        <option>01.10.2024</option>
                        <option>02.10.2024</option>
                        <option>03.10.2024</option>
                    </select>
                </li>
                <li>
                    <select value = {time} onChange={changeTextTime}>
                        <option>15:00</option>
                        <option>16:00</option>
                        <option>17:00</option>
                        </select>
                </li>
                <li>
                    <select value={status} onChange={changeTextStatus}>
                        <option value={"TO_CREATE"}>Create</option>
                        <option value={"TO_BOOK"}>Book</option>
                        <option value={"BOOKED_LESSON"}>Booked</option>

                    </select>
                </li>
            </ul>
            <button onClick={() => deleteThisItem(props.ridinglesson.id)}>cancel</button>
        </div>

    );
}