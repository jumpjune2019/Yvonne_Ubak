package preterm_v04;

public class Labels {
	static char rowlbl;
	static int row;
	static char getRow(int rv) {
//		rowlbl = 'A';
		if(rv >=0 && rv <10) {
			rowlbl ='A';
		}
		else if(rv >=10 && rv <20) {
			rowlbl ='B';
		}
		else if(rv >=20 && rv <30) {
			rowlbl ='C';
		}
		else if(rv >=30 && rv <40) {
			rowlbl ='D';
		}
		else if(rv >=40 && rv <50) {
			rowlbl ='E';
		}
		else if(rv >=50 && rv <60) {
			rowlbl ='F';
		}
		else if(rv >=60 && rv <70) {
			rowlbl ='G';
		}
		else if(rv >=70 && rv <80) {
			rowlbl ='H';
		}
		else if(rv >=80 && rv <90) {
			rowlbl ='I';
		}
		else if(rv >=90 && rv <100) {
			rowlbl ='J';
		}
	 return rowlbl;
	}
	
	static int getSeatNumber(int sn) {
		int seatNum =0;
		int compNum = 0;
		int s =0;
		//seat 1
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 1;
			}
			compNum = compNum + 10;
		}
		//seat 2
		compNum = 1;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 2;
			}
			compNum = compNum + 10;
		}
		//seat 3
		compNum = 2;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 3;
			}
			compNum = compNum + 10;
		}
		//seat 4
		compNum = 3;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 4;
			}
			compNum = compNum + 10;
		}
		//seat 5
		compNum = 4;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 5;
			}
			compNum = compNum + 10;
		}
		//seat 6
		compNum = 5;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 6;
			}
			compNum = compNum + 10;
		}
		//seat 7
		compNum = 6;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 7;
			}
			compNum = compNum + 10;
		}
		//seat 8
		compNum = 7;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 8;
			}
			compNum = compNum + 10;
		}
		//seat 9
		compNum = 8;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 9;
			}
			compNum = compNum + 10;
		}
		//seat 10
		compNum = 9;
		for(s =0; s < 10; s++) {
			if(sn == compNum) {
				seatNum = 10;
			}
			compNum = compNum + 10;
		}
		return seatNum;
	}
	
	static int getRowNum(char rlbl) {
		switch(rlbl) {
		case 'A':
			row = 0;
			break;
		case 'B':
			row = 1;
			break;
		case 'C':
			row = 2;
			break;
		case 'D':
			row = 3;
			break;
		case 'E':
			row = 4;
			break;
		case 'F':
			row = 5;
			break;
		case 'G':
			row = 6;
			break;
		case 'H':
			row = 7;
			break;
		case 'I':
			row = 8;
			break;
		case 'J':
			row = 9;
			break;
		}
		return row;
	}
}
