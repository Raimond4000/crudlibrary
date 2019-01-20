package com.sda.database.connection;

import com.sda.database.property.ConnectionProperty;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
@Log
public class MysqlDatabaseConnection extends DatabaseConnection {

    @Override
    public void connect() {

    }
}
