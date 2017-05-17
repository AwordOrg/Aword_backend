package aword.security.impl;

import aword.security.TokenManager;
import aword.util.CodecUtil;
import aword.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 将 token 存储到 JVM 内存中
 *
 * Created by Lee on 2017/5/7 0007.
 */
@Component
public class DefaultTokenManager implements TokenManager {


    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, username);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }


    @Override
    public String getUserName(String token){
        return tokenMap.get(token);
    }

    @Override
    public boolean removeToken(String token) {
        if (tokenMap.containsKey(token)){
            tokenMap.remove(token);
            return true;
        }
        return false;
    }


}