import request from '@/utils/request'

// 查询顾客中心列表
export function listCustomer(query) {
  return request({
    url: '/test1/customer/list',
    method: 'get',
    params: query
  })
}

// 查询顾客中心详细
export function getCustomer(id) {
  return request({
    url: '/test1/customer/' + id,
    method: 'get'
  })
}

// 新增顾客中心
export function addCustomer(data) {
  return request({
    url: '/test1/customer',
    method: 'post',
    data: data
  })
}

// 修改顾客中心
export function updateCustomer(data) {
  return request({
    url: '/test1/customer',
    method: 'put',
    data: data
  })
}

// 删除顾客中心
export function delCustomer(id) {
  return request({
    url: '/test1/customer/' + id,
    method: 'delete'
  })
}
