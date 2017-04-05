package yong.emp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpContentAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idx_s = req.getParameter("idx");
		
		EmpDAO edao = new EmpDAO();
		ArrayList<EmpDTO> arry_edto = edao.empList("idx", idx_s);
		
		req.setAttribute("arry_edto", arry_edto);
		
		return "/emp/empContent.jsp";
	}

}
