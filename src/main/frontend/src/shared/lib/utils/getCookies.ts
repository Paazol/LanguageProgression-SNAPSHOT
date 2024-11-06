import { json } from "react-router-dom";

async function getCookie(name: string, url: string) {


    fetch(url, {
        method: "GET",
        body: JSON.stringify("token")
    })
}

export default getCookie;
