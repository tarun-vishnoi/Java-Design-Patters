package solid;

import java.util.Arrays;
import java.util.List;

/**
 * DIP - The principle of Dependency Inversion refers to the decoupling of
 * software modules.
 * 
 * This way, instead of high-level modules depending on low-level modules, both
 * will depend on abstractions.
 * 
 * Abstraction should not depend on details. Details should depend on
 * abstraction.
 * 
 * @author Tarun Vishnoi
 *
 */
public class DependencyInversionPrinciple {
	public static void main(String[] args) {
		Developer developer1 = new BackendDeveloper();
		Developer developer2 = new FrontendDeveloper();
		List<Developer> developers = Arrays.asList(developer1, developer2);
		BetterProject betterProject = new BetterProject(developers);
		betterProject.implement();
	}
}

//Dependency Inversion Non Compliant

class JavaDeveloper {
	public void writeJavaCode() {
		System.out.println("java");
	}
}

class PythonDeveloper {
	public void writePythonCode() {
		System.out.println("python");
	}
}

class JavaScriptDeveloper {
	public void writeJavaScriptCode() {
		System.out.println("javascript");
	}
}

// Hard Coupled Project Implementation

class Project {
	private JavaDeveloper javaDeveloper = new JavaDeveloper();
	private PythonDeveloper pythonDeveloper = new PythonDeveloper();
	private JavaScriptDeveloper javaScriptDeveloper = new JavaScriptDeveloper();

	public void implement() {
		javaDeveloper.writeJavaCode();
		pythonDeveloper.writePythonCode();
		javaScriptDeveloper.writeJavaScriptCode();
	}
}

//Dependency Inversion Compliant

interface Developer {
	public void develop();
}

class BackendDeveloper implements Developer {

	@Override
	public void develop() {
		writeBackendCode();
	}

	private void writeBackendCode() {
		System.out.println("backend");
	}
}

class FrontendDeveloper implements Developer {

	@Override
	public void develop() {
		writeFrontendCode();
	}

	private void writeFrontendCode() {
		System.out.println("frontend");
	}
}

// Loosely coupled Project Implementation

class BetterProject {
	List<Developer> developers;

	public BetterProject(List<Developer> developers) {
		this.developers = developers;
	}

	public void implement() {
		developers.forEach(dev -> dev.develop());
	}
}