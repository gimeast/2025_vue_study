<template>
  <div class="grid-container">
    <h2>상품 목록</h2>
    <table class="hover">
      <thead>
        <tr>
          <th>상품번호</th>
          <th>상품명</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="product in paginatedProducts"
          :key="product.pno"
          @click="goToDetail(product.pno)"
        >
          <td>{{ product.pno }}</td>
          <td>{{ product.pname }}</td>
          <td>{{ product.hits }}</td>
          <td>{{ formatDate(product.resdate) }}</td>
        </tr>
      </tbody>
    </table>
    <div class="pagination">
      <button class="button" :disabled="currentPage === 1" @click="changePage(currentPage - 1)">
        Previous
      </button>
      <span>Page {{ currentPage }} of {{ totalPages }}</span>
      <button
        class="button"
        :disabled="currentPage === totalPages"
        @click="changePage(currentPage + 1)"
      >
        Next
      </button>
    </div>
    <button class="button" @click="navigateToInsert">상품등록</button>
  </div>
</template>

<script setup>
import { onMounted, ref, computed } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'

const store = useStore()
const router = useRouter()
const products = computed(() => store.state.products)
const currentPage = ref(1)
const itemsPerPage = 10

const paginatedProducts = computed(() => {
  //현재 페이지에 해당하는 목록 계산
  const start = (currentPage.value - 1) * itemsPerPage
  const end = start + itemsPerPage
  return products.value.slice(start, end)
})

const totalPages = computed(() => {
  return Math.ceil(products.value.length / itemsPerPage)
})

const fetchProducts = async () => {
  //스토어의 함수를 실행시켜서 데이터를 중앙관리한다.
  await store.dispatch('fetchProducts')
}

const goToDetail = (pno) => {
  router.push({ name: 'productDetail', params: { pno } })
}

const navigateToInsert = () => {
  router.push({ name: 'productInsert' })
}

const formatDate = (dateStr) => {
  const date = new Date(dateStr)
  return date.toLocaleDateString()
}

const changePage = (page) => {
  if (page > 0 && page <= totalPages.value) {
    currentPage.value = page
  }
}

onMounted(fetchProducts)
</script>

<style></style>
