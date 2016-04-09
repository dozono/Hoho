/**
 * Created by Hao on 4/7/2016.
 */
public class DynamicArrayArithmetic<T> extends DynamicArray<T>
{
	public DynamicArrayArithmetic()
	{
		super();
	}

	@Override
	public void increaseCapacity()
	{
		T[] newData = newArr(this.size + 10000);
		System.arraycopy(this.data, 0, newData, 0, size);
		data = newData;
	}


}
