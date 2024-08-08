/*$(document).ready(function() {
    $('#myForm').submit(function(e) {
        var stateName = $('#stateName').val().trim();

        if (stateName === "") {
            alert("State Name cannot be empty.");
            e.preventDefault(); // Prevent form submission
        }

        // Additional validation checks can be added here
    });
});
*/

// validation.js

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

/*userjsp valid*/
$(document).ready(function() {
    $.validator.addMethod("validMobile", function(value, element) {
        // Regular expression to check for valid mobile number
        return this.optional(element) || /^(\+\d{1,3}[- ]?)?\d{10,15}$/.test(value);
    }, "Please enter a valid phone number.");

    $("#myFormU").validate({
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
            stateName: {
                required: true
            },
            cityName: {
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
        errorClass: "error",
        highlight: function(element, errorClass, validClass) {
            $(element).addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function(element, errorClass, validClass) {
            $(element).removeClass(errorClass).addClass(validClass);
        }
    });
});
