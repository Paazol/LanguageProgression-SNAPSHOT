document.getElementById('postForm').addEventListener('submit', function(event) {
    const checkboxes = document.querySelectorAll('input[name="suggestedLevelOfEnglish"]');
    let atLeastOneChecked = false;

    for (const checkbox of checkboxes) {
        if (checkbox.checked) {
            atLeastOneChecked = true;
            break;
        }
    }

    if (!atLeastOneChecked) {
        // Set a default value if no checkbox is selected
        const defaultCheckbox = document.getElementById('A0');
        defaultCheckbox.checked = true;
    }
});
