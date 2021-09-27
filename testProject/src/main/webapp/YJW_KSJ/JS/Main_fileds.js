
function categoryChange(e) {
    var 광산구 = ['경기장1','경기장2','경기장3'];
    var 남구 = ['경기장4','경기장5','경기장6'];
    var 동구 = ['경기장7','경기장8','경기장9'];
    var 북구 = ['경기장10','경기장11','경기장12'];
    var 서구 = ['경기장13','경기장14','경기장15'];
    var target = document.getElementById("fileds");

    if (e.value == "광산구") var XX = 광산구;
    else if (e.value == "남구") var XX = 남구;
    else if (e.value == "동구") var XX = 동구;
    else if (e.value == "북구") var XX = 북구;
    else if (e.value == "서구") var XX = 서구;

    target.options.length = 0;

    for (i in XX) {
        var opt = document.createElement("option");
        opt.value = XX[i];
        opt.innerHTML = XX[i];
        target.appendChild(opt);
    } 
}

