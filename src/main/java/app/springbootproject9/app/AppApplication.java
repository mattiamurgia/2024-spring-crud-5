package app.springbootproject9.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.springbootproject9.app.Customer.Pojo.Customer;
import app.springbootproject9.app.Customer.ServiceCustomer.ServiceCustomer;
import app.springbootproject9.app.Order.Pojo.Order;
import app.springbootproject9.app.Order.ServiceOrder.ServiceOrder;
import app.springbootproject9.app.Product.Pojo.Product;
import app.springbootproject9.app.Product.ServiceProduct.ServiceProduct;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	private ServiceCustomer serviceCustomer;

	@Autowired
	private ServiceProduct serviceProduct;

	@Autowired
	private ServiceOrder serviceOrder;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		System.out.println("Start Running ------> ");

		test01SaveAndCreate();
		// test02FindAndDelete();
		// test03UpdateProduct();
		System.out.println("<-------- Finish Running");
		
	}

	public void test01SaveAndCreate() {

		Customer c1 = new Customer("Mattia", "Murgia", "ma@gmail.com", "0987665");
		Customer c2 = new Customer("Marco", "Rossi", "rossi@rossi.com", "251512");
		Customer c3 = new Customer("Gaetano", "Mackck", "juig@hnb.com", "6548943");

		serviceCustomer.saveCustomer(c1);
		serviceCustomer.saveCustomer(c2);
		serviceCustomer.saveCustomer(c3);

		System.out.println("\nCustomer dal DB");
		serviceCustomer.findAllCustomer().forEach(System.out::println);

		Product p1 = new Product("T-Shirt", 29, 22);
		Product p2 = new Product("Jeans", 100, 4);
		Product p3 = new Product("Cappello", 50, 22);
		Product p4 = new Product("Pantalone", 20, 5);
		Product p5 = new Product("Borsa", 10, 22);

		serviceProduct.saveProduct(p1);
		serviceProduct.saveProduct(p2);
		serviceProduct.saveProduct(p3);
		serviceProduct.saveProduct(p4);
		serviceProduct.saveProduct(p5);

		System.out.println("\nProdotti dal DB");
		serviceProduct.findAllProduct().forEach(System.out::println);

		Order o1 = new Order(c1, Arrays.asList(p1, p2, p3));
		Order o2 = new Order(c2, Arrays.asList(p4, p5));

		serviceOrder.saveOrder(o1);
		serviceOrder.saveOrder(o2);

		System.out.println("\nOrdini dal DB");
		serviceOrder.findAllOrder().forEach(System.out::println);

		System.out.println("\nProduct Get Full Price");
		System.out.println("P1 con IVA: " + p1.getFullPrice(true));
		System.out.println("P1 senza IVA: " + p1.getFullPrice(false));

		System.out.println("\nOrder Get Full Price");
		System.out.println("O1 con IVA: " + o1.getFullPrice(true));
		System.out.println("O1 senza IVA: " + o1.getFullPrice(false));

	}

	public void test02FindAndDelete() {

		Customer c4 = new Customer("Filippo", "Bianchi", "bia@gmail.com", "2655");
		Product p6 = new Product("Camicia", 80, 10);

		serviceCustomer.saveCustomer(c4);
		serviceProduct.saveProduct(p6);

		// System.out.println("\nCustomer per ID 1");
		// System.out.println("Prodotto trovato: " +
		// serviceCustomer.findByIdCustomer(1).get());

		// System.out.println("\nProdotto per ID 1");
		// System.out.println("Prodotto trovato: " +
		// serviceProduct.findByIdProduct(1).get());

		// System.out.println();
		// serviceCustomer.deleteCustomer(c4);
		// serviceCustomer.findAllCustomer().forEach(System.out::println);

		// System.out.println();
		// serviceProduct.deleteProduct(p6);
		// serviceProduct.findAllProduct().forEach(System.out::println);
	}

	public void test03UpdateProduct() {

		try {

			Product p7 = new Product("SOSTITUZIONE", 0000, 0000);
			serviceProduct.updateProduct(1, p7);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
