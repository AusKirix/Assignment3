public class Wizard extends GameCharacter 
{
	private static int WIZARD_MAX_HP = 6; 
	
	public Wizard()
	{
		super.CHAR_MAX_HP = WIZARD_MAX_HP;		
	}

	@Override
	public void randGen(boolean areHitPointsMaxed) 
	{	
		// HitPoints
		if (areHitPointsMaxed)
			this.hitPoints = WIZARD_MAX_HP;
		else
			hitPoints = rollDice(WIZARD_MAX_HP);
		
		// STR, INT, WIS
		strength = rollDice(6) + rollDice(6) + rollDice(6);
		intelligence = rollDice(6) + rollDice(6) + rollDice(6) +1;
		wisdom = rollDice(6) + rollDice(6) + rollDice(6);
		
		int i,j;
		i = rollDice(GameCharacter.howManyNames)-1;
		j = rollDice(GameCharacter.howManyNames)-1;
		name = randomNames[i][j];
	}
	
	@Override
	public void display()
	{
		System.out.println("Class:"+ "\t \t"+"Wizard");
		super.display();
	}

}
