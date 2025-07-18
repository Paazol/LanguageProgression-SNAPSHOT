/**
 * Fetches data from an API based on the provided URL and interface.
 * @param url - The API endpoint URL.
 * @param interfaceType - The interface that defines the structure of the expected data.
 * @returns A promise that resolves to the fetched data, typed according to the provided interface.
 * BEFORE CREATING AN INTERFACES PLEASE CHECK FOR THE TYPES IN THE DATABASE
 */
export default async function fetchData<T extends Record<string, never>>(url: string, fields: (keyof T)[]){
    try {
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error(`Failed to fetch data: ${response.status} ${response.statusText} from ${url}`);
        }

        const data: T = await response.json();

        const result: Partial<T> = {};
        fields.forEach((field) => {
            if(field in data){
                result[field] = data[field]
            }
        })

        return result;
    } catch (error) {
        console.error("Error fetching data:", error);
        throw error;
    }
}