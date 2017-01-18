package controller;

import java.util.List;

import beans.Item;

public class ShowItem {

	public ShowItem(List<Item> list) {
		for (Item item : list) {
			System.out.println("商品コード:" + item.getCode());
			System.out.println("商品名:" + item.getName());
			System.out.println("商品カテゴリ:" + item.getCategory_code());
			System.out.println("商品価格:" + item.getPrice());
		}
	}
}
