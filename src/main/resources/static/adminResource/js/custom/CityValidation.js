$(document).ready(function() {
    $("#myForm").validate({
        rules: {
            stateVO: {
                required: true
            },
            cityName: {
                required: true,
                minlength: 2
            },
            description: {
                required: true,
                minlength: 5
            }
        },
        messages: {
            stateVO: {
                required: "Please select a state."
            },
            cityName: {
                required: "Please enter a city name.",
                minlength: "City name must be at least 2 characters long."
            },
            description: {
                required: "Please enter a description.",
                minlength: "Description must be at least 5 characters long."
            }
        },
        errorElement: "div",
        errorPlacement: function(error, element) {
            error.addClass("invalid-feedback");
            error.insertAfter(element);
        },
        highlight: function(element) {
            $(element).addClass("is-invalid");
        },
        unhighlight: function(element) {
            $(element).removeClass("is-invalid");
        }
    });
});

