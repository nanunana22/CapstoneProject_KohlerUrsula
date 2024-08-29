
import {Horse} from "../models/Horse.ts"; //rsf

type Props = {
    horse: Horse,

}
export default function HorseCard(props: Props) {
    return (
        <div className="horse-card">
            {props.horse.name}
        </div>
    );
}
