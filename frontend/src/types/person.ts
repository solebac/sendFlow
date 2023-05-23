export type Person = {
    id: number;
    nome: string;
    cpf: string;
    cep: string;
    cidade: string;
    uf: string;
    ramal00: string;
    telefone00: string;
    ramal01: string;
    telefone01: string;
    ramal02: string;
    telefone02: string;
}
export type PersonPage = {
    content: Person[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}
export type PersonDto = {
    id: number;
    nome: string;
    cpf: string;
    cep: string;
    cidade: string;
    uf: string;
    ramal00: string;
    telefone00: string;
    ramal01: string;
    telefone01: string;
    ramal02: string;
    telefone02: string;
}

export type PersonMinDto = {
    id: number
}

export type ResetPersonDto = {
    id: 0;
    nome: "";
    cpf: "";
    cep: "";
    cidade: "";
    uf: "";
    ramal00: "";
    telefone00: "";
    ramal01: "";
    telefone01: "";
    ramal02: "";
    telefone02: "";
}
export const ResetPersonPage = {
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 10,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
}