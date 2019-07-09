import java.io.*;

class MenuSelection {
	static int userIn() {
		int input = 0;
		//boolean flag = false;
		//InputStreamReader userInput = new InputStreamReader(System.in);
		
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))){
			input = Integer.parseInt(buffer.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*while(!flag) {
			try {
				input = System.in.read();
				flag = true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/

		return input;
	}
}
