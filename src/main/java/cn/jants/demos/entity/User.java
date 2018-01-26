package cn.jants.demos.entity;

import cn.jants.common.bean.JsonMap;

import java.util.Date;
import java.util.List;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
public class User {

    private Long id;

    private String account;

    private Integer sex;

    private Date posTime;

    private List<String> strList;

    private List<JsonMap> jsonMapList;

    private List<Integer> intList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getPosTime() {
        return posTime;
    }

    public void setPosTime(Date posTime) {
        this.posTime = posTime;
    }
}
