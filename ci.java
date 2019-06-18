import java.util.*;
import java.util.regex.*;
import java.beans.Statement;
import java.sql.*;
interface info{
	
	public void Initialize();
	public int Initialize(int eflag,int pflag);
}
interface show extends info{

	
	void Display();
}

public class ci implements show{
	
	public String cust_name,cust_email,ph_no,place;

	public double ann_income;
	
	Scanner in1 = new Scanner(System.in);
	public static boolean isValid(String s)
			{
			Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
			Matcher m=p.matcher(s);
			return (m.find() && m.group().equals(s));
		}
		public static boolean isValide(String email)
			{
				String em="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
			Pattern pe=Pattern.compile(em);
			Matcher me=pe.matcher(email);
			return (me.find() && me.group().equals(email));
		}
	public static void main(String[] args)
		{
			int check;
			int eflag=1,pflag=1;
			
			ci p= new ci();
			System.out.println("Please Enter the following information to use the housing prediction \n");
			p.Initialize();
			check=p.Initialize(eflag,pflag);

			if(check==0)
			{
				System.out.println("Check entered email or phone number");
			} 
			else{

			p.Display();}
                        try{
    Class.forName("com.mysql.cj.jdbc.Driver");  // Loading and registering the driver.
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ci","root","Kaluvas@1"); // Setting up the connection.

    
                        
                       
                         String query = "insert into info values(?,?,?,?,?);";
                        PreparedStatement ps=conn.prepareStatement(query);
                        ps.setString(1,p.cust_name);
                        ps.setString(2,p.place);
                        ps.setString(3,p.cust_email);
                        ps.setString(4,p.ph_no);
                        ps.setDouble(5,p.ann_income);
                        ps.execute();
                        System.out.println("successsss");
                        
		}
		
                 catch(Exception e){System.out.println(e);}       
                
                 	/* linear regression*/






                }





		public void Initialize()
			{
			
			System.out.println("Enter Full name");
			cust_name=in1.nextLine();

			System.out.println("Enter Your Place");
			place=in1.next();

		}
		public int Initialize(int eflag,int pflag)
			{ 
				String s1="@";
				String s2="[a-z]";
				
				int i=0,j=0,elen,plen;

			System.out.println("Enter Email id");
			cust_email=in1.next();
			elen=cust_email.length();
			
				if(isValide(cust_email))
			{
				eflag=1;
			}
			else
			{
				eflag=0;
			}
			
			System.out.println("Enter Phone number");
			ph_no=in1.next();
			if(isValid(ph_no))
			{
				pflag=1;
			}
			else
			{
				pflag=0;
			}
			
			System.out.println("Enter Annual income");
			ann_income=in1.nextDouble();
			if(eflag==1&&pflag==1)
			{
				return 1;

			}
			else
			{
				return 0;
			}

			}

			public void Display()
			{
			System.out.println(cust_name+cust_email+ph_no+ann_income+place);
		
	}
}
