public abstract class Tuple<T, S>
{
	final T t;
	final S s;
	
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
