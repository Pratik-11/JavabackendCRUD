package com.example.backendCRUD;


import static org.junit. Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.backendCRUD.StudentDao;
import org.junit.jupiter.api.Assertions;

import org.junit.Test;
import org.junit.runner. RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class BackendCrudApplicationTests {

		@Autowired
		private DataSource dataSource;

		private JdbcTemplate jdbcTemplate;


		@Test
		public void updateDataTest() {
			// Given
			String newName = "pratik123";
			String newCity = "dehradun123";
			String name = "pratik";
			String city = "dehradun";

			// When
			StudentDao UD = new StudentDao(jdbcTemplate);
			UD.updateData(newName, newCity, name, city);

			// Then
			String query1 = "SELECT COUNT(*) FROM student WHERE name = ? AND city = ?";
			int count1 = jdbcTemplate.queryForObject(query1, Integer.class, newName, newCity);
			Assertions.assertEquals(1, count1, "Should update only one row");

			String query2 = "SELECT COUNT(*) FROM student WHERE name = ? AND city = ?";
			int count2 = jdbcTemplate.queryForObject(query2, Integer.class, name, city);
			Assertions.assertEquals(0, count2, "Should update only one row");
		}

	@Test
	public void insertDataTest() {
		// Given
		String name = "bcd";
		String city = "New York";

		// When
		StudentDao InsertData = new StudentDao(jdbcTemplate);
		InsertData.insertData(name, city);

		// Then
		String query = "SELECT COUNT(*) FROM student WHERE name = ? AND city = ?";
		int count = jdbcTemplate.queryForObject(query, Integer.class, name, city);
		Assertions.assertEquals(1, count, "Should insert only one row");
	}
	}

