const registrationService = async (username: string, email: string, password: string, levelOfEnglish: string) => {
    try {
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, email, password, levelOfEnglish }),
        });
        const result = await response.json();
        console.log(result);
    } catch (error) {
        console.error('There was an error logging in!', error);
    }
};

export default registrationService;