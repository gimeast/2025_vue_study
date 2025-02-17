<template>
  <div class="content">
    <h2 class="title">자료 등록</h2>
    <form @submit.prevent="submitForm">
      <div class="field">
        <label class="label">제목</label>
        <div class="control">
          <input type="text" class="input" v-model="data.title" required />
        </div>
      </div>
      <div class="field">
        <label class="label">글내용</label>
        <div class="control">
          <textarea class="textarea" v-model="data.content" required></textarea>
        </div>
      </div>
      <div class="field">
        <label class="label">작성자</label>
        <div class="control">
          <input type="text" class="input" v-model="data.author" required />
        </div>
      </div>
      <div class="field">
        <label class="label">자료파일</label>
        <div class="control">
          <input
            type="file"
            class="input"
            @change="handleFileChange"
            accept=".pdf,.doc.docx,image/*"
            required
          />
        </div>
      </div>
      <div class="field is-grouped">
        <div class="control"><button class="button is-link">[자료 등록]</button></div>
        <div class="control"><button class="button" @click="goToList">취소</button></div>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useProductStore } from '../store/productStore'
import { useRouter } from 'vue-router'

const productStore = useProductStore()
const router = useRouter()

const data = ref({ title: '', content: '', author: '', datafile: null })

const handleFileChange = (event) => {
  const file = event.target.files[0]
  if (file) {
    data.value.datafile = file
  }
}

const submitForm = async () => {
  const formData = new FormData()
  formData.append('title', data.value.title)
  formData.append('content', data.value.content)
  formData.append('author', data.value.author)

  if (data.value.datafile) {
    formData.append('datafile', data.value.datafile)
  }

  await productStore.insertData(formData)

  router.push({ name: 'DataDetail', params: { dno: productStore.dno } })
}
</script>

<style></style>
