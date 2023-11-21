export interface ActionButtonProp {
    id: number
    text: string;
    isVisible: boolean;

    onAction: (data: { id: number, action: string }) => void;
}
