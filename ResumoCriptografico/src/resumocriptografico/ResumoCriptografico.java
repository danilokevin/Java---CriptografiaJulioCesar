/*
* Gerar resumo criptográfico da mensagem decodificada do desafio
* Codenation - Cifra de Julio César
 */
package resumocriptografico;

import java.math.BigInteger;
import java.security.MessageDigest;

public class ResumoCriptografico 
{

    public static void main(String[] args) 
    {
        String value = "chuck norris does not go hunting. chuck norris goes killing. unknown";

		String sha1 = "";
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(value.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}

		System.out.println( "The sha1 of \""+ value + "\" is:");
		System.out.println( sha1 );
		System.out.println();
       
    }
    
}
