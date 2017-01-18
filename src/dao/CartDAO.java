package dao;

import java.util.HashMap;
import java.util.Map;

import beans.Cart;
import beans.Item;
import logic.ItemLogic;

public class CartDAO {
	private Map<String, Cart> cart = null;

	public CartDAO() {
		cart = new HashMap<String, Cart>();
	}

	// カート追加
	public void addCart(int code) throws Exception {
		try {
			String stCode = String.valueOf(code);
			Cart shoppingCart = cart.get(stCode);
			int count;

			if (shoppingCart == null) {
				ItemLogic itemLogic = new ItemLogic();
				Item item = itemLogic.findByPrimaryKey(code);

				shoppingCart = new Cart();
				shoppingCart.setItem(item);
				shoppingCart.setCount(1);
			} else if (shoppingCart != null) {
				count = shoppingCart.getCount();
				shoppingCart.setCount(count + 1);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// カート削除
	public void deleteCart(int code) {
		cart.remove(code);
	}

	// 数量変更

}
