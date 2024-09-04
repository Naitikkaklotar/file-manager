document.getElementById('folderOption').addEventListener(
		'click',
		function() {
			var myModal = new bootstrap.Modal(document
					.getElementById('newFolderDialog'));
			myModal.show();
		});

document.getElementById('cancelButton').addEventListener('click', function() {
	document.getElementById('folderNameInput').value = ''; // Clear the input field
});
