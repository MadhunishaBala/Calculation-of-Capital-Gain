import java.util.Scanner;
public class Queue {
    private int front;
    private int rear;
    private int maxsize;
    private int CapitalGain;
    private int[] shares; //An integer array for the number of shares stored
    private int[] prices; //An integer array for the number of prices stored
    public Queue(int size)
    {
        maxsize=size;
        front=0;
        rear=-1;
        CapitalGain=0;
        shares=new int[size];
        prices=new int[size];
    }
    public boolean isFull()  // This is used to check if the queue is full
    {
        return(rear==maxsize-1);
    }

    public boolean isEmpty()//This is used to check if the queue is empty
    {
        return(maxsize==0);
    }

    public void enqueue(int share,int price)//enqueue is used to add data into the queue.
    {
        if(isFull())
        {
            System.out.println("Queue is full");
        } else{
            rear++;
            shares[rear]=share;
            prices[rear]=price;
        }

    }
    public void dequeue(int share,int price)//dequeue is used to remove the data from the queue
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
        else {
            int Gain_day = 0;
            // we set a temporary variable to store the capital gain per day
            try {
                while (share > 0 && isFull()) //Share is the first sold share at the end of the queue.
                {
                    if (share >= (shares[front]))
                    {
                        share = share - (shares[front]);
                        Gain_day = Gain_day + ((shares[front]) * (price - prices[front]));
                        front++;
                    } else {
                        shares[front] = shares[front] - share;
                        CapitalGain = CapitalGain + (share * (price - prices[front]));
                        share = 0;
                        }
                }
                CapitalGain=CapitalGain+Gain_day;
                if (CapitalGain>0){
                    System.out.println("Capital gain:"+ CapitalGain);
                    System.out.println("Shares remaining:"+shares[rear]);
                }
                else
                {
                    System.out.println("Capital loss:"+CapitalGain);
                    System.out.print("Shares remaining:"+shares[rear]);
                };
            } catch (Exception e) {
                System.out.println("There are no sufficient amount of shares in order to execute this transaction," +
                        "" + " so please check!");
            }

            //The capital Gain is calculated with the addition of the gain received per day with the multiplication of
            //(Sold share-Purchased share)*(Selling price-Purchased price) and the output will be printed.
        }

    }
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of purchases: "); //Prompts the user for the number of purchases
        int size = scanner.nextInt();
        Queue queue = new Queue(size);
        for (int i = 0; i <size; i++)
        {
            System.out.println("Day " + (i + 1) + ":");
            System.out.println("Enter the number of shares purchased:");
            // We assume only one purchase can be made per day
            int share = scanner.nextInt();
            System.out.println("Enter the price:");
            int price = scanner.nextInt();
            queue.enqueue(share, price); //the enqueue is called and that specific function is implemented.
        }

        System.out.println("Enter the number of sales:"); //Reading the number of sales,which is prompted from the user
        int sales = scanner.nextInt();
        for (int i = 0; i <sales; i++)
        {
            System.out.println("Day " + (i + 1) + ":");
            System.out.println("Enter the number of shares sold:");
            //We assume that only one sales can be made per day.
            int share = scanner.nextInt();
            System.out.println("Enter the price:");
            int price = scanner.nextInt();
            queue.dequeue(share, price); //the dequeue is called and that specific function is implemented.
        }

    }

}