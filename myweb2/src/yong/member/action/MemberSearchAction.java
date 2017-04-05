package yong.member.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yong.controller.CommandHandler;
import yong.member.model.MemberDAO;
import yong.member.model.MemberDTO;

public class MemberSearchAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String method = req.getMethod();
		
		ArrayList<MemberDTO> arry_mdto = null;
		if(method.equals("POST")){
			String fkey = req.getParameter("fkey");
			String fvalue = req.getParameter("fvalue");
			
			MemberDAO mdao = new MemberDAO();
			arry_mdto = mdao.memberList(fkey, fvalue);
			
			req.setAttribute("arry_mdto", arry_mdto);
		}
		req.setAttribute("method", method);
		
		return "/member/memberSearch.jsp";
	}

}
