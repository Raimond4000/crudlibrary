package com.sda.database;

import com.sda.database.connection.DatabaseConnection;
import com.sda.database.connection.H2DatabaseConection;
import com.sda.database.connection.MysqlDatabaseConnection;
import com.sda.database.entity.EmployeeEntity;
import com.sda.database.property.ConnectionProperty;
import com.sda.database.repository.EmployeeRepository;
import lombok.extern.java.Log;

import java.util.List;
@Log

public class CrudExample {

    public static void main(String[] args) {

        DatabaseConnection mysqldatabaseConnection = new MysqlDatabaseConnection();
        ConnectionProperty connectionProperty = mysqldatabaseConnection.getConnectionProperties("src/main/resources/mysql.properties");

        System.out.println(String.format("Driver Name: %s , Database Name: %s , Username: %s, Password: %s ",
                connectionProperty.getDriverName(), connectionProperty.getDatabaseUrl(), connectionProperty.getUsername(), connectionProperty.getPassword()));


        ((MysqlDatabaseConnection) mysqldatabaseConnection).open(connectionProperty);
               //EmployeeRepository employeeRepository = new EmployeeRepository(mysqldatabaseConnection);

        EmployeeRepository employeeRepository = new EmployeeRepository(mysqldatabaseConnection);
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            System.out.println(String.format("Id: %d, Name: %s, City:%s, Phone:%s, Age:%d"
                    , employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getCity()
                    , employeeEntity.getPhone(), employeeEntity.getAge()));
        }
        log.info("usage of findById");
        EmployeeEntity employeeEntity = employeeRepository.findById(1L);
        System.out.println(employeeEntity.getName() != null ? employeeEntity.toString() : "No employee found");
    }
}
