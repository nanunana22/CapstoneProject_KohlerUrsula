import axios from "axios";
import {useEffect, useState} from "react";

export default function HorseList() {
    const [horses, setHorses] = useState<Horse[]>([]);

    function fetchData() {
        axios.get<Horse[]>('/api/horses')
            .then(response => {
                setHorses(response.data);
            })
            .catch(error => {
                console.error("Es gab einen Fehler beim Abrufen der Daten!", error);
            });
    }

    useEffect(() => {
        fetchData()
    }, []);

    return (
        <div>
            <h2 className="sub-heading">Einkaufsliste</h2>
            <GetHorsesById horses={horses}/>
            <div className="list-card">
                {horses.map(product => (
                    <li key={product.id}>{product.name} - Menge: {product.amount}
                        <ProductCard key={product.id} product={product} fetchData={fetchData()}/>

                    </li>
                ))}
            </div>

        </div>
    );
}

