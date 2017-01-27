package beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //����������
    private List<CartItem> list = new ArrayList<CartItem>();
    //���i�̖��O�ƌ��̏��
    private int total = 0;

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean add(Item item, int quantity) {

        //���łɓ���Item�������Ă���Ƃ��A���݂̂𑝂₳�Ȃ��Ƃ����Ȃ��I�I�I�I

        int addItemNo = item.getCode();
        String addItemName = item.getName();
        int addCategoryNo = item.getCategory_code();
        String addCaegoryName = item.getCategoryName();
        int addPrice = item.getPrice();

        CartItem cartItem;

//        int preTotal = total + addPrice * quantity;
//        if (preTotal < 0 || 30000 < preTotal) {
//            return false;
//        }

        if (list.isEmpty() == true) {
            cartItem = new CartItem(addItemNo, addItemName, addCategoryNo, addCaegoryName, addPrice,
                    quantity);
            list.add(cartItem);

            int subTotal = cartItem.getPrice() * cartItem.getQuantity();
            total = total + subTotal;
        } else {

            //���݃J�[�g�ɓ����Ă��鏤�i�ɒǉ����鏤�i�Ɠ������̂����邩�m�F
            //����ꍇ�́A���̂ݍX�V
            int flg = 0;
            for (CartItem cItem : list) {
                int cItemNo = cItem.getCode();
                if (cItemNo == addItemNo) {
                    cItem.setQuantity(cItem.getQuantity() + quantity);
                    flg = 1;
                }
                int subTotal = cItem.getPrice() * cItem.getQuantity();
                total = total + subTotal;
            }
            if (flg == 0) {
                //�Ȃ��ꍇ�́A�����������ɏ��i���ƍw������ǉ�
                cartItem = new CartItem(addItemNo, addItemName, addCategoryNo, addCaegoryName, addPrice,
                        quantity);
                list.add(cartItem);
                total = total + addPrice * quantity;
            }
        }
        return true;

    }

    public void delete(int no) {
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                CartItem cItem = list.get(i);
                int cItemNo = cItem.getCode();
                if (cItemNo == no) {
                    //��s����
                    list.remove(i);
                    //���v���o��
                    total = total - cItem.getPrice() * cItem.getQuantity();
                }
            }
            //�J�[�g�ɊY�����i���Ȃ��ꍇ�́A�J�[�g�ɊY���̏��i���ǉ�����Ă��܂���B���b�Z�[�W
        } else {
            //�J�[�g�ɏ��i������܂���B���b�Z�[�W
        }
    }

    public boolean changeQuantity(int no, int newQuantity) {
        //�J�[�g�ɏ��i�����邩�m�F
        //����΁A�Y�����i��T��
        for (int i = 0; i < list.size(); i++) {

            int cItemNo = list.get(i).getCode();
            //�Y�����i��������������X�V����
            if (cItemNo == no) {
                //�X�V��������v���X�̐����m�F
                if (newQuantity > 0) {
                    int preTotal = total - list.get(i).getPrice() * list.get(i).getQuantity();
                    list.get(i).setQuantity(newQuantity);
                    total = total + list.get(i).getPrice() * newQuantity;
                    if (preTotal < 0 || 30000 < preTotal) {
                        return false;
                    }
                    total = total - list.get(i).getPrice() * list.get(i).getQuantity();
                    //�v���X��������X�V
                    list.get(i).setQuantity(newQuantity);
                    total = total + list.get(i).getPrice() * newQuantity;
                } else if (newQuantity == 0) {
                    //0�������珤�i���Ə���
                    list.remove(i);
                } else {
                    //�}�C�i�X��������
                    //���̓v���X�̐��ł��肢�B���b�Z�[�W
                }
            }

        }
        return true;
        //�J�[�g�ɏ��i���Ȃ�������
        //�J�[�g�ɏ��i������܂���B���b�Z�[�W
    }

    public void removeAll() {
        list.clear();
        total = 0;
    }

}
