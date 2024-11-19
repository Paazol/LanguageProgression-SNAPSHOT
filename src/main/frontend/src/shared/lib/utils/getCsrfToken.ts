async function getCsrfToken() {

    const response = fetch('http://localhost:8080/security/csrf-token')
    const csrfToken = (await response).text   
    return csrfToken    
}

export default getCsrfToken;
s
