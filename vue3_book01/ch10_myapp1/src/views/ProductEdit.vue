<template>
  <div class="grid-container">
    <h2>상품 정보 수정</h2>
    <form @submit.prevent="submitEdit">
      <div class="grid-x grid-padding-x">
        <div class="medium-6 cell">
          <label>상품명<input type="text" v-model="editableProduct.pname" required /></label>
        </div>
        <div class="medium-6 cell">
          <label>상품내용<textarea v-model="editableProduct.pcontent" required></textarea></label>
        </div>
        <div class="medium-4 cell" v-for="(img, index) in editableProduct.images" :key="index">
          <label
            >상품이미지{{ index + 1 }}

            <input type="file" @change="handleFileChange(index, $event)" accept="image/*" />
            <img :src="img" alt="현재 이미지" style="width: 100%; margin-top: 0.5rem" />
          </label>
        </div>
        <div class="medium-6 cell">
          <p><strong>등록일시:</strong>{{ formatDate(editableProduct.resdate) }}</p>
        </div>
        <div class="medium-6 cell">
          <p><strong>조회수:</strong>{{ editableProduct.hits }}</p>
        </div>
      </div>
      <button type="submit" class="button">[상품 정보 수정]</button>
      <button type="button" class="button" @click="goToList">[상품목록]</button>
    </form>
  </div>
</template>

<script setup>
import { reactive, onMounted, computed } from 'vue'
import { useStore } from 'vuex'
import { useRouter, useRoute } from 'vue-router'

const store = useStore()
const router = useRouter()
const route = useRoute()
const pno = route.params.pno
const state = reactive({
  editableProduct: {
    pno: '',
    pname: '',
    pcontent: '',
    images: [],
    resdate: '',
    hits: 0,
    imgFiles: [],
  },
})

const fetchProduct = async () => {
  await store.dispatch('fetchProductDetail', pno)
  const current = store.state.currentProduct

  state.editableProduct = {
    pno: current.pno,
    pname: current.pname,
    pcontent: current.pcontent,
    images: [...current.images],
    resdate: current.resdate,
    hits: current.hits,
    imgFiles: [null, null, null],
  }
}

const handleFileChange = (index, event) => {
  const file = event.target.files[0]

  if (file) {
    state.editableProduct.imgFiles[index] = file
    const reader = new FileReader()
    reader.onload = (e) => {
      state.editableProduct.images[index] = e.target.result
    }
    reader.readAsDataURL(file)
  }
}

const submitEdit = async () => {
  const formData = new FormData()
  formData.append('pname', state.editableProduct.pname)
  formData.append('pcontent', state.editableProduct.pcontent)

  state.editableProduct.imgFiles.forEach((file, index) => {
    if (file) {
      formData.append(`img${index + 1}`, file)
    }
  })

  await store.dispatch('updateProduct', { pno, formData })
  router.push({ name: 'productList' })
}

const goToList = () => {
  router.push({ name: 'productList' })
}

const formatDate = (dateStr) => {
  const date = new Date(dateStr)
  return date.toLocaleString()
}

const editableProduct = computed(() => state.editableProduct)
onMounted(fetchProduct)
</script>
