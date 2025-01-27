import React from "react";
import DropdownMenu from "../../shared/ui/dropdownMenu/dropdownMenu";
import { User } from "../../shared/api/models/user";
import { Post } from "../../shared/api/models/post";
import { Avatar } from "../../shared/api/models/avatar.ts";
import { Session } from "../../shared/api/models/session.ts";
import fetchData from "../../shared/api/services/get/fetchData.ts";


interface homeData {
    avatarById: Post[],
    avatar: Avatar,
    user: User,
    session: Session
}

const fields: (keyof homeData)[] = ["avatarById", "avatar", "user", "session"]

const data = await fetchData("http://localhost:8080/getHomeData", fields);

const Profile: React.FC = () => {
    return (
<>
    <meta charSet="utf-8"/>
    <title>Profile</title>
    <link
        rel="stylesheet"
        type="text/css"
        href="/src/main/frontend/src/css/generic.css"/>
    <link
        rel="stylesheet"
        type="text/css"
        href="/src/main/frontend/src/css/profile.css"/>
    <link rel="icon" href="data:,"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
    <script src="/src/main/frontend/src/js/dropDownBUTTON.js"></script>
    <script src = "/src/main/frontend/src/js/following.js"></script>
    <script src="/src/main/frontend/src/js/cropper.js"></script>

    <div>
        <DropdownMenu
        profile={true}
        login={true}
        home={true}
        posts={true}
        logout={true}
        sessionID={data.session.id} />
    </div>

    <div className="background"></div> 
    <div className="profileDIV">
        <div className="profileBackground"></div>
        <div className="profileCardDIV">
            <div>{data.session.id === data.user.id && (
            <form action={'/' + data.session.id + '/upload'} method="post" encType="multipart/form-data">
                <button className="profilePictureUpload" type="submit">Upload avatar</button>
                <input id="profilePictureINPUT" name="profilePicture" type="file" draggable="true"/>
            </form>
            )}
        </div>
        <img className="userAvatar" src={data.avatar.id}/>
            <span className="levelOfEnglishSPAN">
                <p className="levelOfEnglish">
                    Level: <span>{data.session.levelOfEnglish}</span>
                </p>
            </span>

            <a className="createPosts"  href={"/" + data.session.id + "/create"}>{data.session.id === data.user.id ? "Create post" : ""}</a>

            <span className="viewPostsSPAN">
                <a className="viewPosts" href={"/" + data.session.id + "/posts"}>View posts</a>
            </span>
            <button className="followBUTTON">Follow</button>     
        </div>
    </div>
</>
    );
}

export default Profile;
