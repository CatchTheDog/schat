package com.majq.schat.beans;

import java.util.List;
import java.util.Map;

/**
 * 响应结果result
 */
public class ResultBean {
    /**
     * 行政区划唯一标识
     * 注：省直辖地区，在数据表现上有一个重复的虚拟节点（其id最后两位为99），
     * 其目的是为了表明省直辖关系而增加的，开发者可根据实际需要选用
     */
    private Integer id;
    /**
     * 简称
     */
    private String name;
    /**
     * 全称
     */
    private String fullname;
    /**
     * 中心点坐标
     */
    private Map<String, Double> location;
    /**
     * 行政区划拼音，每一下标为一个字的全拼，如：["nei","meng","gu"]
     */
    private List<String> pinyin;
    /**
     * 子级行政区划在下级数组中的下标位置
     */
    private List<Integer> cidx;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Map<String, Double> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Double> location) {
        this.location = location;
    }

    public List<String> getPinyin() {
        return pinyin;
    }

    public void setPinyin(List<String> pinyin) {
        this.pinyin = pinyin;
    }

    public List<Integer> getCidx() {
        return cidx;
    }

    public void setCidx(List<Integer> cidx) {
        this.cidx = cidx;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullname='" + fullname + '\'' +
                ", location=" + location +
                ", pinyin=" + pinyin +
                ", cidx=" + cidx +
                '}';
    }
}
