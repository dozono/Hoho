/**
 * Created by Hao on 4/5/2016.
 */

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;


import edu.princeton.cs.introcs.StdDraw;

public class StackTurtle
{

	private Point currentPosition;
	private double angle;

	public StackTurtle(Point startingPosition)
	{
		currentPosition = startingPosition;
		angle = 90;
	}

	public void moveForward(double distance)
	{
		Point newPosition = new Point((int) (currentPosition.x +
				distance * Math.cos(Math.toRadians(angle))),
				(int) (currentPosition.y +
						distance * Math.sin(Math.toRadians(angle))));
		StdDraw.line(currentPosition.x, currentPosition.y, newPosition.x,
				newPosition.y);
		currentPosition = newPosition;
	}

	public void rotate(double degrees)
	{
		angle += degrees;
	}

	private ArrayList pos = new ArrayList();
	int size = 0;

	public void pushCurrentPosition()
	{

		pos.add(size, currentPosition);
		size++;

	}

	public void popCurrentPosition() throws ArrayIndexOutOfBoundsException
	{
		try{
			System.out.println(pos.remove(size-1));
			size--;
		}catch(ArrayIndexOutOfBoundsException e){
			e.getMessage();
		}
	}

}
