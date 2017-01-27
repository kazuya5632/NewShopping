package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import beans.Item;
import exception.DAOException;
import logic.ItemLogic;

public class ShowItemAction implements RequestAware {
	private Map<String, Object> map;
	private String categoryCode;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Map<String, Object> getmap() {
		return map;
	}

	public void setmap(Map<String, Object> map) {
		this.map = map;
	}

	@Override
	public void setRequest(Map<String, Object> map) {
		this.map = map;
	}

	public String showAll() {
		// パラメータは特に必要なし
		ItemLogic logic = new ItemLogic();
		try {
			List<Item> list = logic.findAll();
			map.put("items", list);
			return "success";
		} catch (DAOException e) {
			map.put("message", "商品の取得に失敗しました");
			return "failure";

		}
	}

	public String showItemByCategory() {
		ItemLogic logic = new ItemLogic();

		// リクエストからカテゴリコード取得
		int cd = Integer.parseInt(categoryCode);
		try {
			List<Item> list = logic.findByCategory(cd);
			map.put("sortCode", cd);
			map.put("items", list);
			return "success";
		} catch (DAOException e) {
			map.put("message", "商品の取得に失敗しました");
			return "failure";
		}
	}

}
