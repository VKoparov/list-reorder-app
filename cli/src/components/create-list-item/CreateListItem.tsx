import './CreateListItem.css';
import {useState} from "react";
import {createItems} from "../../services/ItemService.ts";

const CreateListItem = () => {
    const [label, setLabel] = useState<string>('');

    const handleChange = (event: any) => {
        setLabel(event.target.value)
    };

    const handleSubmit = () => {
        createItems(label).then();
    };


    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    Write label:
                    <input type="text" name="name" onChange={handleChange}/>
                </label>
                <button type="submit">Create</button>
            </form>
        </div>
    )
}

export default CreateListItem
