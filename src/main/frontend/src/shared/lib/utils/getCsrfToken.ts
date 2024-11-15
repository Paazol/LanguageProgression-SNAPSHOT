import { useState, useEffect } from "react";

async function getCsrfToken(name: string, url: string) {
    const [csrfToken, setCsrfToken] = useState<string | null>(null)
    useEffect(() => {
        // Fetch CSRF token from the backend
        fetch('http://localhost:8080/security/csrf-token')
            .then(response => response.text())
            .then(token => {
                // Set the fetched token in the state
                setCsrfToken(token);
            })
            .catch(error => {
                console.error('Error fetching CSRF token:', error);
            });
    }, []);
}

export default getCsrfToken;
