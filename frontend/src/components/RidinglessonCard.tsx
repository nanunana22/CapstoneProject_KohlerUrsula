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



    function changeTextHorse(event: React.ChangeEvent<HTMLInputElement>) {
        const newHorse = event.target.value;
        setHorse(event.target.value)
        axios.put("/api/ridinglessons/" + props.ridinglesson.id, {
            ...props.ridinglesson,
            horse: newHorse,
        } as Ridinglesson)
    }
    function changeTextInstructor(event: React.ChangeEvent<HTMLInputElement>){
        setInstructor(event.target.value)
    }

    function changeTextRidingtype(event: React.ChangeEvent<HTMLInputElement>){
        setRidingtype(event.target.value)
    }
    function changeTextDate(event: React.ChangeEvent<HTMLInputElement>){
        setDate(event.target.value)
    }
    function changeTextTime(event: React.ChangeEvent<HTMLInputElement>){
        setTime(event.target.value)
    }
    function changeTextStatus(event: React.ChangeEvent<HTMLInputElement>){
        setStatus(event.target.value)
    }

    function deleteThisItem(id:string){
        props.deleteData(id)
    }

    return (
        <div className="ridinglesson-card">
            <ul>
                <li>
                    <input value ={horse} onInput={changeTextHorse}/>
                </li>
                <li>
                    <input value ={instructor} onInput={changeTextInstructor}/>
                </li>
                <li>
                    <input value = {ridingtype} onInput={changeTextRidingtype}/>
                </li>
                <li>
                    <input value = {date} onInput={changeTextDate}/>
                </li>
                <li>
                    <input value = {time} onInput={changeTextTime}/>
                </li>
                <li>
                    <input value = {status} onInput={changeTextStatus}/>
                </li>
            </ul>
            <button onClick={() => deleteThisItem(props.ridinglesson.id)}>cancel</button>
        </div>

    );
}