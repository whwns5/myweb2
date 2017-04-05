package yong.bbs.model;

import java.util.ArrayList;

public class pageDTO {
	private ArrayList<Integer> arry_pageNum;
	private int cp;
	private String preCp;
	private String nextCp;

	public pageDTO() {
		// TODO Auto-generated constructor stub
	}

	public pageDTO(ArrayList<Integer> arry_pageNum, int cp, String preCp, String nextCp) {
		super();
		this.arry_pageNum = arry_pageNum;
		this.cp = cp;
		this.preCp = preCp;
		this.nextCp = nextCp;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public ArrayList<Integer> getArry_pageNum() {
		return arry_pageNum;
	}

	public void setArry_pageNum(ArrayList<Integer> arry_pageNum) {
		this.arry_pageNum = arry_pageNum;
	}

	public String getPreCp() {
		return preCp;
	}

	public void setPreCp(String preCp) {
		this.preCp = preCp;
	}

	public String getNextCp() {
		return nextCp;
	}

	public void setNextCp(String nextCp) {
		this.nextCp = nextCp;
	}

	@Override
	public String toString() {
		return "pageDTO [arry_pageNum=" + arry_pageNum + ", cp=" + cp + ", preCp=" + preCp + ", nextCp=" + nextCp + "]";
	}

}
