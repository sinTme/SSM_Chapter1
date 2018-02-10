package com.powek.common.enumer;

public enum SexType {
    MALE("男",1),FEMALE("女",2);
    private String sex;
    private Integer type;

    public Integer getType() {
        return type;
    }

    private SexType(String sex, Integer type)
    {
        this.sex = sex;
        this.type = type;
    }

    public static SexType getByType(Integer type)
    {
        if (type == null)
        {
            return null;
        }
        for (SexType sexType : SexType.values())
        {
            if (sexType.type.equals(type))
            {
                return sexType;
            }
        }
        return null;
    }
}
