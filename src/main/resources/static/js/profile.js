document.addEventListener("DOMContentLoaded", function() {
    const followButton = document.querySelector(".followBUTTON");
    var userClicked = 0;

    followButton.addEventListener("click", function(event) {
        event.preventDefault();

        if (userClicked % 2 === 0) {
            userClicked++;
            followButton.classList.remove("followBUTTON-released");
            followButton.classList.toggle("followBUTTON-clicked");
            followButton.textContent = "Followed";
           
        } else {
            userClicked++;
            followButton.classList.remove("followBUTTON-clicked");
            followButton.classList.toggle("followBUTTON-released");
            followButton.textContent = "Follow";
        }
    
        // Preventing user from spamming follow-unfollow
        followButton.disabled = true;
        setTimeout(() => {
            followButton.disabled = false;
        }, 350);
    });
});