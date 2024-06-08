package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskGroupDAO;
import model.GetTaskListLogic;
import model.PostTaskLogic;
import model.TaskGroup;
import model.Tasks;
import model.User;

/**
 * Servlet implementation class RegisterTasksServlet
 */
@WebServlet("/RegisterTasksServlet")
public class RegisterTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTasksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//response.getWriter().append("Served at: ").append(request.getContextPath());
    	request.setAttribute("currentDate", new Date());
    	
    	HttpSession session = request.getSession();
    	User loginUser = (User)session.getAttribute("loginUser");

    	if (loginUser == null) {
    		response.sendRedirect("index.jsp");
    	} else {
    		GetTaskListLogic getTaskListLogic = new GetTaskListLogic();
    		List<Tasks> todayRegisterTaskList = getTaskListLogic.execute(loginUser);
    		session.setAttribute("todayRegisterTaskList", todayRegisterTaskList);
    		
    		TaskGroupDAO dao = new TaskGroupDAO();
    		List<TaskGroup> taskGroupList = dao.findTaskGroup();
    		session.setAttribute("taskGroupList", taskGroupList);

    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/taskRegister.jsp");
    		dispatcher.forward(request, response);
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setAttribute("currentDate", new Date());
		
		request.setCharacterEncoding("UTF-8");
	    String taskGroupIdString = request.getParameter("taskGroupId");
	    String taskContent = request.getParameter("taskContent");
	    String tentativeStartDateString = request.getParameter("tentativeStartDateString");
	    String tentativeEndTimeString = request.getParameter("tentativeEndTimeString");
	    
	    HttpSession session = request.getSession();
	    User loginUser = (User)session.getAttribute("loginUser");
	    
	    if(taskGroupIdString != null && !taskGroupIdString.isEmpty()
	            && taskContent != null && !taskContent.isEmpty()
	            && tentativeStartDateString != null && !tentativeStartDateString.isEmpty()
	            && tentativeEndTimeString != null && !tentativeEndTimeString.isEmpty()) {
	        
	        int taskGroupId = Integer.parseInt(taskGroupIdString);
	        LocalDate tentativeStartDate = LocalDate.parse(tentativeStartDateString);
	        LocalTime tentativeStartTime = LocalTime.now();
	        LocalDateTime tentativeStartDateTime = LocalDateTime.of(tentativeStartDate, tentativeStartTime);
	        int tentativeEndMinutes = Integer.parseInt(tentativeEndTimeString);
	        LocalTime tentativeEndTime = tentativeStartTime.plusMinutes(tentativeEndMinutes);
	        LocalDateTime tentativeEndDateTime = LocalDateTime.of(tentativeStartDate, tentativeEndTime);
	        Date tentativeEndDate = Date.from(tentativeEndDateTime.atZone(ZoneId.systemDefault()).toInstant());

	        Tasks task = new Tasks(loginUser.getUserId(), taskGroupId, taskContent, tentativeStartDateTime, tentativeEndDateTime, tentativeEndDate);
	        PostTaskLogic postTaskLogic = new PostTaskLogic();
	        postTaskLogic.execute(task);
	        
	        // タスクリストを更新して再取得
	        GetTaskListLogic getTaskListLogic = new GetTaskListLogic();
	        List<Tasks> todayRegisterTaskList = getTaskListLogic.execute(loginUser);
	        session.setAttribute("todayRegisterTaskList", todayRegisterTaskList);
	        
	        TaskGroupDAO dao = new TaskGroupDAO();
    		List<TaskGroup> taskGroupList = dao.findTaskGroup();
    		session.setAttribute("taskGroupList", taskGroupList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/taskRegister.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        request.setAttribute("errorMsg", "タスクの入力が完了していません");

	        // タスクリストを更新して再取得
	        GetTaskListLogic getTaskListLogic = new GetTaskListLogic();
	        List<Tasks> todayRegisterTaskList = getTaskListLogic.execute(loginUser);
	        session.setAttribute("todayRegisterTaskList", todayRegisterTaskList);
	        
	        TaskGroupDAO dao = new TaskGroupDAO();
    		List<TaskGroup> taskGroupList = dao.findTaskGroup();
    		session.setAttribute("taskGroupList", taskGroupList);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/taskRegister.jsp");
	        dispatcher.forward(request, response);
	    }
	}

}
