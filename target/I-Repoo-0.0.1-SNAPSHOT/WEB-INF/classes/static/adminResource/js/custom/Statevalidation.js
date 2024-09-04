$(document).ready(function() {
    $("#myForm").validate({
        rules: {
            stateName: {
                required: true
            },
            description: {
                required: true
            }
        },
        messages: {
            stateName: {
                required: "Please enter the state name"
            },
            description: {
                required: "Please enter the description"
            }
        }
    });
});

function closeModal() {
    document.getElementById("myModal").style.display = "none";
    document.getElementById("myForm").reset();
    $("#myForm").validate().resetForm();
    $("#myForm .is-invalid").removeClass("is-invalid");
    $("#myForm .is-valid").removeClass("is-valid");
    $('#username').removeAttr("disabled");
    $('#myModalLabel').html('Add User');
    $('#alert-container').hide();
}