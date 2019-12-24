$(function () {
    //alert(1);
    //获取类别
    $.ajax({
        url: "findCropCategory",
        dataType: "json",
        type: "get",
        success: function (result3) {
            $("#cptype").empty();
            var v = ' <option value="">请选择</option>';
            for (var i = 0; i < result3.length; i++) {
                v += ' <option value="' + result3[i].id + '">' + result3[i].cropCategory + '</option>'
            }
            $("#cptype").append(v);
        }
    });

});