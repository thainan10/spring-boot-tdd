package com.example.springboottdd.repository;

import com.example.springboottdd.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void findByNameShouldReturnEmployee() {
        Employee employee = new Employee();
        employee.setName("alex");
        entityManager.persist(employee);
        entityManager.flush();

        Employee result = employeeRepository.findByName(employee.getName());

        Assert.assertEquals(String.format("Employee with name %s to be equal with the Employee with name %s", employee.getName(), result.getName()),employee.getName(), result.getName());
    }
}
