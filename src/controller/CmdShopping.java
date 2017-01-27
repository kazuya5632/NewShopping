package controller;

import java.util.List;
import java.util.Scanner;

import beans.Item;
import exception.DAOException;
import logic.ItemLogic;

public class CmdShopping {

	public static void main(String[] args) {
		int no;
		boolean end = false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("input command(1-all or 2-category or 0-quit");
			no = scan.nextInt();
			switch (no) {
			case 1: // 全データ表示
				try {
					ItemLogic logic = new ItemLogic();
					List<Item> list = logic.findAll();
					ShowItem show = new ShowItem(list);
				} catch (DAOException e) {
					e.printStackTrace();
					ShowError se = new ShowError("データの取得に失敗しました");
				}
				break;
			case 2: // カテゴリ検索
				System.out.println("input category code:");
				int categoryCode = scan.nextInt();
				try {
					ItemLogic logic = new ItemLogic();
					List<Item> list = logic.findByCategory(categoryCode);
					ShowItem show = new ShowItem(list);
				} catch (DAOException e) {
					e.printStackTrace();
					ShowError se = new ShowError("データの取得に失敗しました");
				}
				break;
			case 0:
				end = true;
				break;
			default:
			}
		} while (!end);
		System.out.println("終了");
	}
}
