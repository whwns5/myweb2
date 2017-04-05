package yong.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.member.model.MemberDAO;

public class MemberAdd_IdCheckAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		MemberDAO mdao = new MemberDAO();
		boolean result = mdao.idCheck(id);
		String msg = "";
		String href = "";
		if(result){
			msg = "\"" + id + "\" 는 이미 존재하는 아이디 입니다.";
			href = "/member/memberAdd_IdCheckMsg.jsp";
		} else {
			msg = "\"" + id + "\" 는 사용할 수 있는 아이디 입니다.";
			href = "/member/memberAdd_IdCheck_ok.jsp";
		}
		
		//req.setAttribute("result", result);
		req.setAttribute("id", id);
		req.setAttribute("msg", msg);
		//req.setAttribute("href", href);
	
		return href;
		//return "/member/memberAdd_IdCheckMsg.jsp";
	}

}
