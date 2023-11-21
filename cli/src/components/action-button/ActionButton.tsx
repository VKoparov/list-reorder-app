import './ActionButton.css';
import {ActionButtonProp} from "../../domain/ActionButtonProp.ts";

const ActionButton = (prop: ActionButtonProp) => {
    const data = {
        id: prop.id,
        action: prop.text
    };

    return (
        <button style={{ display: prop.isVisible ? 'block' : 'none' }} type="button" onClick={() => prop.onAction(data)}>{prop.text}</button>
    )
}

export default ActionButton
