import request from '@/utils/request'

// 查询在线用户列表
export function getCacheList(name) {
  return request({
    url: `/system/test/cache/${name}`,
    method: 'get',
  })
}

//
export function getCacheKey(name) {
  return request({
    url: `/system/test/cache/key/${name}`,
    method: 'get',
  })
}

