package com.github.loafer.spring.mvc.convert;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhaojh.
 */
public class JavaBean {
    private Integer primitive;
    private Date date;
    private List<Integer> list;
    private Map<String, String> map;
    private NestedBean nested;

    public Integer getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Integer primitive) {
        this.primitive = primitive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public NestedBean getNested() {
        return nested;
    }

    public void setNested(NestedBean nested) {
        this.nested = nested;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JavaBean");

        if(null != primitive){
            sb.append(" primitive=").append(primitive);
        }

        if(null != date){
            sb.append(" date=").append(date);
        }

        if(null != list){
            sb.append(" list=").append(list);
        }

        if(null != map){
            sb.append(" map=").append(map);
        }

        if (null != nested){
            sb.append(" nestedBean=").append(nested);
        }

        return sb.toString();
    }
}
