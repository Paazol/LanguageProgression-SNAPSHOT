async function getCsrfToken() {
    try {
        const response = await fetch("http://localhost:8080/security/csrf-token");
        if (!response.ok) {
            throw new Error("Network response wasn't ok");
        }
        const csrfToken = await response.text();
        return csrfToken || "";
    } catch (error) {
        console.error("Error fetching CSRF token:", error);
        return "";
    }
}

export default getCsrfToken
