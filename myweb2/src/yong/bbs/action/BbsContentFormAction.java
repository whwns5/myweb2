package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsContentFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idx_s = req.getParameter("idx");
		int idx = 0;
		if(idx_s != null){
			idx = Integer.parseInt(idx_s);
		}
		String cp_s = req.getParameter("cp");
		int cp = 1;
		if(cp_s != null && !(cp_s.equals("")) ){
			cp = Integer.parseInt(cp_s);
		}
		
		BbsDAO bdao = new BbsDAO();
		BbsDTO bdto = bdao.bbsContent(idx);
		
		
		String msg = "";
		String goPage = "";
		String href = "";
		if(bdto == null){
			msg = "삭제된 게시글이거나 잘못된 접근입니다.";
			goPage = "/bbs/bbsMsg.jsp";
			href = "bbsListForm.yong";
			req.setAttribute("msg", msg);
			req.setAttribute("href", href);
		} else {
			bdto.setContent(bdto.getContent().replaceAll("\n", "<br>"));
			req.setAttribute("bdto", bdto);
			goPage = "/bbs/bbsContent.jsp";
		}
	
		req.setAttribute("cp", cp);
		
		return goPage;
	}

}
