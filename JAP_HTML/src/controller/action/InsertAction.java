package controller.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.WordDAO;
import model.dto.WordDTO;

public class InsertAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			WordDAO.insertContent(WordDTO.builder()
										 .content(request.getParameter("content"))
										 .date(new Date())
										 .build());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
