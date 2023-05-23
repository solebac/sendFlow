export type Sale = {
    id: number;
    sellerName: string;
    visited: number;
    deals: number;
    amount: number;
    date: string;
}

export const ResetSale = {
    id: 0,
    sellerName: "",
    visited: 0,
    deals: 0,
    amount: 0
}