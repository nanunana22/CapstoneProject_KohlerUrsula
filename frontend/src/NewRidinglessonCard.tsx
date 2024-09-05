import {useState} from "react";
import {Ridinglesson} from "./models/Ridinglesson.ts";
import axios from "axios";

type Props = {
    onNewRidinglessonSaved: () => void
}

export default function NewRidinglessonCard(props: Props): JSX.Element {

    const[text, setText ] = useState('');
    function changeText(event: React.ChangeEvent<HTMLInputElement>) {
        setText(event.target.value)
    }

    function saveRidinglesson(){
        axios.post("/api/ridinglessons", {
            ridinginstructor: text,
            ridingtype: text,
            horse: text,
            time: text,
            date: text,
            status: "TO_BOOK"
        } as Ridinglesson)
        .then(props.onNewRidinglessonSaved)
    }
    return(
        <div className="ridinglesson-card new-ridinglesson">
            <input type="text" onInput={changeText}/>
            <button onClick={saveRidinglesson}>save</button>
        </div>
    );
}