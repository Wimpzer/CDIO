package gr�nseflade;

public class BGController {


	Brugergr�nseflade input;

	public BGController(){
		input = new Brugergr�nseflade();
	}

	public void run(){

		int in = 0;
		do
		{
			in = input.InputMenu();
			InputHandler(in);
		}while (in!=0);
	}

	private void InputHandler(int in){

		switch(in){

		case 0: exit();

		case 1: opAdmin();					
		break;

		case 2: passControle();
		break;

		case 3: test();
		break;
		}


	}

	private void test() {
		System.out.println("test");

	}

	private void passControle() {
		System.out.println("passControle");

	}

	private void opAdmin() {
		System.out.println("opAdmin");

	}

	private void exit() {
		System.out.println("exit");

	}



}
