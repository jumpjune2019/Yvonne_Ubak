# Javascript Arrow Operator Documentation
## Author: Yvonne Ubak

The arrow operator is a lambda expression that is present in many modern programming languages. This operator is part of ES6 Javascript syntax and it provides a shortened form of creating a function.

###Key Features
The key features of arrow functions are:
    <li> => is the token used 
    <li> Flexible syntax
    <li> changes the way 'this' binds
<br/>

###Examples
In the ES5 syntax, a function would be written as follows:
var subtraction = function(x, y){
    return x- y;
}
<br/>

In the ES6 syntax, the above function can be written in various shortened forms.
//version 1
var subtraction = (x,y)=> {return x-y};
<br/>

//version 2
var subtraction = (x, y) => x-y;

###Advantages
This is a fairly new function and it has its own pros and cons.
Some of the advantages of using the arrow function are that it:
    <li>Saves time in developing
    <li>Simplifys function scope
    <li>Is supported by most browsers
    <li>Is Lightweight
<br/> 

###Disadvantages
Some of the **disadvantages** of using the arrow function are that it:
    <li>Cannot be used with constructors
    <li>Cannot be used as generators
    <li>Does not have an arguements object
    <li>Cannot change the 'this' variable
    <li>Some browsers still don't support this function yet.
<br/>

The provided .html and .js files are test scenarios that use this operator.
