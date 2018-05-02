var flag = 0;
var flag_means = 0;
$(document).ready(function () {
    $("#fullcontent").hide();
    $("#fullcontent_means").hide();
    $("#fullcontent_means").prepend("<select onchange='changeSearchEngine()' id='changeSearchEngine' style='font-size:20px'><option value='0'>选择字典</option><option value='http://dict.baidu.com/s?wd='>baidu</option><option value='https://www.google.com/search?q='>google</option><option value='http://www.baike.com/wiki/'>baike</option></select><br/><br/><br/>");
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
var current_dictionary = "http://dict.baidu.com/s?wd=";
function openDictionary(theword) {
    window.open(current_dictionary + theword);
}

function changeSearchEngine() {
    var searchEngine_s = $("#changeSearchEngine").val();
    if(searchEngine_s === "0"){
        return ;
    }
//    alert(searchEngine_s);
    current_dictionary = searchEngine_s;
}
