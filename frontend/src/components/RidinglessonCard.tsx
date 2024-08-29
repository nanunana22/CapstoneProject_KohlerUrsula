import {Ridinglesson} from "../models/Ridinglesson.ts"; //rsf



type Props = {
    ridinglesson: Ridinglesson;

}
export default function RidinglessonCard(props: Props) {
    return (
        <div className="ridinglesson-card">
            {props.ridinglesson.horse}
            {props.ridinglesson.ridinginstructor}
            {props.ridinglesson.ridingtype}
            {props.ridinglesson.date}
            {props.ridinglesson.time}

        </div>
    );
}