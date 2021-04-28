package com.iflytek.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: sxf
 * @Date:2021/04/27/8:45
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private String id;
    @TableField(value = "name")
    private String permissionName;
    private String url;

}
