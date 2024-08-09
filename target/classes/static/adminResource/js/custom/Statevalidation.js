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
