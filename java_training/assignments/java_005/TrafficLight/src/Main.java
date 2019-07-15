import java.util.concurrent.TimeUnit;
//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean go = MyThread.go;
		int gTime = Lights.Green.getSec();
		int yTime = Lights.Yellow.getSec();
		int rTime = Lights.Red.getSec();
		
		//intro
		System.out.println("Traffic light simulator is a GO!");
		System.out.println("Press the Enter key to end the simulator.");

		
		//go thru lights
		try {
			
			while(go) {
				MyThread lt = new MyThread("Listen");		//listens for Enter key
				MyThread greenL = new MyThread("Green");	//green light
				TimeUnit.SECONDS.sleep(gTime);
				MyThread yellowL = new MyThread("Yellow");	//yellow light
				TimeUnit.SECONDS.sleep(yTime);
				MyThread redL = new MyThread("Red");		//red light
				TimeUnit.SECONDS.sleep(rTime);		
				
			}
			
		}catch(InterruptedException e){
			System.out.println("Thread interrupted");
			e.printStackTrace();
		}		
		
	}

}
