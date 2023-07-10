public class Dog {
	private String breed;
	private int magicValue;

	public Dog(String n)
	{
		breed = n;
		int v = 0;
		for (int i = 0; i < n.length(); i++)
		{
			v += n.charAt(i);
		}
		magicValue = v;
	}
	
	public String toString()
	{
		return breed + "(" + magicValue + ")";
	}

	public String getBreed(){
		return breed;
	}

	public int getMagicValue(){
		return magicValue;
	}

}
