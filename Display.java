public class Display
{
  private String[][] display; 
  public Display(int size)
  {
    display = new String[size][size];
    for(int r = 0; r < display.length; r++)
    {
      for(int c = 0; c < display[r].length; c++)
      {
        display[r][c] = "*";
      }
    }
  }
  public Display(String[][] matrix, boolean loopOver, int size)
  {
    display = new String[size][size];
    if(loopOver == false)
      display = matrix;
    else 
    {
      for(int r = 0; r < display.length; r++)
      {
        for(int c = 0; c < display[r].length; c++)
        {
          matrix[r][c] = "*";
        }
      }
    }
  }

  public void printMatrix()
  {
    String out = "";
    for(int r = 0; r < display.length; r++)
    {
      for(int c = 0; c < display[r].length; c++)
      {
        out += display[r][c] + " ";
      }
      out +="\n";
    }
    System.out.println(out);
  }
  public void printMatrix(String[][] m)
  {
    String out = "";
    for(int r = 0; r < m.length; r++)
    {
      for(int c = 0; c < m[r].length; c++)
      {
        out += m[r][c] + " ";
      }
      out += "\n";
    }
    System.out.println(out);
  }
  public void reset(String[][] m)
  {
    for(int r = 0; r < display.length; r++)
    {
      for(int c = 0; c < display[r].length; c++)
      {
          m[r][c] = "#";
      }
    }
  }
}
