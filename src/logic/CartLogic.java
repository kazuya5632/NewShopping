package logic;

import beans.Cart;
import beans.Item;
import dao.ItemDAO;
import exception.DAOException;
import factory.DaoFactory;

public class CartLogic {
    private Cart cart;

    public CartLogic(Cart cart) {
        this.cart = cart;
    }

    public void addCart(int no, int quantity) throws DAOException {
        final int MAXTOTAL = 30000;
        //delagate����@�Ϗ�����
        try {
        	// データアクセスオブジェクト
        	ItemDAO dao = DaoFactory.createItemDAO();
            Item item = dao.findByPrimaryKey(no);
            int preTotal = cart.getTotal() + item.getPrice() * quantity;
            if(0 < preTotal && preTotal < MAXTOTAL){
            cart.add(item, quantity);
            }else{
                //3���~�ȏ�͍w���ł��܂���B
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void deleatCartItem(int no) throws Exception{

        try{
            cart.delete(no);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeCartQuantity(int no, int quantity) throws Exception{
        try{
            cart.changeQuantity(no, quantity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCart() throws Exception{
        try{
            cart.removeAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
