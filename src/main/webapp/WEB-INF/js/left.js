function openTab(title, url) {

    var tabs = $("#right").tabs("tabs");
    var length = tabs.length;
    for (var i = 0; i < length; i++) {
        var onetab = tabs[0];
        var titleOld = onetab.panel('options').tab.text();
        //var title = onetab.panel('options').title;
        $("#right").tabs("close", titleOld);
    }
    $("#right").tabs("add", {title: title, href: url, closable: true});
}


//必需是自然数
function isInt(str) {
    var reg = /^(([1-9]\d*|0))$/
    return reg.test(str);
}

/**
 * 判断是否是url
 * @param url
 * @returns {Array|{index: number, input: string}|*}
 */
function isUrl(url) {
    var regexp = new RegExp("(http[s]{0,1})://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?", "gi");
    return url.match(regexp) != null;
}

//设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//清除cookie
function clearCookie(name) {
    setCookie(name, "", -1);
}