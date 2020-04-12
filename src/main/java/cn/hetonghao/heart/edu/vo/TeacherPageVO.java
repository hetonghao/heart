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
 * 讲师 分页对象
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TeacherPageVO对象", description = "讲师")
public class TeacherPageVO extends PageVO {

    @ApiModelProperty(value = "讲师ID")
    private String id;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师")
    private String intro;

    @ApiModelProperty(value = "讲师简介")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

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