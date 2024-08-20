const url = "http://localhost:8080/getHomeData";

fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        const userID = data.userID; // Extract the userID from the JSON data
        console.log('User ID:', userID);
    })
    .catch(error => {
        console.error('Error:', error);
    });