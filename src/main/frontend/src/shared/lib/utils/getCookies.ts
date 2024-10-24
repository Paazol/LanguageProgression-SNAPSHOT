function getCookie(name: string) {
    let value = `; ${document.cookie}`;
    let parts = value.split(`${name}`);
    
    console.log(parts)
    return undefined;
}
export default getCookie
