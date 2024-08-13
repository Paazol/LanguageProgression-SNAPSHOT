document.addEventListener("DOMContentLoaded", function() {
    const dropdownButton = document.querySelector(".menuBUTTON");

    dropdownButton.addEventListener("click", function(event) {
        event.preventDefault();
        const dropdownMenu = dropdownButton.parentElement.nextElementSibling;
        dropdownMenu.classList.toggle("dropdownButton-clicked");

        dropdownButton.disabled = true;
        setTimeout(() => {
            dropdownButton.disabled = false;
        }, 100)
    });
});