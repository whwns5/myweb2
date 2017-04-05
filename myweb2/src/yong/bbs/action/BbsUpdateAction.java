package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsUpdateAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cp = req.getParameter("cp");
		
		String idx_s = req.getParameter("idx");
		int idx = 0;
		if(idx_s != null){
			idx = Integer.parseInt(idx_s);
		}
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		BbsDTO bdto = new BbsDTO(idx, subject, content);
		BbsDAO bdao = new BbsDAO();
		int result = bdao.bbsUpdate(bdto);
		
		String msg = "";
		msg = result > 0 ? "수정 완료" : "수정 실패";
		String href = "bbsListForm.yong?cp=" + cp;
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return "/bbs/bbsMsg.jsp";
	}

}
