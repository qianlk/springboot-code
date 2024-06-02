package org.sboot.ssmp.controller.interceptor;

import com.zigzag.service.IpCountService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置ip count
 *
 * @author qlk
 */
public class IpCountInterceptor implements HandlerInterceptor {

    @Resource
    private IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }
}
