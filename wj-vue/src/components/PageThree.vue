<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" style="width: 60%">
    <el-form-item label="图书编号" prop="id">
      <el-input v-model="ruleForm.id" readOnly></el-input>
    </el-form-item>
    <el-form-item label="书名" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author"></el-input>
    </el-form-item>
    <el-form-item label="出版社" prop="publish">
      <el-input v-model="ruleForm.publish"></el-input>
    </el-form-item>
    <el-form-item label="购买日期" required>
      <el-col :span="11">
        <el-form-item prop="date1">
          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1" style="width: 100%;"></el-date-picker>
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="ruleForm.price"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        id:'',
        name: '',
        author: '',
        date1: '',
        publish: '',
        price: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入图书名称', trigger: 'blur' },
          // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        author: [
          { required: true, message: '请填写作者名称', trigger: 'blur' }
        ],
        date1: [
          { type: 'date', required: true, message: '请选择购买日期', trigger: 'blur' }
        ],
        publish: [
          { required: true, message: '请填写出版社', trigger: 'blur' }
        ],
        price: [
          { required: true, message: '请填写价格', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.put('/Book/update', this.ruleForm).then(function (resp){
            if(resp.data == "success"){
              _this.$alert('《'+_this.ruleForm.name+'》 修改成功！','success',{
                confirmButtonText: "确定",
                callback: action => {
                  _this.$router.push('/PageOne')
                }
              });
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created(){
    const _this = this
    this.$axios.get('/Book/findById/'+this.$route.query.id).then(function (resp){
      _this.ruleForm = resp.data
    })
  }
}
</script>
<style scoped>

</style>
