import React from "react";
import dropdownMenu from "../../shared/ui/dropdownMenu/dropdownMenu";

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
    <script src="/src/main/frontend/src/js/dropDownBUTTON.js"></script>
    <script src = "/src/main/frontend/src/js/following.js"></script>
    <script src="/src/main/frontend/src/js/cropper.js"></script>

    <div th:insert="~{Generic/dropdownMenu::dropdown(false, true, true, true, true)}"></div>
    
    <div>
        <dropdownMenu
        profile={true}
        login={true}
        home={true}
        post={true}
        logout={true}
        sessionID={24}
        />
    </div>

    <div className="background"></div> 
    <div className="profileDIV">
        <div className="profileBackground"></div>
        <div className="profileCardDIV">
            <div th:if="${session.id == userID}">
                <form th:action="${'/' + session.id + '/upload'}" method="post" enctype="multipart/form-data">
                    <button className="profilePictureUpload" type="submit">Upload avatar</button>
                    <input id="profilePictureINPUT" name="profilePicture" type="file" draggable="true">
                </form>
            </div>
            <img className="userAvatar" th:src="${avatarByID}">
            <span className="levelOfEnglishSPAN">
                <p className="levelOfEnglish">
                    Level: <span th:text="${session.levelOfEnglish}"></span>
                </p>
            </span> 

            <a className="createPosts" th:if="${session.id == userID}" th:href="${'/' + session.id + '/create'}">Create post</a>

            <span className="viewPostsSPAN">
                <a className="viewPosts" th:href="${'/' + session.id + '/posts'}">View posts</a>
            </span>
            <button className="followBUTTON">Follow</button>     
        </div>
    </div>
</>
    );
}

export default Profile;
