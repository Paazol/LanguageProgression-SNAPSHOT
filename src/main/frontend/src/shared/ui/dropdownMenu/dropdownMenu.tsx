import React from "react";

interface dropdownOptions {
    profile: boolean,
    login: boolean,
    home: boolean,
    posts: boolean,
    logout: boolean,
    sessionID: string | null
}

const DropdownMenu: React.FC<dropdownOptions> = ({profile, login, home, posts, logout, sessionID}) => {
    return (
        <div className="menuDIV">
            <button className="menuBUTTON">
                <img src="src\main\frontend\public\General\menu.png"></img>
            </button>
            <div className="dropdownMenu">
                {profile && <a className="dropdownMenuItems" href={"/" + sessionID}>Profile</a>}
                {login && sessionID && (<a className="dropdownMenuItems" href="/login">Login</a>)}
                {home && <a className="dropdownMenuItems" href="/home">Home</a>}
                {posts && sessionID && (<a className="dropdownMenuItems" href={"/" + sessionID + "/posts"}>Posts</a>)}
                {logout && <a className="dropdownMenuItems" href="/logout">Logout</a>}
            </div>
        </div>
    )
}

export default DropdownMenu;