function closeModal() {
	document.getElementById("myModal").style.display = "none";
	document.getElementById("myForm").reset(); // Reset the form fields
}

function handleClickOfEdit(id) {

	var htp = new XMLHttpRequest();

	htp.onreadystatechange = function() {

		if (htp.readyState === 4) {

			const
			jsn = JSON.parse(htp.responseText);

			$('#id').val(jsn.id)
			$('#cityName').val(jsn.cityName)
			$('#description').val(jsn.description)
			$('#stateName').val(jsn.stateVO.id)
			$('#myModalLabel').html('Edit State');
			$('#saveBtn').html('Update');

			$('#myModal').modal('show', true);

		}
	}

	htp.open("get", "findByCity?id=" + id, true);
	htp.send();

}

