import "./home.css"
import { User } from "../../shared/api/models/user";
import { Post } from "../../shared/api/models/post";
import { Avatar } from "../../shared/api/models/avatar.ts";
import fetchData from "../../shared/api/services/get/fetchData.ts";

interface homeData {
    post: Post[],
    avatar: Avatar,
    user: User
}

const fields: (keyof homeData)[] = ["avatar", "post", "user"]

const data = await fetchData("http://localhost:8080/getHomeData", fields)

const Home: React.FC = () => {
    return (
        <>
            <meta charSet="utf-8" />
            <title>Home</title>
            <link rel="stylesheet" type="text/css" href="../../shared/styles/generic.css" />
            <link rel="stylesheet" type="text/css" href="../../css/home.css" />
            <div className="background"/>
                <div key={data.post.id} className="postDIV">
                    <div className="postBackground" />
                    <div className="postCardDIV">
                        <a className="authorOfAPost" href={"/" + data.post.id_of_an_author}>
                            <img
                                className="userAvatar"
                                src={"/" + data.post.suggested_level_of_english + "/image/userAvatar"}
                                alt="Ohh, no image"
                            />
                            <h5>by {data.post.avatar.id}</h5>
                        </a>
                        <a className="title" href={"/" + data.user.username + "/posts/" + data.post.id}>
                            {data.post.title}
                        </a>
                        <small className="suggestedLevelOfEnglish" aria-required="true">
                            {"Suggested levels: " + data.post.suggestedLevelOfEnglish}
                        </small>
                        <p className="containment">{data.post.containment}</p>
                        <a className="continueReading" href={"/" + data.user.username + "/posts/" + data.post.id}>
                            View
                        </a>
                    </div>
                </div>
            ))
        </>
    );
}

export default Home;
