package dataserviceimpl;

import datahelper.datahelperimpl.orderimpl;
import dataservice.orderservice;
import datahelper.order;
import po.orderpo;

import java.util.ArrayList;

/**
 * Created by huihantao on 2016/11/30.
 */
public class orderserviceimpl implements orderservice {
    private String values;
    private order order;

    public orderserviceimpl() {
        order=new orderimpl();
    }

    @Override
    public orderpo orderfindbyid(int orderid) {
        values=order.find("orderid",orderid);
        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        String[] s=orders[0].split(",");
        int userid=Integer.parseInt(s[1]);
        int hotelid=Integer.parseInt(s[2]);
        long createtime=Long.parseLong(s[3]);
        long executetime=Long.parseLong(s[4]);
        long delaytime=Long.parseLong(s[5]);
        int duringtime=Integer.parseInt(s[6]);
        int value=Integer.parseInt(s[7]);
        int status=Integer.parseInt(s[8]);


        return new orderpo(orderid,userid,hotelid,createtime,executetime,delaytime,duringtime,value,status);
    }

    @Override
    public ArrayList<orderpo> orderfindbyuser(int userid) {
        values=order.find("userid",userid);

        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        ArrayList<orderpo> res=new ArrayList<>();
        for(int i=0;i<orders.length;i++) {

            String[] s = orders[i].split(",");
            int orderid = Integer.parseInt(s[0]);
            int hotelid = Integer.parseInt(s[2]);
            long createtime = Long.parseLong(s[3]);
            long executetime = Long.parseLong(s[4]);
            long delaytime = Long.parseLong(s[5]);
            int duringtime = Integer.parseInt(s[6]);
            int value = Integer.parseInt(s[7]);
            int status = Integer.parseInt(s[8]);
            res.add(new orderpo(orderid,userid,hotelid,createtime,executetime,delaytime,duringtime,value,status));
        }
        return res;
    }

    @Override
    public ArrayList<orderpo> orderfindbyhotel(int hotelid) {
        values=order.find("hotelid",hotelid);
        if (values.equals("")) return  null;
        String[] orders=values.split("\\.");
        ArrayList<orderpo> res=new ArrayList<>();
        for(int i=0;i<orders.length;i++) {

            String[] s = orders[i].split(",");
            int orderid = Integer.parseInt(s[0]);
            int userid = Integer.parseInt(s[1]);
            long createtime = Long.parseLong(s[3]);
            long executetime = Long.parseLong(s[4]);
            long delaytime = Long.parseLong(s[5]);
            int duringtime = Integer.parseInt(s[6]);
            int value = Integer.parseInt(s[7]);
            int status = Integer.parseInt(s[8]);
            res.add(new orderpo(orderid,userid,hotelid,createtime,executetime,delaytime,duringtime,value,status));
        }
        return res;
    }

    @Override
    public int orderinsert(orderpo opo) {
        int orderid=(int)(1000+Math.random()*(9000));
        while (!order.insert("'"+orderid+"',"+opo)){
            orderid=(int)(1000+Math.random()*(9000));
        }

        return orderid;
    }

    @Override
    public boolean orderupdate(orderpo opo) {
        int orderid=opo.getOrderid();
        return order.insert("'"+orderid+"',"+opo);
    }
}
