import java.util.*;

// public class calculate(){

// }
interface reg{
	void Initialize();
	void calculate();
	void value();
	}

class lrr implements reg{

		double[] X={1,2,3,4,5};
		double[] Y={3,4,2,4,5};
		double mx,my,c,m,y,x;
		int i,j,k;

		Scanner in = new Scanner(System.in);
	public static void main(String[] args){
		lrr l=new lrr();
		l.calculate();
		l.Initialize();
		l.value();
		}

		public void Initialize()
		{
			System.out.println("Enter value of x");
				x=in.nextDouble();
		}
		public void calculate()
		{
			int n;
			double xsum=0.0,ysum=0.0,nu=0.0,de=0.0;
			for(int i=0;i<5;i++)
			{
				xsum=xsum+X[i];
			}
			mx=xsum/5;
			for(int j=0;j<5;j++)
			{
				ysum=ysum+Y[j];
			}
			my=ysum/5;
			for(i=0;i<5;i++)
			{
				X[i]=X[i]-mx;
			}
			for(j=0;j<5;j++)
			{
				Y[j]=Y[j]-my;
			}
			for(k=0;k<5;k++)
			{
				nu=nu+X[k]*Y[k];
				de=de+(X[k]*X[k]);
			}
			m=nu/de;
			c=my-(m*mx);
			System.out.println("m="+m+"c="+c);

			
		}
		public void value(){
			y=(m*x)+c;		
			System.out.println("answer is:"+y);
		}
}