package cn.jants.demos.entity;

import cn.jants.common.annotation.action.Entity;

/**
 * @author MrShun
 * @version 1.0
 * @Date 2017/12/20
 */
@Entity
public class User {

    private String name;

    private Integer age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
