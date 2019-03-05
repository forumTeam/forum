package com.forum.common.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：JWT Token的加密和解密工具类.
 * @author 潘溢林
 * 功能完成结果：完成
 * 修改日期：2017/12/02 10：19
 */
public class JWTUtil {

	private static final String SECRET = PropertiesUtil.get("jwt.Secret");
	private static final String EXP = "exp";
	private static final String PAYLOAD = "PAYLOAD";
	
	private static Logger logger = LoggerFactory.getLogger(JWTUtil.class);
	
	/**
	 * 功能描述：将传入的Object加密成Token字符串.
	 * @author 潘溢林
	 * 功能完成结果：完成
	 * 修改日期：2017/12/02 10：19
	 */
	public static <T> String sign(T object, long maxAge){
		try{
			final JWTSigner signer = new JWTSigner(SECRET);
			final Map<String,Object> claims = new HashMap<>();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(object);
			claims.put(PAYLOAD, jsonString);
			claims.put(EXP, System.currentTimeMillis() + maxAge);
			return signer.sign(claims);
		} catch(Exception e) {
			logger.error(String.format("JWTUtil生成 Token发生错误!!!，[Object]：%s", object),e);
			return null;
		}
	}

	/**
	 * 功能描述：将传入的Object加密成Token字符串.
	 * @author 潘溢林
	 * 功能完成结果：完成
	 * 修改日期：2017/12/02 10：19
	 */
	public static <T> String sign(T object){
		return sign(object, Long.valueOf(PropertiesUtil.get("token.maxAge", "18000000")));
	}
	
	/**
	 * 功能描述：将Token字符串，解密成指定的classT对象.
	 * @author 潘溢林
	 * 功能完成结果：完成
	 * 修改日期：2017/12/02 10：19
	 */
	public static <T> T unsign(String jwt, Class<T> classT) {
		final JWTVerifier verifier = new JWTVerifier(SECRET);
		try {
			final Map<String,Object> claims = verifier.verify(jwt);
			if(claims.containsKey(EXP) && claims.containsKey(PAYLOAD)){
				long exp = (Long) claims.get(EXP);
				long currentTimeMillis = System.currentTimeMillis();
				if (exp > currentTimeMillis) {
					String json = (String) claims.get(PAYLOAD);
					ObjectMapper mapper = new ObjectMapper();
					return mapper.readValue(json, classT);
				}
			}
			return null;
		} catch(Exception e) {
			logger.error(String.format("JWTUtil解析Token发生错误!!!，[JWT]：%s; [CLASS_T]：%s", jwt, classT.getName()),e);
			return null;
		}
	}
	
}
