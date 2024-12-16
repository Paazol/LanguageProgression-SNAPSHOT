import React from "react";
import DropdownMenu from "../../shared/ui/dropdownMenu/dropdownMenu";
import { User } from "../../shared/api/models/user";
import { Post } from "../../shared/api/models/post";
import { Avatar } from "../../shared/api/models/avatar.ts";
import { Session } from "../../shared/api/models/session.ts";
import { fetchData } from "../../shared/api/services/get/fetchData.ts";


interface homeData {
    avatarById: Post[],
    avatar: Avatar,
    user: User,
    session: Session
}

const data = fetchData<homeData>("http://localhost:8080/getHomeData");

const Profile: React.FC = async () => {
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
        sessionID={"24"} />
    </div>

    <div className="background"></div> 
    <div className="profileDIV">
        <div className="profileBackground"></div>
        <div className="profileCardDIV">
            <div>{(await data).session.id === (await data).user.id &&  (
            <form action="${'/' + session.id + '/upload'}" method="post" encType="multipart/form-data">
                <button className="profilePictureUpload" type="submit">Upload avatar</button>
                <input id="profilePictureINPUT" name="profilePicture" type="file" draggable="true"/>
            </form>
            )}
        </div>
        <img className="userAvatar" src="${avatarByID}"/>
            <span className="levelOfEnglishSPAN">
                <p className="levelOfEnglish">
                    Level: <span text="{session.levelOfEnglish}"></span>
                </p>
            </span>

            <a className="createPosts" text="${session.id == userID}" href="/ session.id /create">Create post</a>

            <span className="viewPostsSPAN">
                <a className="viewPosts" href="${'/' + session.id + '/posts'}">View posts</a>
            </span>
            <button className="followBUTTON">Follow</button>     
        </div>
    </div>
</>
    );
}

export default Profile;
