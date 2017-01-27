package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Category;
import beans.Item;
import exception.DAOException;

// JDBC経由で商品データにアクセスするクラス
public class jdbcItemDao implements ItemDAO {
	private Connection connection;

	public jdbcItemDao(Connection connection) {
		this.connection = connection;
	}

	// 全件検索
	@Override
	public List<Item> findAll() throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		List<Item> list = new ArrayList<Item>();
		try {
			String sql = "select * from item order by code";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				int category_code = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(code, category_code, name, price);
				list.add(item);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
			/*
			 * } finally { try { if (statement != null) { rs.close();
			 * connection.close(); } } catch (Exception e) { }
			 */
		}
		return list;
	}

	// 商品名検索
	@Override
	public List<Item> findByName(String itemName) throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		List<Item> list = new ArrayList<Item>();
		try {
			String sql = "select * from item where name like ? order by code";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + itemName + "%");
			rs = statement.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				int category = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(code, category, name, price);
				list.add(item);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
		return list;
	}

	// 主キー検索
	@Override
	public Item findByPrimaryKey(int key) throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		Item item = null;
		try {
			String sql = "select * from item where code = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, key);
			rs = statement.executeQuery();

			if (rs.next()) {
				int code = rs.getInt("code");
				int category = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				item = new Item(code, category, name, price);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
		return item;
	}

	// カテゴリ検索
	@Override
	public List<Item> findByCategory(int category_code) throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		List<Item> list = new ArrayList<Item>();
		try {
			String sql = "select * from item where category_code like ? order by code";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + category_code + "%");
			rs = statement.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				int category = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(code, category, name, price);
				list.add(item);
			}
			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
		return list;
	}

	// 商品更新
	@Override
	public void updateItem(Item item) throws DAOException {
		PreparedStatement statement = null;
		try {
			String sql = "update Item set category_code = ?, name = ?, price = ? where code = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, item.getCategory_code());
			statement.setString(2, item.getName());
			statement.setInt(3, item.getPrice());
			statement.setInt(4, item.getCode());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
	}

	// 商品削除
	@Override
	public void deleteItem(int code) throws DAOException {
		PreparedStatement statement = null;
		try {
			String sql = "delete from Item where code = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, code);
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
	}

	// 商品追加
	@Override
	public void addItem(Item item) throws DAOException {
		PreparedStatement statement = null;
		try {
			String sql = "insert into Item (category_code, name, price) values (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, item.getCategory_code());
			statement.setString(2, item.getName());
			statement.setInt(3, item.getPrice());
			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
		}
	}

	// カテゴリ全件取得
	public List<Category> findAllCategory() throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select * from category order by code";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				Category category = new Category(code, name);
				list.add(category);
			}

			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
			/*
			 * } finally { try { if (statement != null) { rs.close();
			 * connection.close(); } } catch (Exception e) { }
			 */
		}
		return list;
	}

	// ソート
	@Override
	public List<Item> sortColumn(String category_code, String sort, String sortPattern) throws DAOException {
		ResultSet rs = null;
		PreparedStatement statement = null;
		List<Item> list = new ArrayList<Item>();
		String sql = "";
		try {
			if (category_code.equals("")) {
				// 全件検索後のソート
				sql = "select * from item order by " + sort + " " + sortPattern;
				statement = connection.prepareStatement(sql);
			} else {
				// カテゴリ検索後のソート
				int categoryCode = Integer.parseInt(category_code);
				sql = "select * from item where category_code = ? order by " + sort + " " + sortPattern;
				statement = connection.prepareStatement(sql);
				statement.setInt(1, categoryCode);
			}
			rs = statement.executeQuery();

			while (rs.next()) {
				int code = rs.getInt("code");
				int categoryCode = rs.getInt("category_code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Item item = new Item(code, categoryCode, name, price);
				list.add(item);
			}

			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new DAOException();
			/*
			 * } finally { try { if (statement != null) { rs.close();
			 * connection.close(); } } catch (Exception e) { }
			 */
		}
		return list;
	}
}
