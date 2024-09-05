import {Ridinglesson} from "../models/Ridinglesson.ts";

type Props = {
    ridinglesson: Ridinglesson;
    deleteData: (id:string) => void;
}


export default function RidinglessonCard(props: Props) {
    function deleteThisItem(id:string){
        props.deleteData(id)
    }
    return (
        <div className="ridinglesson-card">
            <ul>
                <li>
                    {props.ridinglesson.horse}
                </li>
                <li>
                    {props.ridinglesson.ridinginstructor}
                </li>
                <li>
                    {props.ridinglesson.ridingtype}
                </li>
                <li>
                    {props.ridinglesson.date}
                </li>
                <li>
                    {props.ridinglesson.time}
                </li>
                <li>
                    {props.ridinglesson.status}
                </li>
            </ul>
            <button onClick={() => deleteThisItem(props.ridinglesson.id)}>cancel</button>
        </div>

    );
}