import {Ridinglesson} from "../models/Ridinglesson.ts"; //rsf



type Props = {
    ridinglesson: Ridinglesson;

}
export default function RidinglessonCard(props: Props) {
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
            </ul>
        </div>
    );
}