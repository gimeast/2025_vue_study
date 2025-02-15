import axios from 'axios'
import { createStore } from 'vuex'

export default createStore({
  state: { products: [], currentProduct: null },
  getters: {
    allProducts: (state) => state.products,
    getCurrentProduct: (state) => state.currentProduct,
  },
  mutations: {
    SET_PRODUCTS(state, products) {
      state.products = products
    },
    SET_CURRENT_PRODUCT(state, product) {
      state.currentProduct = product
    },
    ADD_PRODUCT(state, product) {
      state.products.push(product)
    },
    UPDATE_PRODUCT(state, updatedProduct) {
      const index = state.products.findIndex((p) => p.pno === updatedProduct.pno)
      if (index !== -1) {
        state.products.splice(index, 1, updatedProduct)
      }
    },
    DELETE_PRODUCT(state, pno) {
      const index = state.products.findIndex((p) => p.pno === pno)
      state.products.splice(index, 1)
    },
    CLEARE_CURRENT_PRODUCT(state) {
      state.products = null
    },
  },
  actions: {
    /**
     * @description 상품목록 조회
     */
    async fetchProducts({ commit }) {
      try {
        const response = await axios.get('http://localhost:8081/products/list')
        commit('SET_PRODUCTS', response.data)
      } catch (error) {
        console.error('상품 목록 가져오는 중 오류 발생: ', error.message)
      }
    },
    /**
     * @description 상품상세 조회
     */
    async fetchProductDetail({ commit }, pno) {
      try {
        const response = await axios.get(`http://localhost:8081/products/detail/${pno}`)

        commit('SET_CURRENT_PRODUCT', response.data)
      } catch (error) {
        console.error('상품 상세 정보를 조회 중 오류 발생: ', error.message)
      }
    },
    async insertProduct({ commit }, formData) {
      try {
        const response = await axios.post('http://localhost:8081/products/insert', formData, {
          headers: { 'Content-Type': 'multipart/form-data' },
        })

        commit('ADD_PRODUCT', response.data)
      } catch (error) {
        console.error('상품 신규 등록 중 오류 발생: ', error.message)
      }
    },
    async updateProduct({ commit }, { pno, formData }) {
      try {
        const response = await axios.put(`http://localhost:8081/products/update/${pno}`, formData, {
          headers: { 'Content-Type': 'multipart/form-data' },
        })

        commit('UPDATE_PRODUCT', response.data)
      } catch (error) {
        console.error('상품 정보 수정 중 오류 발생: ', error.message)
      }
    },
    async deleteProduct({ commit }, pno) {
      try {
        await axios.delete(`http://localhost:8081/products/delete/${pno}`)

        commit('DELETE_PRODUCT', pno)
      } catch (error) {
        console.error('상품 정보 삭제 중 오류 발생: ', error.message)
      }
    },
  },
  modules: {},
})
