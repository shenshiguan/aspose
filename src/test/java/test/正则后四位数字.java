package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则后四位数字 {

	public static void main(String[] args) {
	    // 要验证的字符串
		
	    String regEx = ".*\\d{4}$";
	    
	    regEx = "^.*\\d{4}$";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
//	    Pattern pattern = Pattern.compile("\\d+$");
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    	
		
	    String str = "F:/已核对历年真题/财政部/经济学综合2005/经济学综合2005试题及答案.pdf";
	 
	    String[] strs = str.split("/");
	    System.out.println(strs.length);
    	String str3 = "";
//	    if(strs.length>3){
//	    	str3 = strs[3];
//	    	System.out.println(str3);
//	    	Matcher matcher = pattern.matcher(str3);
////		    // 字符串是否与正则表达式相匹配
//		    boolean rs = matcher.matches();
//		    System.out.println(rs);
//	    	
////		    if(matcher.find()){
////		    	System.out.println("字符串"+str3+"是以数字结尾的，结尾的数字是："+matcher.group());
////		    }
//	    }

	 
	    if(strs.length>3){
	    	str3 = strs[3];
	    	System.out.println(str3);
		    pattern = Pattern.compile("\\d+$");
	    	Matcher matcher = pattern.matcher(str3);
//		    if(matcher.find()){
//		    	System.out.println("字符串"+str3+"是以数字结尾的，结尾的数字是："+matcher.group());
//		    }
//		    System.out.println(matcher.replaceAll(".*\\d{4}$"));
    		int count = matcher.groupCount();
    		if(matcher.find()){

        		System.out.println(count);
        		for(int i = 0 ;i<count;i++){
        			
        			System.out.println(matcher.group(i));
        		}
    		}
	    }

	}

}
