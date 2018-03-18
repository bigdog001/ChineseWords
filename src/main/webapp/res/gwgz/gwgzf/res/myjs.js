  var flag = 0;
        $(document).ready(function () {
            $("#fullcontent").hide();
            $("#hideshow").click(function () {
                if (flag === 0) {
                    $("#fullcontent").show();
                    flag = 1;
                } else {
                    $("#fullcontent").hide();
                    flag = 0;
                }
            });
        });

        $(function () {
            $("[data-toggle='tooltip']").tooltip();
        });