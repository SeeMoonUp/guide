/*
 * http://love.hackerzhou.me
 */

// variables
var $win = $(window);
var clientWidth = $win.width();
var clientHeight = $win.height();
var loveYear = 0;

Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

$(window).resize(function() {
    var newWidth = $win.width();
    var newHeight = $win.height();
    if (newWidth != clientWidth && newHeight != clientHeight) {
        location.replace(location);
    }
});

(function($) {
	$.fn.typewriter = function() {
		this.each(function() {
			var $ele = $(this), str = $ele.html(), progress = 0;
			$ele.html('');
			var timer = setInterval(function() {
				var current = str.substr(progress, 1);
				if (current == '<') {
					progress = str.indexOf('>', progress) + 1;
				} else {
					progress++;
				}
				$ele.html(str.substring(0, progress) + (progress & 1 ? '_' : ''));
				if (progress >= str.length) {
					clearInterval(timer);
				}
			}, 75);
		});
		return this;
	};
})(jQuery);

// function timeElapse(date){
// 	var current = Date();
// 	var seconds = (Date.parse(current) - Date.parse(date)) / 1000;
// 	var days = Math.floor(seconds / (3600 * 24));
// 	seconds = seconds % (3600 * 24);
// 	var hours = Math.floor(seconds / 3600);
// 	if (hours < 10) {
// 		hours = "0" + hours;
// 	}
// 	seconds = seconds % 3600;
// 	var minutes = Math.floor(seconds / 60);
// 	if (minutes < 10) {
// 		minutes = "0" + minutes;
// 	}
// 	seconds = seconds % 60;
// 	if (seconds < 10) {
// 		seconds = "0" + seconds;
// 	}
//
// 	var result = "第 <span class=\"digit\">" + 6 + "</span> 年 <span class=\"digit\">" + days + "</span> 天 <span class=\"digit\">" + hours + "</span> 小时 <span class=\"digit\">" + minutes + "</span> 分钟 <span class=\"digit\">" + seconds + "</span> 秒";
// 	$("#clock").html(result);
// }

function timeElapse(date) {
    var start = '2013-2-14';
    var currentDate = new Date();
    var current = currentDate.getFullYear() + '-' + (currentDate.getMonth()+1) + '-' + currentDate.getDate();
    var result = getDiffYmdBetweenDate(start, current);
    $("#clock").html(result);

}



var getDiffYmdBetweenDate = function(sDate1,sDate2){
    var fixDate = function(sDate){
        var aD = sDate.split('-');
        for(var i = 0; i < aD.length; i++){
            aD[i] = fixZero(parseInt(aD[i]));
        }
        return aD.join('-');
    };
    var fixZero = function(n){
        return n < 10 ? '0'+n : n;
    };
    var fixInt = function(a){
        for(var i = 0; i < a.length; i++){
            a[i] = parseInt(a[i]);
        }
        return a;
    };
    var getMonthDays = function(y,m){
        var aMonthDays = [0,31,28,31,30,31,30,31,31,30,31,30,31];
        if((y%400 == 0) || (y%4==0 && y%100!=0)){
            aMonthDays[2] = 29;
        }
        return aMonthDays[m];
    };
    var checkDate = function(sDate){
    };
    var y = 0;
    var m = 0;
    var d = 0;
    var sTmp;
    var aTmp;
    sDate1 = fixDate(sDate1);
    sDate2 = fixDate(sDate2);
    if(sDate1 > sDate2){
        sTmp = sDate2;
        sDate2 = sDate1;
        sDate1 = sTmp;
    }
    var aDate1 = sDate1.split('-');
    aDate1 = fixInt(aDate1);
    var aDate2 = sDate2.split('-');
    aDate2 = fixInt(aDate2);
    //计算相差的年份
    /*aTmp = [aDate1[0]+1,fixZero(aDate1[1]),fixZero(aDate1[2])];
    while(aTmp.join('-') <= sDate2){
        y++;
        aTmp[0]++;
    }*/
    y = aDate2[0] - aDate1[0];
    if( sDate2.replace(aDate2[0],'') < sDate1.replace(aDate1[0],'')){
        y = y - 1;
    }
    //计算月份
    aTmp = [aDate1[0]+y,aDate1[1],fixZero(aDate1[2])];
    while(true){
        if(aTmp[1] == 12){
            aTmp[0]++;
            aTmp[1] = 1;
        }else{
            aTmp[1]++;
        }
        if(([aTmp[0],fixZero(aTmp[1]),aTmp[2]]).join('-') <= sDate2){
            m++;
        } else {
            break;
        }
    }
    //计算天数
    aTmp = [aDate1[0]+y,aDate1[1]+m,aDate1[2]];
    if(aTmp[1] > 12){
        aTmp[0]++;
        aTmp[1] -= 12;
    }
    while(true){
        if(aTmp[2] == getMonthDays(aTmp[0],aTmp[1])){
            aTmp[1]++;
            aTmp[2] = 1;
        } else {
            aTmp[2]++;
        }
        sTmp = ([aTmp[0],fixZero(aTmp[1]),fixZero(aTmp[2])]).join('-');
        if(sTmp <= sDate2){
            d++;
        } else {
            break;
        }
    }

    // if (loveYear === 0){
    //     loveYear = y;
    // } else if (loveYear !== y) {
    //     loveYear = y;
    //     setTimeout(function () {
    //         window.location.href = 'https://duolemon.github.io/';
    //     }, 2000)
    // }

    // return {y:y,m:m,d:d};
    var result = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"digit\">" + y + "</span> 年 <span class=\"digit\">" + m + "</span> 月 <span class=\"digit\">" + d + "</span> 天";
    var date = new Date();
    var hms = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='timeClock' style='font-size: 28px'>"+ date.getHours() + ' : ' + date.getMinutes() + ' : ' + date.getSeconds()+'</span>';
	// var hms = "<span class=\"digit\">" + 0 + "</span> 分钟 <span class=\"digit\">" + 1 + "</span> 秒"
    return result + hms;
};
