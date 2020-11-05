package com.example.zero.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FbSysUser implements Serializable {
    private static final long serialVersionUID = -8725068474072021448L;

    private Integer id;

    private String account;

    private String cname;

    private String ename;

    private String sex;

    private String email;

    private String phone;

    private String identity;




    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof FbSysUser) {
            FbSysUser vo = (FbSysUser) obj;

            // 比较每个属性的值 一致时才返回true
            if (vo.account.equals(this.account) && vo.cname.equals(this.cname))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return account.hashCode() * cname.hashCode();
    }


}
