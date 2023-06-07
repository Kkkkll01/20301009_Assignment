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
 * (TransportOrder)表实体类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportOrder extends Model<TransportOrder> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String orderNumber;
    private Integer userId;
    private String username;
    private Integer companyId;
    private String companyName;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    private String shipperName;
    private String shipperPhoneNumber;
    private String shipperAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private String receiverAddress;
    private String remark;
}
