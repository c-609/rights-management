package cn.team.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
@Data
public class Menu implements Serializable {
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer parentId;
    
    private List<Role> roles;
    private List<Menu> children;
    private MenuMeta meta;

}
