package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//      Car car1 = new Car("BMW", 7);
//      user1.setUserCar(car1);
//      car1.setUser(user1);
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//      Car car2 = new Car("Skoda", 3);
//      user2.setUserCar(car2);
//      car2.setUser(user2);
//      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
//      Car car3 = new Car("Audi", 3);
//      user3.setUserCar(car3);
//      car3.setUser(user3);
//      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
//      Car car4 = new Car("Lada", 1);
//      user4.setUserCar(car4);
//      car4.setUser(user4);
//
//      userService.add(user1);
//      userService.add(user2);
//      userService.add(user3);
//      userService.add(user4);
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getUserCar());
//         System.out.println();
//      }

      List<User> usersCar = userService.getUserByCarModelAndCarSeries(
              "Audi", 3);
      for (User user : usersCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }

      /*
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      CarService carService = context.getBean(CarService.class);
      carService.addCar(new Car("BMW", 7));
      carService.addCar(new Car("Skoda", 3));
      carService.addCar(new Car("Audi", 3));
      carService.addCar(new Car("Lada", 1));

      List<Car> cars = carService.listCars();
      for (Car car : cars){
         System.out.println("Id = " + car.getId());
         System.out.println("Model = " + car.getModel());
         System.out.println("Series = " + car.getSeries());
         System.out.println();
      }
      */


      context.close();
   }
}
