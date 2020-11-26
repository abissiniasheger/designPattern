CoffeeMachineInterface.java

public interface CoffeeMachineInterface 
{
	public void chooseFirstSelection();
	public void chooseSecondSelection();
}


OldCoffeeMachine.java

public class OldCoffeeMachine
{

	public void selectionA()
	{
		System.out.println("Coffee A");
	}

	public void selectionB()
	{
		System.out.println("Coffee B");
	}

}


CoffeeTouchscreenAdapter.java

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface 
{
	OldCoffeeMachine oldCoffee;
	
	public CoffeeTouchscreenAdapter(OldCoffeeMachine oldCoffee)
	{
		this.oldCoffee = oldCoffee;
	}

	public void chooseFirstSelection()
	{
		oldCoffee.selectionA();
	}	

	public void chooseSecondSelection()
	{
		oldCoffee.selectionB();
	}	

}
