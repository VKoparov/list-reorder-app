import './ListItem.css';
import {ListItemProp} from "../../domain/ListItemProp.ts";
import ActionButton from "../action-button/ActionButton.tsx";
import {ActionButtonType} from "../../domain/ActionButtonType.ts";
import {moveItem} from "../../services/ItemService.ts";

const ListItem = (prop: ListItemProp) => {
    const handleAction = (data: { id: number, action: string }) => {
        moveItem(data).then((res: any) => {
            prop.onChange(res.data)
        });
    };

    return (
        <div className="list-item-container">
            <div className="label">{prop.label}</div>
            <div className="action-buttons-container">
                <ActionButton
                    id={prop.id}
                    text={ActionButtonType.UP}
                    isVisible={prop.isFirstElement || !prop.isLastElement}
                    onAction={handleAction}>
                </ActionButton>
                <ActionButton
                    id={prop.id}
                    text={ActionButtonType.DOWN}
                    isVisible={!prop.isFirstElement || prop.isLastElement}
                    onAction={handleAction}>
                </ActionButton>
            </div>
        </div>
    )
}

export default ListItem
