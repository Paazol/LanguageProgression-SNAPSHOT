document.addEventListener('DOMContentLoaded', function() {
    console.log("profile.js loaded");

    let cropper;
    const input = document.getElementById('profilePictureINPUT');
    const canvas = document.createElement('canvas');
    const ctx = canvas.getContext('2d');

    input.addEventListener('change', function(event) {
        console.log("File input changed");
        const file = event.target.files[0];
        if (file) {
            console.log("File selected:", file.name);
            const reader = new FileReader();
            reader.onload = function(e) {
                console.log("File reader loaded");
                const img = new Image();
                img.src = e.target.result;
                img.onload = function() {
                    console.log("Image loaded");
                    canvas.width = img.width;
                    canvas.height = img.height;
                    ctx.drawImage(img, 0, 0);
                    if (cropper) {
                        cropper.destroy();
                    }
                    cropper = new Cropper(canvas, {
                        aspectRatio: 1,
                        viewMode: 1,
                        dragMode: 'move',
                        cropBoxResizable: false,
                        cropBoxMovable: true,
                    });
                    // Display the canvas in a modal or a specific div
                    const cropModal = document.getElementById('cropModal');
                    const cropCanvas = document.getElementById('cropCanvas');
                    cropCanvas.innerHTML = '';
                    cropCanvas.appendChild(canvas);
                    cropModal.style.display = 'block';
                };
            };
            reader.readAsDataURL(file);
        }
    });

    document.getElementById('cropButton').addEventListener('click', function() {
        console.log("Crop button clicked");
        if (cropper) {
            const croppedCanvas = cropper.getCroppedCanvas({
                width: 1000,
                height: 1000,
            });
            const croppedImage = croppedCanvas.toDataURL('image/jpeg');
            // Send croppedImage to the server using Fetch API
            fetch('/uploadAvatar', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    image: croppedImage
                })
            })
            .then(response => response.text())
            .then(data => {
                alert(data);
                // Close the modal
                document.getElementById('cropModal').style.display = 'none';
            })
            .catch(error => {
                alert('Error uploading avatar.');
            });
        }
    });
});
