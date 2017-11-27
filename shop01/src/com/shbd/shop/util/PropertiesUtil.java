package com.shbd.shop.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties jdbcProp;
	private static Properties daoProp;
	
	public static Properties getJdbcProp() {
		if(jdbcProp == null) {
			try {
				jdbcProp = new Properties();
				jdbcProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jdbcProp;
	}
	
	public static Properties getDaoProp() {
		if(daoProp == null) {
			try {
				daoProp = new Properties();
				daoProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("dao.properties"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return daoProp;
	}
}
