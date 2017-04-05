package yong.member.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import yong.db.yongDB;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public final int LOGIN_OK = 0;
	public final int LOGIN_ID_ERROR = 1;
	public final int LOGIN_PWD_ERROR = 2;
	
	
	public MemberDAO() {
		super();
	}
	
	/** 회원가입 관련 메서드 */
	public int memberAdd(MemberDTO mdto){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "INSERT INTO JSP_member VALUES(JSP_member_idx.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPwd());
			ps.setString(3, mdto.getName());
			ps.setString(4, mdto.getTel());
			ps.setString(5, mdto.getAddr());
			
			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 아이디 체크 관련 메서드 */
	public boolean idCheck(String id){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT id FROM JSP_member WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			return rs.next();
			/*if(rs.next()){
				return true;
			} else {
				return false;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 로그인 관련 메서드 */
	public int loginCheck(String input_id, String input_pwd){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT pwd FROM JSP_member WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, input_id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){ // 결과 값이 있을 경우..
				String pwd = rs.getString("pwd");
				if(pwd.equals(input_pwd)){ // 사용자가 입력한 pwd 와 db의 pwd가 일치할 경우..
					return LOGIN_OK;
				} else {
					return LOGIN_PWD_ERROR;
				}
			} else { // 결과 값이 없을 경우..
				return LOGIN_ID_ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 로그인 정보 검색 관련 메서드 */
	public MemberDTO loginInfo(String input_id){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT id, name FROM JSP_member WHERE id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, input_id);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			String id = rs.getString("id");
			String name = rs.getString("name");
			
			MemberDTO mdto = new MemberDTO(id, name);
			
			return mdto;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 회원 조건 검색 관련 메서드 */
	public ArrayList<MemberDTO> memberList(String fkey, String fvalue){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT * FROM JSP_member WHERE " + fkey + " = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, fvalue);
			
			rs = ps.executeQuery();
			
			ArrayList<MemberDTO> arry_mdto = new ArrayList<MemberDTO>();
			while(rs.next()){
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				Date joindate = rs.getDate("joindate");
				
				MemberDTO mdto = new MemberDTO(idx, id, pwd, name, tel, addr, joindate);
				
				arry_mdto.add(mdto);
			}
			
			return arry_mdto;
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
