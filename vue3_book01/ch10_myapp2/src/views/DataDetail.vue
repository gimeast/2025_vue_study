<template>
  <div class="content">
    <h2 class="title">
      <div v-if="data">
        <p><strong>글번호:</strong>{{ data.dno }}</p>
        <p><strong>제목:</strong>{{ data.title }}</p>
        <p><strong>글 내용:</strong>{{ data.content }}</p>
        <p><strong>작성자:</strong>{{ data.author }}</p>
        <p><strong>작성일시:</strong>{{ formatDate(data.regdate) }}</p>
        <p><strong>조회수:</strong>{{ data.hits }}</p>
        <p>
          <strong>자료파일:</strong
          ><a :href="data.datafile" :download="data.datafileName" target="_blank">{{
            data.datafileName
          }}</a>
        </p>
      </div>
      <div class="buttons">
        <button class="button is-warning" @click="editData">[글 수정]</button>
        <button class="button is-danger" @click="deleteData">[글 삭제]</button>
        <button class="button" @click="goToList">[자료실 목록]</button>
      </div>
    </h2>
  </div>
</template>

<script setup>
import { onMounted, computed } from 'vue'
import { useProductStore } from '@/store/productStore'
import { useRouter, useRoute } from 'vue-router'

const productStore = useProductStore()
const router = useRouter()
const route = useRoute()

const dno = route.params.dno
const data = computed(() => productStore.currentData)

const goToList = () => {
  router.push({ name: 'DataList' })
}

const editData = () => {
  router.push({ name: 'DataEdit', params: dno })
}

const deleteData = async () => {
  if (confirm('정말로 이 자료를 삭제하시겠습니까?')) {
    await productStore.deleteData(dno)
    router.push({ name: 'DataList' })
  }
}

const fetchDataDetail = async () => {
  await productStore.fetchDataDetail(dno)
}

const formatDate = (regdate) => {
  return new Date(regdate).toLocaleDateString()
}

onMounted(fetchDataDetail)
</script>

<style></style>
