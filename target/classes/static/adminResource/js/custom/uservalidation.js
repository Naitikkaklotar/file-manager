/*userjsp valid*/
$(document).ready(function() {
    $.validator.addMethod("validMobile", function(value, element) {
        // Regular expression to check for valid mobile number
        return this.optional(element) || /^(\+\d{1,3}[- ]?)?\d{10,15}$/.test(value);
    }, "Please enter a valid phone number.");

    $("#myForm").validate({
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true
            },
            mobileNumber: {
                required: true,
                minlength: 10,
                maxlength: 15,
                validMobile: true
            },
            email: {
                required: true,
                email: true
            },
            username: {
                required: true
            },
            "stateVO.id": {
                required: true
            },
            "cityVO.id": {
                required: true
            },
            address: {
                required: true
            }
        },
        messages: {
            firstName: {
                required: "Please enter your first name"
            },
            lastName: {
                required: "Please enter your last name"
            },
            mobileNumber: {
                required: "Please enter your mobile number",
                validMobile: "Please enter a valid mobile number. Format: +1234567890 or 1234567890."
            },
            email: {
                required: "Please enter your email",
                email: "Please enter a valid email address"
            },
            username: {
                required: "Please enter your username"
            },
            stateName: {
                required: "Please select a state"
            },
            cityName: {
                required: "Please select a city"
            },
            address: {
                required: "Please enter your address"
            }
        },
        errorElement: "div",
        errorClass: "invalid-feedback",
        highlight: function(element, errorClass, validClass) {
            $(element).addClass("is-invalid").removeClass("is-valid");
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).removeClass("is-invalid").addClass("is-valid");
        },
        errorPlacement: function(error, element) {
            // Add the `invalid-feedback` class to the error element
            error.addClass("invalid-feedback");

            if (element.prop("type") === "checkbox" || element.prop("type") === "radio") {
                error.insertAfter(element.next("label"));
            } else {
                error.insertAfter(element);
            }
        }
    });
});




