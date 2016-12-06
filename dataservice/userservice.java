package dataservice;


import po.userpo;

public interface userservice {

    userpo userfind(int id);

    int userinsert(userpo upo,char[] password);

    boolean userupdate(userpo upo);

    boolean userlogin(int id,char[] password);


}


