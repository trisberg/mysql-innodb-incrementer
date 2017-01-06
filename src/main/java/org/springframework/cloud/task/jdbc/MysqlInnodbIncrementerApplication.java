package org.springframework.cloud.task.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlInnodbIncrementerApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(MysqlInnodbIncrementerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Test ...");
		MySQLInnoDbMaxValueIncrementer incr = new MySQLInnoDbMaxValueIncrementer(dataSource, "TEST_SEQ", "value");
		incr.setCacheSize(100);
		incr.afterPropertiesSet();
		System.out.println("NEXT: " + incr.getNextKey());
		System.out.println("NEXT: " + incr.getNextKey());
		System.out.println("NEXT: " + incr.getNextKey());
		System.out.println("Done!");
	}
}
