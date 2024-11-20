import React from "react";
import getCsrfToken from '../../../lib/utils/getCsrfToken'
const registrationService = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const form = e.currentTarget;
    const formData = new FormData(form);

    const username = formData.get("username") as string;
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;
    const levelOfEnglish = formData.get("levelOfEnglish") as string;

    let сsrfToken = await getCsrfToken();
    console.log(сsrfToken);
    const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': сsrfToken,
        },
        body: JSON.stringify({username, email, password, levelOfEnglish})
    });
    console.log(сsrfToken);

    if (!response.ok) {
        const errorResponse = await response.json();
        throw new Error(errorResponse.message || 'Registration failed');
    }
    return await response.json();
    }

export default registrationService;
