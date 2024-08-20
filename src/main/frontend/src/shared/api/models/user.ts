export interface User {
    id: bigint;

    followers: number;

    username: string;
    email: string;
    level_of_english: string;

    role: string;
}