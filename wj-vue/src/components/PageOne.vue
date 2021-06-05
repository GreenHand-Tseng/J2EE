<template>
<div>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="id"
      label="编号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="书名"
      width="160">
    </el-table-column>
    <el-table-column
      prop="author"
      label="作者"
      width="230">
    </el-table-column>
    <el-table-column
      prop="publish"
      label="出版社"
      width="280">
    </el-table-column>
    <el-table-column
      prop="date"
      label="购买日期"
      width="200">
    </el-table-column>
    <el-table-column
      prop="price"
      label="价格"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template #default="scope">
        <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
        <el-button @click="deletebook(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
    background
    layout="total, sizes, prev, pager, next, jumper"
    :page-size="pagesize"
    :page-sizes="[10, 15, 30, 50]"
    :total="total"
    @current-change="page"
    @size-change="size"
    style="text-align: center;"
  >
  </el-pagination>
</div>


</template>

<script>
export default {
  methods: {
    edit(row) {
      this.$router.push({
        path:'/update',
        query:{
          id:row.id
        }
      })
    },
    deletebook(row){
      const _this = this
      this.$axios.delete('/Book/delete/'+row.id).then(function (resp){
        _this.$alert('删除成功！','success',{
          confirmButtonText: "确定",
          callback: action => {
            window.location.reload()
          }
        });
      })
    },
    page(currentPage){
      const _this = this;
      this.currpage = currentPage
      // console.log(this.total)
      // console.log(this.pagesize)
      this.$axios.get('/Book/findAll/'+this.currpage+'/'+this.pagesize).then(function (resp) {
        _this.tableData = resp.data.content
      })
    },
    size(val){
      this.pagesize = val
      const _this = this;
      this.$axios.get('/Book/findAll/'+this.currpage+'/'+this.pagesize).then(function (resp) {
        _this.tableData = resp.data.content
      })
    }
  },
  created(){
    const _this = this;
    this.$axios.get('/Book/findAll/'+this.currpage+'/'+this.pagesize).then(function (resp) {
      // console.log(resp)
      _this.tableData = resp.data.content
      _this.total = resp.data.totalElements
       // console.log(_this.total)
      // console.log(resp.totalElements)
    })
  },
  data() {
    return {
      total:null,
      pagesize: 10,
      currpage:1,
      tableData: null
    }
  }
}
</script>

<style>

</style>
