import java.util.Scanner;

public class GameCharGen 
{
	
	public static void main(String[] args)  throws NoGameCharacterFoundException
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);
		String option;	

		// if the input isn't ex then the menu will keep looping
		do {
			System.out.println("*** WoK GameCharGen Menu***");
			System.out.printf("Create Wizard \t \t WZ" + "%nCreate Fighter \t \t FG" + "%nCreate Cleric \t \t CL" + "%nLowest HP Character  \t LHC" +
						      "%nSort Characters Asc.  \t SCA" + "%nSort Characters Desc.  \t SCD" + "%nDisplay Characters  \t DC" + "%nExit Program \t \t EX" + "%nEnter selection: ");
			option = menuInput.nextLine().toUpperCase();
			System.out.println();
			
			if (option.equals("WZ")) {
				Wizard myWizard = new Wizard();

				myWizard.randGen(true);
				myWizard.display();
				myCharGen.addGameCharacter(myWizard);
				System.out.println("Number of character: " + myCharGen.getNumCharacters());
				System.out.println();

			}
			else if (option.equals("FG")) {
				Fighter myFighter = new Fighter();

				myFighter.randGen(false);
				myFighter.display();
				myCharGen.addGameCharacter(myFighter);
				System.out.println("Number of character: " + myCharGen.getNumCharacters());
				System.out.println();
			}
			else if (option.equals("CL")) {
				Cleric myCleric = new Cleric();

				myCleric.randGen(true);
				myCleric.display();
				myCharGen.addGameCharacter(myCleric);
				System.out.println("Number of character: " + myCharGen.getNumCharacters());
				System.out.println();

			}
			else if (option.equals("LHC")) {

				System.out.println("Game Character at index " + myCharGen.getLowestHPGameCharacter() +" Has the lowest HP");
				System.out.println();
			}
			else if (option.equals("SCA")) {
				myCharGen.sortGameCharacterWisdom(true);
				System.out.println("Characters are sorted in ascending order in terms of Wisdom, if you pick 'DC' the list will be appear as last sorted option");
			}
			else if (option.equals("SCD")) {
				myCharGen.sortGameCharacterWisdom(false);
				System.out.println("Characters are sorted in decending order in terms of Wisdom, if you pick 'DC' the list will be appear as last sorted option");
			}
			else if (option.equals("DC")) {

				myCharGen.showallcharacters();
			}
			else if (!option.equals("WZ")&& !option.equals("FG")&& !option.equals("CL")&& !option.equals("LHC")&& !option.equals("SCA")&& !option.equals("SCD")&& !option.equals("DC") && !option.equals("EX")) {
				System.out.println("Unrecognised command.");
				System.out.println();
			}

		} while (!option.equals("EX")); 
			
		menuInput.close();
		System.out.println("***************");
		System.out.println("Quitting now...");
		System.out.println("***************");
		System.exit(0);
	}

}
