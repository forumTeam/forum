package com.forum.pojo.roleControllerVo;

import io.swagger.annotations.ApiModelProperty;
import com.forum.pojo.AbstractVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class SelectRoleVo extends AbstractVo{

    //查所有
    public String All;

    //查自己
    public  String myRole;
}
