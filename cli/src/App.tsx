import './App.css'
import {useCallback, useEffect, useState} from "react";
import {getItems} from "./services/ItemService.ts";
import {ListItemProp} from "./domain/ListItemProp.ts";
import ListItem from "./components/list-item/ListItem.tsx";
import CreateListItem from "./components/create-list-item/CreateListItem.tsx";

const App = () => {
    const [listItem, setListItem] = useState<ListItemProp[]>([]);

    useEffect(() => {
        getItems().then((res: any[]) => {
            setListItem(res.data);
        });
    }, []);

    const handleCallback = useCallback((data: ListItemProp[]) => {
        setListItem(data);
    }, []);

    const items = listItem.map((item, index) => {
        const isFirstElement = index > 0 && index < listItem.length;
        const isLastElement = index >= 0 && index < listItem.length - 1;

        return <ListItem key={item.id} id={item.id} label={item.label} isFirstElement={isFirstElement} isLastElement={isLastElement} onChange={handleCallback}/>;
    });

    return (
        <>
            <div className="app-container">{items}</div>
            <CreateListItem></CreateListItem>
        </>
    )
}

export default App
