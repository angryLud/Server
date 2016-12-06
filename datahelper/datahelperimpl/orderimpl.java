package datahelper.datahelperimpl;

import datahelper.order;

/**
 * Created by huihantao on 2016/11/30.
 */
public class orderimpl implements order {


    private runner run;
    public orderimpl(){
        run=new runner();
    }


    @Override
    public String find(String type,int orderid) {
        String sql="SELECT * FROM order WHERE "+type+"="+orderid;
        return run.read(sql);
    }

    @Override
    public boolean insert(String values) {
        String sql="INSERT INTO order(orderid,userid,hotelid,createtime,executetime,delaytime,duringtime,value,status) VALUES("+values+");";
        int i=run.write(sql);
        return (i==1);
    }

    @Override
    public boolean update(String values) {
        String sql="REPLACE INTO order(orderid,userid,hotelid,createtime,executetime,delaytime,duringtime,value,status) VALUES("+values+");";
        int i=run.write(sql);
        return (i==2);
    }
}
