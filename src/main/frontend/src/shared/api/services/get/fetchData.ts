async function getData<T, jsonNameSet>(url: string, jsonNameSet?: jsonNameSet):Promise<T> {
    const response = await fetch(url);
    const keys = Object.keys(response) as (keyof jsonNameSet)
    return await response.json() as Promise<T>
}