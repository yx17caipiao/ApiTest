package com.yxkj.yqcp.util;//import com.jdd.fm.core.context.BaseContext;
//import com.jdd.fm.core.exception.ErrorCode;
//import com.jdd.fm.core.exception.FmCoreException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author chenlongfei
 * 获取comProperties的的值的工具类
 */
public class PropertiesUtil {
	public static String get(String key)
	{
		 String value= BaseContext.configProperties.getProperty(key);
		 return value;
	}
	public static String  getProperties(String path,String key) {   
        Properties prop = new Properties();   
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);   
        try {   
            prop.load(in);
            in.close();
        } catch (IOException e) {   
            e.printStackTrace();
//            throw new FmCoreException(ErrorCode.PROPERTIES_LOAD_ERROR,ErrorCode.PROPERTIES_LOAD_ERROR.getMessage(path));
        }  
        String value= prop.getProperty(key);
		 prop.clear();
		 return value;
    }

    public static Properties  getPropertie(String path) {
        Properties prop = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            prop.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
