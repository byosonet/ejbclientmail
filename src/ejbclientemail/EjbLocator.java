package ejbclientemail;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.gob.imss.ctirss.delta.derechohabientes.service.utility.interfaces.EmailServiceRemote;

public class EjbLocator {

    static EmailServiceRemote getContextoRemoto() {
        EmailServiceRemote ejb = null;
        Context ic = null;
        try {
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            env.put(Context.PROVIDER_URL, "t3://172.16.5.176:8001,172.16.5.176:8003,172.16.5.176:8001,172.16.5.176:8003,172.16.5.176:8001,172.16.5.176:8003");
            env.put(Context.SECURITY_PRINCIPAL, "wloperator");
            env.put(Context.SECURITY_CREDENTIALS, "53rv4p%wl%1p1r1t1r$.");
            ic = new InitialContext(env);
            System.out.println(" -- Context: "+ic);
            ejb = (EmailServiceRemote)ic.lookup("eMailService#mx.gob.imss.ctirss.delta.derechohabientes.service.utility.interfaces.EmailServiceRemote");
            System.err.println(" -- Ejb obtenido: "+ejb);
        } catch (NamingException e) {
            System.out.println(" -- Error no se puede acceder al contexto JNDI EmailService: " + e);
            e.printStackTrace();
        }
        return ejb;
    }
}
