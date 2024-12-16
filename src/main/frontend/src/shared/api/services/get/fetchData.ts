/**
 * Fetches data from an API based on the provided URL and interface.
 * @param url - The API endpoint URL.
 * @param interfaceType - The interface that defines the structure of the expected data.
 * @returns A promise that resolves to the fetched data, typed according to the provided interface.
 */
export async function fetchData<interfaceType>(url: string): Promise<interfaceType> {
    try {
        // Fetch data from the API
        const response = await fetch(url);

        // Check if the response is successful
        if (!response.ok) {
            throw new Error(`Failed to fetch data: ${response.status} ${response.statusText}`);
        }

        // Parse the JSON response
        const data = await response.json();

        // Type-check the data against the provided interface
        const typedData = data as interfaceType;

        return typedData;
    } catch (error) {
        console.error("Error fetching data:", error);
        throw error;
    }
}
