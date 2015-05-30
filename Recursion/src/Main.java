import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception {
		List<String> innerList1 = new ArrayList<>();
		innerList1.add("1");
		innerList1.add("2");
		innerList1.add("3");

		List<String> innerList2 = new ArrayList<>();
		innerList2.add("a");
		innerList2.add("b");
		innerList2.add("c");
		
		List<List<String>> list1 = new ArrayList<List<String>>();
		list1.add(innerList1);
		list1.add(innerList2);
		
		List<List<Bar>> list2 = new ArrayList<List<Bar>>();
		
		List<Bar> innerList11 = new ArrayList<Bar>();
		innerList11.add(new Bar("1"));
		innerList11.add(new Bar("2"));
		innerList11.add(new Bar("3"));

		List<Bar> innerList12 = new ArrayList<Bar>();
		innerList12.add(new Bar("a"));
		innerList12.add(new Bar("b"));
		innerList12.add(new Bar("c"));
		
		list2.add(innerList11);
		list2.add(innerList12);
		
		List<List<Foo>> list3 = new ArrayList<List<Foo>>();
		
		List<Foo> innerList21 = new ArrayList<Foo>();
		innerList21.add(new Foo(new Bar("1")));
		innerList21.add(new Foo(new Bar("2")));
		innerList21.add(new Foo(new Bar("3")));

		List<Foo> innerList22 = new ArrayList<Foo>();
		innerList22.add(new Foo(new Bar("a")));
		innerList22.add(new Foo(new Bar("b")));
		innerList22.add(new Foo(new Bar("c")));
		
		list3.add(innerList21);
		list3.add(innerList22);
		
//		System.out.println(list1);
//		System.out.println(list2);
//		System.out.println(list3);
		
		
		recurse(list1, toStack("[].[]"));
		System.out.println("----------");
		recurse(list2, toStack("[].[].str"));
		System.out.println("----------");
		recurse(list3, toStack("[].[].bar.str"));
		System.out.println("----------");
		Foo foo = new Foo(new Bar("hi"));
		recurse(foo, toStack("bar.str"));
		System.out.println("----------");
		Baz baz = new Baz(new Goo(list3));
		recurse(baz, toStack("goo.baw.[].[].bar.str"));
		System.out.println("----------");
		Doo doo = new Doo(new Roo(innerList11));
		recurse(doo, toStack("roo.gaw.[].str"));
		System.out.println("----------");
		Noo noo = new Noo(new Moo(innerList1));
		recurse(noo, toStack("moo.yoo.[]"));
		
	}
	
	private static Object getField(Object obj, String fieldName) throws Exception {
		Class<?> clazz = obj.getClass();
		String getField = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		Method method = clazz.getMethod(getField);
		Object field = method.invoke(obj);
		return field;
	}
	

	private static ArrayDeque<String> toStack(String path) {
		String[] parts = path.split("\\.");
		ArrayDeque<String> stack = new ArrayDeque<String>(Arrays.asList(parts));
		return stack;
	}
	
	private static void recurse(Object obj, ArrayDeque<String> stack) throws Exception {
		if (stack.isEmpty()) {
			System.out.println((String) obj);
			return;
		}
		
		ArrayDeque<String> stack2 = stack.clone();
		
		String fieldName = stack2.pop();
		
		if (fieldName.equals("[]")) {
			for (Object item : (List<?>) obj) {
				recurse(item, stack2);
			}
		} else {
			obj = getField(obj, fieldName);
			recurse(obj, stack2);
		}
	}
}
