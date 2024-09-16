import RidinglessonCard from "./components/RidinglessonCard.tsx"; //rsf
import {Ridinglesson} from "./models/Ridinglesson.ts";
import {RidinglessonStatus} from "./RidinglessonStatus.ts";
import NewRidinglessonCard from "./NewRidinglessonCard.tsx";

type Props = {
    status: RidinglessonStatus,
    ridinglessons: Ridinglesson[],
    onNewRidinglessonItemSaved: () => void,
    deleteData: (id:string) => void
}

export default function RidinglessonColumn(props: Props) {
    return (
        <div>
            <h2>{props.status}</h2>
        {
            props.ridinglessons.map(ridinglesson => <RidinglessonCard onRidinglessonSaved={props.onNewRidinglessonItemSaved} deleteData={props.deleteData} ridinglesson={ridinglesson} key={ridinglesson.id}/>)

        }
        {
            (props.status === "TO_CREATE") && <NewRidinglessonCard  onNewRidinglessonSaved={props.onNewRidinglessonItemSaved}/>

        }
        </div>
);
}
