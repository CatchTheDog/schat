package com.majq.schat.utils;

import com.majq.schat.beans.AdministrativeAreaRspBean;
import com.majq.schat.beans.ResultBean;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
     * 请求腾讯地图 省县乡 三级行政区划   接口：https://apis.map.qq.com/ws/district/v1/list
     */
    public static AdministrativeAreaRspBean requestListInterface() throws IOException, NoSuchAlgorithmException {
        Properties properties = readConf(null, null);
        String requestHost = (String) properties.get("requestHost");
        String requestPath = (String) properties.get("requestListPath");
        String key = (String) properties.get("key");
        String sk = (String) properties.get("sk");
        TreeMap<String, String> params = new TreeMap<>();
        params.put("key", key);
        String rsp = requestURL(generateRequestURL(requestHost, requestPath, sk, params));
        return JsonUtils.parseObject(rsp, AdministrativeAreaRspBean.class);
    }

    /**
     * 请求腾讯地图 省县乡 三级行政区划 接口：https://apis.map.qq.com/ws/district/v1/getchildren
     *
     * @param id 父级行政区id
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static AdministrativeAreaRspBean requestChildrenInterface(String id) throws IOException, NoSuchAlgorithmException {
        Properties properties = readConf(null, null);
        String requestHost = (String) properties.get("requestHost");
        String requestPath = (String) properties.get("requestChildrenPath");
        String key = (String) properties.get("key");
        String sk = (String) properties.get("sk");
        TreeMap<String, String> params = new TreeMap<>();
        params.put("key", key);
        params.put("id", id);
        String rsp = requestURL(generateRequestURL(requestHost, requestPath, sk, params));
        return JsonUtils.parseObject(rsp, AdministrativeAreaRspBean.class);
    }

    /**
     * 请求腾讯地图 省县乡 三级行政区划 接口：https://apis.map.qq.com/ws/district/v1/search
     *
     * @param search 行政区划名称搜索关键词
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static AdministrativeAreaRspBean requestSearchInterface(String search) throws IOException, NoSuchAlgorithmException {
        Properties properties = readConf(null, null);
        String requestHost = (String) properties.get("requestHost");
        String requestPath = (String) properties.get("requestSearchPath");
        String key = (String) properties.get("key");
        String sk = (String) properties.get("sk");
        TreeMap<String, String> params = new TreeMap<>();
        params.put("key", key);
        params.put("keyword", search);
        String rsp = requestURL(generateRequestURL(requestHost, requestPath, sk, params));
        return JsonUtils.parseObject(rsp, AdministrativeAreaRspBean.class);
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
     * @param rspBean 响应对象
     * @return 转换后对象
     */
    private static void transferAdministrativeAreaRsp(AdministrativeAreaRspBean rspBean) {
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
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        AdministrativeAreaRspBean bean = requestListInterface();
        transferAdministrativeAreaRsp(bean);
        System.out.println(bean.getCountyLevelResults());
        System.out.println(bean.getPrefectureLevelResults().get(0));
        System.out.println(bean.getProvinceLevelResults());
    }
}
