package yong.bbs.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public BbsDAO() {
		
	}
	
	/** Ref 최대 값 관련 메서드 */
	public int getMaxRef(){
		try{
			String sql = "SELECT MAX(ref) FROM jsp_bbs";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int maxRef = 0; // max함수는 게시글이 없을시 null이 넘어 오므로
			if(rs.next()){
				maxRef = rs.getInt(1);
			}
			
			return maxRef;
			
		} catch(Exception e){
			e.printStackTrace();
			return 0;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시글 작성 관련 메서드 */
	public int bbsWrite(BbsDTO bdto){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "INSERT INTO JSP_bbs VALUES(JSP_bbs_idx.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
			int maxRef = getMaxRef();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bdto.getWriter());
			ps.setString(2, bdto.getPwd());
			ps.setString(3, bdto.getSubject());
			ps.setString(4, bdto.getContent());
			
			ps.setInt(5, 0); // readnum
			
			ps.setInt(6, maxRef+1); // 신규 글등록은 max ref + 1
			ps.setInt(7, 0); // 신규 등록은 lev, ref 는 0
			ps.setInt(8, 0);
			
			int result = ps.executeUpdate();

			return result;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/** 순번 업데이트 관련 메서드 */
	public int bbsUpdateSunbun(int ref, int sunbun){
		try{
			String sql = "UPDATE JSP_bbs SET sunbun = sunbun + 1 WHERE ref = ? AND sunbun >= ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ref);
			ps.setInt(2, sunbun);
			
			int result = ps.executeUpdate();
		
			return result;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(ps!=null)ps.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시글 댓글 작성 관련 메서드 */
	public int bbsReWrite(BbsDTO bdto){
		try{
			conn = yong.db.yongDB.getConn();
			
			bbsUpdateSunbun(bdto.getRef(), bdto.getSunbun()+1);
			
			String sql = "INSERT INTO JSP_bbs VALUES(JSP_bbs_idx.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bdto.getWriter());
			ps.setString(2, bdto.getPwd());
			ps.setString(3, bdto.getSubject());
			ps.setString(4, bdto.getContent());
			
			ps.setInt(5, 0); // readnum
			
			ps.setInt(6, bdto.getRef()); // 댓글 등록 ref는 기존 글과 동일하게
			ps.setInt(7, bdto.getLev()+1); // 댓글 등록 lev, sunun은 기존의 +1
			ps.setInt(8, bdto.getSunbun()+1);
			
			int result = ps.executeUpdate();

			return result;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시판 상세 관련 메서드 */
	public BbsDTO bbsContent(int input_idx){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT * FROM JSP_bbs WHERE idx = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, input_idx);
			
			rs = ps.executeQuery();
			
			BbsDTO bdto = null;
			
			if(rs.next()){
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				String pwd = rs.getString("pwd");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date writedate = rs.getDate("writedate");
				int readnum = rs.getInt("readnum");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int sunbun = rs.getInt("sunbun");
				
				bdto = new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
			}
			
			return bdto;
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시글 수정 관련 메서드 */
	public int bbsUpdate(BbsDTO bdto){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "UPDATE JSP_bbs SET subject = ?, content = ? WHERE idx = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bdto.getSubject());
			ps.setString(2, bdto.getContent());
			
			ps.setInt(3, bdto.getIdx());
			
			int result = ps.executeUpdate();

			return result;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시판 삭제 관련 메서드 */
	public int bbsDelete(BbsDTO bdto){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "DELETE FROM JSP_bbs WHERE idx = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bdto.getIdx());
			
			int result = ps.executeUpdate();

			return result;
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시판 리스트 관련 메서드 */
	public ArrayList<BbsDTO> bbsList(){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT * FROM JSP_bbs";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ArrayList<BbsDTO> arry_bdto = new ArrayList<BbsDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				String pwd = rs.getString("pwd");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date writedate = rs.getDate("writedate");
				int readnum = rs.getInt("readnum");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int sunbun = rs.getInt("sunbun");
				
				BbsDTO bdto = new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
				
				arry_bdto.add(bdto);
			}
			
			return arry_bdto;
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시판 페이징 리스트 관련 메서드 */
	public ArrayList<BbsDTO> bbsList(int cp, int listSize){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT b.* "
					+ "FROM (SELECT rownum as rnum, a.* "
					+ 		"FROM (SELECT * "
					+ 			  "FROM jsp_bbs "
					+ 			  "ORDER BY ref desc, sunbun asc) a) b "
					+ "WHERE rnum > " + (cp-1)*listSize + " AND rnum <= " + cp*listSize;
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			ArrayList<BbsDTO> arry_bdto = new ArrayList<BbsDTO>();
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				String pwd = rs.getString("pwd");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				Date writedate = rs.getDate("writedate");
				int readnum = rs.getInt("readnum");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int sunbun = rs.getInt("sunbun");
				
				BbsDTO bdto = new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
				
				arry_bdto.add(bdto);
			}
			
			return arry_bdto;
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 게시물 총갯수 관련 메서드 */
	public int getBbsTotalCnt(){
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "SELECT COUNT(*) FROM jsp_bbs";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			int count = rs.getInt(1);
			
			count = count == 0 ? 1 : count;
			
			return count;
			
		} catch(Exception e){
			e.printStackTrace();
			return 1;
		} finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
