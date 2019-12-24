$(function () {


    //页面加载事件 添加所有的毒素
    $(".add-dsxx").click(function(){
        $('.addds').append('' +
            '<li class="edittable-middle">' +
            '<div class="editmiddle-left">毒素信息</div>' +
            '<div class="editmiddle-right"><ul><li><lable>毒素种类</lable>' +
            '<select name="toxins" id="toxins" class="toxins">' +
            '<option value="0" >请选择</option></select>' +
            '<span id="toxin_id" ></span></li><li><lable>毒素含量</lable>' +
            '<input name="toxinCount" type="text"  class="toxinCount"  maxlength="10" placeholder="毒素含量最大可输入十位"/>' +
            '<span id="toxin_count" ></span></li><li><a class="del">删除</a></li></ul></div></li>')
        //alert(1);
        $.ajax({
            url:"findtoxins",
            type:"post",
            dataType:"json",
            success:function(res){//形式参数  真正的参数 是控制层返回的
                //alert(res);
                $(".toxins").empty();
                for (var j = 0; j < res.length; j++) {
                    $(".toxins").append("<option value='"+res[j].id+"'>"+res[j].toxinType+"</option>")
                }
            }
        });
    });
    var delcharacter = [];
    $(".addds").on("click",'.del',function(){
        var y = $(this).parents(".editmiddle-right").siblings(".editmiddle-left").html().substring(6,7)
        delcharacter.push(y);
        delcharacter.sort();
        $(this).parents(".edittable-middle").remove();
    })

    $(".ypbh").on("input",function(){
        if($(".add-con").find("li").length !==0){
            $(".sample").each(function(){
                var m = $(".ypbh").val();
                $(this).val(m);
            })
        }
    })

});