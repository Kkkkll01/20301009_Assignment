package com.example.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 物流公司表(Company)表实体类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company extends Model<Company> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String contactPerson;
    private String address;
    private String phoneNumber;
    private String contactPhoneNumber;
}
