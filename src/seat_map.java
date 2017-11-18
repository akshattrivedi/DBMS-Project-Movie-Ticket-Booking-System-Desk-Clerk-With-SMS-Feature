
import classes.mainclass;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.*;
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
public class seat_map extends javax.swing.JFrame {
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
     * Creates new form seat_map
     */
    public seat_map() {
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

      String sql = "SELECT * FROM seat_info where screen_no="+mainclass.final_screen_no;
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
        String bookedSeats = rs.getString("seat_number");
        String empty = " ";

         //Display values
         
        System.out.println("SEAT NUMBERS LIST:" + bookedSeats);
        
        if(bookedSeats.length()>3)
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
         se.printStackTrace();
      }//end finally try
   }//end try
    System.out.println("\n\n\n\n");
   
    for(int n=0;n<20;n++)
   {
       System.out.println("SEAT NUMBER ["+n+"] = "+seat_arr[n]);
       if(seat_arr[n] != null)
       {
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
    }
    lbcount.setText(details);
    
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        g1 = new javax.swing.JButton();
        g2 = new javax.swing.JButton();
        g3 = new javax.swing.JButton();
        g4 = new javax.swing.JButton();
        g5 = new javax.swing.JButton();
        g10 = new javax.swing.JButton();
        g6 = new javax.swing.JButton();
        g7 = new javax.swing.JButton();
        g8 = new javax.swing.JButton();
        g9 = new javax.swing.JButton();
        s5 = new javax.swing.JButton();
        s10 = new javax.swing.JButton();
        s6 = new javax.swing.JButton();
        s7 = new javax.swing.JButton();
        s8 = new javax.swing.JButton();
        s9 = new javax.swing.JButton();
        s1 = new javax.swing.JButton();
        s2 = new javax.swing.JButton();
        s3 = new javax.swing.JButton();
        s4 = new javax.swing.JButton();
        lbgold = new javax.swing.JLabel();
        lbsilver = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbcount = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        g1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g1.setMaximumSize(new java.awt.Dimension(30, 30));
        g1.setMinimumSize(new java.awt.Dimension(30, 30));
        g1.setPreferredSize(new java.awt.Dimension(30, 30));
        g1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g1ActionPerformed(evt);
            }
        });
        getContentPane().add(g1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 147, -1, -1));

        g2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g2.setMaximumSize(new java.awt.Dimension(30, 30));
        g2.setMinimumSize(new java.awt.Dimension(30, 30));
        g2.setPreferredSize(new java.awt.Dimension(30, 30));
        g2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g2ActionPerformed(evt);
            }
        });
        getContentPane().add(g2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 147, -1, -1));

        g3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g3.setMaximumSize(new java.awt.Dimension(30, 30));
        g3.setMinimumSize(new java.awt.Dimension(30, 30));
        g3.setPreferredSize(new java.awt.Dimension(30, 30));
        g3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g3ActionPerformed(evt);
            }
        });
        getContentPane().add(g3, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 147, -1, -1));

        g4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g4.setMaximumSize(new java.awt.Dimension(30, 30));
        g4.setMinimumSize(new java.awt.Dimension(30, 30));
        g4.setPreferredSize(new java.awt.Dimension(30, 30));
        g4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g4ActionPerformed(evt);
            }
        });
        getContentPane().add(g4, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 147, -1, -1));

        g5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g5.setMaximumSize(new java.awt.Dimension(30, 30));
        g5.setMinimumSize(new java.awt.Dimension(30, 30));
        g5.setPreferredSize(new java.awt.Dimension(30, 30));
        g5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g5ActionPerformed(evt);
            }
        });
        getContentPane().add(g5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 147, -1, -1));

        g10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g10.setMaximumSize(new java.awt.Dimension(30, 30));
        g10.setMinimumSize(new java.awt.Dimension(30, 30));
        g10.setPreferredSize(new java.awt.Dimension(30, 30));
        g10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g10ActionPerformed(evt);
            }
        });
        getContentPane().add(g10, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 147, -1, -1));

        g6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g6.setMaximumSize(new java.awt.Dimension(30, 30));
        g6.setMinimumSize(new java.awt.Dimension(30, 30));
        g6.setPreferredSize(new java.awt.Dimension(30, 30));
        g6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g6ActionPerformed(evt);
            }
        });
        getContentPane().add(g6, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 147, -1, -1));

        g7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g7.setMaximumSize(new java.awt.Dimension(30, 30));
        g7.setMinimumSize(new java.awt.Dimension(30, 30));
        g7.setPreferredSize(new java.awt.Dimension(30, 30));
        g7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g7ActionPerformed(evt);
            }
        });
        getContentPane().add(g7, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 147, -1, -1));

        g8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g8.setMaximumSize(new java.awt.Dimension(30, 30));
        g8.setMinimumSize(new java.awt.Dimension(30, 30));
        g8.setPreferredSize(new java.awt.Dimension(30, 30));
        g8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g8ActionPerformed(evt);
            }
        });
        getContentPane().add(g8, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 147, -1, -1));

        g9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        g9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        g9.setMaximumSize(new java.awt.Dimension(30, 30));
        g9.setMinimumSize(new java.awt.Dimension(30, 30));
        g9.setPreferredSize(new java.awt.Dimension(30, 30));
        g9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        g9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g9ActionPerformed(evt);
            }
        });
        getContentPane().add(g9, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 147, -1, -1));

        s5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s5.setMaximumSize(new java.awt.Dimension(30, 30));
        s5.setMinimumSize(new java.awt.Dimension(30, 30));
        s5.setPreferredSize(new java.awt.Dimension(30, 30));
        s5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });
        getContentPane().add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 231, -1, -1));

        s10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s10.setMaximumSize(new java.awt.Dimension(30, 30));
        s10.setMinimumSize(new java.awt.Dimension(30, 30));
        s10.setPreferredSize(new java.awt.Dimension(30, 30));
        s10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });
        getContentPane().add(s10, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 231, -1, -1));

        s6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s6.setMaximumSize(new java.awt.Dimension(30, 30));
        s6.setMinimumSize(new java.awt.Dimension(30, 30));
        s6.setPreferredSize(new java.awt.Dimension(30, 30));
        s6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });
        getContentPane().add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 231, -1, -1));

        s7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s7.setMaximumSize(new java.awt.Dimension(30, 30));
        s7.setMinimumSize(new java.awt.Dimension(30, 30));
        s7.setPreferredSize(new java.awt.Dimension(30, 30));
        s7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });
        getContentPane().add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 231, -1, -1));

        s8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s8.setMaximumSize(new java.awt.Dimension(30, 30));
        s8.setMinimumSize(new java.awt.Dimension(30, 30));
        s8.setPreferredSize(new java.awt.Dimension(30, 30));
        s8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });
        getContentPane().add(s8, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 231, -1, -1));

        s9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s9.setMaximumSize(new java.awt.Dimension(30, 30));
        s9.setMinimumSize(new java.awt.Dimension(30, 30));
        s9.setPreferredSize(new java.awt.Dimension(30, 30));
        s9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });
        getContentPane().add(s9, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 231, -1, -1));

        s1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s1.setMaximumSize(new java.awt.Dimension(30, 30));
        s1.setMinimumSize(new java.awt.Dimension(30, 30));
        s1.setPreferredSize(new java.awt.Dimension(30, 30));
        s1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });
        getContentPane().add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 231, -1, -1));

        s2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s2.setMaximumSize(new java.awt.Dimension(30, 30));
        s2.setMinimumSize(new java.awt.Dimension(30, 30));
        s2.setPreferredSize(new java.awt.Dimension(30, 30));
        s2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });
        getContentPane().add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 231, -1, -1));

        s3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s3.setMaximumSize(new java.awt.Dimension(30, 30));
        s3.setMinimumSize(new java.awt.Dimension(30, 30));
        s3.setPreferredSize(new java.awt.Dimension(30, 30));
        s3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });
        getContentPane().add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 231, -1, -1));

        s4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/vacant.jpg"))); // NOI18N
        s4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/booked.jpg"))); // NOI18N
        s4.setMaximumSize(new java.awt.Dimension(30, 30));
        s4.setMinimumSize(new java.awt.Dimension(30, 30));
        s4.setPreferredSize(new java.awt.Dimension(30, 30));
        s4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/seat images/clicked_icon.jpg"))); // NOI18N
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });
        getContentPane().add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 231, -1, -1));

        lbgold.setText("GOLD");
        getContentPane().add(lbgold, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 147, -1, 30));

        lbsilver.setText("SILVER");
        getContentPane().add(lbsilver, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 231, -1, 30));

        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 341, 99, 43));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("SEATS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 51, -1, -1));
        getContentPane().add(lbcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 99, 113, 26));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 31, 56, 62));

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
            JOptionPane.showMessageDialog(null,"Limit Exceeded");

    }//GEN-LAST:event_g1ActionPerformed

    private void g2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g2ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g2.setIcon(images[1]);
            ccount++;
            seat_clicked[1] = "G2";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g2.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g2ActionPerformed

    private void g3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g3ActionPerformed
        // TODO add your handling code here:
       
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g3.setIcon(images[1]);
            ccount++;
            seat_clicked[2] = "G3";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
            g3.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g3ActionPerformed

    private void g4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g4ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g4.setIcon(images[1]);
            ccount++;
            seat_clicked[3] = "G4";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g4ActionPerformed

    private void g5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g5ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g5.setIcon(images[1]);
            ccount++;
            seat_clicked[4] = "G5";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g5ActionPerformed

    private void g6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g6ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g6.setIcon(images[1]);
            ccount++;
            seat_clicked[5] = "G6";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g6ActionPerformed

    private void g7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g7ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g7.setIcon(images[1]);
            ccount++;
            seat_clicked[6] = "G7";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g7ActionPerformed

    private void g8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g8ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g8.setIcon(images[1]);
            ccount++;
            seat_clicked[7] = "G8";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g8ActionPerformed

    private void g9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g9ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g9.setIcon(images[1]);
            ccount++;
            seat_clicked[8] = "G9";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g9ActionPerformed

    private void g10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g10ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            g10.setIcon(images[1]);
            ccount++;
            seat_clicked[9] = "G10";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_g10ActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s1.setIcon(images[1]);
            ccount++;
            seat_clicked[10] = "S1";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
        
    }//GEN-LAST:event_s1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s2.setIcon(images[1]);
            ccount++;
            seat_clicked[11] = "S2";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s2ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s3.setIcon(images[1]);
            ccount++;
            seat_clicked[12] = "S3";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s4.setIcon(images[1]);
            ccount++;
            seat_clicked[13] = "S4";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s5.setIcon(images[1]);
            ccount++;
            seat_clicked[14] = "S5";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s5ActionPerformed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s6.setIcon(images[1]);
            ccount++;
            seat_clicked[15] = "S6";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s6ActionPerformed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s7.setIcon(images[1]);
            ccount++;
            seat_clicked[16] = "S7";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s7ActionPerformed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s8.setIcon(images[1]);
            ccount++;
            seat_clicked[17] = "S8";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s8ActionPerformed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s9.setIcon(images[1]);
            ccount++;
            seat_clicked[18] = "S9";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s9ActionPerformed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
        
        if(ccount < ticket_count)
        {
            images[1] = createImageIcon("seat images/"+ seatIcon[1]);
            s10.setIcon(images[1]);
            ccount++;
            seat_clicked[19] = "S10";
            details = " "+ccount+"/"+ticket_count ;
            lbcount.setText(details);
        }
        else
            JOptionPane.showMessageDialog(null,"Limit Exceeded");
    }//GEN-LAST:event_s10ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jButton2.setEnabled(false);
        jButton2.setVisible(false);
        jButton2.setBackground(Color.GREEN);
        jButton2.setForeground(Color.GREEN);
        System.out.println("IHHHIHIHHIHIHIHIHIHIHIHHIHI");
    }//GEN-LAST:event_jButton2ActionPerformed

 
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
            java.util.logging.Logger.getLogger(seat_map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seat_map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seat_map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seat_map.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seat_map().setVisible(true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbcount;
    private javax.swing.JLabel lbgold;
    private javax.swing.JLabel lbsilver;
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
