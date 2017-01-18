package logic;

import dao.CartDAO;
import factory.DaoFactory;

// 処理クラス
public class CartLogic {
	private CartDAO dao = DaoFactory.createCartDAO();

	// カート追加
	public void addCart(int code) throws Exception {
		dao.addCart(code);
	}

	// カート削除
	public void deleteCart(int code) {
		dao.deleteCart(code);
	}
}
