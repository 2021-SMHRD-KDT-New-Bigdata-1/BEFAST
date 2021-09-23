var locations = document.querySelector(".locations");

locations.onchange = 
function(){
    var fileds = document.querySelector(".fileds");
    var mainOption = locations.options[locations.selectedIndex].innerText;
}

var subOptions = {
    rhkdtksrn : ["경기장1","경기장2","경기장3"]
    ,skarn : ["경기장4", "경기장5", "경기장6"]
}

switch(mainOption) {
    case '광산구' :
        var subOption = subOptions.rhkdtksrn;
        break;
    case '남구' :
        var subOption = subOptions.skarn;
        break;
}

fileds.options.length = 0;

for (var i=0; i<subOption.length; i++){
    var option = document.createElement("option");
    option.innerText = subOption[i];
    fileds.append(option);
} 