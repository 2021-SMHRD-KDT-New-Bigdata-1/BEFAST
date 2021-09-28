
function categoryChange(e) {
    var 광산구 = ['베스트풋살','태양풋살','제일풋살장','신가풋살'
				,'림FC풋살장','광주풋살파크'];
    var 남구 = ['케이지풋살아레나 백운점','경기장5','경기장6'];
    var 동구 = ['광주동구풋살경기장','경기장8','경기장9'];
    var 북구 = ['챔피언스풋살장','케이지풋살아레나 전대점','광주실내풋살장'
				,'JK풋살아레나'];
    var 서구 = ['더프라임풋살장','스타실내풋살장','돌파살'];
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

