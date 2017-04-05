package yong.bbs.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.bbs.model.BbsDAO;
import yong.bbs.model.BbsDTO;
import yong.bbs.model.pageDTO;
import yong.controller.CommandHandler;

public class BbsListFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BbsDAO bdao = new BbsDAO();
		
		int totalCnt = bdao.getBbsTotalCnt();
		int listSize = 10;
		int pageSize = 5;
		String cp_s = req.getParameter("cp");
		int cp = 1;
		if(cp_s != null){
			cp = Integer.parseInt(cp_s);
		}
		
		ArrayList<BbsDTO> arry_bdto = bdao.bbsList(cp, listSize);
		String pageStr = yong.page.PageModule.makePage("bbsListForm.yong", totalCnt, listSize, pageSize, cp);
		req.setAttribute("pageStr", pageStr);
		req.setAttribute("arry_bdto", arry_bdto);
		req.setAttribute("cp", cp);
		
		return "/bbs/bbsList.jsp";
		
		/*int totalPage = totalCnt / listSize + 1;
		if(totalCnt % listSize == 0)totalPage--;
		
		int userGroup = cp / pageSize;
		if(cp % pageSize == 0)userGroup--;
		
		ArrayList<Integer> arry_pageNum = new ArrayList<Integer>();
		for(int i = (userGroup*pageSize) + 1 ; i <= (userGroup*pageSize)+pageSize ; i++){
			arry_pageNum.add(i);
			if(i == totalPage)break;
		}
		
		String preCp = "";
		if(userGroup != 0){
			preCp = Integer.toString(((userGroup-1) * pageSize) + pageSize);
		}
		
		String nextCp = "";
		if(userGroup != (totalPage / pageSize) - (totalPage % pageSize == 0 ? 1 : 0) ){
			nextCp = Integer.toString(((userGroup+1) * pageSize) + 1);
		}
		
		pageDTO page_dto = new pageDTO(arry_pageNum, cp, preCp, nextCp);
		
		ArrayList<BbsDTO> arry_bdto = bdao.bbsList(cp, listSize);

		req.setAttribute("arry_bdto", arry_bdto);
		req.setAttribute("page_dto", page_dto);
		
		return "/bbs/bbsList.jsp";*/
	}

}
