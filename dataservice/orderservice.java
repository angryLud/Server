package dataservice;


import po.orderpo;

import java.util.ArrayList;

/**
 * Created by huihantao on 2016/11/30.
 */
public interface orderservice {
    orderpo orderfindbyid(int orderid);

    ArrayList<orderpo> orderfindbyuser(int userid);

    ArrayList<orderpo> orderfindbyhotel(int hotelid);

    int orderinsert(orderpo opo);

    boolean orderupdate(orderpo opo);

}
