package service;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import utils.DatabaseConnectivity;

public class ProductDao{
	private Connection conn;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private boolean isSuccess;
	
	public ProductDao()
	{
		this.conn=DatabaseConnectivity.getDbConnection();
	}
	
	public boolean saveProduct(Product product) throws SQLException
	{
		String query="select count(*) from product";
		statement=conn.prepareStatement(query);
		resultSet=statement.executeQuery();
		if(resultSet.next())
		{
			boolean isFind=check(product);
			if(isFind)
			{
				isSuccess=false;
			}
			else
			{
				isSuccess=true;
			}
		}
		else
		{
			int row=insertProductData(product);
			if(row>0)
			{
				isSuccess=true;
			}
		}
		return isSuccess;
	}
	public int insertProductData(Product product) throws SQLException
	{
		String query="insert into product(productName,productCategory,productPrice,image_data,image_name,productDescription) values(?,?,?,?,?,?)";
		statement=conn.prepareStatement(query);
		Blob blob = conn.createBlob();
	    blob.setBytes(1, product.getImage_data());
		statement.setString(1, product.getProductName());
		statement.setString(2,product.getProductCategory());
		statement.setInt(3, product.getProductPrice());
		statement.setBlob(4, blob);
		statement.setString(5, product.getImage_name());
		statement.setString(6, product.getProductDescription());
		int row=statement.executeUpdate();
		return row;
	}
	public boolean check(Product product) throws SQLException
	{
		String query="select productName from product";
		statement=conn.prepareStatement(query);
		resultSet=statement.executeQuery();
		boolean isFind=false;
		while(resultSet.next())
		{
			String productNameFromDB=resultSet.getString("productName");
			if(product.getProductName().equals(productNameFromDB))
			{
				isFind=true;
				break;
			}
			
		}
		return isFind;
	}
	
	public List<Product> getAllProduct() throws SQLException
	{
		statement=conn.prepareStatement("select * from product");
		resultSet=statement.executeQuery();
		List<Product> listOfProduct=new ArrayList<Product>();
		while(resultSet.next())
		{
			Product product=new Product();
			product.setProductName(resultSet.getString("productName"));
			product.setProductCategory(resultSet.getString("productCategory"));
			product.setProductPrice(resultSet.getInt("productPrice"));
			product.setImage_data(resultSet.getBlob("image_data").getBytes(1, (int)resultSet.getBlob("image_data").length()));
			product.setImage_name(resultSet.getString("image_name"));
			product.setProductDescription(resultSet.getString("productDescription"));
			listOfProduct.add(product);
		}
		return listOfProduct;
		
	}
}
