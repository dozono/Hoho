import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Hao on 4/8/2016.
 */
public class FindTest
{
	private LinkedList<Algorithm> list = new LinkedList<>();
	private Session session = new Session();

	interface Algorithm
	{
		boolean find(int[] a, int i);
	}

	public void testFor(int size)
	{
		Random r = new Random();
		int[] a = new int[size];
		for (int i = 0; i < size / 2; i++)
			a[i] = r.nextInt(32);
		for (int j = size / 2; j < size; j++)
			a[j] = -r.nextInt(32);
		Arrays.sort(a);
		for (Algorithm algorithm : list)
		{
			session.start(algorithm.toString() + " with " + size);
			System.out.println(algorithm.find(a, r.nextInt(32)));
			session.end();
		}
	}

	public FindTest addToTest(Algorithm algorithm)
	{
		list.add(algorithm);
		return this;
	}
}
