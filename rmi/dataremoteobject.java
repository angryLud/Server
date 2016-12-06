package rmi;

/**
 * Created by huihantao on 2016/11/28.
 */
import dataservice.userservice;
import dataserviceimpl.userserviceimpl;
import po.userpo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class dataremoteobject extends UnicastRemoteObject implements userservice {

    private static final long serialVersionUID = 4029039744279087114L;

    private userservice userserve;
    public dataremoteobject() throws RemoteException{
        userserve=new userserviceimpl();
    }


    @Override
    public userpo userfind(int id) {return userserve.userfind(id);
    }

    @Override
    public int userinsert(userpo upo, char[] password) {
        return userserve.userinsert(upo,password);
    }

    @Override
    public boolean userupdate(userpo upo) {return userserve.userupdate(upo);}

    @Override
    public boolean userlogin(int id, char[] password) {
        return userserve.userlogin(id,password);
    }
}
