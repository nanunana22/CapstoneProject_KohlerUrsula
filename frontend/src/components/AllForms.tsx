import {Ridinglesson} from "../models/Ridinglesson.ts";
import RidinglessonColumn from "../RidinglessonColumn.tsx";
import {RidinglessonStatus} from "../RidinglessonStatus.ts";

type AllFormsProps = {
    ridinglessons: Ridinglesson[],
    deleteRidinglesson: (id:string) => void
    fetchRidinglessons: () => void
    allPossibleRidinglessons: RidinglessonStatus[]
}
export default function AllForms({allPossibleRidinglessons, ridinglessons, deleteRidinglesson, fetchRidinglessons}: AllFormsProps){
    return allPossibleRidinglessons.map(status => {
            const filteredRidinglessons: Ridinglesson[] =
                ridinglessons.filter(ridinglesson => ridinglesson.status === status)
            return <RidinglessonColumn deleteData={deleteRidinglesson} status={status}
                                       ridinglessons={filteredRidinglessons}
                                       onNewRidinglessonItemSaved={fetchRidinglessons}/>
        })
}