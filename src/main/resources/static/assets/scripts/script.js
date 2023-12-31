
// function to toggle popup on click
function togglePopup(data) {
    // function to convert Pet[id=1, name=Milo, petGender=male, petType=cat, vaccinated=true] to an array

    document.getElementsByClassName("left-content-input")[0].value = ""

        document.getElementsByClassName("left-content-input")[1].value = "dog";
    
        document.getElementById("female").checked; 
    
        document.getElementById("vaccinated").checked = ""; 

    var x = document.getElementsByClassName("popup")[0];
    if (x.style.display === "none") {
      x.style.display = "flex";
    } else {
      x.style.display = "none";
    }

    if (data) {
        document.getElementById("id").value = data.id;

        document.getElementsByClassName("left-content-input")[0].value = data.name;

        document.getElementsByClassName("left-content-input")[1].value = data.petType.toUpperCase();
    
        document.getElementById(data.petGender.toUpperCase()).checked = true;
    
        document.getElementById("vaccinated").checked = data.vaccinated;   
     }
}

// An AJAX function to give make a post request to the server
function postRequest(url, data, callback) {
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.onload = function() {
        callback(request);
    };


    request.send("id="+ data);
}

// splash screen fadiing out without display none

if(sessionStorage.getItem("splashscreen") !== "true") {
setTimeout(function() {
    document.getElementsByClassName("splashscreen")[0].style.opacity = "0";
} , 3000);
setTimeout(function() {
  document.getElementsByClassName("splashscreen")[0].style.display = "none";
  sessionStorage.setItem("splashscreen", "true");
} , 4000);
} else {
  document.getElementsByClassName("splashscreen")[0].style.display = "none";
}

// Function to create new entry

function deleteRecord() {
    const id = document.getElementById("id").value;
    postRequest("/pet/delete", id,
        () => { location.reload();});
}