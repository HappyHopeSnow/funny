package com.weishu.util;




import com.weishu.constant.WebConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ishehui on 2015-05-14.
 */
public class LoginUtils {
    /**
     * 设置cookie
     * @param uid
     * @param response
     * @param request
     */
    public static void setCookie(long uid,HttpServletResponse response,HttpServletRequest request,String token){
        Cookie uidCookie = new Cookie(WebConstants.UID_COOKIE,uid+"");
        Cookie  utokenCookie = new Cookie(WebConstants.TOKEN_COOKIE,token);

        uidCookie.setMaxAge(WebConstants.COOKIE_MAX_TIME);
        utokenCookie.setMaxAge(WebConstants.COOKIE_MAX_TIME);

        uidCookie.setPath("/");
        utokenCookie.setPath("/");

        response.addCookie(uidCookie);
        response.addCookie(utokenCookie);
    }

    /**
     * 退出 删除cookie
     * @param response
     * @param request
     */
    public static void logoutCookie(HttpServletResponse response,HttpServletRequest request){
        Cookie uidCookie = new Cookie(WebConstants.UID_COOKIE,null);
        Cookie  utokenCookie = new Cookie(WebConstants.TOKEN_COOKIE,null);
        Cookie  deviceCookie = new Cookie(WebConstants.DEVICE,null);

        uidCookie.setMaxAge(WebConstants.COOKIE_MAX_TIME);
        utokenCookie.setMaxAge(WebConstants.COOKIE_MAX_TIME);
        deviceCookie.setMaxAge(WebConstants.COOKIE_MAX_TIME);

        uidCookie.setPath("/");
        utokenCookie.setPath("/");
        deviceCookie.setPath("/");

        response.addCookie(uidCookie);
        response.addCookie(utokenCookie);
        response.addCookie(deviceCookie);
    }
    public static String getCookieDomain(HttpServletRequest request){
        //设置cookie域名，先取出URL中的超域
        String superDomain = getSuperDomain(request.getRequestURL().toString());
        //前面加个.
        return "." + superDomain;
    }
    /**
     * 匹配URL的超域名，前面协议加与不加都可
     * 如：http://a.domain.com/  -> domain.com
     * a.bc.dd ->  bc.dd
     * @param url
     * @return
     */
    public static String getSuperDomain(String url) {
        Matcher matcher = Pattern.compile("^(?:\\w+://)?(?:\\w+\\.)*(\\w+\\.\\w+)(?:\\W.*)?$").matcher(url);
        if(matcher.matches()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
    public static String decodeURIComponent(String s) {
        if (s == null) {
            return null;
        }
        String result = null;
        try {
            result = URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            result = s;
        }
        return result;
    }

    public static Map<String, String> getCookieMap(Cookie[] cookies) {
        return cookieToMap(cookies);
    }

    public static Map<String, String> cookieToMap(Cookie[] cookies) {
        Map<String, String> map = new HashMap<String, String>();
        if(cookies!=null) {
            for(Cookie cookie : cookies) {
                map.put(cookie.getName(), cookie.getValue());
            }
        }
        return map;
    }
}
