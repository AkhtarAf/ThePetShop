
// function to toggle popup on click
function togglePopup(data) {

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
        document.getElementsByClassName("left-content-input")[0].value = data.name;

        document.getElementsByClassName("left-content-input")[1].value = data.type;
    
        document.getElementById(data.gender).checked = true;
    
        document.getElementById("vaccinated").checked = data.vaccinated;   
     }
}

// An AJAX function to give make a post request to the server
function postRequest(url, data, callback) {
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.onload = function() {
        callback(request);
    };
    request.send(JSON.stringify(data));
}
    
// splash screen fadiing out without display none

if(sessionStorage.getItem("splashscreen") != "true") {
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