import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main
{
	static void demo1()
	{
	Puzzle8_651544 game = new Puzzle8_651544(new int [] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
	game.displayBoard();
	}

	static void demo2()
	{
		Puzzle8_651544 game = new Puzzle8_651544(new int [] {9,0,0,1,0,1,3,0,2,4,1,0,2,1,1,5,1,2,7,2,0,8,2,1,6,2,2});
		game.generateNextMove();
	}

	public static void main(String[] args)
	{
		demo1();
		demo2();
	}

	
}

