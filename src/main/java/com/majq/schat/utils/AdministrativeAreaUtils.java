package com.majq.schat.utils;

import com.majq.schat.beans.AdministrativeAreaRspBean;
import com.majq.schat.beans.ResultBean;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static com.majq.schat.utils.URLUtils.*;

/**
 * @author Mr.X
 * @version 1.0.0
 * 三级行政区划工具
 * @since 2019/01/18 14:53
 */
public class AdministrativeAreaUtils {

    /**
     * 发送请求并解析响应
     *
     * @param requestHost 请求主机
     * @param requestPath 请求路径
     * @param sk          sk
     * @param params      参数
     * @return 解析后的响应对象
     * @throws Exception
     */
    private static AdministrativeAreaRspBean sendReqSp(String requestHost, String requestPath, String sk, TreeMap<String, String> params) throws Exception {
        String rsp = requestURL(generateRequestURL(requestHost, requestPath, sk, params));
        return transferAdministrativeAreaRsp(rsp);
    }

    /**
     * 请求腾讯讯地图 省县乡 三级行政区划
     * 接口：https://apis.map.qq.com/ws/district/v1/list  无需其他额外参数
     * https://apis.map.qq.com/ws/district/v1/getchildren 需要传入id
     * https://apis.map.qq.com/ws/district/v1/search 需要传入keyword
     *
     * @param requestPathKey 请求接口路径在配置文件中的key
     * @param params         参数集合，需要在外部构造然后传入
     * @return 接口响应结果对象
     * @throws Exception
     */
    private static AdministrativeAreaRspBean getAdministrativeAreaInfo(String requestPathKey, TreeMap<String, String> params) throws Exception {
        if (StringUtils.isNotBlank(requestPathKey) && null != params) {
            Properties properties = readConf(null, null);
            String requestHost = (String) properties.get("requestHost");
            String requestPath = (String) properties.get(requestPathKey);
            String key = (String) properties.get("key");
            String sk = (String) properties.get("sk");
            params.put("key", key);
            return sendReqSp(requestHost, requestPath, sk, params);
        } else
            throw new IllegalArgumentException("reqeustPathKey & params can't be null !");

    }

    /**
     * 获取行政区划 list
     *
     * @return
     * @throws Exception
     */
    public static AdministrativeAreaRspBean getAdministrativeAreaList() throws Exception {
        TreeMap<String, String> params = new TreeMap<>();
        return getAdministrativeAreaInfo("requestListPath", params);
    }

    /**
     * 获取子级行政区划列表
     *
     * @param id 父级行政区id
     * @return 子级行政区划列表
     * @throws Exception
     */
    public static AdministrativeAreaRspBean getAdminnistrativeAreaChildren(String id) throws Exception {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("id", id);
        return getAdministrativeAreaInfo("requestChildrenPath", params);
    }

    /**
     * 根据关键词搜索行政区划信息
     *
     * @param keyword 搜索关键词
     * @return 匹配的行政区划信息
     * @throws Exception
     */
    public static AdministrativeAreaRspBean getAdministrativeAreaSearch(String keyword) throws Exception {
        TreeMap<String, String> params = new TreeMap<>();
        params.put("keyword", keyword);
        return getAdministrativeAreaInfo("requestSearchPath", params);
    }

    /**
     * 从JackSon解析结果中获取ResultBean对象
     *
     * @param list 源对象集合
     * @return 解析完成后对象集合
     */
    private static List<ResultBean> parseResult(ArrayList<LinkedHashMap<String, Object>> list) {
        List<ResultBean> resultBeans = new ArrayList<>();
        if (null != list && list.size() > 0) {
            for (LinkedHashMap<String, Object> element : list) {
                ResultBean resultBean = new ResultBean();
                resultBean.setId(Integer.valueOf((String) element.get("id")));
                resultBean.setName((String) element.get("name"));
                resultBean.setFullname((String) element.get("fullname"));
                resultBean.setPinyin((ArrayList<String>) element.get("pinyin"));
                resultBean.setLocation((LinkedHashMap<String, Double>) element.get("location"));
                resultBean.setCidx((ArrayList<Integer>) element.get("cidx"));
                resultBeans.add(resultBean);
            }
        }
        return resultBeans;
    }

    /**
     * 转换响应对象为指定响应模型对象
     *
     * @param rsp 响应结果字符串
     * @return 转换后的响应结果
     */
    private static AdministrativeAreaRspBean transferAdministrativeAreaRsp(String rsp) throws Exception {
        if (StringUtils.isNotBlank(rsp)) {
            AdministrativeAreaRspBean rspBean = JsonUtils.parseObject(rsp, AdministrativeAreaRspBean.class);
            if (rspBean.getStatus() == 0) {
                Object[] resultBeans = rspBean.getResult();
                for (int i = 0; i < resultBeans.length; i++) {
                    ArrayList<LinkedHashMap<String, Object>> list = (ArrayList<LinkedHashMap<String, Object>>) resultBeans[i];
                    if (i == 0)
                        rspBean.setProvinceLevelResults(parseResult(list));
                    else if (i == 1)
                        rspBean.setPrefectureLevelResults(parseResult(list));
                    else if (i == 2)
                        rspBean.setCountyLevelResults(parseResult(list));
                }
                return rspBean;
            } else
                throw new Exception("请求地区行政区划接口数据异常！");
        } else
            throw new IllegalArgumentException("rsp is null !");

    }

    public static void main(String[] args) throws Exception {
        AdministrativeAreaRspBean rspBean = getAdministrativeAreaList();
        System.out.println(rspBean.getProvinceLevelResults());
    }
}
