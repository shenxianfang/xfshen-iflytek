package com.iflytek.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: sxf
 * @Date:2021/04/27/8:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @TableId(value = "id",type = IdType.NONE)
    private Long id;
    private String roleName;
    private String rolePerm;
    private String description;

}
