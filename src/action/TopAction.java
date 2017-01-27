package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import beans.Category;
import exception.DAOException;
import logic.ItemLogic;

public class TopAction implements ApplicationAware {
	private Map<String, Object> categoryList;

	public Map<String, Object> getMap() {
		return categoryList;
	}

	public void setMap(Map<String, Object> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public void setApplication(Map<String, Object> categoryList) {
		this.categoryList = categoryList;
	}

	public String top() {
		// パラメータは特になし
		// カテゴリが必要
		ItemLogic logic = new ItemLogic();
		try {
			List<Category> list = logic.searchAllCategory();
			categoryList.put("category", list);
			return "success";
		} catch (DAOException e) {
			categoryList.put("message", "カテゴリの取得に失敗しました");
			return "failure";
		}
	}

}
