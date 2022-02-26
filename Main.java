import java.awt.geom.CubicCurve2D;
import java.util.zip.DataFormatException;
import java.util.Scanner;
public class Main {
    static double calc(double a,char oper,double b){
        switch(oper){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return a/b;
    }
    static String[] my_split(String s){
        String res[]=new String[3];
        boolean flag=false;
        for(int i=0;i<3;i++)
            res[i]="";
        for(int i=s.length()-1;i>=0;i--)
            if(s.charAt(i)=='-' || s.charAt(i)=='+'){
                res[1]+=s.charAt(i);
                for(int r=0;r<i;r++)
                    res[0]+=s.charAt(r);
                for(int r=i+1;r<s.length();r++)
                    res[2]+=s.charAt(r);
                flag=true;
                break;
            }
        if(flag==false){
            for(int i=s.length()-1;i>=0;i--)
                if(s.charAt(i)=='*' || s.charAt(i)=='/'){
                    res[1]+=s.charAt(i);
                    for(int r=0;r<i;r++)
                        res[0]+=s.charAt(r);
                    for(int r=i+1;r<s.length();r++)
                        res[2]+=s.charAt(r);
                    break;
                }
        }
        return res;
    }
    static double recursive_evaluation(String s){
        double d;
        try{
            d = Double.parseDouble(s);
            return d;
        }catch(NumberFormatException ex){
            String run[]=my_split(s);
            return calc(recursive_evaluation(run[0]),run[1].charAt(0),recursive_evaluation(run[2]));
        }
    }
    public static void main(String []args){
        String s;
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("Enter mathematic equation like 2*2+5/3 or -1 exit");
            s=scan.next();
            if(s.equals("-1"))
                break;
            System.out.println("Result: "+recursive_evaluation(s));
        }
        System.out.println("Good Bye");
    }
}
