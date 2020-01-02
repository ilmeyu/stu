package com.ilem.stu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ilem.dto.common.Input;
import com.ilem.dto.common.RestResponse;
import com.ilem.exception.InvalidArgRestException;
import com.ilem.exception.RpcException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @Author ilem
 * @date 2019/12/30 9:42 下午
 * @since 1.0.0
 **/
@Slf4j
@Order
@Aspect
@Component
public class Aop {
	static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	static {
		OBJECT_MAPPER.registerModule(new JavaTimeModule());
		OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	@Pointcut(value = "within(com.ilem.controller..*)")
	public void apiPointcut(){

	}

	@Around(value = "apiPointcut()")
	public Object doApi(ProceedingJoinPoint joinPoint) {

		Object proceed = null;
		// 拦截入参
		Object arg = joinPoint.getArgs()[0];
		// 记录入参日志
		try {
			log.info("REST入参: {}", OBJECT_MAPPER.writeValueAsString(arg));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		// 入参合法性检查
		if (arg instanceof Input) {
			try {
				((Input) arg).doCheck();
			} catch (InvalidArgRestException ex) {
				log.error("参数非法异常: {}", ex.getMessage());
				// 返回错误信息
				return RestResponse.fail(ex.getMessage());
			}
		}

		// 执行目标API
		try {
			proceed = joinPoint.proceed();
		} catch (RpcException ex) {
			log.error("RPC业务异常: {}", ex.getMessage());
			// 返回错误信息
			return RestResponse.fail(ex.getMessage());
		} catch (Throwable ex) {
			// 全局异常处理
			log.error("服务器异常: {}", ex.getMessage());
		}
		// 拦截出参
		// 记录出参日志
		try {
			log.info("REST出参: {}", OBJECT_MAPPER.writeValueAsString(proceed));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return proceed;
	}
}
