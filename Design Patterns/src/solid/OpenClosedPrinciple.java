package solid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OCP - Open for extension but closed for modifications.As a result, when the
 * business requirements change then the entity can be extended, but not
 * modified.
 * 
 * @author Tarun Vishnoi
 *
 */
public class OpenClosedPrinciple {

	public static void main(String[] args) {
		ProductFilter productFilter = new ProductFilter();
		Product product1 = new Product("Laptop", "Black", "Big");
		Product product2 = new Product("Mobile", "Blue", "Medium");
		Product product3 = new Product("Laptop", "Grey", "Big");
		Product product4 = new Product("Monitor", "Black", "Small");
		List<Product> products = Arrays.asList(product1, product2, product3, product4);

		// OCP not compliant START

		System.out.println("OCP not compliant");

		productFilter.filterByColor(products, "Blue")
				.forEach(p -> System.out.println("filterByColor --> " + p.name + ": " + p.color + " : " + p.size));

		/*
		 * Filter requirements changed after the deployment
		 */
		productFilter.filterBySize(products, "Big")
				.forEach(p -> System.out.println("filterBySize --> " + p.name + ": " + p.color + " : " + p.size));
		productFilter.filterByColorAndSize(products, "Black", "Big").forEach(
				p -> System.out.println("filterBySizeAndColor --> " + p.name + ": " + p.color + " : " + p.size));

		// OCP not compliant END

		// OCP compliant Start

		System.out.println("OCP compliant");

		BetterFilter betterFilter = new BetterFilter();
		betterFilter.filter(products, new ColorSprecification("Black"))
				.forEach(p -> System.out.println("filterByColor --> " + p.name + ": " + p.color + " : " + p.size));

		betterFilter.filter(products, new SizeSprecification("Big"))
				.forEach(p -> System.out.println("filterBySize --> " + p.name + ": " + p.color + " : " + p.size));

		betterFilter.filter(products, new ColorAndSizeSprecification("Blue", "Small")).forEach(
				p -> System.out.println("filterByColorAndSize --> " + p.name + ": " + p.color + " : " + p.size));

		// OCP compliant END
	}
}

// OCP not compliant START

class Product {
	String name;
	String color;
	String size;

	public Product(String name, String color, String size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

}

class ProductFilter {
	public List<Product> filterByColor(List<Product> product, String color) {
		return product.stream().filter(p -> p.color.equals(color)).collect(Collectors.toList());
	}

	/*
	 * Filter requirements changed after the deployment (need to be closed for
	 * modification but not)
	 */

	public List<Product> filterBySize(List<Product> product, String size) {
		return product.stream().filter(p -> p.size.equals(size)).collect(Collectors.toList());
	}

	public List<Product> filterByColorAndSize(List<Product> product, String color, String size) {
		return product.stream().filter(p -> p.color.equals(color) && p.size.equals(size)).collect(Collectors.toList());
	}

}

//OCP not compliant END

//OCP compliant Start

interface Specification<T> {
	boolean isSatisfied(T product);
}

interface Filter<T> {
	public List<Product> filter(List<T> products, Specification<T> specification);

}

class ColorSprecification implements Specification<Product> {
	String color;

	public ColorSprecification(String color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.color.equals(color);
	}
}

class SizeSprecification implements Specification<Product> {
	String size;

	public SizeSprecification(String size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.size.equals(size);
	}
}

class ColorAndSizeSprecification implements Specification<Product> {
	String size;
	String color;

	public ColorAndSizeSprecification(String color, String size) {
		this.color = color;
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product product) {
		return product.color.equals(color) && product.size.equals(size);
	}
}

class BetterFilter implements Filter<Product> {

	@Override
	public List<Product> filter(List<Product> products, Specification<Product> specification) {
		return products.stream().filter(p -> specification.isSatisfied(p)).collect(Collectors.toList());
	}

}