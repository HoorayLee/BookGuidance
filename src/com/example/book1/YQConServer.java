package com.example.book1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import com.example.*;
import android.util.Log;
import android.widget.Toast;

public class YQConServer {
	public static Socket s;  
	
	
    public String sendLoginInfo(User obj){  
        String b="no";  
        String a="what?!";
        
       try {  
            s=new Socket();  
            try{ 
                s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
               
            }catch(SocketTimeoutException e){  
            	  //���ӷ�������ʱ  
                return b;  
            }  
            
            YQMessage ms= new YQMessage();
            ms.studentId=obj.getAccount();
            ms.content=obj.getPassword();
            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
            oos.writeObject(ms);  
           
           
            
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
         
            ms=(YQMessage) ois.readObject();
          
    		s.close();
           if(ms.getType().equals(YQMessageType.SUCCESS)){  
            
        	   b="yeah";
               return b;  
           }else if(ms.getType().equals(YQMessageType.FAIL)){  
       
               return a;  
           }  
           
            
        }catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

 
		return b;
    }  
    
	public static boolean exit()
     {
    	 boolean b = false;
     
    	 try {  
             s=new Socket();  
             try{  
                 s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
                
             }catch(SocketTimeoutException e){  
             	 
                 return b;  
             }  
             YQMessage ms = new YQMessage();
         	 ms.setType(YQMessageType.checkout);
         	 ms.studentId=User.account;
             ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
             oos.writeObject(ms);  
                
             ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
          
             ms=(YQMessage) ois.readObject();
           
     		s.close();
     		if(ms.getType().equals(YQMessageType.SUCCESS))
     		{
     			b=true;
     		}
    	 }catch (OptionalDataException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	 return b;
     }
    public static boolean check(String book)
	{
    	boolean b=false;
    	YQMessage ms = new YQMessage();
    	ms.setType(YQMessageType.searchByName);
    	ms.content=book;
    	try{  
    		s=new Socket();
            s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
             
        }catch(SocketTimeoutException e){  
        	  
			//���ӷ�������ʱ  
            return b;  
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	return b; 
		}  
    	
        try {
        	ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
            oos.writeObject(ms);  
           
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ms=(YQMessage) ois.readObject();
			s.close();
			if(!ms.content.equals("none"))
			{
				b= true;
			}
			else
				b= false;
		} catch (OptionalDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
      
	
		
	}
	public static boolean book(String book) {
		// TODO Auto-generated method stub
		boolean b = false;
		YQMessage ms = new YQMessage();
    	YQMessage ms1=new YQMessage();
    	ms.setType(YQMessageType.reserve);
    	ms.content=book;
    	try{  
    		s=new Socket();
            s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
             
        }catch(SocketTimeoutException e){  
        	  
			//���ӷ�������ʱ  
        	e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	e.printStackTrace();
		}  
           
        try {
        	ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
            oos.writeObject(ms);  
           
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ms1=(YQMessage) ois.readObject();
			s.close();
			if(ms1.getType().equals(YQMessageType.SUCCESS))
			{
				b=true;
			}
        }catch (OptionalDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        return b;
	}
	public static boolean feedback(String content) {
		// TODO Auto-generated method stub
		boolean b = false;
		YQMessage ms = new YQMessage();
    	YQMessage ms1=new YQMessage();
    	ms.setType(YQMessageType.feedback);
    	ms.content=content;
    	ms.studentId=User.account;
    	try{  
    		s=new Socket();
            s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
             
        }catch(SocketTimeoutException e){  
        	  
			//���ӷ�������ʱ  
        	e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	e.printStackTrace();
		}  
           
        try {
        	ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
            oos.writeObject(ms);  
           
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ms1=(YQMessage) ois.readObject();
			s.close();
			if(ms1.getType().equals(YQMessageType.SUCCESS))
			{
				b=true;
			}
        }catch (OptionalDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        return b;
	}
	public static boolean confirm(String string) {
		boolean b=false; 
		try {    
			  YQMessage ms = new YQMessage();
			  ms.setType(YQMessageType.borrow);
			  ms.content=string;
	            s=new Socket();  
	            try{  
	                s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
	                //Log.v("TAG", s.isConnected()+"");
	            	//s.connect(new InetSocketAddress("118.114.43.56",43637),5000);  
	            }catch(SocketTimeoutException e){  
	            	  //���ӷ�������ʱ  
	                return b;  
	            }  
	            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
	            oos.writeObject(ms);  
	            
	            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());         
	            ms=(YQMessage) ois.readObject();
	          
	    		s.close();
	           if(ms.getType().equals(YQMessageType.SUCCESS)){  
	               //����һ�����˺źͷ������������ӵ��߳�  
	               //--- 
	        	   b=true;
	               return b;  
	           }else if(ms.getType().equals(YQMessageType.FAIL)){  
	       
	               return b;  
	           }  
	           
	            
	        }catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	 
			return b;// TODO Auto-generated method stub
		
	}
	public static String[][] reserveRec(String account) {
		String[][] record=new String[50][50];
		// TODO Auto-generated method stub
		try {    
			  YQMessage ms = new YQMessage();
			  ms.setType(YQMessageType.reserveRec);
			  ms.studentId=account;
	            s=new Socket();  
	            try{  
	                s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
	                
	            }catch(SocketTimeoutException e){  
	            	  //���ӷ�������ʱ  
	            	e.printStackTrace();
	            }  
	            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
	            oos.writeObject(ms);  
	            
	            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());         
	            ms=(YQMessage) ois.readObject();
	          
	    		s.close();
	           if(ms.getType().equals(YQMessageType.SUCCESS)){ 
	        	   record=ms.getRecord();
	        	   
	           }else if(ms.getType().equals(YQMessageType.NOTEXIST)){  
	        	   record=null;
	              
	           }  
	           else if(ms.getType().equals(YQMessageType.FAIL)){  
	        	   record[0][0]="error!";
	              
	           }  
	           
	            
	        }catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return record; 
	}
	public static String[][] lendhis(String account) {
		// TODO Auto-generated method stub
		String[][] record=new String[50][50];
		// TODO Auto-generated method stub
		try {    
			  YQMessage ms = new YQMessage();
			  ms.setType(YQMessageType.NborrowRec);
			  ms.studentId=account;
	            s=new Socket();  
	            try{  
	                s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
	                
	            }catch(SocketTimeoutException e){  
	            	  //���ӷ�������ʱ  
	            	e.printStackTrace();
	            }  
	            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
	            oos.writeObject(ms);  
	            
	            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());         
	            ms=(YQMessage) ois.readObject();
	          
	    		s.close();
	           if(ms.getType().equals(YQMessageType.SUCCESS)){ 
	        	   record=ms.getRecord();
	        	   
	           }else if(ms.getType().equals(YQMessageType.NOTEXIST)){  
	        	   record=null;
	              
	           }  
	           else if(ms.getType().equals(YQMessageType.FAIL)){  
	        	   record[0][0]="error!";
	              
	           }  
	           
	            
	        }catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return record; 
	}
	public static boolean changecode(String code1, String code2) {
		boolean b=false;
		// TODO Auto-generated method stub
		try {    
			  YQMessage ms = new YQMessage();
			  ms.setType(YQMessageType.modifyPassword);
			  ms.studentId=User.account;
			  ms.content=code1;
			  ms.content2=code2;
	            s=new Socket();  
	            try{  
	                s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
	                
	            }catch(SocketTimeoutException e){  
	            	  //���ӷ�������ʱ  
	            	e.printStackTrace();
	            }  
	            ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
	            oos.writeObject(ms);  
	            
	            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());         
	            ms=(YQMessage) ois.readObject();
	          
	    		s.close();
	    		 if(ms.getType().equals(YQMessageType.SUCCESS)){ 
	    			 b=true;
	    		 }
	    		 else if (ms.getType().equals(YQMessageType.FAIL))
	    		 {
	    			 b=false;
	    		 }
		}catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		 
		
		return b;
	}

	public static boolean feedback1(String content) {
		// TODO Auto-generated method stub
		boolean b = false;
		YQMessage ms = new YQMessage();
    	YQMessage ms1=new YQMessage();
    	ms.setType(YQMessageType.feedback1);
    	ms.content=content;
    	ms.studentId=User.account;
    	try{  
    		s=new Socket();
            s.connect(new InetSocketAddress("192.168.1.105",8863),3000);
             
        }catch(SocketTimeoutException e){  
        	  
			//���ӷ�������ʱ  
        	e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
        	e.printStackTrace();
		}  
           
        try {
        	ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());  
            oos.writeObject(ms);  
           
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ms1=(YQMessage) ois.readObject();
			s.close();
			if(ms1.getType().equals(YQMessageType.SUCCESS))
			{
				b=true;
			}
        }catch (OptionalDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        return b;
	}
}
