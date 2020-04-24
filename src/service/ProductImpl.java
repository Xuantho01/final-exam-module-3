package service;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements IProduct {
    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Product product = null;
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(
                "select*from category")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount  = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

                product = new Product(id,name,price,amount,color,description,category);

                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Product product) throws SQLException {
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(
                "insert into category (name, price, amount, color, description, category) " +
                        "value (?,?,?,?,?,?)")) {
            statement.setString(1, product.getName());
            statement.setFloat(2,product.getPrice());
            statement.setInt(3,product.getAmount());
            statement.setString(4, product.getColor());
            statement.setString(5,product.getDescription());
            statement.setString(6, product.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product findByID(int id) {
        Product product = null;
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(
                "select * from category where id = ?")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount  = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

                product = new Product(id,name,price,amount,color,description,category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(int id, Product product) throws SQLException {
        try {
            PreparedStatement statement = Connect.getConnection().prepareStatement(
                    "update category set name = ?, price = ? , " +
                            "amount = ?, color = ?, description = ?, category = ? where id = ?");
            statement.setString(1, product.getName());
            statement.setFloat(2,product.getPrice());
            statement.setInt(3, product.getAmount());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getCategory());
            statement.setInt(7,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) throws SQLException {
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(
                "delete from category where id = ?")){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findProductByName(String names) {
        List<Product> list = new ArrayList<>();
       Product product = null;
        try (PreparedStatement statement = Connect.getConnection().prepareStatement
                ("select * from category where name like ? ")) {
            statement.setString(1, names + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float Price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(id, name,Price,amount,color,description,category);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
