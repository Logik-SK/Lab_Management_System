// Function to load the content of basic.html
async function loadBasicTemplate() {
	const response = await fetch('/sidebar');
	const text = await response.text();
	document.getElementById('sidebar-container').innerHTML = text;
}

// Load the template when the page loads
window.onload = loadBasicTemplate;


document.addEventListener("DOMContentLoaded", showSidebar);
function showSidebar() {
	const sidebar = document.getElementById("sidebar");
	const sidebarToggle = document.getElementById("sidebarToggle");

	// Check if both elements exist
	if (sidebar && sidebarToggle) {
		sidebarToggle.addEventListener('click', () => {
			console.log("Sidebar selected");
			sidebar.classList.toggle("active"); // Toggle the sidebar
		});
	} else {
		console.error("Sidebar or Sidebar Toggle button not found.");
	}
}


