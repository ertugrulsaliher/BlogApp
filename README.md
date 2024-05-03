# Salih Er's Spring Blog Project

This project contains a blog application developed by Salih Er. This application provides a platform where users can register, publish articles, filter articles by categories, and make comments.

## Technologies Used

The Car Rental Application is built using the following technologies and frameworks:

- Java: The core programming language used for application development.
- Jakarta Persistence (JPA): A Java specification for managing persistence in Java applications.
- Hibernate: An object-relational mapping (ORM) framework for Java.
- Lombok: A library that simplifies Java code by reducing boilerplate code.



## Project Structure

The project consists of the following packages:

- **Controller:** Handles HTTP requests and triggers the business logic.
- **DTO (Data Transfer Object):** Facilitates data communication between Controller and Service classes.
- **Entity:** JPA entities representing database tables.
- **Exception:** Special exception classes managing error conditions.
- **Mapper:** Facilitates conversion between Entity and DTO classes.
- **Repository:** Interfaces performing database operations for JPA entities.
- **Service:** Service classes implementing the business logic.
- **Utility:** General-purpose helper classes and interfaces.
- **Init:** The task is to add data to the database when the project is run.


## Controller

- **CategoryController:** Manages category operations.
  - Provides functionality for creating categories, listing categories, and accessing category details.
- **CommentController:** Manages comment operations.
  - Provides functionality for creating comments and listing comments for a specific article.
- **PostController:** Manages article operations.
  - Provides functionality for creating articles, listing articles, filtering articles by category, and accessing article details.
- **UserController:** Manages user operations.
  - Provides functionality for user registration, listing users, and accessing user details.

## DTO (Data Transfer Object)

- **requestDto:** Request DTOs representing HTTP requests.
- **responseDto:** Response DTOs representing HTTP responses.

## Entity

- **BaseEntity:** Contains common fields for other entity classes.
- **Category:** Entity class representing a category.
- **Comment:** Entity class representing a comment.
- **Post:** Entity class representing an article.
- **User:** Entity class representing a user.

## Service

- **CategoryService:** Implements the business logic for category operations.
- **CommentService:** Implements the business logic for comment operations.
- **PostService:** Implements the business logic for article operations.
- **UserService:** Implements the business logic for user operations.

## Exception

- **BlogAppException:** Custom exception class representing exceptions thrown by the application.
- **ErrorMessage:** DTO class containing error message and code.
- **ErrorType:** Enum class containing error types and their corresponding HTTP status codes.

## Utility

- **IService:** Service interface defining basic CRUD operations.
- **ServiceManager:** Provides basic business logic for services.

This project was developed for Java programming courses.

---

# Salih Er's Spring Blog Projesi

Bu proje, Salih Er tarafından geliştirilen bir blog uygulamasını içerir. Bu uygulama, kullanıcıların kayıt olabileceği, makaleler yayınlayabileceği, kategorilere göre makaleleri filtreleyebileceği ve yorum yapabileceği bir platform sunar.

## Proje Yapısı

Proje, aşağıdaki paketlerden oluşur:

- **Controller:** HTTP isteklerini işler ve iş mantığını tetikler.
- **DTO (Data Transfer Object):** Controller ve Service sınıfları arasında veri iletişimini sağlar.
- **Entity:** Veritabanı tablolarını temsil eden JPA varlıkları.
- **Exception:** Hata durumlarını yöneten özel istisna sınıfları.
- **Mapper:** Entity ve DTO sınıfları arasında dönüşüm sağlar.
- **Repository:** JPA varlıklarının veritabanı işlemlerini gerçekleştiren arabirimler.
- **Service:** İş mantığını gerçekleştiren servis sınıfları.
- **Utility:** Genel amaçlı yardımcı sınıflar ve arabirimler.
- - **Init:** Proje Çalıştırıldığında veritabanına örnek veriler ekler.

## Controller

- **CategoryController:** Kategori işlemlerini yönetir.
  - Kategori oluşturma, listeleme ve detaylarına erişim sağlar.
- **CommentController:** Yorum işlemlerini yönetir.
  - Yorum oluşturma ve ilgili makaleye ait yorumları listeleme özelliklerine sahiptir.
- **PostController:** Makale işlemlerini yönetir.
  - Makale oluşturma, listeleme, kategoriye göre filtreleme, detaylarına erişim sağlar.
- **UserController:** Kullanıcı işlemlerini yönetir.
  - Kullanıcı kaydı, listeleme ve detaylarına erişim sağlar.

## DTO (Data Transfer Object)

- **requestDto:** HTTP isteklerini temsil eden istek DTO'ları.
- **responseDto:** HTTP yanıtlarını temsil eden yanıt DTO'ları.

## Entity

- **BaseEntity:** Diğer varlık sınıfları için oluşturulan ortak alanlar içerir.
- **Category:** Kategori varlık sınıfı.
- **Comment:** Yorum varlık sınıfı.
- **Post:** Makale varlık sınıfı.
- **User:** Kullanıcı varlık sınıfı.

## Service

- **CategoryService:** Kategori işlemlerinin iş mantığını gerçekleştirir.
- **CommentService:** Yorum işlemlerinin iş mantığını gerçekleştirir.
- **PostService:** Makale işlemlerinin iş mantığını gerçekleştirir.
- **UserService:** Kullanıcı işlemlerinin iş mantığını gerçekleştirir.

## Exception

- **BlogAppException:** Özel istisna sınıfı, uygulama tarafından fırlatılan istisnaları temsil eder.
- **ErrorMessage:** Hata mesajı ve kodunu içeren DTO sınıfı.
- **ErrorType:** Hata türlerini ve bunların HTTP durum kodlarını içeren enum sınıfı.

## Utility

- **IService:** Servis arabirimi, temel CRUD işlemlerini tanımlar.
- **ServiceManager:** Servislerin temel iş mantığını sağlar.

This project was developed for Java programming courses.