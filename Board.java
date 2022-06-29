public class Board
{
  private int[] playerPos;
  private int[] itemPos;          
  private int[] endPos;
  private int size;
  private boolean isPickedUp = false;
  private boolean isFinished = false;
  
  public Board(int size,int[] playerPos, int[] itemPos, int[] endPos)
  {
    this.playerPos = playerPos;
    this.itemPos = itemPos;
    this.endPos = endPos;
    this.size = size;
    this.isPickedUp = false;
    this.isFinished = false;
  }

  public int Action(int a)
  {
    if(a == 0)
    {//up
      if(playerPos[1] < size - 1)
      {
        playerPos[1] = playerPos[1] + 1;
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 1)
    {//down
      if(playerPos[1] > 0)
      {
        playerPos[1] = playerPos[1] - 1;
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 2)
    {//right
      if(playerPos[0] < size - 1)
      {
        playerPos[0] = playerPos[0] + 1;
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 3)
    {//left
      if(playerPos[0] > 0)
      {
        playerPos[0] = playerPos[0] - 1;
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 4)
    {//pickup
      if(playerPos[0] == itemPos[0] && playerPos[1] == itemPos[1] && isPickedUp != true)
      {
        isPickedUp = true;
        return 20;
      }
      else if(isPickedUp == true)
      {
        return -10;
      }
      else
      {
        return -10;
      }
    }
    else
    {//putdown
      if (isPickedUp == true && playerPos[0] == endPos[0] && endPos[1] == playerPos[1]) 
      {
        this.isFinished = true;
        return 20;

      }
      else if( isPickedUp == false)
      {
        return -10;
      }
      else
      {
        return -10;
      }
    }
  }

public int hypotheticalReward(int a)
  {
    if(a == 0)
    {//up
      if(playerPos[1] < size - 1)
      {
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 1)
    {//down
      if(playerPos[1] > 0)
      {
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 2)
    {//right
      if(playerPos[0] < size - 1)
      {
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 3)
    {//left
      if(playerPos[0] > 0)
      {
        return -1;
      }
      else 
      {
        return -10;
      }
    }
    else if(a == 4)
    {//pickup
      if(playerPos[0] == itemPos[0] && playerPos[1] == itemPos[1] && isPickedUp != true)
      {
        return 20;
      }
      else if(isPickedUp == true)
      {
        return -10;
      }
      else
      {
        return -10;
      }
    }
    else
    {//putdown
      if (isPickedUp == true && playerPos[0] == endPos[0] && endPos[1] == playerPos[1]) 
      {
        return 20;

      }
      else if( isPickedUp == false)
      {
        return -10;
      }
      else
      {
        return -10;
      }
    }
  }

  public int getStates()
  {
    return size * size * size * size * 2;
  }

  public int getCurrentState()
  {
    int state = playerPos[0]*size*size*size*2;
    state += playerPos[1]*size*size*2;
    state += itemPos[0]*size*2;
    state += itemPos[1]*2;
    if(isPickedUp == true)
    {
      state += 1;
    }
      
    return state;
  }

  public void toBoard(String[][] board)
  {
    
    if(isPickedUp == false)
    {
      board[itemPos[1]][itemPos[0]] = "I";
    }

    board[endPos[1]][endPos[0]] = "E";

    board[playerPos[1]][playerPos[0]] = "P";
  }

  public boolean getIsFinished()
  {
    return isFinished;
  }
  
}
