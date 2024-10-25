export default async function getCookie(name: string, url: string): string | null {
    let result = await fetch("url", {
        method: "POST",
        credentials: "include"
    });
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop()?.split(';').shift() || null;
    return result;
}
