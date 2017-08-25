<%
/* *
 *功能：支付宝即时到账交易接口调试入口页面
 *版本：3.4
 *日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 **********************************************
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>支付宝手机网站支付接口</title>
<link rel="stylesheet" type="text/css" href="../css/divChoose.css"/>
<link rel="stylesheet" type="text/css" href="../css/pay.css"/>
<link rel="stylesheet" type="text/css" href="../css/reveal.css"/>
<style type="text/css">
.littlecode{display:none;}
</style>
</head>


<body>
    <div class="div1">
		<div><img src="../img/后台_02.png" class="imghead"/></div>
		<div class="choose">
			<ul>
				<li id="tag1"><a href="javascript:void(0)" onclick="switchTag('tag1','content1');this.blur();" class="selectli1">
					<div class="divNormal" id="divNormal"><span class="spanNormal">普通会员</span></div>
					<div class="divimg1" id="divimg1"><img src="../img/矩形-2.png" class="imgnormal"/></div>
					<div class="divimg2" id="divimg2"><img src="../img/矩形-2-拷贝-2.png" class="imgnormal"/></div>
				</a></li>
				<li id="tag2"><a href="javascript:void(0)" onclick="switchTag('tag2','content2');this.blur();">
					<div class="divVip" id="divVip"><span >VIP会员</span></div>
					<div class="divimg3" id="divimg3"><img src="../img/矩形-2.png" class="imgnormal"/></div>
					<div class="divimg4" id="divimg4"><img src="../img/矩形-2-拷贝-2.png" class="imgnormal"/></div>
				</a></li>
				<li id="tag3"><a href="javascript:void(0)" onclick="switchTag('tag3','content3');this.blur();">
					<div class="divTop" id="divTop"><span >至尊会员</span></div>
					<div class="divimg5" id="divimg5"><img src="../img/矩形-2.png" class="imgnormal"/></div>
					<div class="divimg6" id="divimg6"><img src="../img/矩形-2-拷贝-2.png" class="imgnormal"/></div>
				</a></li>
			</ul>
		</div><br>
		
		
		<div id="content" class="content1">
			<div id="content1">
				<ul>
					<li>
						<img src="../img/房卡-拷贝-5.png" class="imgFK"/>
						<span class="spanPay">13 张</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform1" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.01">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no1"><!-- 商品订单号 -->
							<a href="#" onclick="fiveClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥5</span></div></a>
						</form>
					</li>
					<li>
						<img src="../img/房卡-拷贝-5.png" class="imgFK"/>
						<span class="spanPay">28 张</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform2" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.02">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no2"><!-- 商品订单号 -->
							<a href="#" onclick="TEightClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥10</span></div></a>
						</form>
					</li>
					<li style="border-bottom: 1px solid lightgray;">
						<img src="../img/房卡-拷贝-5.png" class="imgFK"/>
						<span class="spanPay">88 张</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform3" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.03">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no3"><!-- 商品订单号 -->
							<a href="#" onclick="EEClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥30</span></div></a>
						</form>
					</li>
				</ul>
				
			</div>
			<div id="content2" class="hidecontent" >
				<ul>
					<li>
						<img src="../img/椭圆-1-拷贝-14.png" class="imgFK"/>
						<span class="spanPay">月会员</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform4" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.02">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no4"><!-- 商品订单号 -->
							<a href="#" onclick="monthClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥60</span></div></a>
						</form>
					</li>
					<li>
						<img src="../img/椭圆-1-拷贝-14.png" class="imgFK"/>
						<span class="spanPay">半年会员</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform5" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.03">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no5"><!-- 商品订单号 -->
							<a href="#" onclick="harfClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥330</span></div></a>
						</form>
					</li>
					<li style="border-bottom: 1px solid lightgray;">
						<img src="../img/椭圆-1-拷贝-14.png" class="imgFK"/>
						<span class="spanPay">年会员</span>
						<form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform6" method="POST" target="_blank">
							<input type="hidden" name="WIDtotal_fee" value="0.01">
							<input type="hidden" name="WIDsubject" value="beautifulBuy"><!-- 商品名称 -->
            				<input type="hidden" name="WIDout_trade_no" id="out_trade_no6"><!-- 商品订单号 -->
							<a href="#" onclick="yearClick()" data-reveal-id="myModal" data-animation="fade"><div class="priceDiv"><span class="priceSpan">￥600</span></div></a>
						</form>
					</li>
				</ul>
			</div>
			<div id="content3" class="hidecontent">
				<div><img src="../img/图层-5.png"/></div>
				<p class="p_word1">终生免费会员</p>
				<p class="p_word2">联系客服：666666</p>
			</div>
			<div class="div1">
			<div id="myModal" class="reveal-modal">
				<ul>
					<li style="font-size: 20px;padding-top: 10px;">
						<span id="spanReceive"></span>
						<a href="#" onclick="payClick()"><img src="../img/zfb.jpg" width="130px"/></a>
					</li>
				</ul>
			</div>
	</div>
	</div>
    
    
    <!-- <div class="content">
        <form action="alipayapi.jsp" name=alipayment class="alipayform" id="alipayform" method="POST" target="_blank">
            <div class="element">
                <div class="etitle">付款金额:</div>
                <div class="einput"><input type="text" name="WIDtotal_fee" value="0.01"></div>
                <br>
            </div>
            
            <div class="element">
           	 	<input type="hidden" name="WIDsubject" value="beautifulBuy">商品名称
            	<input type="hidden" name="WIDout_trade_no" id="out_trade_no">商品订单号
                <input type="button" class="alisubmit" value ="确认支付" onclick="surePay()">
            </div>
        </form>
    </div> -->
    
    
    <div class="header">
        <div class="container black">
            <div class="qrcode">
                <div class="littlecode">
                	<!-- 没有会报错ALI38173,可以将其隐藏 -->
                    <img width="16px" src="../img/little_qrcode.jpg" id="licode">
                </div>      
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../js/pay.js"></script>
<script type="text/javascript" src="../js/jquery-1.6.2.js"></script>
<script type="text/javascript" src="../js/jquery.reveal.js"></script>
<script type="text/javascript">
        var even = document.getElementById("licode");   
        var showqrs = document.getElementById("showqrs");
         even.onmouseover = function(){
            showqrs.style.display = "block"; 
         }
         even.onmouseleave = function(){
            showqrs.style.display = "none";
         }
         
         var out_trade_no1 = document.getElementById("out_trade_no1");
         var out_trade_no2 = document.getElementById("out_trade_no2");
         var out_trade_no3 = document.getElementById("out_trade_no3");
         var out_trade_no4 = document.getElementById("out_trade_no4");
         var out_trade_no5 = document.getElementById("out_trade_no5");
         var out_trade_no6 = document.getElementById("out_trade_no6");
         //设定时间格式化函数
         Date.prototype.format = function (format) {
               var args = {
                   "M+": this.getMonth() + 1,
                   "d+": this.getDate(),
                   "h+": this.getHours(),
                   "m+": this.getMinutes(),
                   "s+": this.getSeconds(),
               };
               if (/(y+)/.test(format))
                   format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
               for (var i in args) {
                   var n = args[i];
                   if (new RegExp("(" + i + ")").test(format))
                       format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? n : ("00" + n).substr(("" + n).length));
               }
               return format;
           };
           
         out_trade_no1.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
         out_trade_no2.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
         out_trade_no3.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
         out_trade_no4.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
         out_trade_no5.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
         out_trade_no6.value = 'pay'+ new Date().format("yyyyMMddhhmmss");
 	function payClick(){
 		var spanReceive=document.getElementById("spanReceive").innerHTML;
		if(spanReceive==5){
			document.getElementById("alipayform1").submit();
		}else if(spanReceive==10){
			document.getElementById("alipayform2").submit();
		}else if(spanReceive==30){
			document.getElementById("alipayform3").submit();
		}else if(spanReceive==60){
			document.getElementById("alipayform4").submit();
		}else if(spanReceive==330){
			document.getElementById("alipayform5").submit();
		}else if(spanReceive==600){
			document.getElementById("alipayform6").submit();
		}
 	}
 	
 	
</script>

</html>