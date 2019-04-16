package network_simulator;
import java.util.*;


public class Simulator {

static void broadCast(String data,int sender,int receiver,Device[] d,int devices)
{

	for(int x=0;x<devices;x++)
	{
		if (x==sender-1) continue;

		for(int i=0;i<data.length();i++)
		{
			long startTime = System.currentTimeMillis();
			System.out.println("\nThe Sender "+sender+" sends frame no. "+(i+1)+" to the receiver "+(x+1));
			d[x]= new Device();
			if(x==receiver-1)
			{
			d[x].info += data.charAt(i);
			System.out.println("The Receiver "+(x+1)+" receives frame no. "+(i+1)+" containing the data "+data.charAt(i)+" and sends back ack");
			System.out.println("\n The sender "+sender+" receives the ack \n\n\n");
			}
			else
				System.out.println("receiver discarded the info\n");
			

			long endTime = System.currentTimeMillis();
	    	long durationInNano = (endTime - startTime);
	    	System.out.println("Roundtrip Time: "+durationInNano+" ms ");

		} 
	}
	
	System.out.println("Broadcast domain = 1 \nCollision domain = "+devices);
}


static void transmission2(int sender,int receiver,String data,int bridge,int device,int h1)
{
	Device[] d=new Device[device];
	if(bridge==1)
	{
		System.out.println("The Switch forwards the data 1st time ");
		for(int i=0;i<device;i++)
		{
			d[i] = new Device();
			d[i].setMacAddress(i+10);
			
    	}
		broadCast(data,sender,receiver,d,device);
	}
	else
	{
		if(sender<=h1&&receiver<=h1)
		{
			System.out.println("\nThe switch denied to pass the packet from Hub 1 to Hub 2");
			for(int p=0;p<h1;p++)
			{
				if(sender==p+1) continue;
				
				//broadCast(data,sender,receiver,d,device);
				
				for(int i=0;i<data.length();i++)
				{
					long startTime = System.currentTimeMillis();
					System.out.println("\nThe Sender "+sender+" sends frame no. "+(i+1)+" to the receiver "+(p+1));
					
					if(p==receiver-1)
					{
						d[p] = new Device();
						d[p].info+=data.charAt(i);
						System.out.println("\nThe Receiver "+(p+1)+" receives frame no. "+(i+1)+" containing the data "+data.charAt(i)+" and sends back ack");
						System.out.println("\n The sender "+sender+" receives the ack \n\n\n");
		    		}
    				else
    					System.out.println("\nReceievr Discarded the info \n");
		
					long endTime = System.currentTimeMillis();
				    long durationInNano = (endTime - startTime);
				   	System.out.println("Roundtrip Time: "+durationInNano+" ms ");
            	}
            	
			}
			System.out.println("Broadcast domain = 1 \nCollision domain = 2");
		}
		else if(sender>h1&&receiver>h1)
		{
			System.out.println("\nThe switch denied to pass the packet from Hub 2 to Hub 1");
			for(int p=h1;p<device;p++)
			{
				if(sender==p+1) continue;
				
				//broadCast(data,sender,receiver,d,device);
				
				for(int i=0;i<data.length();i++)
				{
					long startTime = System.currentTimeMillis();

					System.out.println("\nThe Sender "+sender+" sends frame no. "+(i+1)+" to the receiver "+(p+1));
					
					if(p==receiver-1)
					{
					d[p] = new Device() ;
					d[p].info+=data.charAt(i);
					System.out.println("\nThe Receiver "+(p+1)+" receives frame no. "+(i+1)+" containing the data "+data.charAt(i)+" and sends back ack ");
					System.out.println("\n The sender "+sender+" receives the ack \n\n\n");
			    	}
			    	else 
			    		System.out.println("Receiver Discarded the info");

					long endTime = System.currentTimeMillis();
				    long durationInNano = (endTime - startTime);
				   	System.out.println("Roundtrip Time: "+durationInNano+" ms ");

		        }
		        
			}
			System.out.println("Broadcast domain = 1 \nCollision domain = 2");
		}
		else broadCast(data,sender,receiver,d,device);
	}
}
	

	static void transmission(int sender,int receiver,String data,int bridge,int devices)
	{
	    Device[] d=new Device[devices];
		if(bridge==1)
		{
			for(int i=0;i<devices;i++)
			{
				d[i] = new Device() ;
				d[i].setMacAddress(i+10);
				
	    	}
			broadCast(data,sender,receiver,d,devices);
		}
		else
		{
			for(int p=0;p<devices;p++)
			{
				if(receiver==p+1)
				{
					for(int i=0;i<data.length();i++)
					{
						
						long startTime = System.currentTimeMillis();
						System.out.println("\nThe Sender "+sender+" sends frame no. "+(i+1)+" to the receiver "+(p+1));
						
						
							d[p] = new Device() ;
							d[p].info+=data.charAt(i);
							System.out.println("\nThe Receiver "+(p+1)+" receives frame no. "+(i+1)+" containing the data "+data.charAt(i)+" and sends back ack");
							System.out.println("\n The sender "+sender+" receives the ack \n\n\n"); 
						
						
				        long endTime = System.currentTimeMillis();
					    long durationInNano = (endTime - startTime);
					   	System.out.println("Roundtrip Time: "+durationInNano+" ms ");
					}
				}
			}
			System.out.println("Broadcast domain = 1 \nCollision domain = "+devices);
		}
	}

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int c,choice,devices,bridge=0;
		String x;
		char s,r;
		System.out.println("Press 1 for Physical Layer or 2 for Data Link layer\n");
		choice=scn.nextInt();
		Device A = new Device();
		Device B = new Device();
		Device C = new Device();
		Device D = new Device();
		Device E = new Device();
		
		switch(choice)
		{
		case 1:
			A.setMacAddress(0000);
			B.setMacAddress(1111);
			C.setMacAddress(2222);
			D.setMacAddress(3333);
			E.setMacAddress(4444);
			A.setInfo("0");
			B.setInfo("0");
			C.setInfo("0");
			D.setInfo("0");
			E.setInfo("0");
			System.out.println("Initial Mac address and data :\n");
			System.out.println("A : "+A.macaddress+" : "+A.info);
			System.out.println("B : "+B.macaddress+" : "+B.info);
			System.out.println("C : "+C.macaddress+" : "+C.info);
			System.out.println("D : "+D.macaddress+" : "+D.info);
			System.out.println("E : "+E.macaddress+" : "+E.info);
			System.out.println("Enter Sender: ");
			s=scn.next().charAt(0);
			System.out.println("Enter Receiver: ");
			r=scn.next().charAt(0);
			System.out.println("Enter Data:");
			x=scn.next();
			System.out.println("Press 1 for dedicated or press 2 for star topology:");
			c=scn.nextInt();
			Hub h =new Hub(A,B,C,D,E);
			switch(c)
			{
			case 1:
				if(r=='A'||r=='B'||r=='C'||r=='D'||r=='E')
				{
					if(r=='A')
					{
						A.setInfo(x);
					}
					if(r=='B')
					{
						B.setInfo(x);
					}
					if(r=='C')
					{
						C.setInfo(x);
					}
					if(r=='D')
					{
						D.setInfo(x);
					}
					if(r=='E')
					{
						E.setInfo(x);
					}
					
					System.out.println("Now Mac address and data :\n");
					System.out.println("A : "+A.macaddress+" : "+A.info);
					System.out.println("B : "+B.macaddress+" : "+B.info);
					System.out.println("C : "+C.macaddress+" : "+C.info);
					System.out.println("D : "+D.macaddress+" : "+D.info);
					System.out.println("E : "+E.macaddress+" : "+E.info);
					
				}
				break;
			case 2:
				//Hub h=new Hub();
				//h.storeMac(A.macaddress, A.info,B.macaddress,B.info,C.macaddress,C.info,D.macaddress,D.info,E.macaddress,E.info);
				
				if(r=='A'||r=='B'||r=='C'||r=='D'||r=='E')
				{
					if(r=='A')
					{
						A.setInfo(x);
						h.store(A.macaddress, x, s);
						
					}
					if(r=='B')
					   {

					    B.setInfo(x);
					    h.store(B.macaddress,x,s);
					    }
					    if(r=='C')
					   {

					    C.setInfo(x);
					    h.store(C.macaddress,x,s);
					    }
					    if(r=='D')
					   {

					    D.setInfo(x);
					    h.store(D.macaddress,x,s);
					    }
					    if(r=='E')
					   {

					    E.setInfo(x);
					    h.store(E.macaddress,x,s);
					    }
				}
				  break;
		       default:
		        System.out.println("\nEnter valid choice");
				}
			
		case 2:
		   	int gg=0;  
		    System.out.println("\n Press 1 for Switch - End Device data transmission \n Press 2 for Hub - Switch - Hub Configuration\n");
		   	gg = scn.nextInt();
		   	if(gg==1)
		   	{
			   	int sender,receiver;
			   	String data; char y;
			    System.out.println("\nSwitch is created. Enter the number of end Devices\n");
			    devices = scn.nextInt();	
			    boolean flag = true;
			   	while(flag)
			   	{
				   	System.out.println("\nEnter Sender (Should be 1,2,3 etc)\n");
				   	sender = scn.nextInt();
				    System.out.println("\nEnter Receiver (Should be 1,2,3 etc)\n");
				   	receiver = scn.nextInt();
				    System.out.println("\nEnter Data\n");
				    data = scn.next();
				    System.out.println("\nStop and wait protocol is used \n");
				   	bridge++;
				   	transmission(sender,receiver,data,bridge,devices);
				   	System.out.println("\n\nwant to send again? y/n"+"\n");
			   		y = scn.next().charAt(0);
			   		if(y!='y') 
			   			flag=false;
				}
			
		   }
		   if(gg==2)
		   {
		    	int h1,h2,sender,receiver ;
		    	bridge=0;
		    	String data; char y;
		    	
		    	System.out.println("\nEnter number of end Devices in 1st Hub\n");
		    	h1 = scn.nextInt();

		        System.out.println("\nEnter number of end Devices in 2nd Hub\n");
				h2 = scn.nextInt();
		    	boolean flag2 = true ; 
		    	while(flag2)
		    	{
		    		System.out.println("\nEnter Sender (Should be 1,2,3 etc)\n");
			        sender = scn.nextInt();

			        System.out.println("\nEnter Receiver (Should be 1,2,3 etc)\n");
			    	receiver = scn.nextInt();

			        System.out.println("\nEnter Data\n");
			   	    data = scn.next();

			        System.out.println("\nStop and wait protocol is used \n");
			    	bridge++;

			    	transmission2(sender,receiver,data,bridge,h1+h2,h1);

			    	System.out.println("\n\nwant to send again? y/n");
			     	y = scn.next().charAt(0);
			    	if(y=='n') 
			    		flag2 = false;
		    	}
		    	
			}
		   	break;
		  	default: 
		  		System.out.println("\nEnter valid choice");
		}

			
		}
		
}


