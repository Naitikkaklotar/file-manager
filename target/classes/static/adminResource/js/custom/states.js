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
			$('#stateName').val(jsn.stateName)
			$('#description').val(jsn.description)

			$('#myModalLabel').html('Edit State');
			$('#saveBtn').html('Update');

			$('#myModal').modal('show', true);

		}
	}

	htp.open("get", "findByState?id=" + id, true);
	htp.send();

}

