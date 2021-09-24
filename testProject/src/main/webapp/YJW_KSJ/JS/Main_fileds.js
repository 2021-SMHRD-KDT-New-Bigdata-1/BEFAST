
function categoryChange(e) {
    var rhkdtksrn = ['경기장1','경기장2','경기장3'];
    var skarn = ['경기장4','경기장5','경기장6'];
    var ehdrn = ['경기장7','경기장8','경기장9'];
    var qnrrn = ['경기장10','경기장11','경기장12'];
    var tjrn = ['경기장13','경기장14','경기장15'];
    var target = document.getElementById("fileds");

    if (e.value == "rhkdtksrn") var XX = rhkdtksrn;
    else if (e.value == "skarn") var XX = skarn;
    else if (e.value == "ehdrn") var XX = ehdrn;
    else if (e.value == "qnrrn") var XX = qnrrn;
    else if (e.value == "tjrn") var XX = tjrn;

    target.options.length = 0;

    for (i in XX) {
        var opt = document.createElement("option");
        opt.value = XX[i];
        opt.innerHTML = XX[i];
        target.appendChild(opt);
    } 
}



// var subOptions = {
//     rhkdtksrn : ['경기장1','경기장2','경기장3'],
//     skarn : ['경기장4','경기장5','경기장6'],
//     ehdrn : ['경기장7','경기장8','경기장9'],
//     qnrrn : ['경기장10','경기장11','경기장12'],
//     tjrn : ['경기장13','경기장14','경기장15']
// }

// switch (mainOption) {
//     case '광산구' :
//         var subOption = subOptions.rhkdtksrn;
//         break;
//     case '남구' :
//         var subOption = subOptions.skarn;
//         break;
//     case '동구' :
//         var subOption = subOptions.ehdrn;
//         break;
//     case '북구' :
//         var subOption = subOptions.qnrrn;
//         break;
//     case '서구' :
//         var subOption = subOptions.tjrn;
// }
