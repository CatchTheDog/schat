package com.majq.schat.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.X
 * @version 1.0.0
 * 腾讯行政区划 接口响应对象bean
 * @since 2019/01/18 16:05
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdministrativeAreaRspBean {
    /**
     * 状态码，0为正常,
     * 310请求参数信息有误，
     * 311Key格式错误,
     * 306请求有护持信息请检查字符串,
     * 110请求来源未被授权
     */
    private Integer status;
    /**
     * 状态说明
     */
    private String message;
    /**
     * 行政区划数据版本，用于定期更新
     */
    private String data_version;
    /**
     * 结果数组，第0项，代表一级行政区划，第1项代表二级行政区划，以此类推；使用getchildren接口时，仅为指定父级行政区划的子级
     */
    private Object[] result;  //此处使用Object类型，因为数组嵌套，数组类型为Object.class,使用其他类型会报错

    private List<ResultBean> results = new ArrayList<>();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData_version() {
        return data_version;
    }

    public void setData_version(String data_version) {
        this.data_version = data_version;
    }

    public Object[] getResult() {
        return result;
    }

    public void setResult(Object[] result) {
        this.result = result;
    }

    public List<ResultBean> getResults() {
        return results;
    }

    public void setResults(List<ResultBean> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AdministrativeAreaRspBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data_version='" + data_version + '\'' +
                ", result=" + Arrays.toString(result) +
                ", results=" + results +
                '}';
    }
}
