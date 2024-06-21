package servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import model.TaskGroup;
import model.Tasks;
import model.UpdateTaskLogic;
import model.User;

/**
 * Servlet implementation class HandleTasksServlet
 */
@WebServlet("/HandleTasksServlet")
public class HandleTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleTasksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
    	User loginUser = (User)session.getAttribute("loginUser");

    	if (loginUser == null) {
    		response.sendRedirect("index.jsp");
    	} else {
    		GetTaskListLogic getTaskListLogic = new GetTaskListLogic();
    		List<Tasks> todayHandleTaskList = getTaskListLogic.getTodayHandleTasksExecute(loginUser);
    		session.setAttribute("todayHandleTaskList", todayHandleTaskList);
    		
    		TaskGroupDAO dao = new TaskGroupDAO();
    		List<TaskGroup> taskGroupList = dao.findTaskGroup();
    		session.setAttribute("taskGroupList", taskGroupList);

    		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/handleTasks.jsp");
    		dispatcher.forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    HttpSession session = request.getSession();
	    User loginUser = (User)session.getAttribute("loginUser");

	    List<Tasks> todayHandleTaskList = (List<Tasks>)session.getAttribute("todayHandleTaskList");

	    for (Tasks task : todayHandleTaskList) {
	        String action = "action" + task.getTaskId();
	        String actionResult = request.getParameter(action);

	        if("start".equals(actionResult)) {
	            long currentTimeMillis = System.currentTimeMillis();
	            Instant instant = Instant.ofEpochMilli(currentTimeMillis);
	            LocalDateTime startDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	            task.setStartDateTime(startDateTime);
	            UpdateTaskLogic updateTaskLogic = new UpdateTaskLogic();
	            updateTaskLogic.updateStartDateTimeExecute(task);
	        }
	        if("end".equals(actionResult)) {
	            long currentTimeMillis = System.currentTimeMillis();
	            Instant instant = Instant.ofEpochMilli(currentTimeMillis);
	            LocalDateTime endDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	            task.setEndDateTime(endDateTime);
	            UpdateTaskLogic updateTaskLogic = new UpdateTaskLogic();
	            updateTaskLogic.updateEndDateTimeExecute(task);
	        }
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        if(task.getStartDateTime() != null) {
	        	String formattedStartDateTime = task.getStartDateTime().format(formatter);
	        	session.setAttribute("startDateTime" + task.getTaskId(), formattedStartDateTime);
	        }
	        if(task.getEndDateTime() != null) {
	        	String formattedEndDateTime = task.getEndDateTime().format(formatter);
		        session.setAttribute("endDateTime" + task.getTaskId(), formattedEndDateTime);
	        }
	        
	        if(task.getStartDateTime() != null && task.getEndDateTime() != null) {
	        	Duration taskHandleDuration = Duration.between(task.getStartDateTime(), task.getEndDateTime());
		        task.setTaskHandleDuration(taskHandleDuration.toMinutes());
		        session.setAttribute("taskHandleDuration" + task.getTaskId(), task.getTaskhandleDuration());
		        long difference = taskHandleDuration.toMinutes() - task.getTentativeEndTime();
		        session.setAttribute("difference"+ task.getTaskId(), difference);
	        }
	        
	    }
	    
	    

	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/handleTasks.jsp");
	    dispatcher.forward(request, response);
	}

}