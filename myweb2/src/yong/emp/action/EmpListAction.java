package yong.emp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmpDAO edao = new EmpDAO();
		
		String fkey = req.getParameter("fkey");
		String fvalue = req.getParameter("fvalue");
		ArrayList<EmpDTO> arry_edto = null;
		if(fkey != null){ // 사원 검색
			arry_edto = edao.empList(fkey, fvalue);
		} else {
			arry_edto = edao.empList();
		}
		
		req.setAttribute("arry_edto", arry_edto);
		
		return "/emp/empList.jsp";
	}

}
