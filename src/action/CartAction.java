package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import beans.Cart;
import logic.CartLogic;

public class CartAction extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	private String code;
	private String quantity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String aquantity) {
		this.quantity = aquantity;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = map;
	}

	public String add() throws Exception {
		Cart cart = (Cart) sessionMap.get("cart");

		if (cart == null) {
			// 初めてカートを使う
			cart = new Cart();
			sessionMap.put("cart", cart);
		}

		// CartLogicを使う
		CartLogic logic = new CartLogic(cart);
		logic.addCart(Integer.parseInt(code), Integer.parseInt(quantity));

		return "success";
	}

}
