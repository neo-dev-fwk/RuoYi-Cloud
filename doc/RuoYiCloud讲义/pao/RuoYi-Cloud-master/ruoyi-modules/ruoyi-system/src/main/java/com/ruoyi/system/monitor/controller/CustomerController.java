package com.ruoyi.system.monitor.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.monitor.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.monitor.domain.Customer;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 顾客Controller
 *
 * @author 王清江
 * @date 2024-04-22
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController
{
    @Autowired
    private ICustomerService customerService;

    /**
     * 查询顾客列表
     */
    @RequiresPermissions("monitor:customer:list")
    @GetMapping("/list")
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出顾客列表
     */
    @RequiresPermissions("monitor:customer:export")
    @Log(title = "顾客", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        util.exportExcel(response, list, "顾客数据");
    }

    /**
     * 获取顾客详细信息
     */
    @RequiresPermissions("monitor:customer:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(customerService.selectCustomerById(id));
    }

    /**
     * 新增顾客
     */
    @RequiresPermissions("monitor:customer:add")
    @Log(title = "顾客", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改顾客
     */
    @RequiresPermissions("monitor:customer:edit")
    @Log(title = "顾客", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除顾客
     */
    @RequiresPermissions("monitor:customer:remove")
    @Log(title = "顾客", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerService.deleteCustomerByIds(ids));
    }
}
