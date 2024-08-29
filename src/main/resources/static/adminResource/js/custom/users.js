$(document).ready(function() {
    
	$.validator.addMethod("validMobile", function(value, element) {
        return this.optional(element) || /^(\+\d{1,3}[- ]?)?\d{10,15}$/.test(value);
    }, "Please enter a valid phone number.");

    $.validator.addMethod("checkUsername", function(value, element) {
        
    	var response;
    	
    	var htp = new XMLHttpRequest();

    	htp.onreadystatechange = function() {
    		
    		if (htp.readyState === 4) {
    			
    			const jsn = JSON.parse(htp.responseText);
    			
    			if(jsn){
    				response =  false;
    			}else{
    				response =  true;
    			}
    		}
    	}

    	htp.open("get", "checkUsername?username=" + username.value, false);
    	htp.send();
    
        return response;	
    	
    }, "Username already exists.");

    
    
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
                required: true,
                checkUsername : true
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
            error.addClass("invalid-feedback");

            if (element.prop("type") === "checkbox" || element.prop("type") === "radio") {
                error.insertAfter(element.next("label"));
            } else {
                error.insertAfter(element);
            }
        }
    });
});



function closeModal() {
	document.getElementById("myModal").style.display = "none";
	document.getElementById("myForm").reset(); // Reset the form fields

    $("#myForm").validate().resetForm();
	
	$('#username').removeAttr("disabled")
	$('#myModalLabel').html('Add User');
}


function handleClickOfEdit(id) {

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState === 4) {

			const jsn = JSON.parse(htp.responseText);

			$('#firstName').val(jsn.firstName)
			$('#lastName').val(jsn.lastName)
			$('#mobile').val(jsn.mobileNumber)
			$('#email').val(jsn.email)
			$('#username').val(jsn.username)
			$('#stateName').val(jsn.stateVO.id)
			$('#cityName').val(jsn.cityVO.id)
			$('#address').val(jsn.address)
			$('#id').val(jsn.id)
			$('#loginId').val(jsn.loginVO.id)
			$('#gender').val(jsn.gender)
			$('#username').attr("disabled","disabled")
			$('#username').css("cursor","no-drop")
			
			getCityByState();
			
			$('#myModalLabel').html('Edit User');
			$('#saveBtn').html('Update');
			$('#myModal').modal('show', true);

		}
	}

	htp.open("get", "findById?id=" + id, true);
	htp.send();

}

function showInfo(id) {

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		
		if (htp.readyState === 4) {

			let data = `<table class="table table-bordered">`;
			
			const jsn = JSON.parse(htp.responseText);

			$('#myInfoModalLabel').html(jsn.firstName + " " + jsn.lastName);

			data = data + "<tbody>";
			data = data + "<tr>";
			data = data + `<td><b>Full Name</b></td><td>${jsn.firstName} ${jsn.lastName}</td>`;
			data = data + "</tr>";

			data = data + "<tr>";
			data = data + `<td><b>Email</b></td><td>${jsn.email}</td>`;
			data = data + "</tr>";
			
			data = data + "<tr>";
			data = data + `<td><b>Mobile Number</b></td><td>${jsn.mobileNumber}</td>`;
			data = data + "</tr>";

			data = data + "<tr>";
			data = data + `<td><b>Gender</b></td><td>${jsn.gender}</td>`;
			data = data + "</tr>";
			
			data = data + "<tr>";
			data = data + `<td><b>Username</b></td><td>${jsn.username}</td>`;
			data = data + "</tr>";
			

			data = data + "<tr>";
			data = data + `<td><b>State</b></td><td>${jsn.stateVO.stateName}</td>`;
			data = data + "</tr>";
			

			data = data + "<tr>";
			data = data + `<td><b>City</b></td><td>${jsn.cityVO.cityName}</td>`;
			data = data + "</tr>";
			
			data = data + "<tr>";
			data = data + `<td><b>Address</b></td><td>${jsn.address}</td>`;
			data = data + "</tr>";
			data = data + "</tbody>";
			data = data + "</table>";
			
			$('#infoModalBody').html(data);
			$('#myInfoModal').modal('show', true);
			
		}
	}

	htp.open("get", "findById?id=" + id, true);
	htp.send();
}


function getCityByState(){
	
	var state = document.getElementById("stateName");
	var city = document.getElementById("cityName");
	
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		
		if (htp.readyState === 4) {
			
			const jsn = JSON.parse(htp.responseText);
			
			city.innerHTML = "";
			
			
			for(let i = 0 ; i < jsn.length ; i++){
				
				const opn = document.createElement("option");
				
				opn.value = jsn[i].id;
				opn.text = jsn[i].cityName;
				
				city.options.add(opn);
			}
		}
	}

	htp.open("get", "getCityByState?id=" + state.value, true);
	htp.send();
}

function changeStatus(id,status){

	
	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {
		
		if (htp.readyState === 4) {
			
			if(htp.responseText){
				
				
				const s = status === 'active' ? 'Blocked' : 'Active';
				$(`#flexSwitchCheck${id}`).attr('title',s);
				
				
				// TODO : Toasty	
				showErrorToast('test');
			}else{
				// TODO : Toasty
				showErrorToast('testy');
			}
			$(`#flexSwitchCheck${id}`).attr('data-bs-placement','right');
			$(`#flexSwitchCheck${id}`).attr('data-bs-toggle','tooltip');
		}
	}

	htp.open("get", "changeStatus?id=" + id, true);
	htp.send();
	
}




