package com.ruoyi.system.monitor.service;

import java.util.List;
import com.ruoyi.system.monitor.domain.Customer;

/**
 * 顾客Service接口
 *
 * @author 王清江
 * @date 2024-04-22
 */
public interface ICustomerService
{
    /**
     * 查询顾客
     *
     * @param id 顾客主键
     * @return 顾客
     */
    public Customer selectCustomerById(Long id);

    /**
     * 查询顾客列表
     *
     * @param customer 顾客
     * @return 顾客集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增顾客
     *
     * @param customer 顾客
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改顾客
     *
     * @param customer 顾客
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 批量删除顾客
     *
     * @param ids 需要删除的顾客主键集合
     * @return 结果
     */
    public int deleteCustomerByIds(Long[] ids);

    /**
     * 删除顾客信息
     *
     * @param id 顾客主键
     * @return 结果
     */
    public int deleteCustomerById(Long id);
}
