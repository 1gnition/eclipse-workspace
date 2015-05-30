package orip;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import orip.generated.Root;

import com.sun.xml.bind.api.JAXBRIContext;

public class Main {
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream("src\\main\\resources\\foo.xml");
		JAXBContext jc = JAXBRIContext.newInstance("orip.generated");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Root root = (Root) unmarshaller.unmarshal(is);
		System.out.println(root.getFoo());
		System.out.println(root.getBar());
		
	}
}
