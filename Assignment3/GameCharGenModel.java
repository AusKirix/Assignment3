import java.util.Arrays;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}
	
	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
	}
	
	/**
	 * Returns a character at a given index
	 * @param idx Provided index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public int getLowestHPGameCharacter() throws NoGameCharacterFoundException { 

		int index = 0;
		int lowest = randomGameChars[index].hitPoints;
		
		try {

			if (gameCharCount == 0) {
				System.out.println("Make new characters before sorting");
				throw new NoGameCharacterFoundException("No characters created yet");
			}

			for (int x = 0; x < gameCharCount ; x++) {
				if (randomGameChars[x].hitPoints < lowest) {
					
					lowest = randomGameChars[x].hitPoints;
					index = x;
				}
			}
			randomGameChars[index].display();
			return index;
			

		} catch (NoGameCharacterFoundException e) {
			return -1;
		}
		
	}
	
	
	public void sortGameCharacterWisdom(boolean ascending) throws NoGameCharacterFoundException
	{
		
		try {
			if (gameCharCount == 0) {
				System.out.println("Make new characters before sorting");
				throw new NoGameCharacterFoundException("No characters created yet");
			}

		/*******************************************************************************************************************************
		 * Title: Sorting an object array using Insert and Selection sorts
		 * Author: lmiguelvargasf
		 * Date: 26 November 2016
		 * Availability: https://stackoverflow.com/questions/40819059/sorting-an-object-array-using-insert-and-selection-sorts
		 *******************************************************************************************************************************/
			if (ascending == true) {
				for (int x = 0; x < gameCharCount - 1; x++) {
					for (int y = x + 1; y < gameCharCount; y++) {
						if (randomGameChars[x].wisdom > randomGameChars[y].wisdom) {
							GameCharacter temp = randomGameChars[x];
							randomGameChars[x] = randomGameChars[y];
							randomGameChars[y] = temp;
						}
					}		
				}
				for (int x =0;x < gameCharCount; x++) {
					randomGameChars[x].display();
					System.out.println();
				}
			}	
			 
			else if (ascending == false) {
				for (int x = 0; x < gameCharCount - 1; x++) {
					for (int y = x + 1; y < gameCharCount; y++) {
						if (randomGameChars[x].wisdom < randomGameChars[y].wisdom) {
							GameCharacter temp = randomGameChars[x];
							randomGameChars[x] = randomGameChars[y];
							randomGameChars[y] = temp;
						}
					}
				}
				for (int x =0;x < gameCharCount; x++) {
					randomGameChars[x].display();
					System.out.println();
				}
			
			}
		}catch (NoGameCharacterFoundException e) {
			throw new NoGameCharacterFoundException("No characters created yet");
		}
	}

	public void showallcharacters() {

		for (int x =0; x < gameCharCount; x++) {
			randomGameChars[x].display();
			System.out.println();
		}
		
		
	}

}

