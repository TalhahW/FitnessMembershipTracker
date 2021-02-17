package MEM;



import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class sendEmail {
    
    private String user = "Coach.demo2018@gmail.com";
    private String pass= "Ryerson2018";
    
    sendEmail(String to, String sub,String mseg)
    {Properties prop = new Properties();
    prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
    prop.put("mail.smtp.auth",true);
    prop.put("mail.smtp.starttls.enable",true);
    prop.put("mail.smtp.host","smtp.gmail.com");
    prop.put("mail.smtp.port","587");
    
    Session ses = Session.getInstance(prop,new javax.mail.Authenticator()
            {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
            {
            return new javax.mail.PasswordAuthentication(user,pass); 
            
            }
            
            });
    try
    {Message msg = new MimeMessage(ses);
    msg.setFrom(new InternetAddress("no-reply@gmail.com"));
    
  // private String recipient = "yamabs@gmail.com ,priya@gmail.com ";
    String[] recipientList = to.split(",");
    InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
    int counter = 0;
    for (String recipient : recipientList) {
        recipientAddress[counter] = new InternetAddress(recipient.trim());
        counter++;
    }
   // msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    
    msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to) );
    msg.setSubject(sub);
    msg.setText(mseg);
    Transport.send(msg);
    
    System.out.print("Message Sent");
    
    }
    catch(Exception e)
    {    System.out.print(e);
    
    }
    }
}
