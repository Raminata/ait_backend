import de.ait.config.ApplicationConfig;
import de.ait.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------");

            System.out.println("1. Add product");
            System.out.println("2. Get All Products");
            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------");

            switch (command) {
                case 1 -> {
                    System.out.println("Enter the name of the product (min 7 length): ");
                    String name = scanner.nextLine();
                    productService.addProduct(name);
                }
                case 2 -> System.out.println(productService.getProducts());
                case 0 -> System.exit(0);
            }
        }
    }
}
