package solid;

/**
 * ISP - larger interfaces should be split into smaller ones. By doing so, we
 * can ensure that implementing classes only need to be concerned about the
 * methods that are of interest to them.
 * 
 * @author Tarun Vishnoi
 *
 */
public class InterfaceSegregationPrinciple {

}

// Interface Segregation Non Compliant
class Document {
}

interface Machine {
	void print(Document document);

	void fax(Document document);

	void scan(Document document);
}

class MultiFunctionPrinter implements Machine {

	@Override
	public void print(Document document) {
		// Relevant
	}

	@Override
	public void fax(Document document) {
		// Relevant
	}

	@Override
	public void scan(Document document) {
		// Relevant
	}
}

class OldFashionedPrinter implements Machine {

	@Override
	public void print(Document document) {
		// Relevant
	}

	@Override
	public void fax(Document document) {
		// Non Relevant (But end user has the access to these messages and it will
		// create some problem to client)
	}

	@Override
	public void scan(Document document) {
		// Non Relevant (But end user has the access to these messages and it will
		// create some problem to client)
	}
}

//Interface Segregation Compliant

interface Printer {
	public void print(Document document);
}

interface Scanner {
	public void scan(Document document);
}

class JustPrinter implements Printer {

	@Override
	public void print(Document document) {
		// Relevant
	}
}

class XeroxMachine implements Printer, Scanner {

	@Override
	public void scan(Document document) {
		// Relevant
	}

	@Override
	public void print(Document document) {
		// Relevant
	}

}