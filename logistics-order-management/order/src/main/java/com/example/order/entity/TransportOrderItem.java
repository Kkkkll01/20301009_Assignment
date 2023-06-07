package com.example.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (TransportOrderItem)表实体类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportOrderItem extends Model<TransportOrderItem> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer transportOrderId;
    private String status;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
}
