// Fetch data from the API and populate the table
document.addEventListener("DOMContentLoaded", function () {
    fetch("api/patients")
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.querySelector("#patient-table");
            tableBody.innerHTML = ""; // Clear existing rows

            data.forEach(patient => {
                const row = document.createElement("tr");

                // Assuming patient object has id, name, age, and gender fields
                row.innerHTML = `
                    <td>${patient.pId}</td>
                    <td>${patient.name}</td>
                    <td>${patient.age}</td>
                    <td>${patient.gender}</td>
                    <td>${patient.contact}</td>
                    <td>
                        <button class="view-btn btn btn-primary btn-sm" data-id="${patient.pId}" style="margin-right: 0.3125rem;">
                            <i class="fas fa-eye"></i>
                        </button>
                        <button class="edit-btn btn btn-warning btn-sm" data-id="${patient.pId}" style="margin-right: 0.3125rem;">
                            <i class="fas fa-edit"></i>
                        </button>
                        <button class="delete-btn btn btn-danger btn-sm" data-id="${patient.pId}" style="margin-right: 0.3125rem;">
                            <i class="fas fa-trash"></i>
                        </button>
                    </td>
                `;

                // Add event listener for the view button
                row.querySelector(".view-btn").addEventListener("click", function () {
                    const patientId = this.getAttribute("data-id");
                    fetch(`/api/patient/${patientId}`)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error("Network response was not ok " + response.statusText);
                            }
                            return response.json();
                        })
                        .then(patientData => {
                            console.log("Patient Data:", patientData);
                            // You can display the patient data in a modal or alert here
                        })
                        .catch(error => {
                            const alertDiv = document.createElement("div");
                            alertDiv.className = "alert alert-danger";
                            alertDiv.role = "alert";
                            alertDiv.innerText = "Failed to fetch patient details. Please try again later.";
                            alertDiv.style.top="4rem";
                            document.body.prepend(alertDiv);
                            console.error("There was a problem with the fetch operation:", error);
                           
                            setTimeout(() => {
                                alertDiv.remove();
                            }, 5000);
                        });
                });

                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("There was a problem with the fetch operation:", error);
        });
});

function addPatient() {
    fetch('/api/addPatient', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({}) // Add necessary data here if required
    })
    .then(response => {
        if (response.ok) {
            Swal.fire({
            icon: 'success',
            title: 'Success',
            text: 'Patient added successfully!',
            confirmButtonText: 'OK'
            });
            // Optionally reload or update the table
        } else {
            Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Failed to add patient.',
            confirmButtonText: 'Try Again'
            });
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred.');
    });
}