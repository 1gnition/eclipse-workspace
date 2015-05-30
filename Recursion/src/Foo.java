
public class Foo {
	private Bar bar;

	public Foo(Bar bar) {
		super();
		this.bar = bar;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Foo [bar=" + bar + "]";
	}
	
	
}
