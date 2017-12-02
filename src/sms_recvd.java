/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import classes.mainclass;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;
import com.sun.mail.imap.IMAPFolder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.net.URLConnection;
import java.net.URL; 
/**
 *
 * @author Akshat
 */
public class sms_recvd extends javax.swing.JFrame {
    
    
    String fullMssg = "";
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost/movies";

   //  Database credentials
        String USER = "root";
        String PASS = "goodluck";

    /**
     * Creates new form sms_recvd
     */
    public sms_recvd() throws MessagingException,IOException{
        super("SMS BOOKING");
        initComponents();
        
        mainclass.bookingMode ="SMS";
        
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flag flag = null;
        try 
        {
          Properties props = System.getProperties();
          props.setProperty("mail.store.protocol", "imaps");

          Session session = Session.getDefaultInstance(props, null);

          store = session.getStore("imaps");
          store.connect("imap.gmail.com","akshattrivedi50@gmail.com", "8962836216");

          //folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work for other email account
          folder = (IMAPFolder) store.getFolder("Inbox"); //This works for both email account


          if(!folder.isOpen())
            folder.open(Folder.READ_WRITE);
          Message[] messages = folder.getMessages();
          System.out.println("No of Messages : " + folder.getMessageCount());
          System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
          System.out.println(messages.length);
          for (int i=(messages.length-1); i >=(messages.length-10);i--) 
          {

            System.out.println("*****************************************************************************");
            System.out.println("MESSAGE " + (i + 1) + ":");
            Message msg =  messages[i];
            //System.out.println(msg.getMessageNumber());
            //Object String;
            //System.out.println(folder.getUID(msg)
            String reqdSubject = "Text local SMS Received (Akshat)";
            subject = msg.getSubject(); 
            if(subject.compareTo(reqdSubject) == 0)
            {    
                System.out.println("Subject: " + subject);
                System.out.println("From: " + msg.getFrom()[0]);
                System.out.println("To: "+msg.getAllRecipients()[0]);
                System.out.println("Date: "+msg.getReceivedDate());
                mainclass.smsDate = msg.getReceivedDate();
//                System.out.println("Size: "+msg.getSize());
                System.out.println("Flag"+msg.getFlags());
//                System.out.println("Body: \n"+ msg.getContent());
//                System.out.println(msg.isMimeType((String)msg.getContent()));
                MimeMultipart mm = (MimeMultipart)msg.getContent();
//                String bodyp = mm.getPreamble();
//                System.out.println("Message Content Type:"+msg.getContent().toString());
                Object bodyp = null;
                try {
                    bodyp = msg.getContent();
                } catch (MessagingException ex) {
//                    Logger.getLogger(ReadMailNew.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (bodyp instanceof String) {
                    String body = (String) bodyp;
                    

                } else if (bodyp instanceof Multipart) {
                    try {
                        Multipart mp = (Multipart) msg.getContent();
                        int mp_count = mp.getCount();
                        BufferedReader br;

          
                        br = new BufferedReader(new InputStreamReader(mp.getBodyPart(0).getInputStream()));
                        String str;
                        while((str = br.readLine()) != null){
                            System.out.println(str);
                            mainclass.smsRecvd = str;
                        }
                            
                        
                        System.out.println("Multipart!" + mp_count);
                    } catch (Exception ex) {
                        System.out.println("Exception arise at get Content");
                        ex.printStackTrace();
                    }
                }
            }
            break;
          }
        }
        finally 
        {
          if (folder != null && folder.isOpen()) { folder.close(true); }
          if (store != null) { store.close(); }
        }
        
        String seatClass = "";
        String time = "";
        String movieName = "";
        String timeMain = "";
        fullMssg = mainclass.smsRecvd;
        System.out.println(fullMssg);
        String empty = " ";
        String temp[] = new String[10];
        int x = 0;
        int y = 0;
        int len = fullMssg.length() - 1;
//        for(int i=0 ; i<fullMssg.length(); i++)
//        {
//            if(fullMssg.charAt(i)== empty.charAt(0) || i == len)
//            {
//                i++;
//                System.out.println("i value : "+i );
//                temp[y] = fullMssg.substring(x,i);
//                System.out.println("Each String:"+temp[y]);
//                x = i;
//                y++;
//            }
//        }
        String data[] = fullMssg.split(" ");
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
        
        
        System.out.println("DATA[3]:<"+data[3]+">");
        if(data[3] instanceof String)
        {
            System.out.println("Hello");
        }
        else
        {
            System.out.println("Something Wrong");
        }
//        data[3]="1500";
//        String check ="1500";
  
        if(data[3].matches("0900"))
        {
            time = "09:00 am";
            timeMain = "0900";
        }
        else if(data[3].matches("1200"))
        {
            time = "12:00 pm";
            timeMain = "1200";
        }
        else if(data[3].matches("1500"))
        {
            time = "03:00 pm";
            timeMain = "1500";
        }
        else if(data[3].matches("1800"))
        {
            time = "06:00 pm";
            timeMain = "1800";
        }
        else if(data[3].matches("2100"))
        {
            time = "09:00 pm";
            timeMain = "2100";
        }
        mainclass.time_booked = time;
        mainclass.timeInt = Integer.parseInt(timeMain);
        
        if(data[4].matches("SPI"))
        {
            movieName = "Spiderman";
        }
        else if(data[4].matches("DUN"))
        {
            movieName = "Dunkirk";
        }
        else if(data[4].matches("BAB"))
        {
            movieName = "Baby Driver";
        }
        else if(data[4].matches("WON"))
        {
            movieName = "Wonderwoman";
        }
        else if(data[4].matches("LOG"))
        {
            movieName = "Logan";
        }
        else if(data[4].matches("ANN"))
        {
            movieName = "Annabelle";
        }
        else if(data[4].matches("DAN"))
        {
            movieName = "Dangal";
        }
        else if(data[4].matches("BAA"))
        {
            movieName = "Baahubali";
        }
        mainclass.selected_movie = movieName;
        
        if(data[6].matches("G"))
            seatClass = "GOLD";
        else if(data[6].matches("S"))
            seatClass = "SILVER";
        
        
        
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

          //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");
 
           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
 
           // Extract records without any condition.
           System.out.println("Fetching records without condition...");
           System.out.println("MOVIE_NAME:"+mainclass.selected_movie);
           System.out.println("TIME:"+mainclass.time_booked);
           String sql = "SELECT * FROM SCREEN_MOVIE_MAP WHERE MOVIE_NAME ='"+mainclass.selected_movie+"' AND TIME='"+mainclass.time_booked+"'";
             try (ResultSet rs = stmt.executeQuery(sql)) {
                 while(rs.next()){
                     //Retrieve by column name
                     System.out.println("HI Result String");
                     String t = rs.getString("time");
                     String sno = rs.getString("screen_no");
                     //Display values
                     System.out.println("TIME WHEN OK BUTTON IS PRESSED : "+t);
                     System.out.println("SCREEN NO WHEN OK BUTTON IS PRESSED : "+sno);
    //                 lbt.setText(t);
    //                 lbsno.setText(sno);
                     mainclass.final_screen_no = sno;
                 } }
        }catch(SQLException | ClassNotFoundException se){
            //Handle errors for JDBC

        }
            //Handle errors for Class.forName
             finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                  conn.close();
           }catch(SQLException se){
           }// do nothing
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
           }//end finally try
        }//end try
        
        txtpno.setEditable(false);
        txtname.setEditable(false);
        txttime.setEditable(false);
        txtmname.setEditable(false);
        txtnot.setEditable(false);
        txtsno.setEditable(false);
        btsend.setEnabled(false);
        lbstatus.setVisible(false);
        
        txtpno.setText(data[0]);
        txtname.setText(data[2]);
        txttime.setText(time);
        txtmname.setText(movieName);
        txtnot.setText(data[5]);
        txtclass.setText(seatClass);
        txtsno.setText(mainclass.final_screen_no);
        
        mainclass.selected_movie = movieName;
        mainclass.finalTicketCount = data[5];
        mainclass.timeInt = Integer.parseInt(timeMain);
        mainclass.custName = data[2];
        mainclass.custPh = data[0].substring(2);
        mainclass.finalTicketCount = data[5];
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtmname = new javax.swing.JTextField();
        txttime = new javax.swing.JTextField();
        txtnot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtclass = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btsend = new javax.swing.JButton();
        lbstatus = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Trajan Pro 3", 1, 48)); // NOI18N
        jLabel1.setText("SMS REQUEST");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 75, -1, 61));

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel2.setText("NAME:");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 191, -1, -1));

        jLabel3.setBackground(new java.awt.Color(153, 204, 255));
        jLabel3.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel3.setText("MOVIE NAME:");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 303, -1, -1));

        jLabel4.setBackground(new java.awt.Color(153, 204, 255));
        jLabel4.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel4.setText("TIME:");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 359, -1, -1));

        jLabel5.setBackground(new java.awt.Color(153, 204, 255));
        jLabel5.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel5.setText("NUMBER OF TICKETS:");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 415, -1, -1));

        txtname.setBackground(new java.awt.Color(153, 204, 255));
        txtname.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 188, 300, -1));

        txtmname.setBackground(new java.awt.Color(153, 204, 255));
        txtmname.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtmname, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 300, 300, -1));

        txttime.setBackground(new java.awt.Color(153, 204, 255));
        txttime.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txttime, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 356, 300, -1));

        txtnot.setBackground(new java.awt.Color(153, 204, 255));
        txtnot.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtnot, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 412, 300, -1));

        jLabel6.setBackground(new java.awt.Color(153, 204, 255));
        jLabel6.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel6.setText("PHONE NUMBER:");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 247, -1, -1));

        txtpno.setBackground(new java.awt.Color(153, 204, 255));
        txtpno.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 244, 300, -1));

        jLabel7.setBackground(new java.awt.Color(153, 204, 255));
        jLabel7.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel7.setText("CLASS:");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 474, -1, -1));

        txtclass.setBackground(new java.awt.Color(153, 204, 255));
        txtclass.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 471, 300, -1));

        jLabel8.setBackground(new java.awt.Color(153, 204, 255));
        jLabel8.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel8.setText("SCREEN NUMBER:");
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 530, -1, -1));

        txtsno.setBackground(new java.awt.Color(153, 204, 255));
        txtsno.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        getContentPane().add(txtsno, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 527, 300, -1));

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jButton1.setText("BOOK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 594, 126, 82));

        btsend.setBackground(new java.awt.Color(153, 204, 255));
        btsend.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        btsend.setText("SEND SMS");
        btsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsendActionPerformed(evt);
            }
        });
        getContentPane().add(btsend, new org.netbeans.lib.awtextra.AbsoluteConstraints(752, 594, 204, 82));

        lbstatus.setBackground(new java.awt.Color(153, 204, 255));
        lbstatus.setFont(new java.awt.Font("Trajan Pro 3", 1, 18)); // NOI18N
        lbstatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbstatus.setOpaque(true);
        getContentPane().add(lbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, 170, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/back_lights.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1386, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        btsend.setEnabled(true);
        new seat_mapping().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsendActionPerformed
        // TODO add your handling code here:
        lbstatus.setVisible(true);
        String message = mainclass.smsSend ;
        String phone = mainclass.custPh ;
        try {
            URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=7000079368&Password=goodluck&Message="+message+"&To="+phone+"&Key=aksha4XHC7a3Ytwsql2mevLO");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response="";
            while ((i = stream.read()) != -1) {
                response+=(char)i;
            }
            if(response.contains("success")){
                System.out.println("Successfully send SMS");
                lbstatus.setText("SMS SUCCESS!");
                //your code when message send success
            }else{
                System.out.println(response);
                lbstatus.setText("SMS FAILED!");
                //your code when message not send
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btsendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sms_recvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sms_recvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sms_recvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sms_recvd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new sms_recvd().setVisible(true);
                } catch (MessagingException ex) {
                    Logger.getLogger(sms_recvd.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(sms_recvd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
    }
    
     public void writeTo(OutputStream out) throws IOException, MessagingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsend;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbstatus;
    private javax.swing.JTextField txtclass;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnot;
    private javax.swing.JTextField txtpno;
    private javax.swing.JTextField txtsno;
    private javax.swing.JTextField txttime;
    // End of variables declaration//GEN-END:variables
}
