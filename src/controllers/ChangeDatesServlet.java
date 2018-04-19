package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateQuestion;
import model.Evaluation;

/**
 * Servlet implementation class ChangeDates
 */
@WebServlet("/updateDates")
public class ChangeDatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDatesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		HttpSession session = request.getSession();
		Evaluation eval = (Evaluation)session.getAttribute("eval");
		String activation = (String) request.getParameter("activation");
		String deadline = (String)request.getParameter("deadline");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		format = format.withLocale( Locale.US );
		LocalDate activeD = LocalDate.parse(activation, format);
		LocalDate submD = LocalDate.parse(deadline, format);
		UpdateQuestion uq = new UpdateQuestion();
		uq.saveDates(activeD, submD, eval);
		message = "The evaluation activation and submission dates have been updated";
		request.setAttribute("message", message);
		String url = "/editEvaluation.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}