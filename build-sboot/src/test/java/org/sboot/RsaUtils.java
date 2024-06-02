package org.sboot;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import sun.misc.BASE64Encoder;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class RsaUtils {

    /**
     * 类型
     */
    public static final String ENCRYPT_TYPE = "RSA";

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 公钥加密
     * @param content 要加密的内容
     * @param publicKey 公钥
     */
    public static String encrypt(String content, PublicKey publicKey) {
        try{
            RSA rsa = new RSA(null,publicKey);
            return rsa.encryptBase64(content, KeyType.PublicKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥加密
     * @param content 要加密的内容
     * @param publicKey 公钥
     */
    public static String encrypt(String content, String publicKey) {
        try{
            RSA rsa = new RSA(null,publicKey);
            return rsa.encryptBase64(content, KeyType.PublicKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 私钥解密
     * @param content 要解密的内容
     * @param privateKey 私钥
     */
    public static String decrypt(String content, PrivateKey privateKey) {
        try {
            RSA rsa = new RSA(privateKey,null);
            return rsa.decryptStr(content, KeyType.PrivateKey);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     * @param content 要解密的内容
     * @param privateKey 私钥
     */
    public static String decrypt(String content, String privateKey) {
        try {
            RSA rsa = new RSA(privateKey,null);
            return rsa.decryptStr(content, KeyType.PrivateKey);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取公私钥-请获取一次后保存公私钥使用
     * @return
     */
    public static Map<String,String> generateKeyPair() {
        try {
            KeyPair pair = SecureUtil.generateKeyPair(ENCRYPT_TYPE);
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            // 获取 公钥和私钥 的 编码格式（通过该 编码格式 可以反过来 生成公钥和私钥对象）
            byte[] pubEncBytes = publicKey.getEncoded();
            byte[] priEncBytes = privateKey.getEncoded();

            // 把 公钥和私钥 的 编码格式 转换为 Base64文本 方便保存
            String pubEncBase64 = new BASE64Encoder().encode(pubEncBytes);
            String priEncBase64 = new BASE64Encoder().encode(priEncBytes);

            Map<String, String> map = new HashMap<String, String>(2);
            map.put(PUBLIC_KEY,pubEncBase64);
            map.put(PRIVATE_KEY,priEncBase64);

            return map;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> keys = RsaUtils.generateKeyPair();
        System.out.println("keys = " + keys);

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCXiwaAHUayhae+qU5ajTnKy4ct57PQ4lcQdqoM" +
                "wn84uKwdPbFPMyyw9YtiuBs6lJJifomuKdZ7afn8OGJ1BQ4kgJmVQCRze3rwhbgD+RWoQZ0heY7f" +
                "R75HLOXRvlHnUs8afqckA2mxmVF43KKb9i8k6VbLmzskAZrjN56VJw+zzwIDAQAB";

        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJeLBoAdRrKFp76pTlqNOcrLhy3n" +
                "s9DiVxB2qgzCfzi4rB09sU8zLLD1i2K4GzqUkmJ+ia4p1ntp+fw4YnUFDiSAmZVAJHN7evCFuAP5" +
                "FahBnSF5jt9Hvkcs5dG+UedSzxp+pyQDabGZUXjcopv2LyTpVsubOyQBmuM3npUnD7PPAgMBAAEC" +
                "f3XMnED6gPpE6yBKe53oKgR6MZp9gkndp9Akbgt9JWfyJdiVHD90iEkGllMmygO/egsWUfAQlalZ" +
                "t/lX2zEbvOFpl4WZ+zsvaC8NhUHWuVawsQk/wj6sNXj5Z0JjlgC4IvhN9YN103cUvIhNvSk9OzaC" +
                "iWmxpgtiu0wLha4j/akCQQD01bkxjowP5vdgIgIBY8jFIItTRqneN8s79beBXQr/tQ2DhJ3uISsG" +
                "5Im4lPkPQwRAnw6BIQdJsdaGM0EM2jP9AkEAnnQvbSJXICTdik7a6ZF75e9uWLd+Lw1fZ3MEosie" +
                "Lub+Q0Q0f57QBKibeJvVGd/3033y1deN4V08lBBYZT7CuwJBAOdK4GEIoRiEwT134x0c/xX64KQT" +
                "JXZgjwZd4rW7CCD5EYMlTW0guF0SmWhek8rvLJ0/pZwnb5MXBepRkSprGKECQQCY5xLw5AdhDFH/" +
                "6fITG4GMs4wu7fpE20mp4PKjRqZmKh9Ht+RVFmIzbKSCMRXlXxudqVcQhW3y/+66Dj/Oi06LAkB0" +
                "SGQNwit58tz8VmbVYQxpdSgmWWEP7mAOACTPDaZY2cKuKwmjWY0rMFngdyX142EmqaItUNomlSxC" +
                "sw8CX2eI";

        System.out.println("RsaUtils.encrypt(\"asdasadasda\", publicKey) = " + RsaUtils.encrypt("asdasadasda", publicKey));


        System.out.println(RsaUtils.decrypt("NtJ/6RHAIsM55EVhim58OagBOv/99RMKkz3Ub5xol40PVcW4tvNTR7uDdVXf1GWrd907uuWBnjgiEDdHIPu8WsP8iLp2Pkrx+/nXtfJRvBmD0zI0CSwZ1/qzi5h7OADXF6wxZZ4Dg66/WLw+SeHZ/kjbkcW7fRqdvSpagDyKkuE=", privateKey));

    }

  
}