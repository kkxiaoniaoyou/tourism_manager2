<template>
<div>
  <el-dialog title="新增管理员" width="40%" :destroy-on-close="true" :visible.sync="addUserVisible" :before-close="handleClose">
    <el-form :model="form" :rules="rules" ref="ruleForm">
      <el-row :gutter="10">
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">用户昵称:</span>
            <div style="width:100%">
              <el-form-item prop="userName" style="margin-bottom:0">
                <el-input v-model="form.userName"   placeholder="请输入用户昵称" autocomplete="off"></el-input>
              </el-form-item>
            </div>
        </el-col>
        
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">手机号码:</span>
            <div style="width:100%">
              <el-form-item prop="tel" style="margin-bottom:0">
                <el-input v-model="form.tel"   placeholder="请输入手机号码" autocomplete="off"></el-input>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">&nbsp;&nbsp;&nbsp;&nbsp;邮箱:</span>
            <div style="width:100%">
              <el-form-item prop="email" style="margin-bottom:0">
                <el-input v-model="form.email"   placeholder="请输入邮箱" autocomplete="off"></el-input>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">登陆账号:</span>
            <div style="width:100%">
              <el-form-item prop="loginAccount" style="margin-bottom:0">
                <el-input v-model="form.loginAccount"   placeholder="请输入登陆账号" autocomplete="off"></el-input>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">用户密码:</span>
            <div style="width:100%">
              <el-form-item prop="password" style="margin-bottom:0">
                <el-input v-model="form.password" show-password   placeholder="请输入用户密码" autocomplete="off"></el-input>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">用户性别:</span>
            <div style="width:100%">
              <el-form-item prop="sex" style="margin-bottom:0">
                <el-select   v-model="form.sex" placeholder="请选择用户性别">
                  <el-option label="男" value="0"></el-option>
                  <el-option label="女" value="1"></el-option>
                </el-select>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">状态:</span>
            <div style="width:100%">
              <el-form-item prop="name" style="margin-bottom:0">
                  <el-radio-group style="margin-top:1px;height:40px;display:flex;align-items: center" v-model="form.status">
                    <el-radio label="0">正常</el-radio>
                    <el-radio label="1">停用</el-radio>
                  </el-radio-group>
              </el-form-item>
            </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
            <span class="search-title">&nbsp;&nbsp;&nbsp;&nbsp;备注:</span>
            <div style="width:100%">
              <el-input type="textarea" v-model="form.remark"></el-input>
            </div>
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button   type="primary" @click="submit">确 定</el-button>
      <el-button   @click="handleClose">取 消</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
  import {saveUser} from '../../../api/api'
  export default {
    data() {
      return{
        formLabelWidth: '80px',
        form: {
          userName: "",
          loginAccount: "",
          userType: 0,
          email: "",
          tel: "",
          sex: "",
          avatar: "",
          password: "",
          status: "0",
          remark: "",
        },
        rules: {
          userName: [
            { required: true, message: '请输入用户昵称', trigger: 'blur' },
          ],
          loginAccount: [
            { required: true, message: '请输入登陆账号', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入登陆密码', trigger: 'blur' },
          ],
          tel: [
            { required: true, message: '请输入联系方式', trigger: 'blur' },
          ],
          email: [
            { required: true, message: '请输入邮箱', trigger: 'blur' },
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'blur' },
          ],
        }
      }
    },
    props: ['addUserVisible'],
    methods: {
      submit() {
        this.$refs["ruleForm"].validate((valid) => {
          if (valid) {
            saveUser(this.form).then(res => {
              if(res.code == 1000) {
                this.$notify.success({
                  title: '成功',
                  message: "保存成功"
                });
                this.handleClose();
              } else {
                this.$notify.error({
                  title: '错误',
                  message: res.message
                });
              }
            })
          } else {
            return false;
          }
        });
      },
      handleClose() {
        this.form = {
          userName: "",
          loginAccount: "",
          userType: 0,
          email: "",
          tel: "",
          sex: "",
          avatar: "",
          password: "",
          status: "0",
          remark: "",
        }
        this.$emit("addUserFalse")
      },
    },
    created() {
     
    },
    mounted() {
      
    }
 }
</script>

<style  scoped>
  .el-col {
      display: flex;
      flex-direction: row;
      align-items: center;
      margin-top: 12px
  }
  .search-title {
      font-family: '黑体';
      float: right;
      white-space: nowrap;
      font-size: 14px;
      width: 63px;
      text-align: right;
  }
</style>