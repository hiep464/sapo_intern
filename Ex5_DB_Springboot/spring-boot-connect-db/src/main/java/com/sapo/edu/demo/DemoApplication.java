package com.sapo.edu.demo;

import com.sapo.edu.Configs;
import com.sapo.edu.dao.CategoryDao;
import com.sapo.edu.dao.InventoryDao;
import com.sapo.edu.dao.ProductDao;
import com.sapo.edu.entities.Category;
import com.sapo.edu.entities.Inventory;
import com.sapo.edu.entities.Product;
import com.sapo.edu.repository.CategoryRepository;
import com.sapo.edu.repository.InventoryRepository;
import com.sapo.edu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication()
@EntityScan("com.sapo.edu.entities")
@EnableJpaRepositories("com.sapo.edu.repository")
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	InventoryDao inventoryDao = new InventoryDao();
	CategoryDao categoryDao = new CategoryDao();
	ProductDao productDao = new ProductDao();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true){
			printMenu();
			int choose = userRequest();
			handleUserRequest(choose);
		}
	}

	public void printMenu(){
		System.out.println("----------MENU-----------");
		System.out.println("1. JDBC");
		System.out.println("2. JPA");
		System.out.println("3. Exit");
		System.out.println("-------------------------");
	}

	public int userRequest(){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Your choose: ");
		String choose = null;
		if (scanner.hasNext()) {
			choose = scanner.nextLine();
		}
		return Integer.parseInt(choose);
	};

	public void handleUserRequest(int choose){
		switch (choose){
			case 1:
				menu();
				int data = userRequest();
				handleJbdc(data);
				break;
			case 2:
				printJpa();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid choose");
				break;
		}
	}

	public void menu(){
		System.out.println("1. print");
		System.out.println("2. insert");
		System.out.println("3. update");
		System.out.println("4. delete");
		System.out.println("5. statistical");
	}

	public void handleJbdc(int data){
		switch (data){
			case 1:
				printJbdc();
				break;
			case 2:
				insertJbdc();
				break;
			case 3:
				updateJbdc();
				break;
			case 4:
				deleteJbdc();
				break;
			case 5:
				statistical();
			default:
				System.out.println("Invalid choose");
				break;
		}
	}

	public void printJbdc(){
		List<Inventory> inventories = inventoryDao.getAll();
		for(int i = 0; i < inventories.size(); i++){
			System.out.println(inventories.get(i).toString());
		}

		List<Category> categories = categoryDao.getAll();
		for(int i = 0; i < categories.size(); i++){
			System.out.println(categories.get(i).toString());
		}

		List<Product> products = productDao.getAll();
		for(int i = 0; i < products.size(); i++){
			System.out.println(products.get(i).toString());
		}
	}

	public void insertJbdc(){
		Inventory inventory = new Inventory(4, "K004", "name 4", "", null, null);
		inventoryDao.save(inventory);
	}

	public void updateJbdc(){
		Inventory inventory = new Inventory(4, "K004", "name 4", "location 4", null, null);
		inventoryDao.update(inventory);
	}

	public void deleteJbdc(){
		Inventory inventory = new Inventory(4, "K004", "name 4", "location 4", null, null);
		inventoryDao.delete(inventory);
	}

	public void statistical(){
		String sql = "select c.category_name, count(p.id) as products, sum(p.quantity) as number_of_products " +
				"from ex03_mysql.Product as p join ex03_mysql.Category as c " +
				"on (p.category_id = c.id) " +
				"group by c.category_name " +
				"order by number_of_products desc;";
		List<Map<String, Object>> values = Configs.jdbcTemplate.queryForList(sql);
		System.out.println(values);
	}

	public void printJpa(){
		CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);
		categoryRepository.findAll().forEach(System.out::println);

		InventoryRepository inventoryRepository = ctx.getBean(InventoryRepository.class);
		inventoryRepository.findAll().forEach(System.out::println);

		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		productRepository.findAll().forEach(System.out::println);
	}
}
