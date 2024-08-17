import "./login.css"

function Login() {
    return (
        <html key="1">
        <head>
            <meta charSet="UTF-8" />
            <title>Login</title>
        </head>
        <body>
        <form method="post" action="/login">
            <div className="background"></div>
            <div className="wrapper colorable">
                <h1 id="loginMainHeader">Login</h1>
                <div className="Input">
                    <input maxLength="20" name="username" required type="text" />
                    <label>Username</label>
                    <img className="loginICONS" src="/authentication/user.png" />
                </div>
                <br />
                <div className="Input">
                    <input id="password" name="password" required type="password" />
                    <label>Password</label>
                    <img className="loginICONS" src="/authentication/lock_closed.png" />
                </div>
                <div id="loginButtonDIV">
                    <button id="loginButton" type="submit">Login</button>
                </div>
                <div id="forgotPasswordDIV">
                    <a className="forgotPasswordLink" href="#">Forgot password?</a>
                </div>
                <div id="registerLinkDIV">
                    <p className="registerP">
                        Don't have an account? <a className="registerLink" href="/register">Register</a>
                    </p>
                </div>
            </div>
        </form>
        </body>
        </html>
    );
}

export default Login;