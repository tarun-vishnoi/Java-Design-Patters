package solid;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * SRP - A class should only have one responsibility
 * 
 * @author Tarun Vishnoi
 *
 */

public class SingleResponsibilityPrinciple {

	public static void main(String[] args) throws IOException {
		Book book = new Book();
		book.addBook("Rich Dad Poor Dad");
		book.addBook("Deep Work");
		System.out.println(book);
		Persitance persitance = new Persitance();
		String filename = "E:\\books";
		persitance.save(book, filename);
		Runtime.getRuntime().exec("notepad.exe " + filename);
	}
}

class Book {
	private List<String> books = new ArrayList<String>();
	private static int count = 0;

	public void addBook(String book) {
		books.add((++count) + " : " + book);
	}

	public void remove(int index) {
		books.remove(index);
	}

	@Override
	public String toString() {
		return "Book [books=" + books + "]";
	}

	// Below code breaks the purpose of SRP, Hence moving it to new class
	/*
	 * public void save(String filename) { try (PrintStream stream = new
	 * PrintStream(filename)) { stream.println(toString()); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * public void loadBooks() { }
	 */
}

class Persitance {

	public void save(Book book, String filename) {
		try (PrintStream stream = new PrintStream(filename)) {
			stream.println(book.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadBooks() {
	}
}