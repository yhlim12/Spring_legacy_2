package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	public static void main(String[] args) {
		Connection con;
		try {
			con = DBConnect.getConnect();
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect() throws Exception{
		//1. 濡쒓렇�씤 �젙蹂� 4媛�吏� (user,password,url,driver)
		
		//logon deny
		//1. ID/PW媛� ���졇�쓣 寃쎌슦
		//2. DB�뿉 �빐�떦 �쑀��媛� �깮�꽦�릺吏� �븡�� 寃쎌슦
		//3. �쑀���쓽 沅뚰븳�씠 �쟻�슜 �릺吏� �븡�� 寃쎌슦
		String user = "user02";
		String password= "user02";
		
		//not connect
		//1. ip, port, xe �젙蹂닿� ��由� 寃쎌슦
		//2. 臾쇰━�쟻�쑝濡� �뿰寃곗씠 �븞�릺嫄곕굹, �꽌踰꾧� 醫낅즺�맂 寃쎌슦
		//3. Listener臾몄젣 , DB �옱�떆�룞
		String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		//2. �뱶�씪�씠踰꾨�� 硫붾え由ъ뿉 濡쒕뵫
		//class not found Exception
		//1. driver紐낆씠 ��由� 寃쎌슦
		//2. jdbc API(ojdbc6.jar)媛� �뾾�뒗 寃쎌슦
		
		Class.forName(driver);
		
		//3. 濡쒓렇�씤 �썑 Connection 媛앹껜 諛섑솚
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
