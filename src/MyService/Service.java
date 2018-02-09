package MyService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BBS_dto;


public interface Service {
	public HttpServletRequest execute(HttpServletRequest request, HttpServletResponse response);
}
