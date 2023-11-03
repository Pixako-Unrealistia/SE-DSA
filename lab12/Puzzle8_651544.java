import java.util.*;

class Puzzle8State {
    private int score;
    public int[] sequence;

    public Puzzle8State(int[] sequence) {
        this.score = 0;
        this.sequence = sequence;
    }

    public void displayBoard() {

        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]);
            if (i % 3 == 2) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Puzzle8State)) return false;
        Puzzle8State otherState = (Puzzle8State) obj;
        return Arrays.equals(sequence, otherState.sequence);
    }

    @Override
    public String toString() {
        return Arrays.toString(sequence);
    }

    public int[] getSequence() {
        return Arrays.copyOf(sequence, sequence.length);
    }
}

class Puzzle8_651544 {
    private int size = 3;
    private int[] sequence = new int[size * size];
    public ArrayList<Puzzle8State> explored = new ArrayList<>();
    private Stack<Puzzle8State> dfs = new Stack<>();
    public Puzzle8_651544(int[] sequence) {
        this.sequence = oneDBoard(sequence);
    }
	public int[] swap(int[] sequence, int number1, int number2) {
		int[] newSequence = sequence.clone();
		int number1Index = 0;
		int number2Index = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == number1) {
				number1Index = i;
			}
			if (sequence[i] == number2) {
				number2Index = i;
			}
		}
		newSequence[number1Index] = number2;
		newSequence[number2Index] = number1;
		return newSequence;
	}
	
	private int findBlankIndex() {
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] == 9) {
				return i;
			}
		}
		return -1;
	}
	
	private void tryMove(int targetIndex, String direction) {
		if(targetIndex >= 0 && targetIndex < sequence.length) {
			int targetNumber = sequence[targetIndex];
			int[] newSequence = swap(sequence, 9, targetNumber);
			Puzzle8State newState = new Puzzle8State(newSequence);
			if (!explored.contains(newState)) {
				System.out.println("Pushing " + direction + " " + targetNumber + " " + Arrays.toString(newSequence));
				dfs.push(newState);
			}
		}
	}
	
	private void tryMoveDown() {
		int blankIndex = findBlankIndex();
		tryMove(blankIndex + 3, "South");
	}
	
	private void tryMoveUp(){
		int blankIndex = findBlankIndex();
		tryMove(blankIndex - 3, "North");
	}
	
	private void tryMoveEast(){
		int blankIndex = findBlankIndex();
		if(blankIndex % 3 < 2) {
			tryMove(blankIndex + 1, "East");
		}
	}
	
	private void tryMoveWest(){
		int blankIndex = findBlankIndex();
		if(blankIndex % 3 > 0) {
			tryMove(blankIndex - 1, "West");
		}
	}
	
    public void generateNextMove() {
        tryMoveEast();
        tryMoveWest();
        tryMoveUp();
        tryMoveDown();

    }

    public void displayBoard() {
        for (int i = 0; i < sequence.length; i++)
		{
			
            if (sequence[i] == 9) {
                System.out.print("  ");
            } else {
                System.out.print(sequence[i] + " ");
            }
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


    public int[] oneDBoard(int[] sequence) {
        int[] board = new int[size * size];
        for (int i = 0; i < sequence.length; i=i+3) {
            int number = sequence[i];
            int row = sequence[i+1];
            int column = sequence[i+2];
            board[row * size + column] = number;
        }
        return board;
    }




    public void nextMoveWithStack() {
        generateNextMove();
        if (dfs.isEmpty()) {
            System.out.println("No more moves");
            return;
        }

        while (!dfs.isEmpty()) {
            Puzzle8State state = dfs.pop();
            sequence = state.sequence;
            if (isGoal(sequence)) {
                System.out.println("Goal reached");
                return;
            }
            explored.add(state);
            generateNextMove();
            displayBoard();
        }


    }

    public boolean isGoal(int[] seq) {
        int[] goal = new int[] {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < seq.length; i++) {
            if(seq[i] != goal[i]) {
                return false;
            }
        }
        return true;
    }
}
