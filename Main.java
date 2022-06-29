import java.util.*;
import java.util.concurrent.TimeUnit;
class Main 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(System.in);
    int size = 10;
    int x = 0;
    int y = size-1;
    Board board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
    Brain brain = new Brain();
    brain.initializeQLearningTable(board);

    System.out.println("Hello, welcome to the Simple AI Simulation, this is a program where an AI will train to complete a puzzle. This puzzle is on a 10 by 10 grid to start. The goal of this puzzle is to get the item in the bottom left, then go to the end at the bottom right to drop off the item");

    boolean stop = false;
    int input = 0;

    while(stop == false)
    {
      System.out.println("\nWhat would you like to do? \n\n1: Train the AI showing visuals\n2: Show the AI completing the puzzle\n3: Get the average turn number\n4: Change the size of the puzzle\n5: Move the item\n6: Train the AI showing turn count\n7: End the program\n(Enter the number of the action you want to do)\n(Disclaimer: Training on boards with sizes above 15 takes a very long time)");

      input = scan.nextInt();

      if(input == 1)
      {
        System.out.println("\nEnter the number of times you wish to train for.\n");
        
        int ui = scan.nextInt();
        for(int i = 0; i < ui;i++)
        {
          if(i % 10*(size/10)== 0&&i<=150*(size/10)&&i!=0)
          {
            brain.run(board,true,true,size,18);
            board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
          }
          else
          {
            
            brain.run(board,false,true,size,500);
            board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});

          }

        }
        
       
        System.out.println("Completed");
        
      }
      else if(input == 2)
      {
        int t = brain.run(board,true,false,size,500);
        System.out.println("Completed in " + t + " turns.");
        board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
      }
      else if(input == 3)
      {
        int avgTurnTimes = 0;

        for(int i = 0; i < 50; i++)
        {
          avgTurnTimes += brain.run(board,false,false,size,500);  
          board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
        }

        System.out.println("\nThe average turns to complete the puzzle is " + avgTurnTimes/50 + "."); 

      }
      else if(input == 4)
      {
        System.out.println("\nWhat would you like to change the size to?\n");
        size = scan.nextInt();
        x = 0;
        y = size-1;
        board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
        brain.initializeQLearningTable(board);
      }
      else if(input == 5)
      {
        boolean xi = false;
        boolean yi = false;

        int X = 0;
        int Y = size-1; 

        while(xi == false)
        {   
          System.out.println("How far over? ");
          X = scan.nextInt();

          if(X > size-1 || X < 0)
          {
            xi = false;
            System.out.println("Out of the board, change input.");
          }
          else
          {
            xi = true;
          }
        }

        while(yi == false)
        {
          System.out.println("How far down?");
          Y = scan.nextInt();

          if(Y > size-1 || Y < 0)
          {
            yi = false;
            System.out.println("Out of the board, change input.");
          }
          else
          {
            yi = true;
          }
        }


        x = X;
        y = Y;

        board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
        brain.initializeQLearningTable(board);
      }
      else if(input == 6)
      {
        System.out.println("\nEnter the number of times you wish to train for.\n");
        int ti = scan.nextInt();
        for(int o = 0; o < ti; o++)
        {
          try
          {
            Thread.sleep(5);
          }
          catch(InterruptedException ex)
          {
            
          }
          System.out.println(brain.run(board,false,true,size,500));
          board = new Board(size,new int[]{0,0},new int[]{x,y}, new int[]{size-1,size-1});
        }
      }
      else if(input == 7)
      {
        stop = true;
      } 
      else
      {
        System.out.println("\nNot a valid input.\n");
      }
    }   
  }    
}
