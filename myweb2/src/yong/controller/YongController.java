package yong.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

public class YongController extends HttpServlet{

	private Map commandMap;
	
	public YongController() {
		commandMap = new HashMap();
	}
	
	@Override
	public void init() throws ServletException {
		String path = this.getServletContext().getRealPath("/WEB-INF/yongCommand.properties");
		
		Properties pr = new Properties();
		try {
			FileInputStream f = new FileInputStream(path);
			pr.load(f);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Object> keys = pr.keySet().iterator();
		while(keys.hasNext()){
			String key = (String) keys.next();
			String value = pr.getProperty(key);
			
			try {
				Class sobject = Class.forName(value); // 문자열로 구성된 클래스의 설계도를 생성
				Object obj = sobject.newInstance(); // 그 설계도로 객체를 생성
				commandMap.put(key, obj);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userProcess(req, resp);
	}
	
	protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 요청받음
		//String type = req.getParameter("type");
		String type = req.getRequestURI();
		if(type.indexOf(req.getContextPath()) == 0){
			type = type.substring(req.getContextPath().length());
		}
		
		// 2. 요청분석
		CommandHandler cmd = (CommandHandler) commandMap.get(type);
		//String result = "";
		//String goPage = "";
		//CommandHandler cmd = null;
		//if(type.equals("list")){
			// 3. 요청처리
			//result = "리스트 기능을 요청하였음.";
			//goPage = "/list.jsp";
			//cmd = new ListAction();
		//} else if(type.equals("write")) {
			//result = "글쓰기 기능을 요청하였음.";
			//goPage = "/write.jsp";
			//cmd = new WriteAction();
		//} else if(type.equals("content")){
			//result = "본문보기 기능을 요청하였음.";
			//goPage = "/content.jsp";
			//cmd = new contentAction();
		//}
		
		// 4. 저장
		//req.setAttribute("result", result);
		// 5. 전달
		String goPage = cmd.process(req, resp);
		RequestDispatcher dis = req.getRequestDispatcher(goPage);
		dis.forward(req, resp);		
	}
}
