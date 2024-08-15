import {useEffect, useState} from 'react'
import './home.css'

function Home() {
    const [avatarByID, setAvatarByID] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetch('http://localhost:5174/home') // Adjust the URL to your backend endpoint
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setAvatarByID(data);
                setLoading(false);
            })
            .catch(error => {
                console.error('There was an error fetching the data!', error);
                setError(error);
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error.message}</p>;

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