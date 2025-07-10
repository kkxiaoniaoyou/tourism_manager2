<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import "@/assets/font/font.css"

export default ({

})
</script>


<style>
* {
  font-family: "Noto Sans SC,SimHei" !important;
}

html,
body,
#app,
.common-layout {
  margin: 0;
  padding: 0;
  height: 100%;
}

.xiaoshi {
  display: none;
}

body::-webkit-scrollbar {
  width: 0px;
  height: 0px;
}

::-webkit-scrollbar {
  width: 8px;
  height: 8px;
  background-color: #e4e4e4;
  border-radius: 6px;
}

::-webkit-scrollbar-thumb {
  background-color: #a1a3a9;
  border-radius: 6px;
}

.el-pagination {
  padding-bottom: 10px !important;
  padding-top: 10px !important;
  display: flex;
  justify-content: flex-end
}

.el-dialog__wrapper {
  .el-dialog {
    border-radius: 8px;
  }
}

.el-dialog__title {
  font-size: 14px !important;
  font-family: "黑体";
}

.el-dialog__header {
  border-bottom: 1px solid #e3e8ee;
}
</style>
