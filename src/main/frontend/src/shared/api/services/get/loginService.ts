import React from "react";
import getCsrfToken from "../../../lib/utils/getCsrfToken"
const loginService = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const form = e.currentTarget;
    const formData = new FormData(form);

    const username = formData.get("username") as string;
    const password = formData.get("password") as string;

    let сsrfToken = await getCsrfToken();

    const response = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "X-CSRF-TOKEN": сsrfToken,
        },
        body: JSON.stringify({username, password})
    });
    console.log(сsrfToken);

    if (!response.ok) {
        const errorResponse = await response.json();
        throw new Error(errorResponse.message || "Registration failed");
    }
    
    return await response.json();
    }

export default loginService;
