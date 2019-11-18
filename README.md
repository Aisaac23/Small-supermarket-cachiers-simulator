# Small-supermarket-cachiers-simulator
This is a small supermarket cashiers simulator uses an asynchronized thread to start eight threads and initialize eight queues. Each separate queue is accessed and modified by one of the eight threads but also by the thread that holds them, all this simultaneously (asynchronized). 

Variables "NewCustTimeMax" and "NewCustTimeMin" are important for you to see an analyze carefully how the simulator works so feel free to adjust them if you feel that the simulator goes too fast or too slow.

When runing the whole application you'll be able to see that the main thread finishes but before that it has already called the start() method of our variable supermarket so the supermarket thread starts.

Then you'll see at the console a format like this:

A customer just queued at cashier 1, with 24 items.
A customer just left cashier 5, with 163 items.
1. [59]
2. [100][145]
3. [112][165]
4. [147][124]
5. [87][163]
6. [153]
7. [39]
8. [2]

Where you can see how many items the next customer is going to take in each one of the queues. When a customer arrives you'll read "A customer just queued at cashier 'a' with 'b' items." If a customer has finished all their transactions you'll see "A customer just left cashier a with b items.".

You'll see the eight queues printed each time a customer arrives to any one of them but if a customer leaves you'll only se the message previously explained. 
