# Small-supermarket-cachiers-simulator
This is a small supermarket cashiers simulator uses an unsynchronized thread to start eight threads and initialize eight queues. Each separate queue is accessed and modified by one of the eight threads but also by the thread that holds them, all this simultaneously (unsynchronized). 
