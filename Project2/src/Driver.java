/**
 * Created by Hao on 4/8/2016.
 */
public class Driver
{
	public static void main(String[] args)
	{

		FindTest a = new FindTest();
		a.addToTest(new FindTest.Algorithm()
		{
			@Override
			public String toString()
			{
				return "linear";
			}

			@Override
			public boolean find(int[] a, int x)
			{
				boolean positive = false, negative = false;
				for (int i = 0; i < a.length; i++)
				{
					int next = a[i];
					if (next < 0 && next == -x)
					{
						negative = true;
						if (positive)
							return true;
					}
					else if (next > 0 && next == x)
					{
						positive = true;
						if (negative)
							return true;
					}
				}
				return false;
			}
		}).addToTest(new FindTest.Algorithm()
		{
			@Override
			public String toString()
			{
				return "binary";
			}

			@Override
			public boolean find(int[] a, int i)
			{
				return binary(a, i) && binary(a, -i);
			}

			private boolean binary(int[] a, int x)
			{
				int left = 0;
				int right = a.length - 1;
				int mid;
				while (left < right)
				{
					mid = left + (right - left) / 2;
					if (a[mid] == x)
						return true;
					else if (x < a[mid])
						right = mid - 1;
					else
						left = mid + 1;

				}
				return false;
			}
		}).addToTest(new FindTest.Algorithm()
		{
			public String toString()
			{
				return "two way search";
			}

			@Override
			public boolean find(int[] a, int x)
			{
				int temp1 = 0;
				int temp2 = a.length - 1;
				int left = a[temp1];
				int right = a[temp2];
				int sum = left + right;
				while (left < 0)
				{
					if (sum == 0)
						if (right == x || left == x)
							return true;
						else {left = a[++temp1]; right = a[--temp2]; sum = left + right;}
					if (sum < 0)
						left = a[++temp1];
					if (sum > 0)
						right = a[--temp2];
					sum = left + right;

				}
				return false;
			}
		});
		for (int i = 1; i < 5; i++)
			a.testFor(50000 * (int) Math.pow(2, i));
	}
}
