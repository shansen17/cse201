
public class Tuple<T, S>
{
	T t;
	S s;
	
	public Tuple(T t, S s)
	{
		this.t = t;
		this.s = s;
	}
	
	public T first()
	{
		return t;
	}
	
	public S second()
	{
		return s;
	}
}
