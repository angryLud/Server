package datahelper;

/**
 * Created by huihantao on 2016/11/30.
 */
public interface order {

    String find(String type,int orderid);

    boolean insert(String values);

    boolean update(String values);


}
