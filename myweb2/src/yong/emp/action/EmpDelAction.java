package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpDelAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idx_s = req.getParameter("idx");
		int idx = 0;
		if(idx_s != null){
			idx = Integer.parseInt(idx_s);
		}
		
		EmpDTO edto = new EmpDTO(idx);
		EmpDAO edao = new EmpDAO();
		int result = edao.empDel(edto);
		
		String msg = result > 0 ? "삭제 완료" : "삭제 실패";
		
		req.setAttribute("msg", msg);
		
		return "/emp/empMsg.jsp";
	}

}
