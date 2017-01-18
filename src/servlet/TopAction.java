package servlet;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Category;
import exception.DAOException;
import logic.ItemLogic;

public class TopAction {
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		//パラメータは特になし
		// カテゴリが必要
		ItemLogic logic = new ItemLogic();
		try{
		List<Category> list = logic.searchAllCategory();
		ServletContext application = request.getServletContext();
		application.setAttribute("category", list);
		return true;
		} catch(DAOException e) {
			request.setAttribute("message", "カテゴリの取得に失敗しました");
			return false;
		}
	}
}
