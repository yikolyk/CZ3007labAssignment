package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;

public class ParserTests {
	private void runtest(String src) {
		runtest(src, true);
	}

	private void runtest(String src, boolean succeed) {
		Parser parser = new Parser();
		try {
			parser.parse(new Lexer(new StringReader(src)));
			if(!succeed) {
				fail("Test was supposed to fail, but succeeded");
			}
		} catch (beaver.Parser.Exception e) {
			if(succeed) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testEmptyModule() {
		runtest("module Test { }");
		
		runtest("module Test { " 
				+ " import CZ3007;"
				+ " abc [][][] arrTest;"
				+ " int Deposit;"
				+ " public type id = \"abc\";"
				+ " public int calculateDeposit(int hours, boolean a){"
				+ " 	return arrTest = \"aaa\";"
				+ "	}"
				+ " public boolean isStudent(abc a){"
				+ " 	Student a;"
				+ " 	{"
				+ "			break;"	
				+ "			return;"
				+ "		}"
				+ " 	1;"
				+ "		break;"
				+ "		while(1){"
				+ "			break;"
				+ " 	}"
				+ "		if(1 < a){"
				+ "			break;"
				+ " 	}else{"
				+ "			return;"
				+ "		}"	
				+ " 	return -arrTest(arr[3] = \"bbb\",24) * 3 + 24 <= 25;"
				+ "	}"
				+ "}" );
	}
	
	@Test
	public void testImports()
	{
		runtest("module test { import jkfdshjkfdh; import haha;}");
		runtest("module test { import jkfdshjkfdh; import haha; }");
		// runtest("int a;"); // must enclosed in module
		runtest("module test { int a; }");
		// runtest("module test {  a=1; }");
		// runtest("module test {  a(1, 2); }");
		runtest("module test {public int function_name() { } }");
		runtest("module test {public int function_name() { } }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw() { } }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw(int cw) {int cw2; } }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw(int cw, cw cw1) {int cw2; } }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw(int cw, cw cw1) {int cw2; } public int[] cw2;  public type cw3 = \"hello world\"; }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw(int cw, cw cw1) {int cw2; if(cw2= 1*2) cw = 2;else while(cw = 2) cw = cw+1; } }");
		runtest("module test { import jkfdshjkfdh; import haha; public int cw(int cw, cw cw1) {int cw2; if(cw2= 1*2) cw = 2;else while(cw = 2) cw = cw+1; } }");	
		
		runtest("module test {	public void runtest(string src) { runtest(src, true); } }");
		runtest("module test {	public void runtest(string src) { int[] a;  a[1] = 1;} }"); // refer to LhsExpression 
		runtest("module test { import java; public int Num1; public int Num2; public void count(){int A = Num1;int B = Num2; while(sub(A,B)){A=A-1;}}public int sub(int num1, int num2){if(num1>num2){return 1;}else{return 0;}}}", false);
		
	}
	
	

}
