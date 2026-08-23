# Flavorista - Software Design Patterns

This document describes the software design patterns that will be implemented in the Flavorista Restaurant Management System.

---

# Design Pattern 01 — Singleton Pattern

## 1. Name of the Pattern

**Singleton Pattern**

---

## 2. Problem it Solves

The Flavorista application contains several modules such as Authentication, Users, Menu, Orders, Payments, Reviews, Coupons, Reservations, and Notifications. These modules require access to the same application configuration throughout the system.

Without the Singleton Pattern, different classes could create multiple configuration objects using the `new` keyword. This would increase memory usage, duplicate configuration data, and may result in inconsistent application settings.

The following code solves this problem by ensuring that only one configuration object can exist during the application's lifetime. Every service retrieves the same object whenever configuration is required.

Singleton is the most suitable design pattern because the objective is to create **one shared instance** for the entire application.

Other patterns were not selected because they solve different software design problems:

- **Factory Method** creates different types of objects but does not restrict object creation.
- **Strategy** changes application behavior by switching algorithms.
- **Observer** notifies multiple objects when an event occurs.
- **Facade** provides a simplified interface to multiple classes.

None of these patterns guarantee a single shared configuration object.

---

## 3. Specific Java Class Involved

```
flavorista\config\AppConfig.java
```

---

## 4. UML Diagram

```
                    +---------------------------+
                    |        AppConfig          |
                    +---------------------------+
                    | - instance : AppConfig    |
                    +---------------------------+
                    | + getInstance()           |
                    +---------------------------+
                               ▲
                               │
                 ..............│..............
                 .             │             .
                 .             │             .
      Authentication      OrderService    PaymentService
                 .             │             .
                 .             │             .
                 ..............│..............
                               │
                               ▼
                 One Shared Configuration Object
```
The UML diagram shows that the `AppConfig` class contains a private static instance of itself and provides a public `getInstance()` method. Authentication, Order Service, and Payment Service do not create their own configuration objects. Instead, they all access the same shared instance through `getInstance()`. This relationship illustrates how the Singleton Pattern guarantees that only one configuration object exists throughout the application's lifetime.

---

## 5. Code Snippet

```java
public class AppConfig {

    private static AppConfig instance;

    private AppConfig() {
    }

    public static AppConfig getInstance() {

        if (instance == null) {
            instance = new AppConfig();
        }

        return instance;
    }
}
```

---

## 6. Explanation

The code creates a centralized configuration manager for the Flavorista application.

The private constructor prevents other classes from creating configuration objects directly, while the static `getInstance()` method ensures that the application always returns the same object. When the object is requested for the first time, it is created. Every subsequent request returns the existing object instead of creating a new one.

As a result, all future modules such as Authentication, Users, Orders, Payments, Notifications, Coupons, and Reservations will use one common configuration object, improving consistency, reducing memory usage, and making the application easier to maintain.

The Singleton Pattern was chosen because the project requires exactly one shared configuration object. Other patterns such as Factory Method, Strategy, Observer, and Facade cannot guarantee a single application-wide instance, making Singleton the most appropriate solution for this requirement.

---

The application's configuration has now been centralized. The next challenge is creating different business objects such as Users, Orders, Menu Items, Coupons, and Payments without tightly coupling object creation to the application logic. This requirement is addressed using the **Factory Method Pattern**.

---

# Design Pattern 02 — Factory Method Pattern

## 1. Name of the Pattern

**Factory Method Pattern**

---

## 2. Problem it Solves

After centralizing the application's configuration using the Singleton Pattern, the next challenge is creating different business objects throughout the Flavorista application.

Modules such as Authentication, Menu, Orders, Coupons, Reservations, Payments, Reviews, and Notifications frequently require new business objects. If every service creates objects directly using the `new` keyword, object creation becomes tightly coupled with business logic. This makes the application difficult to maintain, extend, and test.

The following Factory Method code solves this problem by moving object creation into a dedicated factory class. Instead of knowing how an object is created, other classes simply request an object from the factory.

This reduces coupling, improves maintainability, and allows future changes to object creation without modifying the business logic.

The Factory Method Pattern is the most suitable solution because its primary purpose is object creation.

Other patterns were not selected because they solve different problems.

- **Singleton** guarantees only one object exists but does not manage the creation of different business objects.
- **Strategy** changes algorithms during runtime.
- **Observer** handles communication between multiple objects.
- **Facade** simplifies access to several classes but does not create objects.

Therefore, Factory Method is the most appropriate choice for creating business objects within Flavorista.

---

## 3. Specific Java Class Involved

```
flavorista\factory\UserFactory.java
```

---

## 4. UML Diagram

```
                   +----------------------+
                   |     UserFactory      |
                   +----------------------+
                   | + createUser()       |
                   +----------------------+
                              │
                              │ creates
                              ▼
                      +----------------+
                      |      User      |
                      +----------------+
                      | id             |
                      | name           |
                      | email          |
                      | role           |
                      +----------------+

                              ▲
                              │
                    AuthenticationService
                              │
                    RegistrationController
```
The UML diagram shows that the `UserFactory` class is responsible for creating `User` objects. Instead of creating users directly, classes such as `AuthenticationService` and `RegistrationController` request a new object from the factory. This structure separates object creation from business logic, reducing coupling and making the application easier to maintain and extend.

---

## 5. Code Snippet

```java
public class UserFactory {

    public static User createUser(String name,
                                  String email,
                                  String password) {

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
```

---

## 6. Explanation

The Factory Method Pattern centralizes the creation of `User` objects inside the `UserFactory` class.

Instead of allowing multiple controllers and services to create users directly, they simply call the `createUser()` method. The factory prepares the object, assigns its required values, and returns a fully initialized `User` instance.

This approach keeps business logic separate from object creation, making the application easier to maintain and extend. For example, if future requirements require assigning a default role, generating a unique username, encrypting the password, or initializing additional fields, only the factory class needs to be modified. The remaining application code remains unchanged.

The Factory Method Pattern was selected because Flavorista creates many business objects such as Users, Orders, Menu Items, Coupons, Payments, Reviews, and Reservations. Centralizing object creation improves code organization and reduces duplication.

Singleton was not chosen because it only restricts the number of instances.

Strategy changes algorithms rather than creating objects.

Observer manages event notifications.

Facade provides a simplified interface but does not manage object creation.

Therefore, the Factory Method Pattern is the most appropriate solution for this requirement.

---

Business objects can now be created in a consistent and maintainable manner. The next challenge is allowing the application to perform different business operations, such as multiple payment methods, without changing the existing application structure. This requirement is addressed using the **Strategy Pattern**.

---

# Design Pattern 03 — Strategy Pattern

## 1. Name of the Pattern

**Strategy Pattern**

---

## 2. Problem it Solves

Flavorista allows customers to pay using different payment methods such as Cash on Delivery, Credit/Debit Card, Mobile Banking (bKash, Nagad), and Online Payment Gateway.

Without the Strategy Pattern, all payment logic would be written inside a single class using multiple `if-else` or `switch` statements. As new payment methods are introduced, the code becomes longer, more difficult to understand, harder to maintain, and more prone to errors.

The following code solves this problem by placing each payment method into its own strategy class. The application simply selects the appropriate payment strategy at runtime based on the customer's choice.

This approach follows the **Open/Closed Principle**, allowing new payment methods to be added without modifying existing business logic.

The Strategy Pattern is the most suitable solution because the application's behavior changes depending on the selected payment method.

Other patterns were not selected because they solve different software design problems.

- **Singleton** manages only one shared object.
- **Factory Method** creates objects but does not change application behavior.
- **Observer** handles notifications between objects.
- **Facade** simplifies communication between multiple classes.

None of these patterns allow payment algorithms to be changed dynamically.

---

## 3. Specific Java Class Involved

```
flavorista\strategy\PaymentStrategy.java

flavorista\strategy\CashPayment.java

flavorista\strategy\CardPayment.java

flavorista\strategy\BkashPayment.java

flavorista\strategy\PaymentContext.java
```

---

## 4. UML Diagram

```
                   +------------------------+
                   |    PaymentStrategy     |
                   +------------------------+
                   | + pay(amount)          |
                   +------------------------+
                           ▲
            ...............|................
            .              |               .
            .              |               .
+----------------+ +----------------+ +----------------+
| CashPayment    | | CardPayment    | | BkashPayment   |
+----------------+ +----------------+ +----------------+
            .              |               .
            .              |               .
            ...............|................
                           │
                           ▼
                +----------------------+
                |   PaymentContext     |
                +----------------------+
                | setStrategy()        |
                | executePayment()     |
                +----------------------+
```
The UML diagram illustrates that `PaymentStrategy` is the common interface for all payment methods. `CashPayment`, `CardPayment`, and `BkashPayment` implement this interface by providing their own payment logic. `PaymentContext` communicates only with the interface and executes whichever payment strategy is selected at runtime. This structure allows new payment methods to be added without modifying the existing payment process.

---

## 5. Code Snippet

```java
public interface PaymentStrategy {

    void pay(double amount);

}
```

```java
public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }

}
```

---

## 6. Explanation

The Strategy Pattern separates each payment method into its own class while defining a common interface named `PaymentStrategy`.

Instead of embedding all payment methods inside one large class, the application selects the required strategy at runtime. For example, if a customer chooses Cash on Delivery, the `CashPayment` strategy is executed. If the customer selects Card Payment or bKash, the corresponding strategy is executed without changing the remaining application logic.

This design makes the payment module flexible, reusable, and easy to maintain. New payment methods such as Stripe, PayPal, SSLCommerz, or Apple Pay can be added later by creating another strategy class that implements `PaymentStrategy`. Existing classes remain unchanged.

The Strategy Pattern was selected because Flavorista requires different payment algorithms depending on the customer's choice.

Singleton cannot switch algorithms.

Factory Method only creates objects.

Observer manages event notifications.

Facade simplifies interactions between classes.

Therefore, the Strategy Pattern is the most appropriate solution for implementing multiple payment methods in the Flavorista application.

---

The application can now perform different payment operations dynamically. The next challenge is notifying multiple modules whenever an important event occurs, such as placing an order or completing a payment. This requirement is addressed using the **Observer Pattern**.

---

# Design Pattern 04 — Observer Pattern

## 1. Name of the Pattern

**Observer Pattern**

---

## 2. Problem it Solves

Whenever an important event occurs in Flavorista, such as a customer placing an order, completing a payment, cancelling an order, or making a reservation, multiple modules need to react to that single event.

For example, after an order is successfully placed:

- The customer should receive an order confirmation.
- The restaurant staff should receive a new order notification.
- The inventory should be updated.
- The sales report should be refreshed.
- Loyalty points may need to be added.

Without the Observer Pattern, the `OrderService` would directly call every notification and update class. As more features are added, the service becomes tightly coupled with many other classes, making the code difficult to maintain and extend.

The following code solves this problem by allowing interested classes (Observers) to subscribe to an event. Whenever the event occurs, all registered observers are notified automatically without the subject knowing their implementation details.

The Observer Pattern is the most suitable solution because one event needs to notify multiple independent components.

Other patterns were not selected because they solve different software design problems.

- **Singleton** manages a single shared object.
- **Factory Method** creates objects.
- **Strategy** changes algorithms during runtime.
- **Facade** simplifies interactions between classes.

None of these patterns provide automatic event notification between multiple objects.

---

## 3. Specific Java Classes Involved

```
flavorista\observer\OrderObserver.java

flavorista\observer\OrderSubject.java

flavorista\observer\CustomerNotificationObserver.java

flavorista\observer\AdminNotificationObserver.java
```

---

## 4. UML Diagram

```
                     +----------------------+
                     |    OrderSubject      |
                     +----------------------+
                     | attach()             |
                     | detach()             |
                     | notifyObservers()    |
                     +----------------------+
                               │
                  notifies     │
                               ▼
                 +---------------------------+
                 |      OrderObserver        |
                 +---------------------------+
                 | + update(order)          |
                 +---------------------------+
                         ▲             ▲
                         │             │
              ...........             ...........
              .                               .
              .                               .
+-----------------------------+   +---------------------------+
| CustomerNotificationObserver|   | AdminNotificationObserver |
+-----------------------------+   +---------------------------+
```
The UML diagram shows that `OrderSubject` maintains a list of registered observers and notifies them whenever an important event occurs. `CustomerNotificationObserver` and `AdminNotificationObserver` implement the common `OrderObserver` interface and receive updates through the `update()` method. This structure enables one event to automatically notify multiple independent components while keeping them loosely coupled.

---

## 5. Code Snippet

```java
public interface OrderObserver {

    void update(String message);

}
```

```java
public class OrderSubject {

    private List<OrderObserver> observers = new ArrayList<>();

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {

        for (OrderObserver observer : observers) {
            observer.update(message);
        }

    }

}
```

---

## 6. Explanation

The Observer Pattern allows multiple parts of the Flavorista application to respond automatically whenever an important event occurs.

Instead of the `OrderService` manually sending notifications to every module, it simply informs the `OrderSubject` that an event has occurred. The subject then automatically notifies every registered observer by calling their `update()` method.

This design keeps the application loosely coupled because the order module does not need to know which notification classes exist. New observers can be added in the future, such as Inventory Observer, Email Observer, SMS Observer, Analytics Observer, or Loyalty Points Observer, without modifying the existing order processing code.

The Observer Pattern was selected because Flavorista contains many business events where one action should trigger multiple independent responses.

Singleton cannot notify multiple objects.

Factory Method focuses only on object creation.

Strategy changes algorithms rather than distributing events.

Facade simplifies access to classes but does not provide an event notification mechanism.

Therefore, the Observer Pattern is the most appropriate solution for handling automatic event notifications throughout the Flavorista application.

---

The application's event notification system has now been decoupled from the business logic. The next challenge is simplifying communication between multiple services by providing a single entry point for complex operations. This requirement is addressed using the **Facade Pattern**.

---

# Design Pattern 05 — Facade Pattern

## 1. Name of the Pattern

**Facade Pattern**

---

## 2. Problem it Solves

As the Flavorista application grows, completing a single business operation requires communication with multiple modules. For example, placing an order is not limited to creating an order record. The application may also need to verify the customer, validate menu items, calculate the total price, apply coupons, process payment, update inventory, save the order, and send notifications.

Without the Facade Pattern, controllers would have to communicate with every service individually. This results in complex controller code, high coupling, duplicated business logic, and reduced maintainability.

The following code solves this problem by introducing a single service that coordinates all related operations. Instead of interacting with several classes, the controller communicates only with the facade, which internally delegates tasks to the required services.

The Facade Pattern is the most suitable solution because it provides a simplified interface for performing complex business workflows.

Other patterns were not selected because they solve different software design problems.

- **Singleton** manages a single shared instance.
- **Factory Method** creates objects.
- **Strategy** changes algorithms dynamically.
- **Observer** distributes event notifications.

None of these patterns simplify communication between multiple independent services.

---

## 3. Specific Java Class Involved

```
flavorista\facade\OrderFacade.java
```

---

## 4. UML Diagram

```
                      +----------------------+
                      |     OrderFacade      |
                      +----------------------+
                      | + placeOrder()       |
                      +----------------------+
             _________/_____|__________\________________________
            /               |           \                       \
           ▼                ▼            ▼                       ▼
 +----------------+ +----------------+ +----------------+ +------------------+
 | UserService    | | MenuService    | | PaymentService | | NotificationService |
 +----------------+ +----------------+ +----------------+ +------------------+
                    ▲
                    │
              OrderController
```
The UML diagram illustrates that `OrderFacade` acts as a single entry point for the order processing workflow. Instead of communicating with multiple services individually, the `OrderController` interacts only with the facade. The facade internally coordinates `UserService`, `MenuService`, `PaymentService`, and `NotificationService`. This structure simplifies complex interactions and reduces dependencies between the controller and individual service classes.

---

## 5. Code Snippet

```java
public class OrderFacade {

    private UserService userService;
    private MenuService menuService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public void placeOrder() {

        userService.validateUser();

        menuService.prepareOrder();

        paymentService.processPayment();

        notificationService.sendConfirmation();

    }

}
```

---

## 6. Explanation

The `OrderFacade` class provides a single entry point for processing an order in the Flavorista application.

Instead of allowing the controller to communicate separately with `UserService`, `MenuService`, `PaymentService`, and `NotificationService`, the controller simply calls the `placeOrder()` method. The facade then coordinates each required service in the correct order.

This approach hides unnecessary implementation details from the controller, reduces dependencies between modules, and keeps business logic organized in one place. As additional features are introduced, such as inventory updates, coupon validation, reservation checks, delivery scheduling, or loyalty point calculations, they can be incorporated into the facade without changing the controller.

The Facade Pattern was selected because one business operation in Flavorista involves multiple collaborating services. Providing a single interface makes the application easier to develop, understand, test, and maintain.

Singleton cannot coordinate multiple services.

Factory Method focuses on object creation.

Strategy changes business algorithms.

Observer distributes events to subscribers.

Therefore, the Facade Pattern is the most appropriate solution for simplifying complex business workflows within the Flavorista application.

---

## Conclusion

The Flavorista project implements five software design patterns to improve maintainability, scalability, and code organization.

- **Singleton Pattern** centralizes application configuration using a single shared instance.
- **Factory Method Pattern** centralizes the creation of business objects and reduces coupling.
- **Strategy Pattern** allows different payment methods to be selected dynamically without modifying existing business logic.
- **Observer Pattern** enables automatic notification of multiple modules when important business events occur.
- **Facade Pattern** provides a single interface for coordinating complex workflows involving multiple services.

Together, these patterns promote loose coupling, better separation of responsibilities, easier maintenance, and future extensibility, making the Flavorista application more robust and aligned with object-oriented software engineering principles.