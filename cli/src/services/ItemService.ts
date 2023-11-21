import axios from "axios";
import {ListItemProp} from "../domain/ListItemProp.ts";

export const getItems = (): Promise<ListItemProp[]> => {
    return axios.get(`http://localhost:8080/v1/items`);
}

export const createItems = (data: string): Promise<unknown> => {
    return axios.post(`http://localhost:8080/v1/items`, { label: data });
}

export const moveItem = (data: { id: number, action: string }): Promise<unknown> => {
    return axios.put(`http://localhost:8080/v1/items`, data);
}
