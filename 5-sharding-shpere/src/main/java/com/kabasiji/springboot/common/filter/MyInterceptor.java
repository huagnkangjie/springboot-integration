package com.kabasiji.springboot.common.filter;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author huang_kangjie
 * @create 2018-09-11 8:49
 **/
@Log4j2
public class MyInterceptor implements HandlerInterceptor {

     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
          String path = request.getRequestURL().toString();

          ThreadContext.put("tracker_id", UUID.randomUUID().toString());

          return true;
     }

     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

     }

     @Override
     public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

     }

     /**
      * 401
      * @param resp
      * @param errMsg
      * @throws IOException
      */
     public void sendUnAuthResponse(HttpServletResponse resp, String errMsg) throws IOException {
          resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, errMsg);
          resp.getWriter().flush();
     }

     /**
      * 403
      * @param resp
      * @param errMsg
      * @throws IOException
      */
     public void sendForbidenResponse(HttpServletResponse resp, String errMsg) throws IOException {
          resp.sendError(HttpServletResponse.SC_FORBIDDEN, errMsg);
          resp.getWriter().flush();
     }
}
