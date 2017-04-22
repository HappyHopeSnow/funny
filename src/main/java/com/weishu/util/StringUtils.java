package com.weishu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {


	/**
	 * 驼峰式转下划线
	 * @author Jack Chan
	 * @param param
	 * @return
	 */
	public static String camel2underline(String param){
		Pattern  p=Pattern.compile("[A-Z]");
		if(param==null ||param.equals("")){
			return "";
		}
		StringBuilder builder=new StringBuilder(param);
		Matcher mc=p.matcher(param);
		int i=0;
		while(mc.find()){
			builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());
			i++;
		}

		if('_' == builder.charAt(0)){
			builder.deleteCharAt(0);
		}
		return builder.toString();
	}
	/**
	 * 下划线转驼峰
	 * @author Jack Chan
	 * @param str
	 * @return
	 */

	public static String underline2camel(String str){
		while(str.contains("_")){
			int i = str.indexOf("_");
			if(i+1<str.length()){
				char c = str.charAt(i+1);
				String temp = (c+"").toUpperCase();
				str = str.replace("_"+c, temp);
			}
		}
		return str;
	}
	/**
	 * 安全的数组字符串是否为空判断 替代 array.length>5&&array[5]!=null.....
	 * @param array 数组
	 * @param index 索引
	 * @return
	 */
	public static boolean isArrayStringEmpty(String[]array,int index){
		if (array.length<=index)
			return true;
		return isEmpty(array[index]);
	}
	public static int safeStringCompTo(String str1,String str2){
		if (str1==null && str2==null)
			return 0;
		if (str1==null)
			return -1;
		if (str2==null)
			return 1;
		return str1.compareTo(str2);
	}
	/**
	 * 安全字符串比较,区分大小写 都为null返回true
	 * @param str1 要比较的字符串1
	 * @param str2 要比较的字符串2
	 * @return true相等，false不等
	 */
	public static boolean safeStringComp(String str1,String str2)
	{
		if (str1==null && str2==null)
			return true;
		if (str1==null || str2==null)
			return false;
		return str1.equals(str2);
	}
	/**
	 * 安全字符串比较,不区分大小写 都为null返回true
	 * @param str1 要比较的字符串1
	 * @param str2 要比较的字符串2
	 * @return true相等，false不等
	 */
	public static boolean safeStringIgnoreComp(String str1,String str2)
	{
		if (str1==null && str2==null)
			return true;
		if (str1==null || str2==null)
			return false;
		return str1.equalsIgnoreCase(str2);
	}
	
	/**
	 * 返回字符串有效长度
	 * @param str 字符串
	 * @return 返回字符串有效长度
	 */
	public static int noSpaceStringLen(String str)
	{
		
		if (str==null)
			return 0;
		return str.trim().length();
	}
	
	public static boolean isEmpty(String v)
	{
		return (noSpaceStringLen(v)==0);

	}
	static Pattern parttern= Pattern.compile("\\p{Punct}");//包括!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~标点
	public static String safeString(String org){
		if (org==null)
			return org;
		
		Matcher matcher = parttern.matcher(org);
		return matcher.replaceAll("").trim();
	}

	public static String[] trimSplit(String str, String regex){
		String[] array = new String[0];
		if(StringUtils.isEmpty(str) || StringUtils.isEmpty(regex)){
			return array;
		}
		array = str.split(regex);
		List<String> list = new ArrayList<String>();
		int i = 0;
		for(; i< array.length; i++){
			if(!StringUtils.isEmpty(array[i])){
				list.add(array[i]);
			}
		}
		return list.toArray(array);
	}

	public static final int maxSize = 8;
    
	/** 最多返回8个字加上... */
    public static String getString(String str) {
    	return getString(str, maxSize);
    }

    public static String getString(String str, int size) {
    	if(StringUtils.isBlank(str)) {
    		return "";
    	}
    	if(size <= 0) {
    		return "";
    	}
    	
    	int length = str.length();
    	if(length <= (size+3)) {
    		return str;
    	}
    	
    	return str.substring(0, size) + "...";
    }
    
	public static final Pattern BRACKET = Pattern.compile("[《｛【（＜［<\\{\\[\\(]([^》｝】）＞］>\\}\\]\\)]*)[》｝】）＞］>\\}\\]\\)]");
	
	public static String getBracketString(String input){
		if(StringUtils.isBlank(input)){
			return "";
		}
		Matcher matcher = BRACKET.matcher(input);
		if(matcher.find() && matcher.start() == 0){
			return input.substring(matcher.start(1), matcher.end(1));
		}else{
			return "";
		}
	}
	public static String replaceBracketString(String input, String replacement){
		if(StringUtils.isBlank(input)){
			return "";
		}
		if(replacement == null){
			return input;
		}
		Matcher matcher = BRACKET.matcher(input);
		if(matcher.find() && matcher.start() == 0) {
			return input.replace(input.substring(matcher.start(0), matcher.end(0)), replacement);
		}else{
			return input;
		}
	}

	/**
	 * 产生非0的随机整数
	 * @return
	 */
	public static int getRandomInt() {
		Random random = new Random();
		int result = random.nextInt(Integer.MAX_VALUE - 10);
		if(result <= 0) {
			return getRandomInt();
		}

		return result;
	}

}
