import RidinglessonCard from "./components/RidinglessonCard.tsx"; //rsf
import {Ridinglesson} from "./models/Ridinglesson.ts";
import {RidinglessonStatus} from "./RidinglessonStatus.ts";

type Props = {
    status: RidinglessonStatus,
    ridinglessons: Ridinglesson[]
}

export default function RidinglessonColumn(props: Props) {
    return (
        <div>
            <h2>{props.status}</h2>
    {
        props.ridinglessons.map(ridinglesson => <RidinglessonCard ridinglesson={ridinglesson} key={ridinglesson.id}/>)

    }
        </div>
);
}
