## Arrow Function Documetaion
### By: W Andrew Montgomery

####Arrow Functions have two main benefits:
1) A shorter syntax then typical functions
2) No binding of this

__**ES5 Version**__
functuon add2(num){
    return num + 2;
}
add(2)
// 4

__**ES6 Version**__
const add2 = num => num + 2;

add2(2);
// 4

####Main benefit: No binding of "this"
<p> In classic function expressions, the this keyword is bound to different values based on the context in which it is called. With arrow functions however, this is lexically bound. It means that it usesthis from the code that contains the arrow function.

__**ES5 Version**__
var obj = {
    id: 42,
    counter: function counter(){
        setTimeout(function(){
            console.log(this.id);
        }.bind(this), 1000);
    }
};

#### Note:
<p> In the ES5 example, .bind(this) is required to help pass the this context into the function. Otherwise, by default this would be undefined.


__**ES6 Version**__
var obj = {
    id: 42,
    counter: function counter() {
        setTime(() => {
            console.log(this.id);
        }, 1000);
    }
};

#### Note:
<p>ES6 arrow functions can’t be bound to a this keyword, so it will lexically go up a scope, and use the value of this in the scope in which it was defined.

####Arrow Functions Cons:

<p> It is important to note that arrow functions are anonymous, which means that they are not named.

#### Anonymity creates some issues
<li>Harder to dedug
<p>When you get an error, you will not be able to trace the name of the function or the exact line number where it occurred.
<li> No self-referencing

<p> If your function needs to have a self-reference at any point (e.g. recursion, event handler that needs to unbind), it will not work.


