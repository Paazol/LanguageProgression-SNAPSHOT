function getCookie(name: string): string | undefined  {
    let value = `; ${document.cookie}`;
    console.log(document.cookie);
    let parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop()?.split(';').shift();
    return undefined;   
}
export default getCookie
