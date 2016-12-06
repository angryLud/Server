package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/11/30.
 */
public class orderpo implements Serializable {
    private static final long serialVersionUID=3L;


    private int orderid;
    private int userid;
    private int hotelid;
    private long createtime;
    private long executetime;
    private long delaytime;
    private int duringtime;
    private int value;
    private int status;
    private String assess;

    public orderpo(int orderid, int userid, int hotelid, long createtime, long executetime, long delaytime, int duringtime, int value, int status) {
        this.orderid = orderid;
        this.userid = userid;
        this.hotelid = hotelid;
        this.createtime = createtime;
        this.executetime = executetime;
        this.delaytime = delaytime;
        this.duringtime = duringtime;
        this.value = value;
        this.status = status;
    }

    public long getCreattime() {
        return createtime;
    }

    public long getExecutetime() {
        return executetime;
    }

    public long getDelaytime() {
        return delaytime;
    }

    public int getUserid() {
        return userid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getValue() {
        return value;
    }

    public int getDuringtime() {
        return duringtime;
    }

    public void setassess(String assess){this.assess=assess;}

    public String toString(){
        return "'"+userid+"','"+hotelid+"','"+createtime+"','"+executetime+"','"+delaytime+"','"+duringtime+"','"+value+"','"+status+"'";
    }

}
