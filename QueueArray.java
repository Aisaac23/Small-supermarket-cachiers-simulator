package dreamincode;

// This is the Java Queue class which has been built instead of using the 
// library for the sake of learning how a queue works.
////////////////////////////////////////////////////////////////
 
class QueueArray
{
    protected int maxSize;
    protected long[] queArray;
    protected int front;
    protected int rear;
    protected int nItems;

/* We initilize this queue as an array because we want to practice how a queue 
    works but this is completly optional as we have the Java Queue interface from java.util.
    
Also, although at the end, a linear queue and a circular queue are practically the same, 
    this queue is an strictly linear one, because custumers make a line strictly one after the other.*/
    
    public QueueArray(int s)       
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
/*We don't verify if the queue is full as this is implementation specific so becarefull by checking before inserting.*/
    public void insert(long j)   
    {
        queArray[++rear] = j;         
        nItems++;                     
    }
/*We don't verify if the queue is empty as this is implementation specific so becarefull by che-.king before removing.*/
    public long remove()         
    {
        long temp = queArray[front++]; 
        nItems--;  
        return temp;
    }
/*Simply allows you to see the element in the front without removing it.*/
    public long peek()      
    {
        return queArray[front];
    }
/*Checks if there are no items left in the queue*/
    public boolean isEmpty()   
    {
        return (nItems==0);
    }
/*Checks if there is no space available in the queue*/
    public boolean isFull()  
    {
        return (nItems==maxSize);
    }
/*Returns the number of elements in the queue*/
    public int size()
    {
        return nItems;
    }
    
/*Displays the queue from left to right: [front]...[2][3][4]....[rear]*/
    public void displayQueue()
    {
        int disp = front;
        if(!this.isEmpty())
            while(disp <= rear)
                System.out.print("[" + this.queArray[disp++] + "]");
        else
            System.out.println("Empty queue");
        System.out.println("");
    }
}


class SupermarketApp
{
    public static void main(String[] args)
    {

    /*********** Testing ***********************/
    System.out.println("SUPER MARKET SIMULATOR:");
    SuperMarket supermarket = new SuperMarket("SuperMarket_1");
    supermarket.start();//Starts main thread: the supermarket
    /**********************************************************************/
    System.out.println("\t\t\tFinishing main thread...");
    }
   
}
