import java.util.*;

class Main{

    public static void display(char[][] board){
        for(int row=0;row<board.length;row++){          //Set values to null in array
            for(int col=0;col<board[0].length;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board,char player){
        for(int row=0;row<board.length;row++){          //Checks Row
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
 
        for(int col=0;col<board[0].length;col++){       //Checks Column
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){  //Checks Diagonal 
            return true;
        }

        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){  //Checks Diagonal 
            return true;
        }
        return false;
    }

    public static boolean hasDraw(char[][]board){   //Checks board space if it is empty return false else return true 
        for(int row=0;row<board.length;row++){          
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]!=' '){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     //User Input 
        boolean loop = true;   //Game will continue till the player doesnt win or draw
        char board[][] = new char[3][3]; //board size 3x3
        char player = 'X';

        for(int row=0;row<board.length;row++){          //Set values to null in array
            for(int col=0;col<board[0].length;col++){
                board[row][col]=' ';
            }
        }

        

        while(loop){  
            System.out.println("Player "+player+" turn!");
            display(board);
            System.out.println("Enter Row: ");
            int row = input.nextInt();
            System.out.println("Enter Column: ");
            int col = input.nextInt();
            if(board[row][col]==' '){
                board[row][col]=player;
                boolean wonStatus  = hasWon(board,player);
                boolean drawStatus = hasDraw(board);
                if(wonStatus){
                    System.out.println("Congratulations! Player "+player+" has won the game!");
                    loop = false;
                }
                else if(drawStatus){
                    System.out.println("The game is draw!");
                    loop = false;
                }
                player = player=='X' ? 'O':'X'; //Change Player Turn

            }
            else{
                System.out.println("Invalid Move!"); //Edge Case: Checks Player Move
            }
            display(board);

        }
    }
    
}