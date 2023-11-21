export interface ListItemProp {
    id: number;
    label: string;
    isFirstElement: boolean;
    isLastElement: boolean;

    onChange: (data: ListItemProp[]) => void;
}
