package yong.emp.model;

import java.sql.*;
import java.util.ArrayList;

public class EmpDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmpDAO() {
		super();
	}
	
	/** 사원 등록 관련 메서드 */
	public int empAdd(EmpDTO edto){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "INSERT INTO employee VALUES(employee_idx.NEXTVAL, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, edto.getName());
			ps.setString(2, edto.getEmail());
			ps.setString(3, edto.getDept());
			
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
	
	/** 사원 삭제 관련 메서드 */
	public int empDel(EmpDTO edto){
		try {
			conn = yong.db.yongDB.getConn();
			
			String sql = "DELETE FROM employee WHERE idx = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, edto.getIdx());
		
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
	
	/** 사원 목록 관련 메서드 */
	public ArrayList<EmpDTO> empList(){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT * FROM employee ORDER BY idx DESC";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ArrayList<EmpDTO> arry_edto = new ArrayList<EmpDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				
				EmpDTO dto = new EmpDTO(idx, name, email, dept);
				
				arry_edto.add(dto);
			}
			
			return arry_edto;
			
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
	
	/** 사원 검색 관련 메서드 */
	public ArrayList<EmpDTO> empList(String fkey, String fvalue){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT * FROM employee WHERE " + fkey + " = ? ORDER BY idx DESC";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, fvalue);
			
			rs = ps.executeQuery();
			
			ArrayList<EmpDTO> arry_edto = new ArrayList<EmpDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String dept = rs.getString("dept");
				
				EmpDTO dto = new EmpDTO(idx, name, email, dept);
				
				arry_edto.add(dto);
			}
			
			return arry_edto;
			
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
	
	/** 사원 수정 관련 메서드 */
	public int empUpdate(EmpDTO edto){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "UPDATE employee SET name = ?, email = ?, dept = ? WHERE idx = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, edto.getName());
			ps.setString(2, edto.getEmail());
			ps.setString(3, edto.getDept());
			ps.setInt(4, edto.getIdx());
			
			int count = ps.executeUpdate();
	
			return count;
			
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
	
}
