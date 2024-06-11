/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinematicketbookingsystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SSC
 */
public class EmbededDatabase {

    String databaseName = "tbs111";
    String userName = "root";
    String password = "root";
    public static void main(String[] args) {
        new EmbededDatabase().embedDatabase();
    }
    public void embedDatabase() {
        createDatabase();
        createHallTable();
        createBookedTickTable();
        createMoviesTable();
        createPaymentDetailsTable();
        createTicketTypeTable();
        createUserTicketSeatTable();
        createUsersInfoTable();
        emptyTicketTypeData();
        emptyUsersData();
        fillTicketTypeData();
        fillUsersData();
//createBookedTickTable();
    }

    public void createDatabase() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+databaseName  + ";create=true", userName, password);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection createConnection() {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + databaseName, userName, password);
            System.out.println("Connection create");

        } catch (Exception ex) {
            System.out.println("Connection not create " + ex.getMessage());
        }
        return con;
    }

    public void createHallTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE HALLTABLE"
                    + "("
                    + "   H_ID INT not null primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),   "
                    + "   H_NAME VARCHAR(100),     "
                    + "   H_ISDELETED BOOLEAN default false"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //    e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createBookedTickTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE \"BOOKEDTICKETSTABLE\" ("
                    + "  BT_ID int NOT NULL  primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "  BT_UID varchar(200) NOT NULL,"
                    + "  BT_TOTALPRICE double NOT NULL,"
                    + "BT_DRINKQUANTITY  int NOT NULL,"
                    + "BT_POPCORNQUANTITY  int NOT NULL"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
               e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void createMoviesTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE MOVIESTABLE ("
                    + "  M_Id int NOT NULL primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "  M_NAME varchar(200) NOT NULL ,"
                    + "  M_DATE date NOT NULL ,"
                    + "  M_TIME varchar(200) NOT NULL ,"
                    + "  M_PRICE double NOT NULL ,"
                    + "  M_TID int NOT NULL ,"
                    + "  M_HID int NOT NULL ,"
                    + "  M_IMAGEPATH varchar(2000) DEFAULT NULL,"
                    + "  M_ISDELETED boolean DEFAULT false"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void createPaymentDetailsTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE PAYMENTDETAILTABLE ("
                    + "  P_ID int NOT NULL primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "  P_BTID int NOT NULL,"
                    + "  P_CARDHOLDERNAME varchar(200) DEFAULT NULL,"
                    + "  P_CCVNUMBER varchar(5) DEFAULT NULL ,"
                    + "  P_CARDNUMBER varchar(100) DEFAULT NULL,"
                    + "  P_PAYMENTMETHOD varchar(200) NOT NULL"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void createTicketTypeTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE TICKETTYPETABLE ("
                    + "  T_ID int NOT NULL primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "  T_NAME varchar(100) NOT NULL,"
                    + "  T_ISDELETED BOOLEAN DEFAULT false"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void createUsersInfoTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE USERSTABLE ("
                    + "  U_EMAIL varchar(300) NOT NULL primary key,"
                    + "  U_PASSWORD varchar(300) NOT NULL ,"
                    + "  U_FIRSTNAME varchar(300) NOT NULL,"
                    + "  U_LASTNAME varchar(300) NOT NULL,"
                    + "  U_ADDRESS varchar(500) NOT NULL ,"
                    + "  U_USERTYPE varchar(100) NOT NULL"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void createUserTicketSeatTable() {
        Connection con = createConnection();
        try {
            String sql = "CREATE TABLE USERTICKETSEATTABLE ("
                    + "  UTS_ID int NOT NULL primary key"
                    + "        GENERATED ALWAYS AS IDENTITY"
                    + "        (START WITH 1, INCREMENT BY 1),"
                    + "  UTS_BID int NOT NULL  ,"
                    + "  UTS_MID int NOT NULL  ,"
                    + "  UTS_SEATNUMBER int  NOT NULL"
                    + ")";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void emptyTicketTypeData() {
        Connection con = createConnection();
        try {
            String sql = "DELETE FROM TICKETTYPETABLE";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void emptyUsersData() {
        Connection con = createConnection();
        try {
            String sql = "DELETE FROM USERSTABLE";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    private void fillTicketTypeData() {
        Connection con = createConnection();
        try {
            String sql = "INSERT INTO TICKETTYPETABLE ( t_name, T_IsDeleted) VALUES"
                    + "( 'Diamond', false),"
                    + "( 'Silver', false)";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void fillUsersData() {
        Connection con = createConnection();
        try {
            String sql = "INSERT INTO USERSTABLE (U_Email, U_Password, U_FirstName, U_LastName, U_Address, U_UserType) VALUES"
                    + "('admin1@admin.com', 'admin1', 'Akbar', 'Ahmad', 'Street 214, Madinah', 'ADMIN'),"
                    + "('admin@admin.com', 'admin', 'Ahmad', 'Ali', 'Street 214, Riyadh', 'ADMIN')";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            //   e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmbededDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
