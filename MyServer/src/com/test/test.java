package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test
{

	public static void main(String[] args)
	{

		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		try
		{

			Date serverDate = sdf.parse("1992-3-2 18:24:36");
			// 时间转回时间戳
			Date d = new Date(serverDate.getTime());

			System.out.println(serverDate.getTime());
			System.out.println(System.currentTimeMillis());
			// 时间戳 转回时间
			System.out.println(sdf.format(d));
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = MD5Util.MD5("18732252get9ab41cc1bbef27fa4b5b7d4cbe17a75a");
		System.out.println(str);
	}
	
	
	

}
