package com.ecom.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.UserDtls;
import com.ecom.repository.CategoryRepository;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;

@Configuration
public class DataInitializer {

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, UserService userService,
			CategoryRepository categoryRepository, ProductRepository productRepository) {
		return args -> {
			// 1. Seed Admin User
			if (userRepository.findByEmail("admin@gmail.com") == null) {
				UserDtls admin = new UserDtls();
				admin.setName("Admin Manager");
				admin.setEmail("admin@gmail.com");
				admin.setPassword("admin");
				admin.setMobileNumber("9999999999");
				admin.setAddress("Headquarters Tech Park");
				admin.setCity("Metropolis");
				admin.setState("Central");
				admin.setPincode("100001");
				userService.saveAdmin(admin);
				System.out.println(">>> Default Admin initialized: admin@gmail.com / admin");
			}

			// 2. Seed Customer User
			if (userRepository.findByEmail("user@gmail.com") == null) {
				UserDtls customer = new UserDtls();
				customer.setName("John Customer");
				customer.setEmail("user@gmail.com");
				customer.setPassword("user");
				customer.setMobileNumber("9876543210");
				customer.setAddress("Flat 402, Green Valley Apartments");
				customer.setCity("Hyderabad");
				customer.setState("Telangana");
				customer.setPincode("500081");
				userService.saveUser(customer);
				System.out.println(">>> Default Customer initialized: user@gmail.com / user");
			}

			// 3. Seed Default Categories if none exist
			if (categoryRepository.count() == 0) {
				categoryRepository.save(new Category(null, "Electronics", "/img/category_img/laptop.jpg", true));
				categoryRepository.save(new Category(null, "Mobiles", "/img/category_img/mobile.png", true));
				categoryRepository.save(new Category(null, "Fashion", "/img/category_img/pant.png", true));
				categoryRepository.save(new Category(null, "Appliances", "/img/category_img/appli.png", true));
				categoryRepository.save(new Category(null, "Beauty", "/img/category_img/beuty.png", true));
				categoryRepository.save(new Category(null, "Grocery", "/img/category_img/groccery.jpg", true));
				System.out.println(">>> Default Categories initialized");
			}

			// 4. Seed Default Products if none exist
			if (productRepository.count() == 0) {
				addProduct(productRepository,
						"HP Pavilion Gaming Laptop 15.6\"",
						"High performance FHD IPS display, Intel Core i7 12th Gen, 16GB DDR4 RAM, 512GB NVMe SSD, NVIDIA GeForce RTX 3050 graphics, Bang & Olufsen audio, backlit keyboard.",
						"Electronics", 68999.0, 15, 25, "/img/product_img/hp laptop.jpg");

				addProduct(productRepository,
						"Apple iPhone 14 Pro (128 GB)",
						"6.1-inch Super Retina XDR OLED display with Dynamic Island, A16 Bionic processor, 48MP triple camera system with Action mode & 4K cinematic video, all-day battery life.",
						"Mobiles", 79999.0, 10, 40, "/img/product_img/iphone 14.jpg");

				addProduct(productRepository,
						"OnePlus Nord CE 5G (Charcoal Gray)",
						"Smooth 90Hz Fluid AMOLED display, Qualcomm Snapdragon 750G 5G processor, 64MP AI triple camera, 4500mAh high-capacity battery with Warp Charge 30T Plus.",
						"Mobiles", 24999.0, 12, 50, "/img/product_img/oneplus mobile.jpg");

				addProduct(productRepository,
						"Dell Inspiron 14 Thin & Light Ultrabook",
						"Ultra-portable 14-inch FHD anti-glare screen, Intel Core i5 12th Gen, 8GB DDR4 RAM, 512GB PCIe NVMe SSD, Windows 11 Home + MS Office, fingerprint reader.",
						"Electronics", 52000.0, 10, 30, "/img/product_img/laptop.jpg");

				addProduct(productRepository,
						"LG UltraGear 27\" QHD Gaming Monitor",
						"27-inch 2560x1440 Nano IPS display, 165Hz ultra-fast refresh rate, 1ms response time, HDR10, NVIDIA G-SYNC & AMD FreeSync Premium compatible, borderless design.",
						"Electronics", 28500.0, 18, 18, "/img/product_img/monitor.jpg");

				addProduct(productRepository,
						"Samsung 253L Inverter Double Door Refrigerator",
						"253 Litres 3-star energy rating frost-free double door refrigerator with digital inverter compressor, all-around cooling system, toughened glass shelves, stabilizer free.",
						"Appliances", 26990.0, 15, 15, "/img/product_img/fridge.png");

				addProduct(productRepository,
						"Whirlpool 7Kg Front Load Washing Machine",
						"7 Kg 5-star fresh care front load washing machine with in-built heater, steam wash technology, 1200 RPM spin speed, 14 wash programs for maximum fabric care.",
						"Appliances", 31500.0, 20, 12, "/img/product_img/washing_machine.png");

				addProduct(productRepository,
						"Philips 750W Heavy Duty Mixer Grinder",
						"Powerful 750 Watt copper motor, 3 stainless steel leak-proof jars with ergonomically designed handles, advanced air ventilation system for rapid cooling.",
						"Appliances", 3499.0, 25, 60, "/img/product_img/grinder.jpg");

				addProduct(productRepository,
						"Men's Classic Slim Fit Denim Shirt",
						"100% premium breathable cotton, washed blue shade, spread collar, full button placket, dual flap button pockets on chest, modern tailored fit.",
						"Fashion", 1599.0, 30, 45, "/img/product_img/blue shirt.jfif");

				addProduct(productRepository,
						"Men's Comfort Stretch Slim Fit Jeans",
						"Premium stretchable cotton blend denim, mid-rise waist, 5 pocket styling with coin pocket, durable brass zipper with top button closure, enzyme washed.",
						"Fashion", 1999.0, 35, 35, "/img/product_img/jeans blue.jfif");

				addProduct(productRepository,
						"Men's Casual Lightweight White Sneakers",
						"Lightweight faux leather upper, perforated side panels for breathability, cushioned memory foam insole, durable non-slip textured rubber outsole.",
						"Fashion", 2499.0, 40, 28, "/img/product_img/white shoe.jfif");

				addProduct(productRepository,
						"Men's Premium Handcrafted Leather Loafers",
						"Handcrafted slip-on dress loafers, elegant tan synthetic leather with contrast stitching, flexible TPR sole with shock-absorbing heel support.",
						"Fashion", 2999.0, 25, 22, "/img/product_img/lofer.jfif");

				System.out.println(">>> 12 Default Products initialized with local image assets");
			} else {
				// Fix any existing products that had AWS S3 or broken URLs
				List<Product> existingProducts = productRepository.findAll();
				for (Product p : existingProducts) {
					if (p.getImage() != null && p.getImage().contains("amazonaws.com")) {
						String filename = p.getImage().substring(p.getImage().lastIndexOf("/") + 1);
						p.setImage("/img/product_img/" + filename);
						productRepository.save(p);
					}
				}
			}
		};
	}

	private void addProduct(ProductRepository repo, String title, String description, String category,
			Double price, int discount, int stock, String image) {
		Double discountAmount = price * (discount / 100.0);
		Double discountPrice = price - discountAmount;
		Product p = new Product(null, title, description, category, price, stock, image, discount, discountPrice, true);
		repo.save(p);
	}
}
