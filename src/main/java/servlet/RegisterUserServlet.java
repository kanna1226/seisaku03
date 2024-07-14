package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.User;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String forwardPath = null;
		
		String action = request.getParameter("action");
		
		if(action == null) {
			forwardPath = "WEB-INF/jsp/registerUserForm.jsp";
		} else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");
			
			UsersDAO dao = new UsersDAO();
			boolean result = dao.registerUser(registerUser);
			
			if(result) {
				session.removeAttribute("registerUser");
				
				forwardPath = "WEB-INF/jsp/registerUserResult.jsp";
			} else {
				response.sendRedirect("index.jsp");
				
				//後で変更
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String userName = request.getParameter("userName");
		String dateValue = request.getParameter("dateOfBirth");
		LocalDate dateOfBirth = LocalDate.parse(dateValue);
		
		String errorMsg = null;
		
		if (userId != null && userId.length() != 0 
				&& pass != null && pass.length() != 0
				&& mail != null && mail.length() != 0
				&& userName != null && userName.length() != 0
				&& dateValue != null && dateValue.length() != 0) {
			
			User registerUser = new User(userId, pass, mail, userName, dateOfBirth);
			
			UsersDAO dao = new UsersDAO();
			User result = dao.findRegisterdUser(registerUser);
			
			
			if(result == null) {
				HttpSession session = request.getSession();
				session.setAttribute("registerUser", registerUser);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerUserConfirm.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("userId", userId);
				request.setAttribute("pass", pass);
				request.setAttribute("mail", mail);
				request.setAttribute("userName", userName);
				request.setAttribute("dateValue", dateValue);
				
				errorMsg = "既に同じユーザーIDで登録されています。<br>ユーザーIDを変更するか、<br>既に登録済みの場合はログインしてください。";
				request.setAttribute("errorMsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerUserForm.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("userId", userId);
			request.setAttribute("pass", pass);
			request.setAttribute("mail", mail);
			request.setAttribute("userName", userName);
			request.setAttribute("dateValue", dateValue);
			
			errorMsg = "入力漏れがあります。全ての欄を入力してください";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerUserForm.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
