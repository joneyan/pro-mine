package com.jone.pro.admin.vo.request;

import com.jone.pro.common.base.ParamsObject;

/**
 * @Author: yanjing
 * @Date: 2019/4/18 上午11:43
 * @Description:
 */
public class AopRequst extends ParamsObject {
    private String name;

    private String age;
    @Override
    public void validate() {
        if (name == null){
            System.out.println("名字不能为null");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
