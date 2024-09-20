import {Ridinglesson} from "../models/Ridinglesson.ts";
import RidinglessonColumn from "../RidinglessonColumn.tsx";

export default function AllForms({allPossibleRidinglessons, ridinglessons, deleteRidinglesson, fetchRidinglessons}){
    return allPossibleRidinglessons.map(status => {
            const filteredRidinglessons: Ridinglesson[] =
                ridinglessons.filter(ridinglesson => ridinglesson.status === status)
            return <RidinglessonColumn deleteData={deleteRidinglesson} status={status}
                                       ridinglessons={filteredRidinglessons}
                                       onNewRidinglessonItemSaved={fetchRidinglessons}/>
        })
}