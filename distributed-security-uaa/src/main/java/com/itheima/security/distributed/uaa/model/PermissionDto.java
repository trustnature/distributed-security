package com.itheima.security.distributed.uaa.model;

import lombok.Data;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
public class PermissionDto {

    private String ID;
    private String permission_NAME;
    private String description;
    private String permission_url;
}
