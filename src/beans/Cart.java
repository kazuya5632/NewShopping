package beans;

import java.io.Serializable;

public class Cart implements Serializable {
	private Item item;
	private int count;

	public Cart() {
		super();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAmount() {
		return (item.getPrice() * count);
	}

}
