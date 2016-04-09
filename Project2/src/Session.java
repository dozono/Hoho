import java.util.Stack;

/**
 * Created by Hao on 4/1/2016.
 */
public class Session
{
	Stack<Pair> sessions = new Stack<>();

	public void start(String name)
	{
		Pair pair = new Pair(System.currentTimeMillis(), name);
		sessions.push(pair);
	}

	public void execute(Runnable runnable)
	{
		start(runnable.toString());
		runnable.run();
		end();
	}

	public void end()
	{
		Pair pop = sessions.pop();
		System.out.printf("spend %s on %s\n", System.currentTimeMillis() - pop.startTime, pop.name);
	}

	public void endStart(String name)
	{
		end();
		start(name);
	}

	private class Pair
	{
		public final long startTime;
		public final String name;

		private Pair(long startTime, String name)
		{
			this.startTime = startTime;
			this.name = name;
		}

	}
}
