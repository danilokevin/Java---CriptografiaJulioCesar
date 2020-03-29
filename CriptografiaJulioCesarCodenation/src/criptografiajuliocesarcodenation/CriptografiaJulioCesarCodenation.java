/*
 * CRIPTOGRAFIA DE JULIO CÉSAR
 * REGRAS:
    1 - As mensagens serão convertidas para minúsculas tanto para a 
        criptografia quanto para descriptografia.
    2 - Os números e pontos serão mantidos.
 */

package criptografiajuliocesarcodenation;

import javax.swing.JOptionPane;

public class CriptografiaJulioCesarCodenation 
{
    public static void main(String[] args) 
    {
        String mensagem, textoDecifrado = "";
        int i, chave, option;
        boolean x;
        
        chave = Integer.parseInt(JOptionPane.showInputDialog("Declare a chave: "));
        
        while ((chave == 0) || (chave > 25))
        {
            JOptionPane.showMessageDialog(null, "Chave Inválida");
            chave = Integer.parseInt(JOptionPane.showInputDialog("Declare a chave: "));
        }
        
        option = Integer.parseInt(JOptionPane.showInputDialog("1. Criptar\n 2. Decriptar"));
        
        while (option != 1 && option != 2)
        {
            JOptionPane.showMessageDialog(null, "Opção Inválida");
            option = Integer.parseInt(JOptionPane.showInputDialog("1. Criptar\n 2. Decriptar"));
        }
        
        mensagem = JOptionPane.showInputDialog("Declare a mensagem: ");
        
        char[] textoOriginal = mensagem.toCharArray();
        char alfabetoMin[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char alfabetoMai[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        for (i=0; i < textoOriginal.length; i++)
        {            
            x = false;
            for (int j=0; j < 26; j++)
            {
                if ((textoOriginal[i] == alfabetoMin[j]) || (textoOriginal[i] == alfabetoMai[j]))
                {
                    if (option == 2)
                    {
                        if(j-chave<0)
                        {
                            textoDecifrado += (alfabetoMin[(26+j)-chave]);
                            x = true;
                        } else 
                        {
                            textoDecifrado += (alfabetoMin[j-chave]);
                            x = true;
                        }
                    } else 
                    {
                         textoDecifrado += (alfabetoMin[(j+(chave))%26]);
                         x = true;  
                    }   
                }
            }
            
            if (x == false)
            {
                textoDecifrado += textoOriginal[i];
            }
        }
        
        System.out.println("Resultado: \n" + textoDecifrado);  
    }
}


