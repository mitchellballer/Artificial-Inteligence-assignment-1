import java.math.*;

/**
 * 
 * @author mhb91
 * Class that represents a current state of the 8-puzzle
 * the board will be laid out such that each square will have an index according to the following chart:
 * 				0	1	2
 * 				3	4	5
 * 				6	7	8
 * 
 * each squares value will be represented by an int. where 'b' is represented by 0.//the ASCII integer value for the char 53)'b' (
 */
public class State {
	/**
	 * grid is the matrix representation of the state
	 */
	private int[][] grid;
	/**
	 * row0 is the array representation of the top row of the board
	 */
	private int[] row0;
	/**
	 * row1 is the array representation of the middle row of the board.
	 */
	private int[] row1;
	/**
	 * row2 is the array representation of the bottom row of the board.
	 */
	private int[] row2;
	
	/**
	 * constructor for State with no arguments. Creates "solved" puzzle state
	 * Should be used in conjunction with randomizeState(n) in order to get a random state that is solvable.
	 */
	public State(){
		grid = new int[3][3];
		
		//initialize the State
		for(int i = 0; i < 3; i ++){
			for(int j = 0; j < 3; j ++){
				grid[i][j] = i*3 + j;
			}
		}
		//grid[0][0] = (int)'b';
	}
	
	public boolean setState(String newState){
		char c;
		//state was given with no delimiter
		if(isFormat(newState)){
			for(int i = 0; i < 3; i ++){
				for(int j = 0; j < 3; j ++){
					c = newState.charAt(i*4 + j);
					if(c == 'b')
						grid[i][j] = 0;
					else
						grid[i][j] = (char)(c - 48);
				}
			}
			return true;
		}
		else
			return false;
	}
	
	/**
	 * checks the formatting of the given newState to make sure it has one of every required character.
	 * (b)	(1)	(2)	(3)	(4)	(5)	(6)	(7)	(8)	( )
	 * 1	1	1	1	1	1	1	1	1	1
	 * 2^9	2^8	2^7	2^6	2^5	2^4	2^3	2^2	2^1	2^0
	 * Note: since space is expected to be used twice, we want the final value to be -1
	 * @param newState
	 * @return
	 */
	public boolean isFormat(String newState){
		int checksum = (int)Math.pow(2, 10) - 1;
		char c;
		for(int i = 0; i < newState.length(); i ++){
			c = newState.charAt(i);
			switch(c){
				case ' ': checksum -= 1;
				break;
				case 'b': checksum -= Math.pow(2, 9);
				break;
				case '1': checksum -= Math.pow(2, 8);
				break;
				case '2': checksum -= Math.pow(2, 7);
				break;
				case '3': checksum -= Math.pow(2, 6);
				break;
				case '4': checksum -= Math.pow(2, 5);
				break;
				case '5': checksum -= Math.pow(2, 4);
				break;
				case '6': checksum -= Math.pow(2, 3);
				break;
				case '7': checksum -= Math.pow(2, 2);
				break;
				case '8': checksum -= Math.pow(2, 1);
				break;
			}		
		}
		if(checksum == -1)
			return true;
		else
			return false;
	}
	/**
	 * Method that prints the current state to the command line
	 */
	public void printState(){
		for(int i = 0; i < 3; i ++){
			for(int j = 0; j < 3; j ++){
				if(grid[i][j] == 0)
					System.out.print("b ");
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
