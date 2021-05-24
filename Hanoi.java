public class Hanoi {
	
	// https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
	// https://www.mathsisfun.com/games/towerofhanoi.html
	
	public static int moves = 1; // Will always be (2^n) - 1 moves.
	
	public static void hanoi(int n, char from, char to, char aux) {
		if (n == 1) {
			System.out.println("Move " + moves++ + ": " + from + " to " + to);
			return;
		}
		
		hanoi(n - 1, from, aux, to);
		System.out.println("Move " + moves++ + ": " + from + " to " + to);
		hanoi(n - 1, aux, to, from);
	}
	
	public static void main(String[] args) {
		hanoi(1, 'A', 'B', 'C');
	}
}
