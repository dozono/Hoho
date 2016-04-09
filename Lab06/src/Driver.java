/**
 * Created by Hao on 4/7/2016.
 */
public class Driver
{
	public static void main(String[] args){
		DynamicArrayArithmetic<Integer> da = new DynamicArrayArithmetic<>();
		//System.arraycopy(da,0,da.data,0,da.size);
		for(int i=0;i<50;i++)
			da.add(0,5);
		for(int i=0;i<da.size;i++){
			System.out.println(da.get(i));
		}


	}
}
