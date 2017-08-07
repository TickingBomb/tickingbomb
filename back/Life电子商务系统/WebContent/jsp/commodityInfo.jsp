<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
img {
	float: left;
}

hr {
	float: left;
	width: 1000px;
}

.top_box {
	width: 1000px;
	float: left;
	margin-top: 10px;
	margin-bottom: 10px;
}

.in {
	width: 20px;
}

.table_info {
	width: 500px;
	height: 30px;
	float: left;
}

.td_txt {
	width: 80px;
}

.input_sunmit {
	width: 150px;
	height: 30px;
	font-size: 20px;
	color: white;
	background-color: grey;
	border: 1px solid grey;
}

.kind_div {
	float: left;
	width: 1000px;
	height: 70px;
}

.littleInfo {
	float: left;
	width: 100px;
	margin-top: 10px;
	height: 50px;
	margin-left: 10px;
	border: 1px solid gray;
}

.delete_in {
	float: right;
	margin-top: 13px;
	color: white;
	background-color: gray;
	border: 1px solid gray;
}

.spanfont {
	float: left;
	margin-top: 15px;
	margin-left: 10px;
	font-size: 12px;
}

.upload_img {
	width: 1000px;
	height: 380px;
	float: left;
}

.font_div {
	width: 100px;
	height: 380px;
	float: left;
}

.img_div {
	float: left;
	width: 300px;
	height: 580px;
	margin-left: 10px;
}

.img_div2 {
	width: 100px;
	height: 170px;
	/*background-color: green;*/
	float: left;
}

.input_css {
	width: 20px;
	height: 20px;
	border: 0px;
	background-color: gray;
	float: left;
	margin-left: 40px;
	margin-top: -5px;
}

tr:hover {
	background-color: white;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js">
	
</script>
<script type="text/javascript">
	$(function() {
		var i = 100000000;
		$("#addkind")
				.click(
						function() {
							var ikey = $('#kindkey').val();
							var value = $('#kindvalue').val();
							var num=0;
							ikey = ikey.toString();
							value = value.toString();
							if(ikey!=""&&value!=""){
								var ret = ikey + ":" + value;
								var arr = $('.kindInfo');
								$.each(arr,function(i,item){
									var a = $(this).attr("value");
									if(a==ret){
 										num=1;
 									}
								});
								if(num==0){
									$('#kind').append(
											"<div class='littleInfo'><span class='spanfont'>"
														+ ret
														+ "</span><input type='button' class='delete_in' value='X' id='delete_in"
													+ i
													+ "' onclick='deleteKind("
														+ i
														+ ")'/><input type='hidden' name='kind' class='kindInfo' value='"+ret+"'></div>")
										i++;
								}else{
									alert("标签以存在");
								}
							}
							
						});

		$("#firstInfo").change(
				function() {
					var info = $("#firstInfo").val();
					var i="-请选择-";
					$("#secondInfo").html("");
					$('#secondInfo').append(
							'<option value="' + i + '">' + i
									+ '</option>');
					$("#thirdInfo").html("");
					$('#thirdInfo').append(
							'<option value="' + i + '">' + i
									+ '</option>');
					
					$.get("secondInfo.do", {
						info : info
					}, function(data) {
						var strInfo = data.split("#");
						for (var i = 0; i < strInfo.length; i++) {
							var arr = strInfo[i].split(":");
							$('#secondInfo').append(
									'<option value="' + arr[0] + '">' + arr[1]
											+ '</option>');
						}
					});
				});
		$("#secondInfo").change(
				function() {
					var info = $("#secondInfo").val();
					$("#thirdInfo").html("");
					$.get("secondInfo.do", {
						info : info
					}, function(data) {
						var strInfo = data.split("#");
						for (var i = 0; i < strInfo.length; i++) {
							var arr = strInfo[i].split(":");
							$('#thirdInfo').append(
									'<option value="' + arr[0] + '">' + arr[1]
											+ '</option>');
						}
					});
				});
		});
	function deleteKind(i) {
		var id = "delete_in" + i;
		$('#div_hidden').append("<input type='hidden' name='deleted' value='"+i+"'>");
		document.getElementById(id).parentElement.remove();
	}
	
	function deleteImg(i,id,url) {
		var getId = "preview" + i;
		$('#div_img_hidden').append("<input type='hidden' name='deletePicUrl' value='"+id+"#"+url+"'>");
		document.getElementById(getId).parentElement.remove();
	}
	
	function setImagePreview(avalue) {
		var docObj = document.getElementById("doc" + avalue);
		if (docObj.files && docObj.files[0]) {
			if(avalue == 1){
				var imgObjPreview = document.getElementById("preview" + avalue);
				//火狐下，直接设img属性
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '230px';
				imgObjPreview.style.height = '280px';
				//imgObjPreview.src = docObj.files[0].getAsDataURL();
				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			}else if (avalue == 2) {
				for(var i=0;i<docObj.files.length;i++){
					var id="preview"+(i+2);
					var hidID="hid"+i;
					var imgObj=document.getElementById(id);
					var hid=document.getElementById(hidID);
					hid.style.display = 'block';
					imgObj.style.display = 'block';
					imgObj.style.width = '100px';
					imgObj.style.height = '150px';
					imgObj.src = window.URL.createObjectURL(docObj.files[i]);
				}
			}
		} else {
			//IE下，使用滤镜
			// 			alert("IE下");
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag" + avalue);
			//必须设置初始大小
			localImagId.style.width = "150px";
			localImagId.style.height = "180px";
			//图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}

</script>
</head>
<body background="#F3F3F3">
	<form action="updateCommodityInfo.do" method="post"
		enctype="multipart/form-data">
		<!-- 		enctype="multipart/form-data" -->
		<div class="top_box">
			<span>商品管理&nbsp;&nbsp;>&nbsp;&nbsp;商品基本信息&nbsp;&nbsp;>&nbsp;&nbsp;信息修改</span>
			<a href="commodityList.do">返回</a>
		</div>
		<hr>
		<div class="top_box">
			<table class="table_info">
				<tr>
					<td class="td_txt">商品名称：</td>
					<td><input type="text" name="name" value="${commodity.name}" />
						<input type="hidden" name="commodityNo"
						value="${commodity.commodityNo}" /></td>
					<td class="td_txt">激活： <input type="checkbox" name="states"
						${commodity.states==1? "checked":""} value="1" />
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div class="top_box">
			类别信息： <select name="firstInfo" id="firstInfo">
				<c:forEach items="${fiList}" var="key">
					<option ${fiCate.id==key.id?"selected":""} value="${key.id}">${key.categoryname!=""&&key.categoryname!=null?key.categoryname:"没有此类"}</option>
				</c:forEach>
			</select> <select name="secondInfo" id="secondInfo">
				<option value="miss">--请选择--</option>
				<c:forEach items="${seList}" var="key">
					<option ${seCate.id==key.id?"selected":""} value="${key.id}">${key.categoryname!=""&&key.categoryname!=null?key.categoryname:"没有此类"}</option>
				</c:forEach>
			</select> <select name="thirdInfo" id="thirdInfo">
				<option value="miss">--请选择--</option>
				<c:forEach items="${thList}" var="key">
					<option ${thCate.id==key.id?"selected":""} value="${key.id}">${key.categoryname!=""&&key.categoryname!=null?key.categoryname:"没有此类"}</option>
				</c:forEach>
			</select>
		</div>
		<hr>
		<div class="top_box">
			规格信息：&nbsp;&nbsp; 规格组： <input type="text" name="kindkey" id="kindkey" />
			规格名： <input type="text" name="kindvalue" id="kindvalue" /> <input
				type="button" value="+" id="addkind" />
			<hr>
			<div class="kind_div" id="kind">
				<c:forEach items="${specList}" var="key">
					<div id="father_div" class='littleInfo'>
						<span  class='spanfont'>${key.specGroup}:${key.specName}</span>
						<input type='button' class='delete_in' value='X'
							id='delete_in${key.specid}' onclick='deleteKind(${key.specid})' />
						<input type='hidden' class='kindInfo' value='${key.specGroup}:${key.specName}'>
					</div>
				</c:forEach>
			</div>
			<div id="div_hidden"></div>
		</div>
		<hr />
		<div class="top_box">
			商品简介： <br>
			<textarea cols="150" rows="7" name="introduce">${commodity.introduce}</textarea>
		</div>
		<div class="top_box">
			商品简介： <br>
			<textarea cols="150" rows="7" name="detailed">${commodity.detailed}</textarea>
		</div>
		<hr>
		<div class="upload_img">
			<div class="font_div">商品主图：</div>
			<div class="img_div" id="localImag1">
				<img id="preview1" src="<%=basePath %>${commodity.pictureurl}"
					style="width: 230px; height: 280px">
			</div>
			<div class="img_div">
				<input type="hidden" name="pictureurl" id="textfield"> <input
					type="file" name="myfiles" id="doc1" style="width: 150px;"
					onchange="document.getElementById('textfield').value=this.value">
			</div>
			<!-- 			document.getElementById('textfield').value=this.value -->
			<input type="button" value="上传主图" class="input_sunmit"
				onclick="javascript:setImagePreview(1);">
		</div>
		<hr>
		<div class="upload_img">
			<div class="font_div">商品配图：</div>
			<div class="img_div" id="localImag2">
				<%
					int i = 10;
				%>
				<c:forEach items="${comList}" var="key">
					<div class="img_div2">
						<img id="preview<%=i%>" src="<%=basePath%>${key.pictureUrl}"
							style="width: 100px; height: 150px"> <input type="button"
							class="input_css" value="X"
							onclick="deleteImg('<%=i%>','${key.id}','${key.pictureUrl}')" />
						<!-- display: none; -->
						<%
							i++;
						%>
					</div>
				</c:forEach>
				<div class="img_div2">
					<img id="preview2"
						style="display: none; width: 100px; height: 150px"> <input
						id="hid0" type="button" style="display: none;" class="input_css"
						value="X" onclick="deleteImg('2','two','twourl')" />
				</div>
				<div class="img_div2">
					<img id="preview3"
						style="display: none; width: 100px; height: 150px"> <input
						id="hid1" type="button" style="display: none;" class="input_css"
						value="X" onclick="deleteImg('3','two','twourl')" />
				</div>
				<div class="img_div2">
					<img id="preview4"
						style="display: none; width: 100px; height: 150px"> <input
						id="hid2" type="button" style="display: none;" class="input_css"
						value="X" onclick="deleteImg('4','two','twourl')" />
				</div>
			</div>
			<div id="div_img_hidden"></div>
			<div class="img_div">
				<input type="file" multiple="multiple" name="myfiles" id="doc2"
					style="width: 150px;"
					onchange="document.getElementById('textfields').value=this.value">
			</div>
			<input type="button" value="上传配图" class="input_sunmit"
				onclick="javascript:setImagePreview(2);" />
		</div>
		<hr>
		<div class="top_box">
			<center>
				<input type="submit" value="保存信息" class="input_sunmit" />
			</center>
		</div>
	</form>
</body>
</body>
</html>