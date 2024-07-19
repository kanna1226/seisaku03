package test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import dao.FindTasksDAO;
import model.Tasks;
import model.User;

public class FindTasksDAOTest {
	public static void main(String[] args) {
		LocalDate dateOfBirth = LocalDate.of(2001, 5, 1);
		User loginUser = new User("minato", "1234", "yusuke.minato@miyabilonk.jp", "湊　雄輔", dateOfBirth);
		testFindTodayRegisterTasksOK(loginUser);
		//testFindTodayRegisterTasksNG();
		testFindTodayHandleTasksOK(loginUser);
		
		LocalDateTime now = LocalDateTime.now();
		Date d = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(d);
		
		long currentTimeMillis = System.currentTimeMillis();
		Instant instant = Instant.ofEpochMilli(currentTimeMillis);
		LocalDateTime startDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(startDateTime);
	}
	
	public static void testFindTodayRegisterTasksOK(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> result = dao.findIncompleteTasks(loginUser);
//		LocalDate registerDate = LocalDate.of(2024, 6, 7);
//		LocalDateTime tentativeStartDateTime = LocalDateTime.of(2024,6,7,11,34,16,539491);
//		LocalDateTime tentativeEndDateTime = LocalDateTime.of(2024,6,7,12,34,16,539491);
//		LocalDateTime startDateTime = null;
//		LocalDateTime endDateTime = null;
		if (result != null) {
			System.out.println("testFindTodayRegisterTasksOK:成功しました");
		} else {
			System.out.println("testFindTodayRegisterTasksOK:失敗しました");
		}
	}
	
	public static void testFindTodayHandleTasksOK(User loginUser) {
		FindTasksDAO dao = new FindTasksDAO();
		List<Tasks> result = dao.findTodayHandleTasks(loginUser);
//		LocalDate registerDate = LocalDate.of(2024, 6, 7);
//		LocalDateTime tentativeStartDateTime = LocalDateTime.of(2024,6,7,11,34,16,539491);
//		LocalDateTime tentativeEndDateTime = LocalDateTime.of(2024,6,7,12,34,16,539491);
//		LocalDateTime startDateTime = null;
//		LocalDateTime endDateTime = null;
		if (result != null) {
			System.out.println("testFindTodayHandleTasksOK:成功しました");
		} else {
			System.out.println("testFindTodayHandleTasksOK:失敗しました");
		}
	}

//	public static void testFindTodayRegisterTasksNG() {
//		if (result == null) {
//			System.out.println("testFindByLoginNG:成功しました");
//		} else {
//			System.out.println("testfindByLoginNG:失敗しました");
//		}
//	}
}
