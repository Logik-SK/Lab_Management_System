document.addEventListener("DOMContentLoaded", fetchPatientData);

async function fetchPatientData() {
    console.log("Fetching all patients...");

    try {
        let response = await fetch("/api/patients");
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        let patients = await response.json();
        let patientTable = createPatientTableAndHeader();
        createPatienTableData(patients, patientTable);
    } catch (error) {
        console.error("Error fetching patient data:", error);
    }
}


function createPatientTableAndHeader() {

    let headers = ["Reg_No", "Name", "Age", "Status", "Actions"];

    let table = document.createElement("table");
    table.classList.add("table");
    table.classList.add("table-hover");
    table.classList.add("table-bordered");
    table.style.borderCollapse = "collapse";

    // Create table header
    let thead = document.createElement("thead");
    let headerRow = document.createElement("tr");

    headers.forEach(headerText => {
        let th = document.createElement("th");
        th.textContent = headerText;
        th.style.background = "linear-gradient(90deg, #e3f2fd, #f1f8e9)";
        headerRow.appendChild(th);
    });

    thead.appendChild(headerRow);
    table.appendChild(thead);
    return table;

}



function createPatienTableData(patients, patientTable) {

    // Create table body
    let tbody = document.createElement("tbody");

    patients.forEach(patient => {
        let row = document.createElement("tr");
        let tdsize = 0;
        let values = Object.values(patient);

        for (let i = 0; i <= 4; i++) {
            if (i == 4) {
                let cell = document.createElement("td");
                // Create Button 1 (View)
                let btnView = document.createElement("button");
                btnView.textContent = "View";
                btnView.classList.add("btn", "btn-primary", "btn-sm"); // Add classes for styling
                btnView.style.marginRight = "8px";

                // Create Button 2 (Edit)
                let btnEdit = document.createElement("button");
                btnEdit.textContent = "Edit";
                btnEdit.classList.add("btn", "btn-warning", "btn-sm");
                btnEdit.style.marginRight = "8px";

                // Create Button 3 (Delete)
                let btnDelete = document.createElement("button");
                btnDelete.textContent = "Delete";
                btnDelete.classList.add("btn", "btn-danger", "btn-sm");
                btnDelete.style.marginRight = "8px";

                cell.appendChild(btnView);
                cell.appendChild(btnEdit);
                cell.appendChild(btnDelete);

                row.appendChild(cell);
            } else {
                let cell = document.createElement("td");
                cell.textContent = values[i];
                row.appendChild(cell);
            }
            tdsize++;


            if (tdsize === patientTable.length) {
                break;
            }
        }

        tbody.appendChild(row);
    });

    patientTable.appendChild(tbody);

    // Append the table to a specific container
    document.getElementById("table-container").classList.add("table-responsive")
    document.getElementById("table-container").appendChild(patientTable);
}