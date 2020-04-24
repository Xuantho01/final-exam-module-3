package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public List<Product> findAll();

    public void save(Product product) throws SQLException;

    public Product findByID(int id);

    public void update(int id, Product product) throws SQLException;

    public void remove(int id) throws SQLException;

    public List<Product> findProductByName(String name);
}
