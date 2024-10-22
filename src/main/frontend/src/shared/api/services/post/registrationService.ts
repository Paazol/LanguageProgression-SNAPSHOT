import React from "react";
import {getCookies} from '../../../lib/utils/getCookies.js'
const registrationService = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const form = e.currentTarget;
    const formData = new FormData(form);

    const username = formData.get("username") as string;
    const email = formData.get("email") as string;
    const password = formData.get("password") as string;
    const levelOfEnglish = formData.get("levelOfEnglish") as string;

    let getCsrfToken = await fetch("http://localhost:8080/security/csrf-token", {
        method: "GET",
        credentials: "include"
    });
   
    
    let csrfToken = await getCookies();
    console.log(csrfToken);
    const response = await fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken.token
        },
        body: JSON.stringify({username, email, password, levelOfEnglish})
    });

    if (!response.ok) {
        const errorResponse = await response.json();
        throw new Error(errorResponse.message || 'Registration failed');
    }
    return await response.json();
    }

export default registrationService;
