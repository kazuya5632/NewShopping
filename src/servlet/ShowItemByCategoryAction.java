package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import exception.DAOException;
import logic.ItemLogic;

public class ShowItemByCategoryAction {
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		ItemLogic logic = new ItemLogic();

		// リクエストからカテゴリコード取得
		String cd = request.getParameter("category");
		int categoryCode = Integer.parseInt(cd);
		try {
			List<Item> list = logic.findByCategory(categoryCode);
			request.setAttribute("sortCode", categoryCode);
			request.setAttribute("items", list);
			return true;
		} catch (DAOException e) {
			request.setAttribute("message", "商品の取得に失敗しました");
			return false;
		}
	}
}
