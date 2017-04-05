package yong.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.controller.CommandHandler;
import yong.member.model.MemberDAO;
import yong.member.model.MemberDTO;

public class MemberAddProcAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		MemberDTO mdto = new MemberDTO(id, pwd, name, tel, addr);
		MemberDAO mdao = new MemberDAO();
		int result = mdao.memberAdd(mdto);
		String msg = result > 0 ? "회원가입 성공" : "회원가입 실패";
		String href = "index.yong";
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return "/member/memberMsg.jsp";
	}

}
