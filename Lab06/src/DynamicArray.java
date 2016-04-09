/**
 * Created by Hao on 4/7/2016.
 */
public class DynamicArray<T>
{
	protected T[] data;
	protected int size;

	public DynamicArray()
	{
		data = newArr(16);
		size = 0;
	}

	public int size()
	{
		return size;
	}

	public boolean empty()
	{
		return size == 0;
	}

	protected void checkIndex(int i) throws IndexOutOfBoundsException
	{
		if (i >= size || i < 0)
			throw new IndexOutOfBoundsException("i: " + i + ", size: " + size);
	}

	public T get(int i) throws IndexOutOfBoundsException
	{
		checkIndex(i);
		return data[i];
	}

	public void set(int i, T v) throws IndexOutOfBoundsException
	{
		checkIndex(i);
		data[i] = v;
	}

	public void add(int i, T v) throws IndexOutOfBoundsException
	{
		checkIndex(i);
		if (size == data.length)
			increaseCapacity();
		for (int j = size; j > i; j--)
			data[j] = data[j - 1];
		data[i] = v;
		size++;
	}

	protected void increaseCapacity()
	{
		T[] newData = newArr(2 * data.length);

		for (int i = 0; i < size; i++)
		{

			newData[i] = data[i];

		}

		data = newData;


	}

	@SuppressWarnings("unchecked")
	protected T[] newArr(int size)
	{
		return (T[]) (new Object[size]);
	}

	public T remove(int i) throws IndexOutOfBoundsException
	{
		checkIndex(i);
		T ret = data[i];
		for (int j = i + 1; j < size; j++)
			data[j - 1] = data[j];
		data[size - 1] = null;
		size--;
		return ret;
	}
}
