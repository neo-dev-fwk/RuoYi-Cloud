package com.ruoyi.test1.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test1.mapper.CustomerMapper;
import com.ruoyi.test1.domain.Customer;
import com.ruoyi.test1.service.ICustomerService;

/**
 * 顾客中心Service业务层处理
 * 
 * @author 王清江
 * @date 2024-04-22
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询顾客中心
     * 
     * @param id 顾客中心主键
     * @return 顾客中心
     */
    @Override
    public Customer selectCustomerById(Long id)
    {
        return customerMapper.selectCustomerById(id);
    }

    /**
     * 查询顾客中心列表
     * 
     * @param customer 顾客中心
     * @return 顾客中心
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    /**
     * 新增顾客中心
     * 
     * @param customer 顾客中心
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改顾客中心
     * 
     * @param customer 顾客中心
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 批量删除顾客中心
     * 
     * @param ids 需要删除的顾客中心主键
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(Long[] ids)
    {
        return customerMapper.deleteCustomerByIds(ids);
    }

    /**
     * 删除顾客中心信息
     * 
     * @param id 顾客中心主键
     * @return 结果
     */
    @Override
    public int deleteCustomerById(Long id)
    {
        return customerMapper.deleteCustomerById(id);
    }
}
