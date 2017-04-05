package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsWriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String pwd = req.getParameter("pwd");
		
		BbsDTO bdto = new BbsDTO(writer, pwd, subject, content);
		BbsDAO bdao = new BbsDAO();
		int result = bdao.bbsWrite(bdto);
		
		String msg = "";
		String href = "";
		msg = result > 0 ? "게시글 등록 완료" : "게시글 등록 실패";
		href = "bbsListForm.yong";
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return "/bbs/bbsMsg.jsp";
	}

}
