# 🛒 E-Commerce – Full-Stack Spring Boot Application

A full-stack e-commerce web application built with **Spring Boot**, where customers can browse products, manage a shopping cart and place orders, while admins manage the product catalog.

> Developed by **M.S.R. Yaswanth**

## ✨ Features

### 👤 Customer
- Register and log in securely
- Browse all products and view product details
- Search products by name / filter by category
- Add products to the cart, update quantity, remove items
- Checkout and place orders
- View order history

### 🛠️ Admin
- Secure admin login (role-based access)
- Add, update and delete products
- Manage categories
- View all customer orders and update order status

---

## 🧰 Tech Stack

| Layer | Technology | Used For |
|---|---|---|
| Backend | **Spring Boot** | Core application framework |
| Web | **Spring MVC** | Controllers, request handling |
| Database Access | **Spring Data JPA (Hibernate)** | Mapping Java entities to database tables |
| Security | **Spring Security** | Authentication, password encryption, role-based access |
| Frontend | **Thymeleaf** | Server-side HTML rendering |
| Styling | **Bootstrap, HTML, CSS** | Responsive user interface |
| Database | **MySQL** | Storing users, products, carts and orders |
| Build Tool | **Maven** | Dependency management and build |
| Language | **Java 17** | Application code |

---

## 🏗️ Project Architecture

The application follows a layered architecture:

```
Browser  →  Controller  →  Service  →  Repository  →  MySQL
              ↓
        Thymeleaf Template (View)
```

- **Controller** – receives HTTP requests and returns views
- **Service** – contains business logic (cart handling, order placement)
- **Repository** – database operations using Spring Data JPA
- **Entity** – Java classes mapped to database tables

---

## 📁 Project Structure

```
src/main/java/com/example/ecommerce
├── config/         # Spring Security configuration
├── controller/     # Request handlers
├── entity/         # JPA entities (User, Product, Cart, Order...)
├── repository/     # JPA repositories
├── service/        # Business logic
└── EcommerceApplication.java

src/main/resources
├── templates/      # Thymeleaf HTML pages
├── static/         # CSS, JS, images
└── application.properties
```

> Update the package name and folders to match your actual project.

---

## 🗄️ Database Design

**Database:** MySQL

| Table | Description |
|---|---|
| `users` | Customer and admin accounts (name, email, encrypted password, role) |
| `products` | Product name, description, price, stock, image, category |
| `categories` | Product categories |
| `cart_items` | Products added to a user's cart with quantity |
| `orders` | Order details (user, date, total, status) |
| `order_items` | Products and quantities in each order |

**Relationships**
- One User → Many Orders
- One Order → Many Order Items
- One Category → Many Products

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or later
- Maven (or use the included `mvnw`)
- MySQL 8+
- Any IDE (IntelliJ IDEA / Eclipse / VS Code)

### Installation

**1. Clone the repository**
```bash
git clone https://github.com/yashmiriyala1914/E-Commerce.git
cd E-Commerce
```

**2. Create the database**
```sql
CREATE DATABASE ecommerce_db;
```

**3. Configure `src/main/resources/application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
server.port=8080
```

**4. Run the application**
```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

**5. Open in browser**
```
http://localhost:8080
```

---

## 🔑 Default Credentials

| Role | Email | Password |
|---|---|---|
| Admin | admin@example.com | admin123 |
| Customer | Register from the sign-up page | – |

> Change these in your project and never commit real passwords.
## 🔮 Future Enhancements
- Online payment integration (Razorpay / Stripe)
- Email notifications for orders
- Product reviews and ratings
- Wishlist
- REST API documentation with Swagger
- Docker deployment

---

## 👨‍💻 Authors

- **M.S.R. Yaswanth** – [GitHub](https://github.com/yashmiriyala1914)

---

## 📄 License

This project is created for educational purposes.