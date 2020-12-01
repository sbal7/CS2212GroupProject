import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		IDandPass idandPass = new IDandPass();
		
		Login login = new Login(idandPass.getLoginInfo());
	}
}
