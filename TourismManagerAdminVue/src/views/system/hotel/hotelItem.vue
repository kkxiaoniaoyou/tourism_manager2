<template>
  <div class="_item">
    <div class="search-table">
      <div class="search">
        <el-row :gutter="10" style="padding:10px">
          <el-col :xs="24" :sm="12" :md="8" :lg="8" :xl="8">
            <span class="search-title">名称:</span>
            <el-input style="margin-top:10px"   placeholder="请输入名称" v-model="search.name">
            </el-input>
          </el-col>
          <el-col :xs="24" :sm="12" :md="8" :lg="8" :xl="8">
            <el-button style="margin-top:10px"     type="primary"
              @click="searchPage">查询</el-button>
            <el-button style="margin-top:10px"     @click="refresh">重置</el-button>
          </el-col>
        </el-row>
      </div>
      <div class="table">
        <el-row style="padding-top:10px;margin-left:10px">
          <el-button type="primary"     plain @click="add">新增</el-button>
          <el-button type="success" :disabled="update.length != 1 ? true : false"     plain
            @click="updateDataBtn">修改</el-button>
          <el-button type="danger" :disabled="update.length <= 0 ? true : false"     plain
            @click="deleteDataBtn">删除</el-button>
        </el-row>
        <el-table v-loading="loading" :data="tableData" @selection-change="handleSelectionChange" stripe
          style="width: 100%">
          <el-table-column type="selection" width="55">
          </el-table-column>
          <el-table-column prop="name" label="名称">
          </el-table-column>
          <el-table-column prop="price" label="价格">
          </el-table-column>
          <el-table-column prop="num" label="数量">
          </el-table-column>
          <el-table-column label="操作" width="260">
            <template slot-scope="scope">
              <el-button   type="success" @click="updateData(scope.row.id)">修改</el-button>
              <el-popconfirm style="margin-left:5px" confirm-button-text='确认' cancel-button-text='取消'
                icon="el-icon-info" icon-color="red" title="确认删除选中的数据？" @confirm="deleteDate(scope.row.id)">
                <el-button   slot="reference" type="danger">删除</el-button>
              </el-popconfirm>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination background layout="total, sizes, prev, pager, next, jumper" :page-sizes="[10, 20, 50, 100]"
          :page-size="search.pageSize" :current-page="search.pageNumber" @size-change="handleSizeChange"
          @current-change="handleCurrentChange" :total="total">
        </el-pagination>
      </div>
    </div>
    <add @addFalse="addFalse" :addVisible="addVisible" :hotelId="search.hotelId"></add>
    <update @updateFalse="updateFalse" :updateId="updateId" :updateVisible="updateVisible"></update>
  </div>
</template>

<script>
import { getSysHotelItemPage, removeSysHotelItem } from '../../../api/api'
import add from '../../../components/system/hotelItem/addHotelItem'
import update from '../../../components/system/hotelItem/updateHotelItem'
export default {
  data() {
    return {
      id: "",
      loading: true,
      update: [],
      remove: [],
      updateId: "",
      addVisible: false,
      updateVisible: false,
      search: {
        hotelId: "",
        name: "",
        pageNumber: 1,
        pageSize: 10
      },
      total: 0,
      tableData: []
    }
  },
  components: {
    add,
    update
  },
  methods: {
    searchPage() {
      this.search.pageNumber = 1
      this.query()
    },
    query() {
      getSysHotelItemPage(this.search).then(res => {
        if (res.code == 1000) {
          this.tableData = res.data.records
          this.total = res.data.total
          this.loading = false
        } else {
          this.$notify.error({
            title: '错误',
            message: res.message
          });
        }
      })
    },
    refresh() {
      this.search.hotelId = ""
      this.search.name = ""
      this.query()
    },
    handleCurrentChange(val) {
      this.search.pageNumber = val
      this.query()
    },
    handleSizeChange(val) {
      this.search.pageSize = val
      this.query()
    },
    handleSelectionChange(val) {
      this.update = []
      this.remove = []
      for (let i = 0; i < val.length; i++) {
        var item = val[i]
        this.update.push(item.id)
        this.remove.push(item.id)
      }
    },
    add() {
      this.addVisible = true
    },
    addFalse() {
      this.addVisible = false
      this.query()
    },
    updateFalse() {
      this.updateId = ''
      this.updateVisible = false
      this.query()
    },
    updateData(id) {
      this.updateId = id
      this.updateVisible = true
    },
    updateDataBtn() {
      this.updateData(this.update[0])
    },
    deleteDataBtn() {
      this.$confirm('确定删除选中的' + this.remove.length + '条数据?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.deleteDate(this.remove.join(","))
      }).catch(() => {

      });
    },
    deleteDate(ids) {
      removeSysHotelItem({ ids: ids }).then(res => {
        if (res.code == 1000) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.query()
        } else {
          this.$notify.error({
            title: '错误',
            message: res.message
          });
        }
      })
    },
  },
  mounted() {
    this.id = this.$route.query.id
    this.search.hotelId = this.$route.query.id
    this.query()
  }
}
</script>
<style lang=scss scoped>
.search-table {
  width: 100%;
}

.search {
  background: #ffffff;
  border-radius: 7px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1)
}

.table {
  background: #ffffff;
  border-radius: 7px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);
  margin-top: 10px
}

.el-col {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.search-title {
  font-family: '黑体';
  float: right;
  white-space: nowrap;
  font-size: 14px;
  margin-top: 10px;
  width: 63px;
  text-align: right;
}

.el-table {
  padding: 10px;
}

.el-dialog__header {
  border-bottom: 1px solid #F4F8F9 !important;
}

.el-dialog {
  border-radius: 10px !important;
}
</style>