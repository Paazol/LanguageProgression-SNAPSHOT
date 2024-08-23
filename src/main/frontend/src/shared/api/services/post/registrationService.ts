import React from "react";

const registrationService = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const form = e.currentTarget;
    const formData = new FormData(form);

    const username = formData.get("username") as string;
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;
    const levelOfEnglish = formData.get("levelOfEnglish") as string;

    async function getCsrfToken() {
        try {
            // Fetch the CSRF token from the server
            const response = await fetch('http://localhost:8080/security/csrf-token', {
                method: "GET"
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const csrfToken = await response.json();
            return csrfToken.token;
        } catch (error) {
            console.error('Error fetching CSRF token:', error);
            throw error;
        }
    }

    try {
        const csrfToken = await getCsrfToken();
        console.log('CSRF Token:', csrfToken);

        const response = await fetch('http://localhost:8080/register', {
            method: 'POST',
            headers: {
                "X-CSRF-TOKEN": csrfToken,
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, email, password, levelOfEnglish })
        });

        if (!response.ok) {
            const errorResponse = await response.json();
            console.error('Registration failed:', errorResponse);
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        console.log('Registration successful:', result);
    } catch (error) {
        console.error('There was an error registering!', error);
    }
};

export default registrationService;