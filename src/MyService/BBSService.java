package MyService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BBS_dao;
import DTO.BBS_dto;

public class BBSService implements Service{
	
	public BBSService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public HttpServletRequest execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("command: " + request.getAttribute("name"));

		int pageNumber = 1;
		if( request.getParameter("pageNumber") != null ) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		BBS_dao dao = new BBS_dao();
		ArrayList<BBS_dto> dtos = new ArrayList<BBS_dto>();
		boolean hasNextPage = dao.nextPage( pageNumber );

		request.setAttribute("pageNumber",  dtos);
		request.setAttribute("list", dtos);
		request.setAttribute("hasNextPage", hasNextPage);
		
		return request;
	}
}
