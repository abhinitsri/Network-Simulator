package network_simulator;
import java.util.*;
public class Hub {

	String data;
	int mac;
	Hub()
	{
		data="0";
		mac=0;
	}
	
	public Device B,A,C,D,E;
    public Hub(Device A, Device B, Device C, Device D, Device E)
    {
        data="0";
        mac=0;
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;
        this.E=E;
    }
	
	void store(int m,String x,char s)
	{
		mac=m;
		data=x;
		send(mac,data,s);
	}
	void send(int maac,String d,char s)
    {
        if(s=='A')
        {
         if(B.macaddress==maac && B.info==d)
          System.out.println("\nmacadress matched with B and the information sent to it is "+d);
         else
          System.out.println("\nB discarded the info");
         if(C.macaddress==maac && C.info==d)
          System.out.println("\nmacadress matched with C and the information sent to it is "+d);
         else
          System.out.println("\nC discarded the info");
         if(D.macaddress==maac && D.info==d)
          System.out.println("\nmacadress matched with D and the information sent to it is "+d);
         else
          System.out.println("\nD discarded the info");
         if(E.macaddress==maac && E.info==d)
          System.out.println("\nmacadress matched with E and the information sent to it is "+d);
         else
          System.out.println("\nE discarded the info");
        }
        if(s=='B')
        {
         if(A.macaddress==maac && A.info==d)
          System.out.println("\nmacadress matched with A and the information sent to it is "+d);
         else
          System.out.println("\nA discarded the info");
         if(C.macaddress==maac && C.info==d)
          System.out.println("\nmacadress matched with C and the information sent to it is "+d);
         else
          System.out.println("\nC discarded the info");
         if(D.macaddress==maac && D.info==d)
          System.out.println("\nmacadress matched with D and the information sent to it is "+d);
         else
          System.out.println("\nD discarded the info");
         if(E.macaddress==maac && E.info==d)
          System.out.println("\nmacadress matched with E and the information sent to it is "+d);
         else
          System.out.println("\nE discarded the info");
        }
        if(s=='C')
        {
        if(A.macaddress==maac && A.info==d)
          System.out.println("\nmacadress matched with A and the information sent to it is "+d);
        else
          System.out.println("\nA discarded the info");
        if(B.macaddress==maac && B.info==d)
          System.out.println("\nmacadress matched with B and the information sent to it is "+d);
        else
          System.out.println("\nB discarded the info");
        if(D.macaddress==maac && D.info==d)
          System.out.println("\nmacadress matched with D and the information sent to it is "+d);
         else
          System.out.println("\nD discarded the info");
         if(E.macaddress==maac && E.info==d)
          System.out.println("\nmacadress matched with E and the information sent to it is "+d);
         else
          System.out.println("\nE discarded the info");
        }
        if(s=='D')
        {
        if(A.macaddress==maac && A.info==d)
          System.out.println("\nmacadress matched with A and the information sent to it is "+d);
        else
          System.out.println("\nA discarded the info");
        if(B.macaddress==maac && B.info==d)
          System.out.println("\nmacadress matched with B and the information sent to it is "+d);
        else
          System.out.println("\nB discarded the info");
         if(C.macaddress==maac && C.info==d)
          System.out.println("\nmacadress matched with C and the information sent to it is "+d);
         else
          System.out.println("\nC discarded the info");
         if(E.macaddress==maac && E.info==d)
          System.out.println("\nmacadress matched with E and the information sent to it is "+d);
         else
          System.out.println("\nE discarded the info");
        }
        if(s=='E')
        {
        if(A.macaddress==maac && A.info==d)
          System.out.println("\nmacadress matched with A and the information sent to it is "+d);
        else
          System.out.println("\nA discarded the info");
        if(B.macaddress==maac && B.info==d)
          System.out.println("\nmacadress matched with B and the information sent to it is "+d);
        else
          System.out.println("\nB discarded the info");
        if(C.macaddress==maac && C.info==d)
          System.out.println("\nmacadress matched with C and the information sent to it is "+d);
        else
          System.out.println("\nC discarded the info");
        if(D.macaddress==maac && D.info==d)
          System.out.println("\nmacadress matched with D and the information sent to it is "+d);
         else
          System.out.println("\nD discarded the info");
        }
    }
	}

