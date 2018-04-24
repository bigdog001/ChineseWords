var flag = 0;
var flag_means = 0;
$(document).ready(function () {
    $("#fullcontent").hide();
    $("#fullcontent_means").hide();
    $("#hideshow").click(function () {
        if (flag === 0) {
            $("#fullcontent").show();
            flag = 1;
        } else {
            $("#fullcontent").hide();
            flag = 0;
        }
    });

    $("#hideshow_means").click(function () {
        if (flag_means === 0) {
            $("#fullcontent_means").show();
            flag_means = 1;
        } else {
            $("#fullcontent_means").hide();
            flag_means = 0;
        }
    });


});

$(function () {
    $("[data-toggle='tooltip']").tooltip();
});

var url_baidu = "http://dict.baidu.com/s?wd=";
var url_google = "https://www.google.com/search?q=";
var url_baike = "http://www.baike.com/wiki/";
var url_handian = "http://www.zdic.net/z/1a/js/"; //   漢典

function openDictionary(theword) {
    window.open(url_baidu+theword);
}
