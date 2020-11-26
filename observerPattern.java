Subject.java

public interface Subject
{
	public void removeObserver(Observer observer);
	public void registerObserver(Observer observer);
	public void notifyObserver();
}

Channel.java

public class Channel implements Subject
{
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void registerObserver(Observer observer)
	{
		observers.add(observer);
	}

	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}

	public void notifyObserver()
	{

		String test = "newContent";
		for (Observer o:observers)
		{
			o.update(test);
		}
	}  
}

Observer.java

public interface Observer
{
	public void update(String status);
}





Follower.java

public class Follower implements Observer {







}
