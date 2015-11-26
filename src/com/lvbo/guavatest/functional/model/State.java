/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.functional.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 类功能描述:
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/10 11:08
 */
public class State {
    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();

    public State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<City> getMainCities() {
        return mainCities;
    }

    public void setMainCities(Set<City> mainCities) {
        this.mainCities = mainCities;
    }
}
