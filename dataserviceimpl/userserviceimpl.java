package dataserviceimpl;

import datahelper.datahelperimpl.userimpl;
import datahelper.user;
import dataservice.userservice;
import po.userpo;

import java.util.Locale;

/**
 * Created by huihantao on 2016/11/27.
 */
public class userserviceimpl implements  userservice{
    //数据库访问对象
    private user user;
    //
    private String name;
    private String number;
    private int credit;
    private String values;
    private int id;
    private char[] pass;

    public userserviceimpl(){
        user=new userimpl();
    }

    @Override
    public userpo userfind(int id) {

        values=user.find(id);
        if (values.equals("") )
            return null;

        String[] users=values.split("\\.");
        String[] s=users[0].split(",");

        //set userpo
        name=s[1];
        credit=Integer.parseInt(s[2]);
        number= s[3];
        return new userpo(id,name,credit,number);
    }

    @Override
    public int userinsert(userpo upo,char[] password) {
        name=upo.getName();
        credit=upo.getCredit();
        number=upo.getNumber();
        id=(int)(1000+Math.random()*(1000));
        values="'"+id+"','"+name+"','"+credit+"','"+number+"'";
        for(int i=0;i<password.length;i++)
            password[i]=(char)(password[i]-2);
        String log="'"+id+"','"+String.valueOf(password)+"'";
        while(!user.insert(values,log)){
            id=(int)(1000+Math.random()*(1000));
            values="'"+id+"','"+name+"','"+credit+"','"+number+"'";
            log="'"+id+"','"+String.valueOf(password)+"'";
        }
        return id;
    }

    @Override
    public boolean userupdate(userpo upo) {
        id=upo.getid();
        name=upo.getName();
        credit=upo.getCredit();
        number=upo.getNumber();
        values="'"+id+"','"+name+"','"+credit+"','"+number+"'";

        return user.update(values);


    }


    @Override
    public boolean userlogin(int id,char[] password) {
        values=user.login(id);
        pass=values.toCharArray();
        if (values.equals("")) return false;
        for(int i=0;i<pass.length-2;i++){
            if (pass[i]-password[i]!=-2 ) return false;

        }
        return true;
    }
}
