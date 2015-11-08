package ejbclientemail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import mx.gob.imss.ctirss.delta.derechohabientes.service.utility.interfaces.EmailServiceRemote;

public class TestEmail {
    public static void main(String args[]){
        System.out.println(" -- Procesando Ejb for Send Email");
        try{
            System.err.println(" -- Enviando correo...");
            EmailServiceRemote ejb = EjbLocator.getContextoRemoto();
            String email = "gtrejo.armenta@gmail.com";
            String asunto = "Asunto de prueba con Adjuntos";
            String body = "<html><br><h3><strong>Texto en el body de prueba</strong></h3></html>";
            
            Map<String, byte[]> adjuntos = new HashMap<String, byte[]>();
            
            //Path path = Paths.get("C:\\Users\\User\\Documents\\NetBeansProjects\\EJBClientEmail\\src\\ejbclientemail\\CFDI_2392.pdf");
            //byte[] data = Files.readAllBytes(path);
            
             //Path path2 = Paths.get("C:\\Users\\User\\Documents\\NetBeansProjects\\EJBClientEmail\\src\\ejbclientemail\\CFDI_2392.xml");
            //byte[] data2 = Files.readAllBytes(path2);

            //adjuntos.put("CFDI_2392.pdf", data);
            ///adjuntos.put("CFDI_2392.xml", data2);

            ejb.enviaCorreoConDocumentoAdjunto(email, null, asunto, body, adjuntos);
             System.err.println(" -- Correo Enviado a: "+email);
        }catch(Exception e){
            System.err.println(" -- No se pudo enviar el correo:: "+e);
                e.printStackTrace();
        }
        
    }

}
