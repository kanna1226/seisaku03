package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import dao.RegisterTasksDAO;
import model.Tasks;

public class RegisterTasksDAOTest {
	public static void main(String[] args) {
		//testRegisterTasksOK();
		testUpdateTasksOK();
	}
	
	
	
	
	public static void testRegisterTasksOK() {
		LocalDateTime tentativeStartDateTime = LocalDateTime.now();
		LocalDateTime tentativeEndDateTime = LocalDateTime.now().plusHours(1);
		Date tentativeEndDate = Date.from(tentativeEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		Tasks task = new Tasks("minato", 1, "午後メール対応", tentativeStartDateTime, tentativeEndDateTime, tentativeEndDate);
		RegisterTasksDAO dao = new RegisterTasksDAO();
		boolean result = dao.registerTasks(task);
		if (result) {
			System.out.println("testRegisterTasksOK:成功しました");
		} else {
			System.out.println("testRegisterTasksOK:失敗しました");
		}
	}
	
	public static void testUpdateTasksOK() {
		LocalDate registerDate = LocalDate.of(2024, 5,31);
		LocalDateTime tentativeStartDateTime = LocalDateTime.of(2024,6,2,9,0,0);
		LocalDateTime tentativeEndDateTime = LocalDateTime.of(2024,6,2,9,15,0);
		Date tentativeEndDate = Date.from(tentativeEndDateTime.atZone(ZoneId.systemDefault()).toInstant());
		LocalDateTime startDateTime = LocalDateTime.of(2024,6,10,9,0,0);
		LocalDateTime endDateTime = LocalDateTime.of(2024,6,10,9,20,0);
		
		Tasks task = new Tasks(1, "minato", 1, "午前中メール対応", registerDate, tentativeStartDateTime, tentativeEndDateTime, tentativeEndDate, startDateTime, endDateTime);
		RegisterTasksDAO dao = new RegisterTasksDAO();
		boolean result = dao.updateTasks(task);
		if (result) {
			System.out.println("testUpdateTasksOK:成功しました");
		} else {
			System.out.println("testUpdateTasksOK:失敗しました");
		}
	}
}


//
//private int taskId;
//private String userId;
//private int taskGroupId;
//private String taskContent;
//private LocalDate registerDate;
//private LocalDateTime tentativeStartDateTime;
//private LocalDateTime tentativeEndDateTime;
//private LocalDateTime startDateTime;
//private LocalDateTime endDateTime;
