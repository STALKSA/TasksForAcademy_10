package com.example.notepads_project.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/notepads";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private final String DB_DRIVER = "org.postgresql.Driver";


    public DatabaseManager() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("подключение невозможно");
            throw new RuntimeException(e);
        }

    }


    public List<Notebook> getAllNotebooks() throws SQLException {
        List<Notebook> notebooks = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM notebooks")) {
            while (resultSet.next()) {
                Notebook notebook = new Notebook();
                notebook.setId(resultSet.getInt("id"));
                notebook.setBrand(resultSet.getString("brand"));
                notebook.setName(resultSet.getString("name"));
                notebook.setPageAmount(resultSet.getInt("pageAmount"));
                notebook.setCover(resultSet.getString("cover"));
                notebook.setCountry(resultSet.getString("country"));
                notebook.setPageType(resultSet.getString("pageType"));
                notebooks.add(notebook);
            }
        }
        return notebooks;
    }

    public List<String> getAllCountries() throws SQLException {
        List<String> countries = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT country FROM notebooks")) {
            while (resultSet.next()) {
                countries.add(resultSet.getString("country"));
            }
        }
        return countries;
    }

    public List<String> getCountryNotebookCounts() throws SQLException {
        List<String> countryNotebookCounts = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT country, COUNT(*) AS notebook_count FROM notebooks GROUP BY country")) {
            while (resultSet.next()) {
                String country = resultSet.getString("country");
                int notebookCount = resultSet.getInt("notebook_count");
                countryNotebookCounts.add(country + ": " + notebookCount);
            }
        }
        return countryNotebookCounts;
    }
    public String getCountryWithMostNotebooks() throws SQLException {
        String countryWithMostNotebooks = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT country FROM notebooks GROUP BY country ORDER BY COUNT(*) DESC LIMIT 1")) {
            if (resultSet.next()) {
                countryWithMostNotebooks = resultSet.getString("country");
            }
        }
        return countryWithMostNotebooks;
    }

    public String getCountryWithLeastNotebooks() throws SQLException {
        String countryWithLeastNotebooks = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT country FROM notebooks GROUP BY country ORDER BY COUNT(*) ASC LIMIT 1")) {
            if (resultSet.next()) {
                countryWithLeastNotebooks = resultSet.getString("country");
            }
        }
        return countryWithLeastNotebooks;
    }

    public String getBrandWithMostNotebooks() throws SQLException {
        String brandWithMostNotebooks = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT brand FROM notebooks GROUP BY brand ORDER BY COUNT(*) DESC LIMIT 1")) {
            if (resultSet.next()) {
                brandWithMostNotebooks = resultSet.getString("brand");
            }
        }
        return brandWithMostNotebooks;
    }

    public String getBrandWithLeastNotebooks() throws SQLException {
        String brandWithLeastNotebooks = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT brand FROM notebooks GROUP BY brand ORDER BY COUNT(*) ASC LIMIT 1")) {
            if (resultSet.next()) {
                brandWithLeastNotebooks = resultSet.getString("brand");
            }
        }
        return brandWithLeastNotebooks;
    }

    public List<Notebook> getHardCoverNotebooks() throws SQLException {
        List<Notebook> hardCoverNotebooks = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM notebooks WHERE cover = 'hard'")) {
            while (resultSet.next()) {
                Notebook notebook = new Notebook();
                notebook.setId(resultSet.getInt("id"));
                notebook.setBrand(resultSet.getString("brand"));
                notebook.setName(resultSet.getString("name"));
                notebook.setPageAmount(resultSet.getInt("pageAmount"));
                notebook.setCover(resultSet.getString("cover"));
                notebook.setCountry(resultSet.getString("country"));
                notebook.setPageType(resultSet.getString("pageType"));
                hardCoverNotebooks.add(notebook);
            }
        }
        return hardCoverNotebooks;
    }

    public List<Notebook> getSoftCoverNotebooks() throws SQLException {
        List<Notebook> softCoverNotebooks = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM notebooks WHERE cover = 'soft'")) {
            while (resultSet.next()) {
                Notebook notebook = new Notebook();
                notebook.setId(resultSet.getInt("id"));
                notebook.setBrand(resultSet.getString("brand"));
                notebook.setName(resultSet.getString("name"));
                notebook.setPageAmount(resultSet.getInt("pageAmount"));
                notebook.setCover(resultSet.getString("cover"));
                notebook.setCountry(resultSet.getString("country"));
                notebook.setPageType(resultSet.getString("pageType"));
                softCoverNotebooks.add(notebook);
            }
        }
        return softCoverNotebooks;
    }

    // Добавление строки
    public void addNotebook(Notebook notebook) throws SQLException {
        String sql = "INSERT INTO notebooks (brand, name, pageAmount, cover, country, pageType) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, notebook.getBrand());
            statement.setString(2, notebook.getName());
            statement.setInt(3, notebook.getPageAmount());
            statement.setString(4, notebook.getCover());
            statement.setString(5, notebook.getCountry());
            statement.setString(6, notebook.getPageType());
            statement.executeUpdate();
        }
    }

    // Удаление строки
    public void deleteNotebook(int id) throws SQLException {
        String sql = "DELETE FROM notebooks WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    // Обновление строки
    public void updateNotebook(Notebook notebook) throws SQLException {
        String sql = "UPDATE notebooks SET brand = ?, name = ?, pageAmount = ?, cover = ?, country = ?, pageType = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, notebook.getBrand());
            statement.setString(2, notebook.getName());
            statement.setInt(3, notebook.getPageAmount());
            statement.setString(4, notebook.getCover());
            statement.setString(5, notebook.getCountry());
            statement.setString(6, notebook.getPageType());
            statement.setInt(7, notebook.getId());
            statement.executeUpdate();
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }
}