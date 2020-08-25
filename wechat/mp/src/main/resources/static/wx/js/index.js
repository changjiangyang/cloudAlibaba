$(document).ready(function() {
    //添加图片
    $("div .subMenu>img").each(function() {
        var name = $(this).attr("data-imgname");
        var src = "http://www.jq22.com/img/cs/500x300-" + name + ".png"
		if(name==1)
			src="../img/shouye.png"
		else if (name==3)
			src= "../img/kefu1.png"
		else if (name==4)
			src = "../img/share.png"
		else if(name==5)
			src="../img/wode.png"
        //设置img的属性和值。
        $(this).attr("src", src);
    });

    //点击事件
    $("div .subMenu").click(function() {
        // 取消当前激活状态
		var index= $(this).children("img").attr("index");
		console.log(index);
		
        var $img = $(".active>img");
        //返回被选元素的属性值
        var name = $img.attr("data-imgname");
		console.log(name)
		var src;
		if(name==1)
			src="../img/shouye.png"
		else if (name==3)
			src= "../img/kefu1.png"
		else if (name==4)
			src= "../img/share.png"
		else if (name==5)
			src= "../img/wode.png"
        $img.attr("src", src);
		if(index==2){
			$(".dol").css("display","block");
			$(".hidden").css("display","block");
			return;
		}
        $(".active").removeClass("active");

        // 添加新状态
        $(this).addClass("active");
        //找到所有 div(subMenu) 的子元素(img)
        $img = $(this).children("img");
        name = $img.attr("data-imgname");
        src = "http://www.jq22.com/img/cs/500x300-" + name + ".png";
		if(name==1)
			src="../img/shouyeactivity.png"
		else if (name==3)
			src= "../img/kefuactivity.png"
		else if (name==4)
			src= "../img/shareactivity.png"
		else if (name==5)
			src= "../img/wodeacvitity.png"
        //设置img的属性和值。
        $img.attr("src", src);
		
        //content根据点击按钮加载不同的html
        var page = $(this).attr("data-src");
		console.log(page)
        if (page) {
            $("#content").load(page)
        }
    });

    // 自动点击第一个菜单
    $("div .subMenu")[0].click();
	initSize()
});

/*content高度*/
function initSize() {
    var height = $(window).height() - $("header").height() - $("#description").height() - $("#menu").height();
	var pa=$("#menu").css("paddingTop").replace('px', '')
	console.log(pa)
    $("#content").height(height + "px");
	$("#content").css("margin-bottom",($("#menu").height()+parseInt(pa)+10)+"px")
}

function closedol(){
	
	$(".dol").css("display","none");
	$(".hidden").css("display","none");
}

function call(){
	alert("call")
}
