package com.example.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.dao.CompanyDao;
import com.example.order.entity.Company;
import com.example.order.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * (Company)表服务实现类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, Company> implements CompanyService {

}
