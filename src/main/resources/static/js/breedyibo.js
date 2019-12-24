//回显种类两级联动
$(function () {
    $.ajax({
        url: "findCropCategory",
        dataType: "json",
        type: "get",
        success: function (result) {
            $("#cptype").empty();
            var v = ' <option value="">请选择</option>';
            for (var i = 0; i < result.length; i++) {
                v += ' <option value="' + result[i].id + '">' + result[i].cropCategory + '</option>'
            }
            $("#cptype").append(v);
        }
    })

})

function cptypes(){
    var cptypess = $("#cptype").val();
    $.ajax({
        url: "findCropSpecies",
        type: "get",
        datatype: "json",
        data: {"cptypess": cptypess},
        success: function (result) {
            $("#cptypess").empty();
            var v = ' <option value="">请选择</option>';
            for (var j = 0; j < result.length; j++) {
                v += ' <option value="' + result[j].id + '">' + result[j].cropSpecies
            }
            $("#cptypess").append(v);

        }
    })
}

