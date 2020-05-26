import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Practice18 extends ClassLoader{
	
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Scanner scan = new Scanner(System.in);
		ClassLoader parent = Practice18.class.getClassLoader();
		CCLoader ccl = new CCLoader(parent);
		
		System.out.print("사용자 아이디 : ");
		String userId = scan.next();
		System.out.print("비번 : ");
		String password = scan.next();
		
		if (userId.equals("dongduk") && password.equals("1234")) {
			Class<?> targetClass = ccl.loadClass("HelloWorld");
			Class<?> param = (new String[0]).getClass();
			Class<?> mainArgType[] = {param};   
			Method main = targetClass.getMethod("main",  mainArgType); 
			String[] actualArg = new String[0];
			Object[] argsArray = {actualArg};
			
			main.invoke(null, argsArray);
		}
	}
}
