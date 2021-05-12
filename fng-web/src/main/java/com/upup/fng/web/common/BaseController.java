package com.upup.fng.web.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.upup.fng.common.BaseEntity;
import com.upup.fng.engine.model.dto.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/7/31 下午3:38
 */
public abstract class BaseController<P extends BaseEntity, V extends P, S extends IService<P>> {

    private ThreadLocal<V> params = new ThreadLocal<V>();
    private ThreadLocal<Result> json = new ThreadLocal<Result>();
    private ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();
    private ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    private ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();

    private S service;

    @ModelAttribute
    public void requestInit(HttpServletRequest request, HttpServletResponse response, V item){
        this.params.set(item);
        this.request.set(request);
        this.response.set(response);
        this.session.set(request.getSession());
        this.json.set(new Result());
    }
    
    @ExceptionHandler
    public String exception(HttpServletRequest request, HttpServletResponse response, Exception e){
        if(e instanceof RuntimeException){
            return "301301";
        }
        return "301301";
    }

    public Result json(){
        return this.json.get();
    }

    public S service(){
        return service;
    }

    public V params() {
        return params.get();
    }

    /**
     * 获取 params
     * @return the params
     */
    public ThreadLocal<V> getParams() {
        return params;
    }

    /**
     * 设置 params
     * @param params the params to set
     */
    public void setParams(ThreadLocal<V> params) {
        this.params = params;
    }

    /**
     * 获取 service
     * @return the service
     */
    public S getService() {
        return service;
    }

    /**
     * 设置 service
     * @param service the service to set
     */
    @Resource
    public void setService(S service) {
        this.service = service;
    }

    /**
     * 获取 request
     * @return the request
     */
    public ThreadLocal<HttpServletRequest> getRequest() {
        return request;
    }

    /**
     * 设置 request
     * @param request the request to set
     */
    public void setRequest(ThreadLocal<HttpServletRequest> request) {
        this.request = request;
    }

    /**
     * 获取 response
     * @return the response
     */
    public ThreadLocal<HttpServletResponse> getResponse() {
        return response;
    }

    /**
     * 设置 response
     * @param response the response to set
     */
    public void setResponse(ThreadLocal<HttpServletResponse> response) {
        this.response = response;
    }

    /**
     * 获取 session
     *
     * @return the session
     */
    public ThreadLocal<HttpSession> getSession() {
        return session;
    }

    /**
     * 设置 session
     *
     * @param session the session to set
     */
    public void setSession(ThreadLocal<HttpSession> session) {
        this.session = session;
    }

    /**
     * 获取 json
     *
     * @return the json
     */
    public ThreadLocal<Result> getJson() {
        return json;
    }

    /**
     * 设置 json
     *
     * @param json the json to set
     */
    public void setJson(ThreadLocal<Result> json) {
        this.json = json;
    }
}
