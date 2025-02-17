import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    customers: [],
  },
  getters: {},
  mutations: {
    SET_CUSTOMERS(state, customers) {
      state.customers = customers
    },
    ADD_CUSTOMER(state, customer) {
      state.customers.push(customer)
    },
  },
  actions: {
    async fetchCustomers({ commit }) {
      try {
        const response = await axios.get('https://api.example.com/customers')
        commit('SET_CUSTOMERS', response.data)
      } catch (error) {
        console.error('Failed to fetch customers:', error)
      }
    },

    async addCustomer({ commit }, customer) {
      try {
        const response = await axios.post('https://api.example.com/customer/', customer)
        commit('ADD_CUSTOMER', response.data)
      } catch (error) {
        console.log('Failed to add customer:', error)
      }
    },
  },
  modules: {},
})
