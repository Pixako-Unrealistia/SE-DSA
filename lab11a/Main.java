import java.util.ArrayList;

public class Main {
    final static int inf = Integer.MAX_VALUE;
    public static void main(String[] args) {
        q2();
    }

    static void q2() {
        // A B C D E
        int[][] thisGraph = {
            {0, 3, inf, inf, 2}, 
            {3, 0, 1, inf, inf}, 
            {inf, 1, 0, 4, inf}, 
            {inf, inf, 4, 0, 5}, 
            {2, inf, inf, 5, 0}
        };  
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }

	private static void q2_dfs(int[][] thisGraph) {
		ArrayList<Integer> stack = new ArrayList<>();
		ArrayList<Integer> visited = new ArrayList<>();
		stack.add(0); // root is at A
		while (notEmpty(stack)) {
			int parent = stack.remove(stack.size() -1);
			// if (!visited.contains(parent)) {
				visited.add(parent);
				for (int x = 0; x < thisGraph.length; x++) {
					if (thisGraph[parent][x] < inf && !visited.contains(x) && 0 < thisGraph[parent][x]) {
						stack.add(x);
						visited.add(x);
						System.out.println("Edge " + parent + ", " + x);
					}
				} 
			// }
		}
	}
    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }
}
