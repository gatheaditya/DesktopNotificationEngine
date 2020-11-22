package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Base64;

public class keystoreUtil {



    public static void RetriveKey( String alias) throws IOException, KeyStoreException, UnrecoverableEntryException, NoSuchAlgorithmException, CertificateException {
        FileInputStream fis = new FileInputStream("D://keystore.jks");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(fis,"password".toCharArray());
        KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection("password".toCharArray());
        KeyStore.PrivateKeyEntry  privateKeyEntry = (KeyStore.PrivateKeyEntry)keyStore.getEntry(alias,protectionParameter);
        System.out.println( new String(Base64.getEncoder().encode(privateKeyEntry.getPrivateKey().getEncoded()),"UTF-8"));
    }

    public static void main(String[] args)  throws Exception{
        RetriveKey("selfSigned");
    }
}
