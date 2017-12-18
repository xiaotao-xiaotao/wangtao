package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志记录
 *
 */
@Aspect
@Component
public class WebLogAspect {

	private final Logger logger = Logger.getLogger(this.getClass());
	ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
	//@Pointcut("within(@org.springframework.stereotype.Controller *)")
	@Pointcut("execution(* com.example.demo.controller.*.*(..))")
	public void logPoint() {
	}
	@Before(value = "logPoint()")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		Map<String, Object> map = new HashMap<String,Object>();
		// 记录方法开始执行的时间
		map.put("startTimeMillis", System.currentTimeMillis());
		threadLocal.set(map);
	}
	@After(value = "logPoint()")
	public void doAfterInServiceLayer(JoinPoint jp) {
		try {
			Map<String, Object> map = threadLocal.get();
			// 接收到请求，记录请求内容
			map.put("endTimeMillis", System.currentTimeMillis());
			JSONObject info=new JSONObject();
			info.put("目标方法", jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName());
			info.put("传入参数",getParameters(jp.getArgs()));
			map.put("info",info);

			this.printOptLog();
			logger.info(info.toJSONString());
		} catch (Exception e) {
			logger.error("日志切面出错", e);
		}
	}

	@Around(value = "logPoint()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
//		try{
		Object result = pj.proceed();// result的值就是被拦截方法的返回值
		Map<String, Object> map =threadLocal.get();
		map.put("result", result);
		return result;
//		}
//		catch (Exception e) {
//			Map<String, Object> map =threadLocal.get();
//			map.put("result", e);
//			return null;
//		}

	}
	@AfterThrowing(value = "logPoint()", throwing = "e")
	public void afterThrowing(Throwable e) {
		if (e instanceof Exception) {
			logger.error("通知中发现异常StationErrorCodeException", e);
		} else {
			logger.error("通知中发现未知异常", e);
		}
	}
	private void printOptLog() {
		Map<String, Object> map = threadLocal.get();
		Long startTimeMillis = (Long) map.get("startTimeMillis");
		Long endTimeMillis = (Long) map.get("endTimeMillis");
		JSONObject info=(JSONObject) map.get("info");
		Object result=map.get("result");
		String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
		info.put("开始时间", optTime);
		info.put("消耗时间", (endTimeMillis - startTimeMillis)+"ms");
		if (result != null) {
			info.put("info", result);
		}
	}
	private Object getParameter(Object obj){
		if(obj instanceof HttpServletRequest){
			HttpServletRequest request=(HttpServletRequest)obj;
			JSONObject json=new JSONObject();
			json.put("paramters", request.getParameterMap());
			json.put("客户端ip",request.getRemoteAddr());
			json.put("服务端ip", request.getLocalAddr());
			json.put("来源url",  request.getHeader("Referer"));
			return json;
		}
		else if(obj instanceof HttpServletResponse ){
			return obj.toString();
		}
		else{
			try{
				return JSONObject.toJSONString(obj);
			}
			catch(Exception e){
				return obj.toString();
			}
		}
	}
	private List<Object> getParameters(Object [] objs){
		List<Object> list=new ArrayList<>();
		for(Object obj :objs){
			list.add(getParameter(obj));
		}
		return list;
	}
}
