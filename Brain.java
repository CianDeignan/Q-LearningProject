public class Brain
{
  private double[][] QLearningTable;
  private double epsilon = 0.1;
  private double alpha = 0.1;
  private double gamma = 0.6;
    
  public Brain()
  {
    QLearningTable = new double[1][1];
  }

  public int run(Board board, boolean Show, boolean Learn, int size, int se)
  {
    int t = 0;
    while(board.getIsFinished() == false)
    {
      if(Show == true && t == 0)
      {
        String[][] show = new String[size][size];
        Display display = new Display(show,true,size);
        board.toBoard(show);
        display.printMatrix(show);
        System.out.println();
      }

      int reward;
      int state = board.getCurrentState();
      int action;

      if(Math.random() < epsilon)
      {
        action = (int)(Math.random() * 6);    
      }
      else
      {
        double max = (double)Integer.MIN_VALUE;
        action = -1;
        for(int c = 0; c < QLearningTable[state].length; c++)
        {
          if(max < QLearningTable[state][c])
          {
            max = QLearningTable[state][c];
            action = c;
          }
        }
        
      }

      reward = board.Action(action);
      int newState = board.getCurrentState();

      double expectedMax = (double)Integer.MIN_VALUE;
      for(int i = 0; i < QLearningTable[newState].length; i++){
        if(expectedMax < QLearningTable[newState][i])
        {
          expectedMax = QLearningTable[newState][i];
        }
      }

      if(Learn == true)
      {
        QLearningTable[state][action] = QLearningTable[state][action] + alpha*(reward + gamma*(expectedMax)-QLearningTable[state][action]);
      }
      t++;

      if(Show == true)
      {
        String[][] show = new String[size][size];
        Display display = new Display(show,true,size);
        board.toBoard(show);
        display.printMatrix(show);
        System.out.println();
        
        try
        {
          Thread.sleep(se);
        }
        catch(InterruptedException ex)
        {
          
        }
      }
    }
    return t;
  }   

  public void showBrain()
  {
    for(int r  = 0; r < QLearningTable.length; r++)
    {
      for(int c = 0; c < QLearningTable[c].length; c++)
      {
        System.out.println(QLearningTable[r][c] + " ");
      }
    }
  }
  
  public void initializeQLearningTable(Board board)
  {
    QLearningTable = new double[board.getStates()][6];
  }
  public double getMax(double[][] Matrix, int x) 
  {
    for(int r = 0; r < Matrix.length; r++) 
    {
      if(r == x)
      {
        double max = Double.MIN_VALUE;
        for(int c = 0; c < Matrix[r].length; c++)
        {
          if(Matrix[r][c] > max)
          {
            max = Matrix[r][c];
          }
        }
        return max;
      }
    } 
    return 0;
  }
}
