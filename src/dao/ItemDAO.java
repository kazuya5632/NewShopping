package dao;

import java.util.List;

import beans.Category;
import beans.Item;
import exception.DAOException;

// 商品データにアクセスするインターフェース
public interface ItemDAO {
	// 商品追加
	abstract void addItem(Item item) throws DAOException;

	// 全商品
	abstract List<Item> findAll() throws DAOException;

	// 商品削除
	abstract void deleteItem(int code) throws DAOException;

	// 商品更新
	abstract void updateItem(Item item) throws DAOException;

	// 商品名で検索
	abstract List<Item> findByName(String itemName) throws DAOException;

	// 主キーで検索
	abstract Item findByPrimaryKey(int key) throws DAOException;

	// カテゴリで検索
	abstract List<Item> findByCategory(int category_code) throws DAOException;

	// カテゴリ全件取得
	abstract List<Category> findAllCategory() throws DAOException;
}