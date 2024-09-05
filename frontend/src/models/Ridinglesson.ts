import {RidinglessonStatus} from "../RidinglessonStatus.ts";

export type Ridinglesson = {
    id: string,
    ridinginstructor: string,
    ridingtype: string,
    horse: string,
    date: string,
    time: string,
    status: RidinglessonStatus,
}