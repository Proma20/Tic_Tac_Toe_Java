
/**
 * Example MiniMax agent extending Agent class.
 * Here, for simplicity of understanding min and max functions are written separately. One single function can do the task. 
 * 
 *
 */
public class MinimaxTTTAgent extends Agent
{
   int Count = 0;
    int depth=0;
   
  
    public int[][] tempboard = new int[3][3];
	public MinimaxTTTAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game,tictactow tj) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                TickTackToe tttGame = (TickTackToe) game;
               // tttGame.showGameState();
               
               
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        tempboard[i][j] = tttGame.board[i][j];
                    }
                }
                 System.out.println("Count " + Count);
		CellValueTuple best = max(tttGame,100,depth);
                for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                      tttGame.board[i][j]= tempboard[i][j];
                    }
                }
		if(best.col!=-1)
		{
			tttGame.board[best.row][best.col] = 1;
                        tj.setPC(best.row,best.col);
                       // System.out.println("best col");
		}
                System.out.println("Count " + Count);
                //tttGame.showGameState();
		
	}
	
	private CellValueTuple max(TickTackToe game,int beta,int depth)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
		maxCVT.utility = -100;
                int alpha=-100;
                int winner = game.checkForWin();
	        if(game.isFinished())
                {
                    
                
                if(winner==1)
                    maxCVT.utility=10-depth;
                else if(winner==0)
                    maxCVT.utility=-10+depth;
                else if(winner == -1)
                   maxCVT.utility=0;
                 // System.out.println("utility"+maxCVT.utility);
                    return maxCVT;
                
                
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
               
                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(game.board[i][j]==-1)
                            {
                                game.board[i][j]=role;
                                CellValueTuple minC= new CellValueTuple();
                                
                               // game.showGameState();
                               // if(alpha<beta)
                                {
                                    minC=min(game,alpha,depth+1);
                                }
                                Count++;
                                minC.row=i;minC.col=j;
                                //maxCVT.utility= Math.max(maxCVT.utility,minC.utility);
                                if(minC.utility>maxCVT.utility)
                                {
                                    maxCVT=minC;
                                    
                                    
                                }
                                alpha=maxCVT.utility;
                                game.board[i][j]=-1;
                                //winner = -1;
                                
                            }
                           
                        }
                    }
                
		//implement max function of minimax/alpha-beta pruning algorithm
                        //traverse the whole board
                                //temporarily machine agent occupy the empty cell
                                //call for min function of human agent
                                //update maxcvt
                                //go to previous state
                
                
               
		return maxCVT;
			
	}
	
	private CellValueTuple min(TickTackToe game,int alpha,int depth)
	{	
		CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 100;
                 int beta=100;
		
		int winner = game.checkForWin();
               // System.out.println("winner min " + winner);
                if(game.isFinished())
                {
                if(winner==1)
                    minCVT.utility=10-depth;
                else if(winner==0)
                    minCVT.utility=-10+depth;
                else if(winner==-1)
                   minCVT.utility=0;
                 
                    return minCVT;
                
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
         
                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(game.board[i][j]==-1)
                            {
                                
                                game.board[i][j]=minRole();
                                CellValueTuple maxC = new CellValueTuple();
                              //  game.showGameState();
                                //if(alpha<beta)
                                {
                                    maxC=max(game,beta,depth+1);
                                }
                                Count++;
                               
                                minCVT.row=i;minCVT.col=j;
                                //minCVT.utility= Math.min(maxC.utility,minCVT.utility);
                                if(maxC.utility<minCVT.utility)
                                {
                                    minCVT=maxC;
                                }
                                beta=minCVT.utility;
                                game.board[i][j]=-1;
                                
                            }
                           
                        }
                    }
                    
                    
                
		//implement min function of minimax/alpha-beta pruning algorithm 
                return minCVT;
			
	}





	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}

	class CellValueTuple
	{
		int row,col, utility;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
		}
	}
        
        private int evaluate (Game game){
            
            
            return 0;
        }

          

}
 
