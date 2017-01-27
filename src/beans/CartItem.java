package beans;

public class CartItem extends Item {
    private int quantity;

    public CartItem(int no, String name, int categoryNo, String categoryName, int price, int quantity) {
        super(no, name, categoryNo, price, categoryName);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem() {
        super();
    }

}
