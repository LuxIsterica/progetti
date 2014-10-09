package esecutore;

import java.io.InputStream;
 
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
 
 
public class SSHCommandExecutor {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        String host="10.16.26.117";
        String user="dromos";
        String password="Dr0mos";
        
    //    String command1="cd /opt/batch/RU/monitorDS";
   //     esegui (user, host, password, command1);
        
        String command2="/usr/ApplicazioniWeb/LUDL/infocert/dromos/LulIndexGenerator/prova.sh";
        esegui (user, host, password, command2);
    }
    
    private static void esegui (String user, String host, String pass, String comm) {
        try{
            
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(user, host, 22);
            session.setPassword(pass);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
             
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(comm);
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
              while(in.available()>0){
                int i=in.read(tmp, 0, 1024);
                if(i<0)break;
                System.out.print(new String(tmp, 0, i));
              }
              if(channel.isClosed()){
                System.out.println("exit-status: "+channel.getExitStatus());
                break;
              }
              try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
}