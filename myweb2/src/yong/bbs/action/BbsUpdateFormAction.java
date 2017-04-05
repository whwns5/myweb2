package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.controller.CommandHandler;

public class BbsUpdateFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idx_s = req.getParameter("idx");
		int idx = 0;
		if(idx_s != null){
			idx = Integer.parseInt(idx_s);
		}
		String cp_s = req.getParameter("cp");
		int cp = 0;
		if(cp_s != null){
			cp = Integer.parseInt(cp_s);
		}
		
		BbsDAO bdao = new BbsDAO();
		BbsDTO bdto = bdao.bbsContent(idx);
		//bdto.setContent(bdto.getContent().replaceAll("\n", "<br>"));
		
		req.setAttribute("bdto", bdto);
		req.setAttribute("cp", cp);

		return "/bbs/bbsUpdate.jsp";
	}

}
