import java.util.Scanner;
public class FourByFourSudoku {
	public static boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = j + 1; k < 16; k++) {
                    if (board[i][j] != '.' && board[i][j] == board[i][k]) return false;  
                }
            }
        }
        
        // Check columns
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = j + 1; k < 16; k++) {
                    if (board[j][i] != '.' && board[j][i] == board[k][i]) return false;  
                }
            }
        }
        
        // Check boxes
        for (int i = 0; i < 16; i++) {
            char[] flatBox = new char[16];
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    flatBox[(4 * a) + b] = board[(4 * (i % 4)) + a][(4 * (i / 4)) + b];
                }
            }
            for (int j = 0; j < 16; j++) {
                for (int k = j + 1; k < 16; k++) {
                    if (flatBox[j] != '.' && flatBox[j] == flatBox[k]) return false;  
                }
            }
        }
        return true;
    }
    
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (board[i][j] == '.') {
                    for (int k = 65; k < 81; k++) {
                        board[i][j] = (char) k;
                        if (isValidSudoku(board) && solveSudoku(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false; 
                    /*
                    * If placing a 1-9 here is impossible or leads to an unsolvable board,
                    * then this board cannot be solved. Return.
                    */
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	char[][] sudoku = new char[16][16];
    	for (int i = 0; i < 16; i++) {
    		for (int j = 0; j < 16; j++) {
    			sudoku[i][j] = '.';
    		}
    	}
    	
    	
    	
    	for (int i = 0; i < 16; i++) {
    		for (int j = 0; j < 16; j++) {
    			System.out.print(sudoku[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("-------------------------------");
    	
    	solveSudoku(sudoku);
    	
    	Scanner scan = new Scanner(System.in);
    	scan.nextLine();
    	
    	for (int i = 0; i < 16; i++) {
    		for (int j = 0; j < 16; j++) {
    			System.out.print(sudoku[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
