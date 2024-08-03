function closeModal() {
	document.getElementById("myModal").style.display = "none";
	document.getElementById("myForm").reset(); // Reset the form fields

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
			
			$('#' + jsn.gender).attr('checked', true)

			
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





