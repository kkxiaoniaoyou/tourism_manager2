<template>
  <div class="header">
    <div class="header1">
      <div class="header4">
        <div class="menu-list">
          <div @click="toPage('index')" :class="$route.path == '/' ? 'menu_item' : ''">
            <i class="iconfont icon-r-home" style="font-size: 26px;"></i>
            主页
          </div>
          <div @click="toPage('attractions')" :class="$route.path == '/attractions' ? 'menu_item' : ''">
            <i class="iconfont icon-r-refresh" style="font-size: 26px;margin-right: 5px;"></i>
            景点
          </div>
          <div @click="toPage('line')" :class="$route.path == '/line' ? 'menu_item' : ''">
            <i class="iconfont icon-r-bottom" style="font-size: 26px;margin-right: 5px;"></i>线路
          </div>
          <div @click="toPage('hotel')" :class="$route.path == '/hotel' ? 'menu_item' : ''">
            <i class="iconfont icon-r-building" style="font-size: 26px;margin-right: 5px;"></i>酒店
          </div>
          <div @click="toPage('forum')" :class="$route.path == '/forum' ? 'menu_item' : ''">
            <i class="iconfont icon-r-paper" style="font-size: 26px;margin-right: 5px;"></i>资讯
          </div>
          <div @click="toPage('favor')" :class="$route.path == '/favor' ? 'menu_item' : ''">
            <i class="iconfont icon-r-add" style="font-size: 26px;margin-right: 5px;"></i>收藏
          </div>
          <div @click="toPage('order')" :class="$route.path == '/order' ? 'menu_item' : ''">
            <i class="iconfont icon-r-yes" style="font-size: 26px;margin-right: 5px;"></i>预定
          </div>
        </div>
      </div>
      <div class="header5">
        <!-- <img @click="toCenter" style="width:40px;height:40px;border-radius:50%" src="../assets/image/logo.png"> -->
        <div class="header6" @click="toCenter">
          我的
        </div>
        <div class="header6" @click="loginOut">
          退出
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: ""
    }
  },
  methods: {
    toCenter() {
      this.$router.push("/center")
    },
    toPage(name) {
      if (name == "index") {
        this.$router.push("/")
      } else if (name == "attractions") {
        this.$router.push("/attractions")
      } else if (name == "line") {
        this.$router.push("/line")
      } else if (name == "hotel") {
        this.$router.push("/hotel")
      } else if (name == "forum") {
        this.$router.push("/forum")
      } else if (name == "manage") {
        window.open("http://localhost:3000")
      } else if (name == "order") {
        this.$router.push("/order")
      } else if (name == "favor") {
        this.$router.push("/favor")
      } else if (name == "order") {
        this.$router.push("/order")
      }
    },
    loginOut() {
      this.$store.dispatch('logout').then(() => {
        window.localStorage.removeItem("user_info")
        window.localStorage.removeItem("user_token")
        this.$message({
          message: '退出成功',
          type: 'success'
        });
        setTimeout(function () {
          window.location.reload()
        }, 1000)
      })
    }
  },
  created() {

  },
  mounted() {

  }
}
</script>

<style scoped>
.header {
  width: 100%;
  height: 80px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.header1 {
  width: 80%;
  height: 80px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ffffff;
}

.header4 {
  width: 80%;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.menu-list {
  display: flex;
  color: #000000;
}

.menu-list>div {
  font-family: '黑体';
  font-size: 18px;
  width: 100px;
  cursor: pointer;
}

.menu_item {
  color: #DC1616;
}

.header5 {
  display: flex;
  align-items: center;
}

.header6 {
  cursor: pointer;
  margin-left: 10px;
  padding: 5px 10px 5px 10px;
  border-radius: 20px;
  color: #ffffff;
  background-color: #4381FF;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 13px;
}
</style>
