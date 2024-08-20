import React from "react";
import "../../shared/styles/generic.css"
import "./register.css";

const Register: React.FC = () => {
    return (
    <html>
    <head>
        <meta charSet="UTF-8"/>
        <title>Registration</title>
    </head>
    <body>
    <form action="/register" method="post">
        <div className="background"></div>
        <div className="wrapper colorable">
            <form className="registerFORM" action="/register" method="post">
                <h1 id="registerMainHeader">Register</h1>

                <div className="Input">
                    <input name="username" type="text" maxLength="20" required/>
                    <label>Username</label>
                    <img className="loginICONS" src="../../../public/Auth/user.png"/>
                </div>

                <br/>

                <div className="Input">
                    <input name="email" type="text" required/>
                    <label>Email</label>
                    <img className="loginICONS" src="../../../public/Auth/email.png"/>
                </div>

                <br/>

                <div className="Input">
                    <input name="password" id="password" type="password" required/>
                    <label>Password</label>
                    <img className="loginICONS" src="/authentication/lock_closed.png"/>
                </div>

                <br/>

                <div className="Input" id="passwordRepeatDIV">
                    <input name="repeatedPasswordINPUT" id="repeatedPassword" type="password" required/>
                    <label id="repeatPasswordLabel">Repeat password</label>
                    <img className="loginICONS" src="/authentication/lock_repeat.png"/>
                </div>

                <div className="chooseOfALanguageLevelDIV">
                    <label className="chooseOfALanguageLevelLABEL">Pick your level of English: </label>
                    <select name="levelOfEnglish" id="languageLevelOptions">
                        <option id="A0">A0</option>
                        <option id="A1">A1</option>
                        <option id="A2">A2</option>
                        <option id="B1">B1</option>
                        <option id="B2">B2</option>
                        <option id="C1">C1</option>
                        <option id="C2">C2</option>
                    </select>
                </div>

                <div id="registerButtonDIV">
                    <button type="submit" id="registerButton">Register</button>
                </div>
            </form>
        </div>
    </form>
    </body>

    </html>
    )
}

export default Register;