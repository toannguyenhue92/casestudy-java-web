let roomRadio = document.getElementById("roomRadio");
let houseRadio = document.getElementById("houseRadio");
let villaRadio = document.getElementById("villaRadio");
let stayStandard = document.getElementById("stayStandard");
let numberOfFloors = document.getElementById("numberOfFloors");
let poolArea = document.getElementById("poolArea");

roomRadio.addEventListener("click", function () {
    stayStandard.hidden = true;
    numberOfFloors.hidden = true;
    poolArea.hidden = true;
});

houseRadio.addEventListener("click", function () {
    stayStandard.hidden = false;
    numberOfFloors.hidden = false;
    poolArea.hidden = true;
});

villaRadio.addEventListener("click", function () {
    stayStandard.hidden = false;
    numberOfFloors.hidden = false;
    poolArea.hidden = false;
});