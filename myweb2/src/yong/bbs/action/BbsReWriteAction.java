package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsReWriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cp = Integer.parseInt(req.getParameter("cp"));
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String pwd = req.getParameter("pwd");
		
		int ref = Integer.parseInt(req.getParameter("ref"));
		int lev = Integer.parseInt(req.getParameter("lev"));
		int sunbun = Integer.parseInt(req.getParameter("sunbun"));
		
		BbsDTO bdto = new BbsDTO(writer, pwd, subject, content, ref, lev, sunbun);
		BbsDAO bdao = new BbsDAO();
		int result = bdao.bbsReWrite(bdto);
		
		String msg = "";
		String href = "";
		msg = result > 0 ? "답글 등록 완료" : "답글 등록 실패";
		href = "bbsListForm.yong?cp=" + cp;
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return "/bbs/bbsMsg.jsp";
	}

}
