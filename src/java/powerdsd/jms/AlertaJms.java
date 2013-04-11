/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.jms;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author s7263
 */
public class AlertaJms {

    public void enviar(String mensaje) throws JMSException, NamingException {
        sendJMSMessageToMyQueue(mensaje);
    }

    public String obtener() throws NamingException, JMSException {
        QueueConnection queueCon = null;
        String mensaje=null;
        try {
            // get the initial context, refer to your app server docs for this
            Context ctx = new InitialContext();

            // get the connection factory, and open a connection
            QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("java:comp/env/jms/myQueueFactory");
            queueCon = qcf.createQueueConnection();

            // create queue session off the connection
            QueueSession queueSession = queueCon.
                    createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            // get handle on queue, create a sender and send the message
            Queue queue = (Queue) ctx.lookup("java:comp/env/jms/myQueue");
            QueueReceiver receiver = queueSession.createReceiver(queue);

            queueCon.start();
            Message m = receiver.receive();
            if (m != null && m instanceof TextMessage) {
                System.out.println("enter if");
                TextMessage message = (TextMessage) m;
                
                mensaje=message.getText();
                System.out.println("Reading message: " + mensaje);
            }else{
            System.out.println("no data");
            }
            
        } finally {
            // close the queue connection
            System.out.println("finally");
            if (queueCon != null) {
                queueCon.close();
            }
        }
        
        return mensaje;
    }

    private Message createJMSMessageForjmsMyQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToMyQueue(Object messageData) throws NamingException, JMSException {
        Context c = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) c.lookup("java:comp/env/jms/myQueueFactory");
        Connection conn = null;
        Session s = null;
        try {
            conn = cf.createConnection();
            s = conn.createSession(false, s.AUTO_ACKNOWLEDGE);
            Destination destination = (Destination) c.lookup("java:comp/env/jms/myQueue");
            MessageProducer mp = s.createProducer(destination);
            mp.send(createJMSMessageForjmsMyQueue(s, messageData));
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
