package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.WordDAO;

public class SelectAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("list", WordDAO.getAllContents(request.getParameter("startDate"),request.getParameter("endDate")));
		} catch (SQLException e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		request.getRequestDispatcher("data.jsp").forward(request, response);
	}
}
