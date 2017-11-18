
import classes.mainclass;
import javax.swing.ImageIcon;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshat
 */
public class seat_mapping extends javax.swing.JFrame {
    String[] seatIcon = {"vacant.jpg","clicked_icon.jpg","booked.jpg"};
    ImageIcon[] images;
    String seat_arr[] = new String[20];                                         //BOOKED SEATS
    String seat_clicked[] = new String[20];                                     //SEATS CLICKED INDEX WHILE BOOKING
    int ccount = 0;                                                             //CURRENT COUNT OF TICKETS WHILE SELECTING
    String total_count = mainclass.finalTicketCount;
    int ticket_count = Integer.valueOf(total_count);
    String details = " "+ccount+"/"+ticket_count;
    
    
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/movies";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "goodluck";
    /**
     * Creates new form seat_mapping
     */
    public seat_mapping() {
        super("SEATS");
        System.out.println("\n\nTICKET COUNTER:("+ccount+","+ticket_count+") \n\n");
        images = new ImageIcon[seatIcon.length];
        Integer[] intArray = new Integer[seatIcon.length];
        for (int i = 0; i < seatIcon.length; i++) {
            intArray[i] = i;
            images[i] = createImageIcon("seat images/" + seatIcon[i]);
            if (images[i] != null) {
                images[i].setDescription(seatIcon[i]);
            }
        }
        initComponents();
        
        
        
        Connection conn = null;
        Statement stmt = null;
    try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      int j = 0;

      //STEP 3: Open a connection
      System.out.println("Connecting to a MOVIES/SEAT_INFO database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected MOVIES/SEAT_INFO successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM seat_info si , screen_details sd where sd.screen_no="+mainclass.final_screen_no+" and sd.movie_name='"+mainclass.selected_movie+"' and sd.time="+mainclass.timeInt+" and si.sid=sd.sid";
      ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
        String bookedSeats = rs.getString("seat_number");
        String empty = " ";

         //Display values
         
        System.out.println("SEAT NUMBERS LIST:" + bookedSeats);
        
        if(bookedSeats.length()>3)                                              //SELECTING STRING OF SEATS ONE BY ONE FOR FINDING PARTICULAR SEAT
        {
            
            System.out.println("Booked Seats length: "+bookedSeats.length());
            
            for(int k=0;k<bookedSeats.length();k++)
            {
                //System.out.println("WE ARE HERE: "+bookedSeats.charAt(k));
                if(bookedSeats.charAt(k)== empty.charAt(0))
                {
                    if(k<4)
                    {
                        seat_arr[j] = bookedSeats.substring(0,k);
                        System.out.println("seat array(0) = "+seat_arr[j]);
                        j++;
                    }
                    
                    //System.out.println("WE ARE HERE 2: "+bookedSeats.charAt(k));
                    //System.out.println("Value of K= "+k);
                    int l=0;
                    while(((k+l)<(bookedSeats.length()-1)) && (bookedSeats.charAt(k+l+1)!=empty.charAt(0)))
                    {
                      //  System.out.println("L= "+l);
                        //System.out.println("Inside loop: "+bookedSeats.charAt(k+l+1));
                        
                        l++;
                      
                    }
                    seat_arr[j] = bookedSeats.substring(k+1, k+l+1);
                    System.out.println("seat array("+j+") = "+seat_arr[j]);
                    j++;
                    //System.out.println("HERE HERE HERE !!");
                }
            }
        }
        else{
         
            seat_arr[j] = bookedSeats;
            System.out.println("seat array("+j+") = "+seat_arr[j]);
            j++;
        }
      }
            rs.close();
   }catch(  SQLException | ClassNotFoundException se){
                //Handle errors for JDBC
                System.out.println("SQL Exception at seat_mapping contructor:" +se);
   }
            //Handle errors for Class.forName
            finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
          System.out.println("SQL Exception at seat_mapping contructor:" +se);
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
    System.out.println("\n\n\n\n");
   
    for(int n=0;n<20;n++)
   {
       if(seat_arr[n] != null)
       {
       System.out.println("SEAT NUMBER ["+n+"] = "+seat_arr[n]);
       switch(seat_arr[n])
       {
            case "S1" :
                s1.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s1.setIcon(images[2]);
            break;
            case "S2" :
                s2.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s2.setIcon(images[2]);
            break;
            case "S3" :
                s3.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s3.setIcon(images[2]);
            break;
            case "S4" :
                s4.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s4.setIcon(images[2]);
            break;
            case "S5" :
                s5.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s5.setIcon(images[2]);
            break;
            case "S6" :
                s6.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s6.setIcon(images[2]);
            break;
            case "S7" :
                s7.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s7.setIcon(images[2]);
            break;
            case "S8" :
                s8.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s8.setIcon(images[2]);
            break;
            case "S9" :
                s9.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s9.setIcon(images[2]);
            break;
            case "S10" :
                s10.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                s10.setIcon(images[2]);
            break;
            case "G1" :
                g1.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g1.setIcon(images[2]);
            break;
            case "G2" :
                g2.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g2.setIcon(images[2]);
            break;
            case "G3" :
                g3.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g3.setIcon(images[2]);
            break;
            case "G4" :
                g4.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g4.setIcon(images[2]);
            break;
            case "G5" :
                g5.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g5.setIcon(images[2]);
            break;
            case "G6" :
                g6.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g6.setIcon(images[2]);
            break;
            case "G7" :
                g7.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g7.setIcon(images[2]);
            break;
            case "G8" :
                g8.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g8.setIcon(images[2]);
            break;
            case "G9" :
                g9.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g9.setIcon(images[2]);
            break;
            case "G10" :
                g10.setEnabled(false);
                images[2] = createImageIcon("seat images/"+ seatIcon[2]);
                g10.setIcon(images[2]);
            break;
            default:
            break;
                   
       }
       }
       
   }
    System.out.println("Goodbye SEATS MAP!");
    lbcount.setText(details);
    submit.setEnabled(false);
    
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
        g1 = new javax.swing.JButton();
        g2 = new javax.swing.JButton();
        g3 = new javax.swing.JButton();
        g4 = new javax.swing.JButton();
        g5 = new javax.swing.JButton();
        g6 = new javax.swing.JButton();
        g7 = new javax.swing.JButton();
        g8 = new javax.swing.JButton();
        g9 = new javax.swing.JButton();
        g10 = new javax.swing.JButton();
        s6 = new javax.swing.JButton();
        s7 = new javax.swing.JButton();
        s8 = new javax.swing.JButton();
        s1 = new javax.swing.JButton();
        s9 = new javax.swing.JButton();
        s10 = new javax.swing.JButton();
        s2 = new javax.swing.JButton();
        s3 = new javax.swing.JButton();
        s4 = new javax.swing.JButton();
        s5 = new javax.swing.JButton();
        lbcount = new javax.swing.JLabel();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trajan Pro 3", 3, 48)); // NOI18N
        jLabel1.setText("SEATS");

        jLabel2.setText("GOLD");

        jLabel3.setText("SILVER");

        g1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g1ActionPerformed(evt);
            }
        });

        g2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g2ActionPerformed(evt);
            }
        });

        g3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g3ActionPerformed(evt);
            }
        });

        g4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g4ActionPerformed(evt);
            }
        });

        g5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g5ActionPerformed(evt);
            }
        });

        g6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g6ActionPerformed(evt);
            }
        });

        g7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g7ActionPerformed(evt);
            }
        });

        g8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g8ActionPerformed(evt);
            }
        });

        g9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g9ActionPerformed(evt);
            }
        });

        g10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g10ActionPerformed(evt);
            }
        });

        s6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });

        s7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });

        s8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });

        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });

        s9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });

        s10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });

        s2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });

        s3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });

        s4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });

        s5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });

        lbcount.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        lbcount.setText("                ");

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbcount, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcount, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void g1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g1ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g1.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[0] = "G1";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g1.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded !");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g1ActionPerformed

    private void g2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g2ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g2.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[1] = "G2";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g2.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g2ActionPerformed

    private void g3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g3ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g3.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[2] = "G3";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g3.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g3ActionPerformed

    private void g4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g4ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g4.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[3] = "G4";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g4.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g4ActionPerformed

    private void g5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g5ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g5.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[4] = "G5";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g5.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g5ActionPerformed

    private void g6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g6ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g6.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[5] = "G6";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g6.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g6ActionPerformed

    private void g7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g7ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g7.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[6] = "G7";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g7.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g7ActionPerformed

    private void g8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g8ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g8.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[7] = "G8";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g8.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g8ActionPerformed

    private void g9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g9ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g9.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[8] = "G9";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g9.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g9ActionPerformed

    private void g10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g10ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g10.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[9] = "G10";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g10.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_g10ActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s1.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[10] = "S1";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s1.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s2.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[11] = "S2";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s2.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s2ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s3.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[12] = "S3";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s3.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s4.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[13] = "S4";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s4.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s5.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[14] = "S5";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s5.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s5ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s6.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[15] = "S6";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s6.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s6ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s7.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[16] = "S7";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s7.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s7ActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s8.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[17] = "S8";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s8.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s8ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s9.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[18] = "S9";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s9.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
    }//GEN-LAST:event_s9ActionPerformed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
        if(ccount < ticket_count)
        {
          
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s10.setIcon(images[1]);
            ccount++;
            System.out.println("Current Count:"+ccount);
            seat_clicked[19] = "S10";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            s10.setEnabled(false);
            
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
        if(ccount == ticket_count)
            submit.setEnabled(true);
            
    }//GEN-LAST:event_s10ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        int tcount = rand.nextInt(1000);
        
        DateFormat dateFormat1 = new SimpleDateFormat("ddMMyy");
        java.util.Date date1 = new java.util.Date();
        String id = dateFormat1.format(date1);
        
        
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = new java.util.Date();
        mainclass.date = dateFormat2.format(date2);
        
        for(int i=0;i<20;i++)
        {
            if(seat_clicked[i]!=null)
            {
                System.out.println("SEAT SELECTED ["+i+"]: "+seat_clicked[i]);
                if(seat_clicked[i].charAt(0) == 'G')                            //GOLD CLASS COST CALCULATE
                    mainclass.cost = mainclass.cost + 200 ;
                else if(seat_clicked[i].charAt(0) == 'S')
                    mainclass.cost = mainclass.cost + 100 ;                     //SILVER CLASS COST CALCULATE
                
                mainclass.ticketSeatNo = mainclass.ticketSeatNo + "" +seat_clicked[i] + " ";
            }
        }    
                
        System.out.println("SEAT STRING:"+mainclass.ticketSeatNo);
        
        Connection conn = null;
        Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      mainclass.ticketID = id + tcount;
      tcount++;
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      String sql = "SELECT * FROM cost";
      ResultSet rs = stmt.executeQuery(sql) ;
      while(rs.next())
      {
          mainclass.sid++;
      }
      mainclass.sid++;
      System.out.println("SID: "+mainclass.sid);
      
      sql = "SELECT * FROM seat_info si , screen_details sd where si.sid = sd.sid and sd.movie_name ='"+mainclass.selected_movie+"' order by si.sid";
      rs = stmt.executeQuery(sql);
      int newSeatsAvail = 0;
      int seatsAvail = 0;
      if(rs.last() == true)
      { 
          rs.last();
          seatsAvail = rs.getInt("seats_available");
          newSeatsAvail = seatsAvail - Integer.parseInt(mainclass.finalTicketCount) ;
      }
      
      else
      {
          seatsAvail = 20 ;
          newSeatsAvail = seatsAvail - Integer.parseInt(mainclass.finalTicketCount) ;
      }
     
      sql = "INSERT INTO cost " +
                   "VALUES ('"+mainclass.sid+"','"+mainclass.ticketID+"','"+mainclass.selected_movie+"',"+mainclass.cost+")";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO customer_info " +
                   "VALUES ('"+mainclass.ticketID+"','"+mainclass.custName+"','"+mainclass.selected_movie+"','"+mainclass.time_booked+"','"+mainclass.ticketSeatNo+"',"+mainclass.final_screen_no+",'"+mainclass.custPh+"','"+mainclass.date+"',"+mainclass.finalTicketCount+")" ;                      
      stmt.executeUpdate(sql);
      sql = "INSERT INTO seat_info " +
                   "VALUES ('"+mainclass.sid+"',"+mainclass.final_screen_no+","+mainclass.finalTicketCount+","+newSeatsAvail+",20,'"+mainclass.ticketSeatNo+"')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO screen_details " +
                   "VALUES('"+mainclass.sid+"',"+mainclass.final_screen_no+",'"+mainclass.selected_movie+"',"+mainclass.timeInt+" )";
      stmt.executeUpdate(sql);
      System.out.println("Inserted records into the table...");

   }catch(SQLException | ClassNotFoundException cfe){
          System.out.println("Class Not Found Exception: "+cfe);  
          //Handle errors for JDBC
   }
        //Handle errors for Class.forName
        finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
          System.out.println("SQL Exception: "+se);
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }//end finally try
   }//end try
   System.out.println("Goodbye SUBMIT BUTTON!");
   
   this.dispose();
   new customer_bill().setVisible(true);
           
    }//GEN-LAST:event_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(seat_mapping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seat_mapping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seat_mapping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seat_mapping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seat_mapping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton g1;
    private javax.swing.JButton g10;
    private javax.swing.JButton g2;
    private javax.swing.JButton g3;
    private javax.swing.JButton g4;
    private javax.swing.JButton g5;
    private javax.swing.JButton g6;
    private javax.swing.JButton g7;
    private javax.swing.JButton g8;
    private javax.swing.JButton g9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbcount;
    private javax.swing.JButton s1;
    private javax.swing.JButton s10;
    private javax.swing.JButton s2;
    private javax.swing.JButton s3;
    private javax.swing.JButton s4;
    private javax.swing.JButton s5;
    private javax.swing.JButton s6;
    private javax.swing.JButton s7;
    private javax.swing.JButton s8;
    private javax.swing.JButton s9;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
   
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = movie_select.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }
    
  
    
}
