import React from 'react';
import "../../shared/styles/generic.css"
import "./login.css";

const Login: React.FC = () => {
    return (
    <div>
        <form method="post">
            <div className="background"></div>
            <div className="wrapper colorable">
                <h1 id="loginMainHeader">Login</h1>
                <div className="Input">
                    <input maxLength={20} name="username" required type="text"/>
                    <label>Username</label>
                    <img className="loginICONS" src="../../../public/Auth/user.png" alt="Account Icon"/>
                </div>
                <br/>
                <div className="Input"> 
                    <input id="password" name="password" required type="password"/>
                    <label>Password</label>
                    <img className="loginICONS" src="../../../public/Auth/lock_closed.png" alt="Lock Icon"/>
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
    </div>
    );
}

export default Login;
