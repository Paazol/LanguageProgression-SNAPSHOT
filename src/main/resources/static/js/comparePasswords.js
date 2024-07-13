document.addEventListener("DOMContentLoaded", function() {
    const password = document.getElementById("password");
    const repeatedPassword = document.getElementById("repeatedPassword");
    const passwordRepeatDIV = document.getElementById("passwordRepeatDIV");
    const repeatPasswordLabel = document.getElementById("repeatPasswordLabel");

    function checkPasswords() {
        if (password.value === repeatedPassword.value) {
            passwordRepeatDIV.classList.remove("invalid");
            passwordRepeatDIV.classList.add("valid");
            repeatPasswordLabel.innerText = "Correct";
            
        } else {
            passwordRepeatDIV.classList.remove("valid");
            passwordRepeatDIV.classList.add("invalid");
            repeatPasswordLabel.innerText = "Passwords must match!";
        }
    }    

    password.onkeyup = checkPasswords;
    repeatedPassword.onkeyup = checkPasswords;

});