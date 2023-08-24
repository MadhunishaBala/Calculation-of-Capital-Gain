# Calculation-of-Capital-Gain
I've used the queue data structure to implement this program and their fundamental enqueue and dequeue functions. This task is calculated using the formula ((Sold Share - Purchased Share)*(Selling Price - Purchased Price)). It uses the aforementioned techniques to determine the capital gain after receiving the user's input regarding the shares that were bought and sold at the relevant prices.

------*Breakdown of what happens in this program*------

To collect user input, we import the scanner. The queue is initially implemented by defining variables of the data types Integer for the following: front (the queue's beginning), rear (its end), max size (the queue's capacity), and capital gain (the variable we need to calculate). To store the shares and the prices, two integer arrays are created.

This constructor queue takes in a parameter called size, and it initializes each variable, maxsize is set to the variable size which is the total capacity of the queue. The front is set to 0, which means it’s the starting point of the queue, it represents the index position of the queue which applies to the rear as well, but in this case -1 means the end of the queue. Capital Gain is initialized to 0, this is where we are going to store the calculations of the Capital Gain or loss. Both these integer arrays are used to store shares and prices of the array size, “SIZE”.

Constructor isFull() is used to check if the queue is full,if the end of the queue index is equal to the total size, then the queue is considered to be full. It says maxsize-1 because the index starts with 0.
Constructor isEmpty() is used to check if the queue is empty, basically if the total size of the queue is equal to 0, which is when there are no elements.

Enqueue is a tool for adding items to the end of a queue; in this case, it's being used to add share and price to the system, so it accepts those two parameters. In order to prevent further data input, it first determines whether the queue is full. When a new piece of information is added to the queue's end, the rear, which represents the back of the queue if it isn't full, will be increased by one. As of right now, the element from the end of the array prices in the queue is stored in price, and the element from the end of the array shares in the queue is stored in the variable share.

When a sale occurs, the dequeue is used to remove items from the system's share and price queues, which are at the front of the queue in this case. It first calls the isEmpty method to see if the queue is empty. The gain or loss calculated per day is stored in the integer variable Gain_day, which is initialized to 0 if the queue is not empty, which is essentially the case if the queue is full. Then the try clause is used, and a while loop is run to see if the shares[rear], or sold shares, are greater than 0, and if the queue is full. If both conditions are satisfied, the if statement is then executed.

If the sold share in the back is greater than the purchased share in the front for the day, the if statement subtracts the sold share from the purchased share and stores the remaining shares in the sold share. When an element is dequeued, the Gain_day variable will contain the value that was previously calculated. The Gain_day is calculated by multiplying the purchased share with (selling price – purchased price). The front of the queue is incremented by one.

ELSE,If the purchased shares are greater than sold shares,then the purchased shares are minused from the sold shares and the remaining are stored in the purchased shares, and we can straightaway calculate the CapitalGain as there’s no remaining sold shares. So the CapitalGain variable stores the calculation of the sold shares multiplied with the (Selling price-purchased price). Then the number of sold shares are set to 0. Once the loops break, the CapitalGain is calculated, and if it is positive, then it’s printed as Capital Gain, if not it is printed as Capital Loss and the shares remaining are also printed. The catch clause is used to print an error message when the total sold shares are greater than the total purchased shares.

A main method is created, where it takes input from the user, to store the number of the purchases which is the capacity of the enqueue, and then the shares and prices are prompted from the user and are enqueued. We assume that only one purchase can be made per day.

It takes input from the user, to store the number of the sales which is the capacity of the dequeue, and then the shares and prices are prompted from the user and are dequeued. We assume that only one sales can be made per day.

##Assumptions & conclusions:

- We assume that only one purchase and sale ccould be made per day.
- The program calculates the capital gain or losses based on the shares and prices input by the user.

##Recommendation:

- Many purchases and sales could be made per day, so we could amend the code to make it calculate that.
