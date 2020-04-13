package cn.hetonghao.heart.edu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.mybatisplus.vo.PageVO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 课程科目 分页对象
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SubjectPageVO对象", description = "课程科目")
public class SubjectPageVO extends PageVO {

    @ApiModelProperty(value = "课程类别ID")
    private String id;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "筛选起始:创建时间")
    private LocalDateTime startGmtCreate;

    @ApiModelProperty(value = "筛选结束:创建时间")
    private LocalDateTime endGmtCreate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "筛选起始:更新时间")
    private LocalDateTime startGmtModified;

    @ApiModelProperty(value = "筛选结束:更新时间")
    private LocalDateTime endGmtModified;
}