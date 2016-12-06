package datahelper.datahelperimpl;

/**
 * Created by huihantao on 2016/11/28.
 */
import datahelper.user;

public class userimpl implements user {
    private runner run;


    public userimpl(){
        run=new runner();
    }


    @Override
    public String find(int id){
        String sql="SELECT * FROM user WHERE id="+id;
        return run.read(sql);
    }

    @Override
    public boolean insert(String values,String log){
        String sql1="INSERT INTO user(id, name ,credit,number) VALUES("+values+");";
        String sql2="INSERT INTO login(id, password) VALUES("+log+");";
        int i=run.write(sql1);
        System.out.println(sql1);
        int j=run.write(sql2);

        return (i==1)&&(j==1);
    }

    @Override
    public boolean update(String values) {

        String sql="REPLACE  INTO user(id, name ,credit,number) VALUES("+values+");";
        int i=run.write(sql);
        return (i==2);
    }

    @Override
    public String login(int id) {
        String sql="SELECT password FROM login WHERE id="+id;

        return run.read(sql);

    }


}
