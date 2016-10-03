import java.lang.*;
import java.lang.reflect.Array;

/**
 * @author mhb91
 * Artificial Intelligence Programming Assignment 1
 * 
 */
public class puzzle8 {
	public State puzzle;
	public boolean initialized;
	public boolean set;
	public boolean complete;
	/**
	 * Constructor for puzzle.
	 * Puzzle is a 3x3 array of integers NOTE: integer representation of the blank tile,'b'=
	 */
	public puzzle8(){
		puzzle = new State();
		set = false;
		complete = false;
		initialized = true;
	}
	
	/**
	 * 
	 * @param input
	 */
	public void setStateStandard(int[][] input){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		State board = new State();
		board.printState();
		String state = "b12 345 678";
		board.setState(state);
		board.printState();

	}

}
