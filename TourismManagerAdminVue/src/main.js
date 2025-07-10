import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './permission'
import store from './store'
import elementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
 
Vue.use(VueQuillEditor) 

Vue.config.productionTip = false
Vue.use(elementUI)

Vue.prototype.$bus = new Vue()  

Vue.prototype.rIcon = {
  excludeGrandClasses: [
    "ql-formats"
  ],
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
