<script>
import {getCacheKey, getCacheList} from "@/api/monitor/cache";


export default {
  name: "Cache",
  data() {
    return {
      loading: false,
      cacheList: [
        {
          num: 1,
          name: 'login_tokens',
          info: '用户信息'
        }, {
          num: 2,
          name: 'sys_config',
          info: '配置信息'
        }, {
          num: 3,
          name: 'sys_dict',
          info: '数据字典'
        }, {
          num: 4,
          name: 'captcha_codes',
          info: '验证码'
        }, {
          num: 5,
          name: 'pwd_err_cnt',
          info: '密码错误次数'
        },
      ],
      keysData: [],
      data1: '',
      data2: '',
      data3: ''
    }
  },
  methods: {
    rowClick(row) {
      const cacheName = row.name;
      this.loading = true
      getCacheList(cacheName).then(res => {
        const data = res.rows;
        this.keysData = data.map((item, index) => {
          const name = item.split(":")[1]
          return {
            cacheName,
            index: index + 1,
            name
          }
        })
        this.loading = false
      }).catch(err => {
        this.loading = false
      })
    },
    keysDataClick(row) {
      this.data1 = row.cacheName;
      this.data2 = row.name;
      this.loading = true
      getCacheKey(row.cacheName + ':' + row.name).then(res => {
        const data = res.msg;
        this.data3 = data
        this.loading = false
      }).catch(err => {
        this.loading = false
      })


    }
  }
}
</script>

<template>
  <div class="outerContainer" v-loading="loading">
    <el-row :gutter="20" class="full-height">
      <el-col :span="8" class="full-height">

        <el-card class="full-height ">
          <div slot="header" class="clearfix">
            <i class="el-icon-collection-tag"></i>
            <span>缓存列表</span>
          </div>
          <el-table
            :row-style="{height: '70px'}"
            :data="cacheList"
            style="width: 100%;height: 100%;"
            @row-click="rowClick"
          >
            <el-table-column
              prop="num"
              label="序号"
              width="100"

            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="缓存名称"

            >
            </el-table-column>
            <el-table-column
              prop="info"
              label="备注">
            </el-table-column>
            <el-table-column
              label="操作"
              width="100">
              <template>
                <i class="el-icon-delete" style="color: #fd3434;"></i>
              </template>
            </el-table-column>
          </el-table>


        </el-card>

      </el-col>
      <el-col class="full-height" :span="8">
        <el-card class="full-height">
          <div slot="header" class="clearfix">
            <i class="el-icon-basketball"></i>
            <span>键名列表</span>
          </div>
          <el-table
            :row-style="{height: '70px'}"
            :data="keysData"
            style="width: 100%;height: 100%;"
            @row-click="keysDataClick"
          >
            <el-table-column
              prop="index"
              width="100"
              label="序号"
            >
            </el-table-column>
            <el-table-column
              prop="name"
              label="缓存键名"
            >
            </el-table-column>

            <el-table-column
              label="操作"
              width="100">
              <template>
                <i class="el-icon-delete" style="color: #fd3434;"></i>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>
      <el-col class="full-height" :span="8">
        <el-card class="full-height">
          <div slot="header" class="clearfix">
            <i class="el-icon-document"></i>
            <span>缓存内容</span>
          </div>

          <el-form>
            <el-form-item label="缓存名称">
              <el-input readonly v-model="data1"></el-input>
            </el-form-item>
          </el-form>
          <el-form>
            <el-form-item label="缓存键名">
              <el-input readonly v-model="data2"></el-input>
            </el-form-item>
          </el-form>
          <el-form>
            <el-form-item label="缓存内容">
              <el-input type="textarea" readonly v-model="data3"></el-input>
            </el-form-item>
          </el-form>


        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<style scoped lang="scss">
.outerContainer {
  font-size: larger;
  margin: 10px;
  height: calc(100vh - 120px);

}

.full-height {
  height: 100%;
}


</style>
