import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {
	//variables
	Thread thrd;
	//boolean stopped;
	Lights light;
	static boolean go = true;
	String uIn = "something";
	
	//constructor
	MyThread(String name){
		thrd = new Thread(this, name);
		go = true;
		//on = true;
		thrd.start();
	}
	
	public void run() {
		try {
			//which light
			switch(thrd.getName()) {
			case "Green":
				light = Lights.Green;
				break;
			case "Yellow":
				light = Lights.Yellow;
				break;
			case "Red":
				light = Lights.Red;
				break;	
			default:
				light = Lights.None;
			}
			
			//while(go) {
				Thread.sleep(1000);
				switch(light) {
				case Green:
					System.out.println("Light is Green - GO!");
					//TimeUnit.SECONDS.sleep(5);
					//light = Lights.Yellow;
					break;
				case Yellow:
					System.out.println("Light is Yellow - BEWARE!");
					//TimeUnit.SECONDS.sleep(2);
					//light = Lights.Red;
					break;
				case Red:
					System.out.println("Light is Red - STOP!");
					//TimeUnit.SECONDS.sleep(3);
					//light = Lights.Green;
					break;
				default:
					Scanner sc = new Scanner(System.in);
					uIn = sc.nextLine();
					if(!uIn.equals(null)) {
						myStop(false);
					}
				}	

			//}
			
		}catch(InterruptedException e) {
			System.out.println("Thread '" + thrd.getName()+ "' interrupted");
			//e.printStackTrace();
		}
		
		
	}
	
	//stop thread
	synchronized void myStop(boolean g) {
		//stopped = true;
		go = false;
		System.out.println("Traffic light simulator is DONE!");
		System.exit(0);
	}
	
}
