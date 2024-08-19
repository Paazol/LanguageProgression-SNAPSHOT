import React from "react";
import './home.css'

const Home: React.FC = () =>{
    return (
        <>
            <meta charSet="utf-8" />
            <title>Home</title>
            <link rel="stylesheet" type="text/css" href="../../css/generic.css" />
            <link rel="stylesheet" type="text/css" href="../../css/home.css" />
            <div id="dropdown-menu"></div> {/* Assuming the dropdown menu is initialized by the script */}
            <div className="background" />
            {avatarByID.map((avatar) => (
                <div key={avatar.post.id} className="postDIV">
                    <div className="postBackground" />
                    <div className="postCardDIV">
                        <a className="authorOfAPost" href={`/${avatar.post.idOfAnAuthor}`}>
                            <img
                                className="userAvatar"
                                src={`/${avatar.post.idOfAnAuthor}/image/userAvatar`}
                                alt="Ohh, no image"
                            />
                            <h5>by {avatar.username}</h5>
                        </a>
                        <a className="title" href={`/${avatar.username}/posts/${avatar.post.id}`}>
                            {avatar.post.title}
                        </a>
                        <small
                            className="suggestedLevelOfEnglish"
                            dangerouslySetInnerHTML={{ __html: `Suggested levels: <br>${avatar.post.suggestedLevelOfEnglish}` }}
                            aria-required="true"
                        />
                        <p className="containment">{avatar.post.containment}</p>
                        <a className="continueReading" href={`/${avatar.username}/posts/${avatar.post.id}`}>
                            View
                        </a>
                    </div>
                </div>
            ))}
        </>
    );
}

export default Home;