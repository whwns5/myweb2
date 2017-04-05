package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsDeleteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cp_s = req.getParameter("cp");
		int cp = 1;
		if(cp_s != null){
			cp = Integer.parseInt(cp_s);
		}
		
		String idx_s = req.getParameter("idx");
		int idx = 0;
		if(idx_s != null){
			idx = Integer.parseInt(idx_s);
		}
		
		BbsDTO bdto = new BbsDTO();
		bdto.setIdx(idx);
		BbsDAO bdao = new BbsDAO();
		int result = bdao.bbsDelete(bdto);
		
		String msg = "";
		msg = result > 0 ? "삭제 완료" : "삭제 실패";
		String href = "";
		href = "bbsListForm.yong?cp=" + cp;
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return "/bbs/bbsMsg.jsp";
	}

}
