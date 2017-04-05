package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;

public class BbsReWriteFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int cp = Integer.parseInt(req.getParameter("cp"));
		int ref = Integer.parseInt(req.getParameter("ref"));
		int lev = Integer.parseInt(req.getParameter("lev"));
		int sunbun = Integer.parseInt(req.getParameter("sunbun"));
		
		req.setAttribute("cp", cp);
		req.setAttribute("ref", ref);
		req.setAttribute("lev", lev);
		req.setAttribute("sunbun", sunbun);
		
		return "/bbs/bbsReWrite.jsp";
	}

}
