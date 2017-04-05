package yong.member.action;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yong.controller.CommandHandler;
import yong.member.model.MemberDAO;
import yong.member.model.MemberDTO;

public class MemberLoginAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String cbSaveId = req.getParameter("cbSaveId");

		MemberDAO mdao = new MemberDAO();
		int result = mdao.loginCheck(id, pwd);
		
		String msg = "";
		String href = "";
		String goPage = "";
		
		switch (result) {
		case -1: // DB에러
			msg = "오류가 발생했습니다. 고객센터에 문의 바랍니다.";
			href = "memberLoginForm.yong";
			goPage = "/member/memberMsg.jsp";
			break;
		case 0: // 로그인 성공
			MemberDTO session_login_mdto = mdao.loginInfo(id);
			
			HashMap<String, Object> set_hm_session = new HashMap<String, Object>();
			set_hm_session.put("session_login_mdto", session_login_mdto);
			
			setSession(req, resp, set_hm_session);
			
			if(cbSaveId != null && cbSaveId.equals("on")){ // 아이디 저장하기 체크시..
				Cookie ck = new Cookie("saveId", URLEncoder.encode(id, "utf-8"));
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			} else { // 아이디 저장 체크 해제시
				Cookie ck = new Cookie("saveId","");
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}
			
			msg = "로그인에 성공하셨습니다. " + id + " 님 환영합니다.";
			goPage = "/member/memberLogin_ok.jsp";
			break;
		case 1: // 아이디 에러
			msg = "해당 아이디가 존재하지 않습니다.";
			href = "memberLoginForm.yong";
			goPage = "/member/memberMsg.jsp";
			break;
		case 2: // PWD 에러
			msg = "비밀번호가 일치하지 않습니다.";
			href = "memberLoginForm.yong";
			goPage = "/member/memberMsg.jsp";
			break;
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("href", href);
		
		return goPage;
	}
	
	public void setSession(HttpServletRequest req, HttpServletResponse resp, HashMap<String, Object> set_hm_session){
		HttpSession session = req.getSession();
		
		Set<String> keyset = set_hm_session.keySet();
		Iterator<String> it = keyset.iterator();
		while(it.hasNext()){
			String key = it.next();
			Object value = set_hm_session.get(key);
			
			session.setAttribute(key, value);
		}
	}

}
