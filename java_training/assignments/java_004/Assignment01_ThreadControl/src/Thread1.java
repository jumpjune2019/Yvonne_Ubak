//creating Thread
class Thread1 implements Runnable{
	//variables
	Thread thrd;
	boolean suspended;		//true = pause and false = resume
	boolean stopped;
	
	//constructor
	Thread1(String name){
		thrd = new Thread(this, name);	//create thread object
		//Main m = new Main();			//create main object
		//initialize booleans
		suspended = false;		
		stopped = false;
		thrd.start();	//automatically start thread	
	}
	
	//thread entry point
	public void run() {
		try {
			Main.displayInfo("Executing " + thrd.getName());
			for(int e = 1; e<1000; e++) {
				Thread.sleep(1000);
				//dots print while executing
				/*for(int d = 1; d < 500; d++) {
					System.out.print(".");	
					Thread.sleep(200);	
				}*/
				
				//check if paused or stopped
				synchronized(this) {
					while(suspended) {
						
						Main.displayInfo("Pausing " + thrd.getName());
						wait();
					}
					if(stopped) {
						break;
					}
				}
				
			}
		}
		catch(InterruptedException e) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		//when stopped
		//System.out.println("Permanently stopping the execution of " + thrd.getName());
	}
	
	//pause thread
	synchronized void mypause() {
		suspended = true;
		stopped = false;
		//Main.displayInfo("Suspended State: " + suspended + "");
		notify();
	}
	
	//resume thread
	synchronized void myresume() {
		suspended = false;
		Main.displayInfo(thrd.getName() +" resumed.");
		Main.displayInfo("Executing " + thrd.getName());
	}
	
	//stop thread
	synchronized void mystop() {
		suspended = false;
		stopped = true;
		Main.displayInfo("Permanently stopping the execution of " + thrd.getName());
		notify();
	}
	
	
}
