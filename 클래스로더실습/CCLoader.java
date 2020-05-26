import java.util.Scanner;

public class CCLoader extends ClassLoader {
	
	public CCLoader(ClassLoader classLoader) {
		super(classLoader);
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		
		System.out.println("Loading Class \"" + name + "\"");
		return super.loadClass(name);
	}
}
