$(function(){
    var character = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    var x = $(".edittable-bottom").length;
    var i = x;
    $("body").on("click",".add-ds",function(){
        if(i<26){
            $(".add-con").append("<li class='edittable-bottom'><div class='editbottom-left'>产毒菌株信息"+character[i]+"</div><div class='editbottom-right'><ul><li><lable>样品编号</lable><input id='sample_num' name='sample_num' type='text' class='sample' readonly='readonly' value='"+$('.ypbh').val()+"'/></li><li><lable>菌株原始编号</lable><input name='originalNum' type='text'  class='originalNum'/><span class='err'></span></li><li class='form-a'><lable>文献信息</lable><a class='xz-btn-a'>选择文件</a> <input type='text' name='docaddr' id='' value='' class='file-name-a'  readonly='readonly' placeholder='仅支持doc/docx格式文档'/><input name='word_addr' type='file' class='file-info-a' accept='.doc,.docx'/></li><li class='form-c'><lable>文本信息</lable><a class='xz-btn-c'>选择文件</a> <input type='text' name='txtaddr' id='' value='' class='file-name-c'  readonly='readonly' placeholder='仅支持txt格式'/><input name='txt_addr' type='file' class='file-info-c' accept='.txt'/></li><li class='form-b'><lable>图片信息</lable><a class='xz-btn-b'>选择文件</a> <input type='text' name='picaddr' id='' value='' class='file-name-b'  readonly='readonly' placeholder='仅支持jpg/png格式'/><input onchange='getPhotoSize(this)' name='picture_addr' type='file' class='file-info-b' accept='.png,.jpg,.jpeg'/></li><li><a class='del'>删除</a></li></ul></div></li>");
            i++;
        }else{
            if($(".edittable-bottom").length<26){
                $(".add-con").append("<li class='edittable-bottom'><div class='editbottom-left'>产毒菌株信息"+delcharacter[0]+"</div><div class='editbottom-right'><ul><li><lable>样品编号</lable><input id='sample_num' name='sample_num' type='text' class='sample' readonly='readonly' value='"+$('.ypbh').val()+"' /></li><li><lable>菌株原始编号</lable><input name='originalNum' type='text'  class='originalNum'/><span class='err'></span></li><li class='form-a'><lable>文献信息</lable><a class='xz-btn-a'>选择文件</a> <input type='text' name='docaddr' id='' value='' class='file-name-a'  readonly='readonly' placeholder='仅支持doc/docx格式文档'/><input name='word_addr' type='file' class='file-info-a' accept='.doc,.docx'/></li><li class='form-c'><lable>文本信息</lable><a class='xz-btn-c'>选择文件</a> <input  type='text' name='txtaddr' id='' value='' class='file-name-c'  readonly='readonly' placeholder='仅支持txt格式'/><input  name='txt_addr' type='file' class='file-info-c' accept='.txt'/></li><li class='form-b'><lable>图片信息</lable><a class='xz-btn-b'>选择文件</a> <input type='text' name='picaddr' id='' value='' class='file-name-b' readonly='readonly' placeholder='仅支持jpg/png格式图片'/><input onchange='getPhotoSize(this)' name='picture_addr' type='file' class='file-info-b' accept='.png,.jpg,.jpeg'/></li><li><a class='del'>删除</a></li></ul></div></li>");
                delcharacter.shift();
            }
        };
    });
    var delcharacter = [];
    //删除新增信息
    $(".table-con").on("click",'.del',function(){
        var y = $(this).parents(".editbottom-right").siblings(".editbottom-left").html().substring(6,7)
        delcharacter.push(y);
        delcharacter.sort();
        $(this).parents(".edittable-bottom").remove();
    });

    //上传文件
    $(".table-con").on("click",'.xz-btn-a',function(){
        $(this).siblings(".file-info-a").trigger('click');
    })
    $(".table-con").on("change",'.file-info-a',function(){
        $(this).siblings(".file-name-a").val($(this).val());
    })
    $(".table-con").on("click",'.xz-btn-b',function(){
        $(this).siblings(".file-info-b").trigger('click');
    })
    $(".table-con").on("change",'.file-info-b',function(){
        $(this).siblings(".file-name-b").val($(this).val());
    })
    $(".table-con").on("click",'.xz-btn-c',function(){
        $(this).siblings(".file-info-c").trigger('click');
    })
    $(".table-con").on("change",'.file-info-c',function(){
        $(this).siblings(".file-name-c").val($(this).val());
    })

});