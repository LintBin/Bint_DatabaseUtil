package org.apache.commons.lang;

import org.junit.Test;
import org.apache.commons.lang.ObjectUtils;
public class ObjectUtilsTest {
	@Test
	public void equals(){
		
		String str1 = "";
		String str2 = "111111";
		boolean flag = ObjectUtils.equals(str1, str2);
		System.out.println(flag);
		
		
	}
}
