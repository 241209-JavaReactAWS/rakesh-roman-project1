export interface User{
    userId: number,
    pfp: string,
    username: string,
    password: string,
    matureContentVisible: boolean,
    isBanned: boolean,
    accType: number
}