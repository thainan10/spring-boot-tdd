package com.example.springboottdd.service;

import com.example.springboottdd.domain.Employee;
import com.example.springboottdd.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @TestConfiguration
    static class EmployeeServiceTestContextConfiguration {
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee();
        employee.setName("alex");

        Mockito.when(employeeRepository.findByName(employee.getName()))
                .thenReturn(employee);
    }

    @Test
    public void getEmployeeByValidNameShouldReturnEmployee() {
        String name = "alex";
        Employee result = employeeService.getEmployeeByName(name);

        Assert.assertEquals(String.format("Employee with name %s to be equal with the Employee with name %s", name, result.getName()), name, result.getName());
    }
}
