import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


class Puzzle8State{
	int[] sequence;
	//int score;
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Puzzle8State)) return false;
		Puzzle8State o = (Puzzle8State) obj;
		return Arrays.equals(this.sequence, o.sequence);
	}
}


public class Puzzle8_651544 {
	int size = 3;
	int[] sequence = new int[9];
	ArrayList<Puzzle8State> explored;
	Stack<Puzzle8State> dfs;
	//HashMap<Puzzle8State, Puzzle8State> tileMap;



	//Puzzle8_651544 game = new Puzzle8_651544(new int [] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
    public Puzzle8_651544(int[] input) {
        //this.sequence = sequence;
        explored = new ArrayList<>();
        dfs = new Stack<>();
        dfs.push(new Puzzle8State());
        dfs.peek().sequence = sequence;
        //tileMap = new HashMap<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<input.length; i+=3){
            int value = input[i];
            int position = input[i+1]*size + input[i+2];
            map.put(position,value);
        }
        for(int i=0; i<sequence.length; i++){
            sequence[i] = map.get(i);
        }
    }


	boolean isGoal(Puzzle8State state)
	{
		int[] goal = {1,2,3,4,5,6,7,8,9};
		return Arrays.equals(state.sequence, goal);
	}

	static ArrayList<Puzzle8State> getNextStates(Puzzle8State currentState) {
		ArrayList<Puzzle8State> nextStates = new ArrayList<>();
		int[] sequence = currentState.sequence;
		int size = (int) Math.sqrt(sequence.length);
		int zeroIndex = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == 0) {
				zeroIndex = i;
				break;
			}
		}
		int zeroRow = zeroIndex / size;
		int zeroCol = zeroIndex % size;
		if (zeroRow > 0) {
			int[] newSequence = sequence.clone();
			newSequence[zeroIndex] = newSequence[zeroIndex - size];
			newSequence[zeroIndex - size] = 9;
			Puzzle8State newState = new Puzzle8State();
			newState.sequence = newSequence;
			nextStates.add(newState);
		}
		if (zeroRow < size - 1) {
			int[] newSequence = sequence.clone();
			newSequence[zeroIndex] = newSequence[zeroIndex + size];
			newSequence[zeroIndex + size] = 9;
			Puzzle8State newState = new Puzzle8State();
			newState.sequence = newSequence;
			nextStates.add(newState);
		}
		if (zeroCol > 0) {
			int[] newSequence = sequence.clone();
			newSequence[zeroIndex] = newSequence[zeroIndex - 1];
			newSequence[zeroIndex - 1] = 9;
			Puzzle8State newState = new Puzzle8State();
			newState.sequence = newSequence;
			nextStates.add(newState);
		}
		if (zeroCol < size - 1) {
			int[] newSequence = sequence.clone();
			newSequence[zeroIndex] = newSequence[zeroIndex + 1];
			newSequence[zeroIndex + 1] = 9;
			Puzzle8State newState = new Puzzle8State();
			newState.sequence = newSequence;
			nextStates.add(newState);
		}

		return nextStates;
	}
	void nextMoveWithStack()
	{
		Puzzle8State currentState = dfs.pop();
		if (isGoal(currentState))
		{
			System.out.println("Goal state found!");
			return;
		}
		explored.add(currentState);
		ArrayList<Puzzle8State> nextStates = getNextStates(currentState);
		for (Puzzle8State state : nextStates)
		{
			if (!explored.contains(state))
			{
				dfs.push(state);
			}
		}
		nextMoveWithStack();
	}
	
		void displayBoard() {
			for (int i = 0; i < sequence.length; i++) {
				if (i % size == 0 && i != 0)
				{
					System.out.println();
				}
				if (sequence[i] != 9)
				{
					System.out.printf("%4d", sequence[i]);
				}
				else
				{
					System.out.printf("%4s", " ");
				}
			}
			System.out.println();
		}

		void generateNextMove() {
			Puzzle8State currentState = dfs.peek();
			ArrayList<Puzzle8State> nextStates = getNextStates(currentState);
			for (Puzzle8State state : nextStates) {
				if (!explored.contains(state)) {
					int zeroPosCurrent = getZeroPos(currentState.sequence);
					int zeroPosNext = getZeroPos(state.sequence);
					String direction = "";
					if (zeroPosCurrent - zeroPosNext == size) {
						direction = "pushing south";
					} else if (zeroPosCurrent - zeroPosNext == -1) {
						direction = "pushing east";
					}
					System.out.println(direction + " " + currentState.sequence[zeroPosNext] + " " + Arrays.toString(state.sequence));
				}
			}
		}
		
		
		int getZeroPos(int[] sequence) {
			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i] == 9) {
					return i;
				}
			}
			return -1;
		}

}

