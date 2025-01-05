import './home.css'
import { User } from "../../shared/api/models/user";
import { Post } from "../../shared/api/models/post";
import { Avatar } from "../../shared/api/models/avatar.ts";
import fetchData from '../../shared/api/services/get/fetchData.ts';

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
            <div className="background" />
            {data.post.map((avatar) => (
                <div key={data.post.id} className="postDIV">
                    <div className="postBackground" />
                    <div className="postCardDIV">
                        <a className="authorOfAPost" href={"/" + data.post.id_of_an_author}>
                            <img
                                className="userAvatar"
                                src={"/" + data.post.suggested_level_of_english + "/image/userAvatar"}
                                alt="Ohh, no image"
                            />
                            <h5>by {data.avatar.username}</h5>
                        </a>
                        <a className="title" href={"/" + data.avatar.username + "/posts/" + data.avatar.post.id}>
                            {data.avatar.post.title}
                        </a>
                        <small
                            className="suggestedLevelOfEnglish"
                            dangerouslySetInnerHTML={"Suggested levels: " + <br /> + data.avatar.post.suggestedLevelOfEnglish}
                            aria-required="true"
                        />
                        <p className="containment">{data.avatar.post.containment}</p>
                        <a className="continueReading" href={"/" + data.avatar.username + "/posts/" + data.avatar.post.id}>
                            View
                        </a>
                    </div>
                </div>
            ))}
        </>
    );
}

export default Home;
