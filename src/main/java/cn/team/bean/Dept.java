package cn.team.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * create by yifeng
 */
@Data
public class Dept {

    private Integer id;
    @NotBlank(message = "部门名称不能为空")
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private LocalDateTime updateTime;
    private Integer parentId;

    /**
     * 是否删除 0： 正常 1： 删除
     */
    private String status;

}
