
public class Bar {
	private String str;

	public Bar(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Bar [str=" + str + "]";
	}
	
}
