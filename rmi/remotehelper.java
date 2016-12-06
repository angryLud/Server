package rmi;

/**
 * Created by huihantao on 2016/11/28.
 */
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class remotehelper {
    public remotehelper(){
        initServer();
    }

    public void initServer(){
        dataremoteobject dataRemoteObject;
        try {
            dataRemoteObject = new dataremoteobject();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/DataRemoteObject",
                    dataRemoteObject);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
