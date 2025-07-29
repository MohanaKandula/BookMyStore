# 📚 RESTful Bookstore API

A Spring Boot-based REST API for managing books and authors, complete with CRUD operations, pagination, filtering, and documentation via Swagger.

## 🚀 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2/MySQL Database
- Swagger (OpenAPI)
- Postman

---

## 📦 Features

✅ CRUD operations for Books and Authors  
✅ One-to-Many relationship (Author → Books)  
✅ Pagination using `Pageable`  
✅ Filtering books by author name and price  
✅ Swagger documentation  
✅ Postman Collection for testing  

---

## 🧩 API Endpoints

### Authors
- `POST /api/authors` - Add author
- `GET /api/authors` - List all authors

### Books
- `POST /api/books` - Add book
- `GET /api/books` - List books (with pagination)
- `GET /api/books/author/{name}` - Filter by author
- `GET /api/books/price?min=xx&max=xx` - Filter by price
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book

---

## 🧪 API Testing

### 📁 Postman Collection:
> Import `Bookstore_API_Collection.json` in Postman

### 🧾 Swagger UI:
> [http://localhost:8000/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🗃️ Database

Supports both:
- ✅ In-memory (H2) — for testing
- ✅ MySQL — for production

---
# 📄 Employee Report Generator

This is a Spring Boot-based **PDF Report Generator** tool that connects to a MySQL database, fetches employee records, and generates professional PDF reports using iText. It also schedules automatic report generation and compresses multiple reports into a ZIP file for download.

---

## 🚀 Features

- 🔌 Connects to MySQL for dynamic employee data
- 🧾 Generates well-designed PDF reports with logo and footer
- ⏳ Schedules report generation automatically (via `Timer`)
- 📦 Zips all generated PDFs into one downloadable archive
- 🖥️ Can be run via command-line or integrated in a UI
- ✅ Includes JUnit test structure
- 📁 `employees.csv` added for sample testing
- 🖼️ `logo.png` and footer included in reports

---





## 📄 Author
Mohana Kandula  


