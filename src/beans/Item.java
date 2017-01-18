
package beans;

import java.io.Serializable;

public class Item implements Serializable{
	private int code;
	private String name;
	private int price;
	private int category_code;


	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 自動生成されたメソッド・スタブ
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "code:" + code + " category_code:" + category_code + " name:" + name + " price:" + price;
	}

	public Item() {
		super();
	}

	public Item(int code, int category_code, String name, int price) {
		super();
		this.code = code;
		this.category_code = category_code;
		this.name = name;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
