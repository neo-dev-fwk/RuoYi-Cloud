package com.ruoyi.test1.service;

import java.util.List;
import com.ruoyi.test1.domain.Customer;

/**
 * 顾客中心Service接口
 * 
 * @author 王清江
 * @date 2024-04-22
 */
public interface ICustomerService 
{
    /**
     * 查询顾客中心
     * 
     * @param id 顾客中心主键
     * @return 顾客中心
     */
    public Customer selectCustomerById(Long id);

    /**
     * 查询顾客中心列表
     * 
     * @param customer 顾客中心
     * @return 顾客中心集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增顾客中心
     * 
     * @param customer 顾客中心
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改顾客中心
     * 
     * @param customer 顾客中心
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 批量删除顾客中心
     * 
     * @param ids 需要删除的顾客中心主键集合
     * @return 结果
     */
    public int deleteCustomerByIds(Long[] ids);

    /**
     * 删除顾客中心信息
     * 
     * @param id 顾客中心主键
     * @return 结果
     */
    public int deleteCustomerById(Long id);
}
