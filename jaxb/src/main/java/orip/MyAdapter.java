package orip;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.w3c.dom.Element;

public class MyAdapter extends XmlAdapter<Element, String> {

	@Override
	public Element marshal(String arg0) throws Exception {
		return null;
	}

	@Override
	public String unmarshal(Element arg0) throws Exception {
		return "23432432423";
	}

}
