//basic usage
let basicStr = `This is a basic string using template literals`;
console.log(basicStr);

//multiline
let multiStr = `This is one line
This is a second line
This is a third line`;
console.log(multiStr);

//expressions - complex object
let paycheck = {
    income: 3000,
    tax: 0.12,
    getTax(){
        return `The goverment will pull out $${this.income * this.tax} in taxes.`;
    },
    getGross(){
        return `The total take home pay for this month is $${this.income - (this.income * this.tax)}.`;
    }
};
console.log(paycheck.getTax());
console.log(paycheck.getGross());

