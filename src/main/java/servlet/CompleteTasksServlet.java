package servlet;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetTaskListLogic;
import model.TaskGroup;
import model.Tasks;
import model.User;

/**
 * Servlet implementation class CompleteTasksServlet
 */
@WebServlet("/CompleteTasksServlet")
public class CompleteTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompleteTasksServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("index.jsp");
		} else {
			GetTaskListLogic getTaskListLogic = new GetTaskListLogic();
			List<Tasks> todayEndTaskList = getTaskListLogic.getTodayEndTasksExecute(loginUser);
			session.setAttribute("todayEndTaskList", todayEndTaskList);

			Map<TaskGroup, Long> totalTaskHandleTimeMap = new HashMap<>();

			Set<Integer> taskGroupIds = new HashSet<>();
			for (Tasks task : todayEndTaskList) {
				taskGroupIds.add(task.getTaskGroupId());
			}

			List<TaskGroup> taskGroupList = (List<TaskGroup>) session.getAttribute("taskGroupList");
			if (taskGroupList != null) {
				for (TaskGroup taskGroup : taskGroupList) {
					if (taskGroupIds.contains(taskGroup.getTaskGroupId())) {
						Duration totalTaskHandleTime_taskGroup = Duration.ZERO;
						for (Tasks task : todayEndTaskList) {
							if (task.getTaskGroupId() == taskGroup.getTaskGroupId()) {
								if (task.getTaskhandleDuration() != null) {
									totalTaskHandleTime_taskGroup = totalTaskHandleTime_taskGroup.plus(task.getTaskhandleDuration());
								}
							}
						}
						totalTaskHandleTimeMap.put(taskGroup, totalTaskHandleTime_taskGroup.toMinutes());
					}
				}
			}
			request.setAttribute("totalTaskHandleTimeMap", totalTaskHandleTimeMap);

			long todayTotalHandleTaskTime = 0;
            if (!totalTaskHandleTimeMap.isEmpty()) {
                for (Long val : totalTaskHandleTimeMap.values()) {
                    todayTotalHandleTaskTime += val;
                }
            }
            long todayTotalSceduleTaskTime = 0;
            for (Tasks task: todayEndTaskList) {
            	todayTotalSceduleTaskTime += task.getTentativeEndTime();
            }
			request.setAttribute("todayTotalHandleTaskTime", todayTotalHandleTaskTime);
			request.setAttribute("todayTotalSceduleTaskTime", todayTotalSceduleTaskTime);


			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/completeTasks.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
