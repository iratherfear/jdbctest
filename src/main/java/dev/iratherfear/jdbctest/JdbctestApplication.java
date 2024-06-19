package dev.iratherfear.jdbctest;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.iratherfear.jdbctest.dao.DAO;
import dev.iratherfear.jdbctest.model.Course;

@SpringBootApplication
public class JdbctestApplication {

	private static DAO<Course> dao;

	public JdbctestApplication(DAO<Course> dao) {
		this.dao = dao;
    }


	public static void main(String[] args) {
		SpringApplication.run(JdbctestApplication.class, args);
		List<Course> courses = dao.list();
		courses.forEach(System.out::println);


		System.out.println("-----------------------------------------------");
		System.out.println("New course was created");
		Course course = new Course("TEst", "TEST", "TEST");
		dao.create(course);
		System.out.println("-----------------------------------------------");
		courses.forEach(System.out::println);
		
		System.out.println("-----------------------------------------------");
		
		Optional<Course> opt = dao.get(1);
		System.out.println(opt.get());

		
		System.out.println("-----------------------------------------------");	
		
		dao.delete(2);
		System.out.println("DELETED");
		
		System.out.println("-----------------------------------------------");

		courses.forEach(System.out::println);



	}
}
