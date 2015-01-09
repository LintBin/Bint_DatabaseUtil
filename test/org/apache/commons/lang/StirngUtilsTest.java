package org.apache.commons.lang;

import org.junit.Test;

public class StirngUtilsTest {
	@Test
	public void capitalize(){
		//System.out.println(StringUtils.capitalize("admin"));
		String str = this.test("admin");
	}
	
	
	public String test(String str){
		 int strLen;
	        if (str == null || (strLen = str.length()) == 0) {
	            return str;
	        }
	        StringBuffer sf = new StringBuffer(strLen);
	        System.out.println(str.substring(1));
	        
	        sf.append(Character.toTitleCase(str.charAt(0)));
	        return new StringBuffer(strLen)
	            .append(Character.toTitleCase(str.charAt(0)))
	            .append(str.substring(1))
	            .toString();
	}
}

