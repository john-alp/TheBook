package com.menfin;

import java.sql.*;

public class Config {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/storageBooks" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        /*
        Подключаемся к нашей БД
         */
        try {
            Connection connection = DriverManager.getConnection(url, "book", "book");
            if(!connection.isClosed()) {
                System.out.println("Соединение с Базой Данных установленно! ");
            }
            /*
            Создаем  statement
             */
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO users (name,age,email) value ('Galina',75,'galina@mail.ru')");
            statement.addBatch("INSERT INTO users (name,age,email) value ('Raya',65,'goodTesha@yandex.ru')");
            statement.executeBatch();
            /*
            Проверяем подключен ли наш statement (подключен - false)
             */
            System.out.println(statement.isClosed());
            /*
            executeQuery - только для select
            Метод возвращает объект ResultSet, который содержит все полученные данные. Как эти данные получить?
            В объекте ResultSet итератор устаналивается на позиции перед первой строкой.
            И чтобы переместиться к первой строке (и ко всем последующим) необходимо вызвать метод next().
            Пока в наборе ResultSet есть доступные строки, метод next будет возвращать true.
             */
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()){
                System.out.println(resultSet.getRow() + " " + resultSet.getInt("id") + " " +
                        resultSet.getString("name") + " " + resultSet.getInt("age") + " " +
                        resultSet.getString("email"));
            }

            if (connection.isClosed()){
                System.out.println("Соединение с Базой Данных закрыто! ");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
