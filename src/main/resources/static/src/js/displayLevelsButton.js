document.addEventListener("DOMContentLoaded", function() {
    const levelButton = document.querySelector(".suggestedLevelOfEnglishBUTTON");
    const levelMenu = document.querySelector(".levelCheckboxesDIV");

    levelButton.addEventListener("click", function(event) {
        event.preventDefault();
        levelMenu.classList.toggle("levelCheckboxes-transition");
    });
});
