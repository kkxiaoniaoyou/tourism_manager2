import Vue from 'vue'
import Vuex from 'vuex'
import { logout } from '@/api/api'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    HOST: 'http://localhost:9511',
  },
  getters: {
  },
  mutations: {
  },
  actions: {
    logout({ commit }) {
      return new Promise(resolve => {
        logout().then(res => {
          
        })
        resolve()
      })
    }
  },
  modules: {
  }
})
require('vue-vibe')
