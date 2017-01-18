package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import exception.DAOException;
import logic.ItemLogic;

public class ShowAllAction {
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// パラメータは特に必要なし
		ItemLogic logic = new ItemLogic();
		try {
			List<Item> list = logic.findAll();
			request.setAttribute("items", list);
			return true;
		} catch (DAOException e) {
			request.setAttribute("message", "商品の取得に失敗しました");
			return false;
		}
	}
}
