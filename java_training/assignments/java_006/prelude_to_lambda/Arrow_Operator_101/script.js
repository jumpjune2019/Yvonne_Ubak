//Calculate cost per person for vacation
var cost = 1028.76;		//price of home
var ppl = 6; 			//persons attending trip
var costPerPerson = (x, y) => x/y;

console.log("The vacation home for the trip to St. Lucia cost a total of: " + cost + 
" usd. There are " + ppl + " people staying in the vacation home, so each person much pay " 
+ costPerPerson(cost, ppl) + " usd.");