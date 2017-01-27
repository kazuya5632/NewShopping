package beans;

import java.io.Serializable;

public class Customer implements Serializable {
    private int no;
    private String name;
    private String tel;
    public Customer(int no, String name, String tel, String address, String mail) {
        super();
        this.no = no;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.mail = mail;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    private String address;
    private String mail;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }



}
