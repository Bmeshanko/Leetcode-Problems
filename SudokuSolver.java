// https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
	public static boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (board[i][j] != '.' && board[i][j] == board[i][k]) return false;  
                }
            }
        }
        
        // Check columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (board[j][i] != '.' && board[j][i] == board[k][i]) return false;  
                }
            }
        }
        
        // Check boxes
        for (int i = 0; i < 9; i++) {
            char[] flatBox = new char[9];
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    flatBox[(3 * a) + b] = board[(3 * (i % 3)) + a][(3 * (i / 3)) + b];
                }
            }
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (flatBox[j] != '.' && flatBox[j] == flatBox[k]) return false;  
                }
            }
        }
        return true;
    }
    
    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 49; k < 58; k++) {
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
    	char[][] sudoku = new char[9][9];
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			sudoku[i][j] = '.';
    		}
    	}
    	
    	sudoku[0][1] = '7';
    	sudoku[0][4] = '2';
    	sudoku[0][5] = '8';
    	sudoku[0][7] = '9';
    	sudoku[0][8] = '4';
    	sudoku[1][1] = '4';
    	sudoku[1][7] = '6';
    	sudoku[1][8] = '7';
    	sudoku[2][0] = '2';
    	sudoku[2][7] = '1';
    	sudoku[3][4] = '5';
    	sudoku[3][5] = '9';
    	sudoku[3][8] = '6';
    	sudoku[4][4] = '4';
    	sudoku[5][0] = '3';
    	sudoku[5][3] = '1';
    	sudoku[5][4] = '8';
    	sudoku[6][1] = '9';
    	sudoku[6][8] = '1';
    	sudoku[7][0] = '7';
    	sudoku[7][1] = '1';
    	sudoku[7][7] = '8';
    	sudoku[8][0] = '6';
    	sudoku[8][1] = '8';
    	sudoku[8][3] = '5';
    	sudoku[8][4] = '3';
    	sudoku[8][7] = '7';
    	
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(sudoku[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("-----------------");
    	
    	solveSudoku(sudoku);
    	
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.print(sudoku[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
