import request from '@/utils/request'

// 查询顾客列表
export function listCustomer(query) {
  return request({
    url: '/system/customer/list',
    method: 'get',
    params: query
  })
}

// 查询顾客详细
export function getCustomer(id) {
  return request({
    url: '/system/customer/' + id,
    method: 'get'
  })
}

// 新增顾客
export function addCustomer(data) {
  return request({
    url: '/system/customer',
    method: 'post',
    data: data
  })
}

// 修改顾客
export function updateCustomer(data) {
  return request({
    url: '/system/customer',
    method: 'put',
    data: data
  })
}

// 删除顾客
export function delCustomer(id) {
  return request({
    url: '/system/customer/' + id,
    method: 'delete'
  })
}
