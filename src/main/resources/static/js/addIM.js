$(function(){
	/*添加产毒菌株信息*/
	var character = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
	var x = $(".edittable-bottom").length;
	var i = x;
	$("body").on("click",".add-ds",function(){
		if(i<26){
			$(".add-con").append("<li class='edittable-bottom'><div class='editbottom-left'>产毒菌株信息"+character[i]+"</div><div class='editbottom-right'><ul><li><lable>样品编号</lable><input id='sample_num' name='sample_num' type='text' class='sample '/></li><li><lable>菌株原始编号</lable><input name='originalNum'  type='text'  class='originalNum'/><span class='err'></span></li><li class='form-a'><lable>文献信息</lable><a class='xz-btn-a'>选择文件</a> <input type='text' name='wordAddr'/><input name='word_addr' type='file' class='wordAddr' accept='.doc,.docx'/></li><li class='form-c'><lable>文本信息</lable><a class='txtAddr'>选择文件</a> <input   type='text' name='txtAddr'/><input name='txt_addr' type='file' class='file-info-c' accept='.txt'/></li><li class='pictureAddr'><lable>图片信息</lable><a class='xz-btn-b'>选择文件</a> <input type='text' name='pictureAddr'/><input name='picture_addr' type='file' class='file-info-b' accept='.png,.jpg,.jpeg'/></li><li><a class='del'>删除</a></li></ul></div></li>");
			i++;
		}else{
			if($(".edittable-bottom").length<26){
				$(".add-con").append("<li class='edittable-bottom'><div class='editbottom-left'>产毒菌株信息"+character[i]+"</div><div class='editbottom-right'><ul><li><lable>样品编号</lable><input id='sample_num' name='sample_num' type='text' class='sample '/></li><li><lable>菌株原始编号</lable><input name='originalNum'  type='text'  class='originalNum'/><span class='err'></span></li><li class='form-a'><lable>文献信息</lable><a class='xz-btn-a'>选择文件</a> <input type='text' name='wordAddr'/><input name='word_addr' type='file' class='wordAddr' accept='.doc,.docx'/></li><li class='form-c'><lable>文本信息</lable><a class='txtAddr'>选择文件</a> <input   type='text' name='txtAddr'/><input name='txt_addr' type='file' class='file-info-c' accept='.txt'/></li><li class='pictureAddr'><lable>图片信息</lable><a class='xz-btn-b'>选择文件</a> <input type='text' name='pictureAddr'/><input name='picture_addr' type='file' class='file-info-b' accept='.png,.jpg,.jpeg'/></li><li><a class='del'>删除</a></li></ul></div></li>");
			delcharacter.shift();
			
			}
			
		};
	});
	/*添加毒素信息*/
	$(".add-dsxx").click(function(){
		$('.addds').append('<li class="edittable-middle"><div class="editmiddle-left">毒素信息</div><div class="editmiddle-right"><ul><li><lable>毒素种类</lable><select name="toxin_id" id="toxin_id1"><option value="0" >请选择</option></select><span id="toxin_id" ></span></li><li><lable>毒素含量</lable><input name="toxin_count" type="text"  maxlength="10" placeholder="毒素含量最大可输入十位"/><span id="toxin_count" ></span></li><li><a class="del">删除</a></li></ul></div></li>')
		$.ajax({
			url:"rest/addtextoption",
			type:"post",
			dataType:"json",
			success:function(res){
				$.each(res,function(index,item){
				$('div[class=addds] li:last-child').find('select').append('<option value='+(index+1)+'>'+item.toxin_type+'</option>');
				});
			}
		});
	});
	var delcharacter = [];
	//样品编号联动
	$(".ypbh").on("input",function(){
		if($(".add-con").find("li").length !==0){
			$(".sample").each(function(){
				var m = $(".ypbh").val();
				$(this).val(m);
			})
		}
	})
});
