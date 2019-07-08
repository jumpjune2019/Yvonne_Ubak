
class tallyDice {
	int dice1 = 0;
	int dice2 = 0;
	
	//combos
	int c1 = 0;
	int c2 = 0;
	int c3 = 0;
	int c4 = 0;
	int c5 = 0;
	int c6 = 0;
	int c7 = 0;
	int c8 = 0;
	int c9 = 0;
	int c10 = 0;
	int c11 = 0;
	int c12 = 0;
	int c13 = 0;
	int c14 = 0;
	int c15 = 0;
	int c16 = 0;
	int c17 = 0;
	int c18 = 0;
	int c19 = 0;
	int c20 = 0;
	int c21 = 0;
	int tally[]= {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11 ,c12, c13, c14, c15, c16, c17, c18, c19, c20, c21};
	
	void checkCombos(int dice1, int dice2) {
		//1s
		if(dice1 == 1) {
			switch (dice2){
			//combo 1 ---> 1,1
			case 1:
				c1+=1;
				break;
			//combo 2 ---> 1,2
			case 2:
				c2+=1;
				break;
			//combo 3 ---> 1,3
			case 3: 
				c3+=1;
				break;
			//combo 4 ---> 1,4
			case 4: 
				c4+=1;
				break;
			//combo 5 ---> 1,5
			case 5: 
				c5+=1;
				break;
			//combo 6 ---> 1,6
			case 6: 
				c6+=1;
				break;
			}
		}
		//2s
		else if(dice1 == 2) {
			switch (dice2){
			//combo 2 ---> 2,1
			case 1:
				c2+=1;
				break;
			//combo 7 ---> 2,2
			case 2: 
				c7+=1;
				break;
			//combo 8 ---> 2,3
			case 3: 
				c8+=1;
				break;
			//combo 9 ---> 2,4
			case 4: 
				c9+=1;
				break;
			//combo 10 ---> 2,5
			case 5: 
				c10+=1;
				break;
			//combo 11 ---> 2,6
			case 6: 
				c11+=1;
				break;
			}
		}
		//3s
		else if(dice1 == 3) {
			switch (dice2){
			//combo 3 ---> 3,1
			case 1:
				c3+=1;
				break;
			//combo 8 ---> 3,2
			case 2: 
				c8+=1;
				break;
			//combo 12 ---> 3,3
			case 3: 
				c12+=1;
				break;
			//combo 13 ---> 3,4
			case 4: 
				c13+=1;
				break;
			//combo 14 ---> 3,5
			case 5: 
				c14+=1;
				break;
			//combo 15 ---> 3,6
			case 6: 
				c15+=1;
				break;
			}
		}
		//4s
		else if(dice1 == 4) {
			switch (dice2){
			//combo 4 ---> 4,1
			case 1:
				c4+=1;
				break;
			//combo 9 ---> 4,2
			case 2: 
				c9+=1;
				break;
			//combo 13 ---> 4,3
			case 3: 
				c13+=1;
				break;
			//combo 16 ---> 4,4
			case 4: 
				c16+=1;
				break;
			//combo 17 ---> 4,5
			case 5: 
				c17+=1;
				break;
			//combo 18 ---> 4,6
			case 6: 
				c18+=1;
				break;
			}
		}
		//5s
		else if(dice1 == 5) {
			switch (dice2){
			//combo 5 ---> 5,1
			case 1:
				c5+=1;
				break;
			//combo 10 ---> 5,2
			case 2: 
				c10+=1;
				break;
			//combo 14 ---> 5,3
			case 3: 
				c14+=1;
				break;
			//combo 17 ---> 5,4
			case 4: 
				c17+=1;
				break;
			//combo 19 ---> 5,5
			case 5: 
				c19+=1;
				break;
			//combo 20 ---> 5,6
			case 6: 
				c20+=1;
				break;
			}
		}
		//6s
		else if(dice1 == 6) {
			switch (dice2){
			//combo 6 ---> 6,1
			case 1:
				c6+=1;
				break;
			//combo 11 ---> 6,2
			case 2: 
				c11+=1;
				break;
			//combo 15 ---> 6,3
			case 3: 
				c15+=1;
				break;
			//combo 18 ---> 6,4
			case 4: 
				c18+=1;
				break;
			//combo 20 ---> 6,5
			case 5: 
				c20+=1;
				break;
			//combo 21 ---> 6,6
			case 6: 
				c21+=1;
				break;
			}
		}
	}
}
