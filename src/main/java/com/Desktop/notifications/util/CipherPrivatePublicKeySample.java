package com.Desktop.notifications.util;


import org.springframework.util.Base64Utils;

import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class CipherPrivatePublicKeySample {

   public static void decrypt(byte[] input, PrivateKey privateKey) throws Exception
   {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(Cipher.DECRYPT_MODE,privateKey);
      cipher.update(input);

      System.out.println( new String(cipher.doFinal(),"UTF8"));
   }
   public static void main(String args[]) throws Exception{
      //Creating a Signature object
      Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generating the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();      
	
      //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");


      SecureRandom randomSecureRandom = new SecureRandom();
      byte[] iv = new byte[cipher.getBlockSize()];
      randomSecureRandom.nextBytes(iv);
      IvParameterSpec ivParams = new IvParameterSpec(iv);


      //Initializing a Cipher object
      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
      //Adding data to the cipher
      byte[] input = "Test".getBytes();
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();

      System.out.println(new String(Base64Utils.encode(cipherText)));

      decrypt(cipherText,pair.getPrivate());


  }
}
