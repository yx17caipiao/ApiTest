package com.yxkj.yqcp.test;

import com.google.gson.Gson;


import java.util.List;

import com.yxkj.yqcp.bean.AwardBean;
import com.yxkj.yqcp.util.okHttpUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class RequestCls {
	static String VerName="http://appadmin_api.test.17caipiao.com/appadmin/public/safeMobileHandler.do";
	static String appIndex="http://appadmin_api.17caipiao.com/ appadmin/public/safeMobileHandler.do";
	static String url1="http://app-api.test.17caipiao.com/appadmin/public/safeMobileHandler.do";
	static String data1="XXWodqWR+CJnRu1hB3FngMnASAZKiw0Pjk1M++hMwJk8TBqyt2RqlbWQjoXml4MSBoYesBEaUh97dgeo+4fsE6XvWC78qb/9B6Nhv/WGpfNQP+8EBrZ2iYWBRtthW8Ekx9IVdc5Qkud1sJWbkD8IueVIFpTqN5h+6TQx27vrBv8F0Kmxtrr3wX308obkjEbGj02guZoPzyvHqEFVktnomXziNBMhcP4Fn9OsGDlcAwO1mrNiyvJ1HzYH4U+CmGI13UZB9XWRLDKctxxwOOk6uhDrdq+QTZJy3gRLBoJgNuJAKtjpebCwVhoxTnckB9Hy+G0LTkFEiUxl6CnZWlj1GQlBfN4wflILuiWeAXnD/WI3NoJWApmRVjC/AD4zf/fwFA+TA83yFwVmDNyubtvV6eU2YMdVxHbpVGE+pcuF4KOHibGlN/cKl+7vOl4t0/Dmx8PUepBh/OTgMBP6tZ2W6xVkUOskY+SxA1cL1X2DO/hIdBAHRSWXGTtROLbO2xryEZNf+9qILztDD2Z+uPqaAVrDGCEowdn8gD8PyDcdrznXrqDyyUewWawi+wEoMS0jJIYeVr2fv2decYJtHJTQh8Z6aASH/GUlIB9y3C8twnHH8jF8VEBbTKejPGhdX91MzfVPEqelEWizdZzvF03ftw==";

	 // test case 1
    @Test
    public void testCase1() {

        okHttpUtil ok=new okHttpUtil();
    	String result=ok.httpPost(url1, data1);
    	System.out.println(result);
    	Gson gson=new Gson();
    	AwardBean awd=gson.fromJson(result, AwardBean.class);
    	List<AwardBean.AwardCls> acls=awd.data;
    	System.out.println(acls.get(0).getLotteryName());
    	
		
		
    }

    // test case 2
    @Test
    public void testCase2() {
        System.out.println("����case 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("���� beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is afterSuite");
    }

}
