/*Program to convert a number to sentence*/
import java.util.*;
class numtosen
{
    private static String u[][]={{"one","two","three","four","five","six","seven","eight","nine"},{"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"},{"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"},{"hundred","thousand","lakh","crore","arab"}};
    private static String s="";
    public static void twoDigits(int num) 
    {  //to convert two digits of the num to sentence
        if(num==0);
        else if(num<10)
            s+=u[0][num-1]+" ";
        else if(num>10 && num<20)
            s+=u[2][num-11]+" ";
        else
        {
            s+=u[1][num/10-1]+" ";
            twoDigits(num%10);
        }
    }
    public static void main(String h[])
    {
        Scanner z=new Scanner(System.in);
        int in=z.nextInt();
        String num=String.valueOf(in);
        if(in==0)
            s="Zero";
        else
        {
            int i,j=0,partsLength;
            partsLength=(num.length()-3)/2+1;
            if(num.length()%2==0)
                partsLength++;
            int parts[]=new int[partsLength];
            parts[j++]=in%1000;
            in/=1000;
            while(in!=0)
            {
                parts[j++]=in%100;
                in/=100;
            }
            for(i=parts.length-1;i>=0;i--) //send two digits at a time to above function
                if(i==0)
                {
                    twoDigits(parts[i]/100);
                    s+=u[3][i]+" ";
                    twoDigits(parts[i]%100);
                }
                else if(parts[i]!=0)
                {
                    twoDigits(parts[i]);
                    s+=u[3][i]+" ";
                }
        }
        System.out.println(s);
    }//end of main
}//end of class