package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import exception.DAOException;
import logic.ItemLogic;

public class SortShowAction {
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		ItemLogic logic = new ItemLogic();
		
		// sortパターン取得
		String categoryCode = request.getParameter("category_code");
		String sort = request.getParameter("sort");
		String sortPattern = request.getParameter("sort_pattern");
		try {
			List<Item> list = logic.sortColumn(categoryCode, sort, sortPattern);
			request.setAttribute("items", list);
			request.setAttribute("sortCode", categoryCode);
			return true;
		} catch (DAOException e) {
			request.setAttribute("message", "商品の取得に失敗しました");
			return false;
		}
	}
}
