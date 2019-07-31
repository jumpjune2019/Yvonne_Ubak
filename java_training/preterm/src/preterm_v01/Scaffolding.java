package preterm_v01;

public class Scaffolding {
	 void start() {
		System.out.println("start()--->");
		System.out.println("* Enter application");
		System.out.println("* Ask to login, register, or quit\n\n");
	}
	
	void getInput() {
		//get client list
		System.out.println("getInput()");
		System.out.println("* Get the client from the Client class");
		
		Client test = new Client("Yvonne", "Ubak", 24);
		System.out.println(test.getFullClient());
		
		System.out.println("\nTesting Client Storage class\n");
		ClientStorage cStore = new ClientStorage("clients.csv");
		Client[] data = cStore.getClientData.storage();
		
		System.out.println("Count: " + cStore.getCount.count());
		System.out.println();
		//display data in client storage
		for(Client c : data) {
			if(c != null) {
				System.out.println(c.getFullClient() + " " + c.getInititals());
			}
		}
	}
	
	void end() {
		System.out.println("\n\nend()");
		System.out.println("* Exit the application");
		System.exit(0);
	}
	
}
