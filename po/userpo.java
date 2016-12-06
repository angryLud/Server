package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/11/27.
 */
public class userpo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int credit;
    private String number;
    private int id;

    public userpo(int id,String name,int credit,String number){
        this.id=id;
        this.name=name;
        this.credit=credit;
        this.number=number;
    }


    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getNumber() {
        return number;
    }

    public int getid() {
        return id;
    }



}
