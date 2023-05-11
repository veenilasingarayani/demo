package mavenprojects.newtestng;

	import org.testng.annotations.Test;

	public class TestNGGrouping {

	@Test(groups= {"sanity"})
	public void test1()
	{
	System.out.println("Test Case 1");
	}
	@Test(groups= {"sanity","smoke"})
	public void test2()
	{
	System.out.println("Test Case 2");
	}
	@Test(groups= {"sanity","regression"})
	public void test3()
	{
	System.out.println("Test Case 3");
	}
	@Test(groups= {"regression"})
	public void test4()
	{
	System.out.println("Test Case 4");
	}

	}

