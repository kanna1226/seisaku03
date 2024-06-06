package test;

import java.time.LocalDate;

import dao.UsersDAO;
import model.Login;
import model.User;

public class UsersDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();
		testFindByLoginNG();
		testRegisterUserOK();

	}

	public static void testFindByLoginOK() {
		Login login = new Login("minato", "1234");
		UsersDAO dao = new UsersDAO();
		User result = dao.findByLogin(login);
		LocalDate dateOfBirth = LocalDate.of(2001, 05, 01);
		System.out.println(dateOfBirth);
		if (result != null &&
				result.getUserId().equals("minato") &&
				result.getPass().equals("1234") &&
				result.getMail().equals("yusuke.minato@miyabilonk.jp") &&
				result.getUserName().equals("湊　雄輔") &&
				result.getDateOfBirth().equals(dateOfBirth)) {
			System.out.println("testFindByLoginOK:成功しました");
		} else {
			System.out.println("testFindByLoginOK:失敗しました");
			System.out.println(result.getUserId() + ":" + result.getPass() + ":" 
			+ result.getMail() + ":" + result.getUserName() + ":" + result.getDateOfBirth());
		}
	}

	public static void testFindByLoginNG() {
		Login login = new Login("minato", "12345");
		UsersDAO dao = new UsersDAO();
		User result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("testFindByLoginNG:成功しました");
		} else {
			System.out.println("testfindByLoginNG:失敗しました");
		}
	}

	public static void testRegisterUserOK() {
		LocalDate dateOfBirth = LocalDate.of(2002, 9, 11);
		User user = new User("megumi", "5678", "megumi.ayabe@miyabilink.jp", "綾部　めぐみ", dateOfBirth);
		UsersDAO dao = new UsersDAO();
		boolean result = dao.registerUser(user);
		if (result) {
			System.out.println("testResultAccountOK:成功しました");
		} else {
			System.out.println("testResultAccountOK:失敗しました");
		}
	}

}
