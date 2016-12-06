package datahelper;

import datahelper.datahelperimpl.runner;

/**
 * Created by huihantao on 2016/11/28.
 */
public interface user {
//    用户信息查询
    String find(int id);

//    用户信息插入
    boolean insert(String values,String log);

//    用户信息更改
    boolean update(String values);

    String login(int id);


}
