package StacksAndQueues;

// This is the Java Queue class which has been built instead of using the 
// library for the sake of learning how a queue works.
////////////////////////////////////////////////////////////////

 
class Queue
{
    protected int maxSize;
    protected long[] queArray;
    protected int front;
    protected int rear;
    protected int nItems;

    public Queue(int s)       
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j)   
    {
        if(rear == maxSize-1)         
            rear = -1;
        queArray[++rear] = j;         
        nItems++;                     
    }

    public long remove()         
    {
        long temp = queArray[front++]; 
        if(front == maxSize)           
            front = 0;
        nItems--;  
        return temp;
    }

    public long peekFront()      
    {
        return queArray[front];
    }

    
    public boolean isEmpty()   
    {
        return (nItems==0);
    }

    
    public boolean isFull()  
    {
        return (nItems==maxSize);
    }

    
    public int size()
    {
        return nItems;
    }
    
    /*********** Programming Projects: 4.1 *******************/
    public void displayQueue()
    {
        if(!this.isEmpty())
        {
            int disp = front;
            if(front > rear)
            {
                while(disp < maxSize)
                    System.out.print("[" + this.queArray[disp++] + "]");
                disp = 0;
                while(disp <= rear)
                    System.out.print("[" + this.queArray[disp++] + "]");
            }
            else
                while(disp <= rear)
                    System.out.print("[" + this.queArray[disp++] + "]");
        }
        else
            System.out.println("Empty queue");
        System.out.println("");
    }
    /********************************************************************/
}


class QueueApp
{
    public static void main(String[] args)
    {

    /*********** Testing: Programming Projects: 4.5 ***********************/
    System.out.println("");
    System.out.println("SUPER MARKET SIMULATOR:");
    SuperMarket supermarket = new SuperMarket("SuperMarket_1");
    supermarket.start();
    /**********************************************************************/
    
    }
   
}
