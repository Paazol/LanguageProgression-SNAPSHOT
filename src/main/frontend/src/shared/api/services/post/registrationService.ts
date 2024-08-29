import React from "react";
import Cookies from 'js-cookie';

const registrationService = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const form = e.currentTarget;
    const formData = new FormData(form);

    const username = formData.get("username") as string;
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;
    const levelOfEnglish = formData.get("levelOfEnglish") as string;

    async function getCsrfToken() {
        const response = await fetch('http://localhost:8080/security/csrf-token', {
            method: "GET",
            credentials: 'include'
        });
        if (!response.ok) {
            throw new Error('Failed to fetch CSRF token');
        }
        const csrfToken = await response.json();

        return Cookies.set("X-CSRF-TOKEN", csrfToken.token, { expires: 1 });
    }

    let csrfToken = Cookies.get("X-CSRF-TOKEN") as string;

    if(!csrfToken) {
        csrfToken = await getCsrfToken() as string;
    }

    console.log(csrfToken);
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
        throw new Error(errorResponse.message || 'Registration failed');
    }

    return await response.json();
};

export default registrationService;