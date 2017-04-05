package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpAddAction implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		
		EmpDTO edto = new EmpDTO(name, email, dept);
		EmpDAO edao = new EmpDAO();
		
		int result = edao.empAdd(edto);
		String msg = result > 0 ? "사원등록 성공(mvc)" : "사원등록 실패(mvc)";
		
		req.setAttribute("msg", msg);
		
		return "/emp/empMsg.jsp";
	}

}
