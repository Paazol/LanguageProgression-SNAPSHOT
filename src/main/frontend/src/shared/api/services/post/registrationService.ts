import React from "react";

const registrationService = async (e: React.FormEvent<HTMLFormElement>) => {

    e.preventDefault()

    const form = e.currentTarget
    const formData = new FormData(form)

    const username = formData.get("username") as string
    const email = formData.get("email") as string
    const password = formData.get("password") as string
    const levelOfEnglish = formData.get("levelOfEnglish") as string

    async function getCsrfToken() {
        const response = await fetch('http://localhost:8080/security/csrf-token', {
                method: "GET"
            })
        ;
        const csrfToken = await response.json();
        return csrfToken.token;
    }

    try {
        const csrfToken = await getCsrfToken()
        console.log(csrfToken)
        const response = await fetch('http://localhost:8080/register', {
            method: 'POST',
            headers: {
                "X-CSRF-TOKEN": csrfToken,
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, email, password, levelOfEnglish })
        });
        const result = await response.json();

        console.log(result);
    } catch (error) {
        console.error('There was an error logging in!', error);
    }
};

export default registrationService;