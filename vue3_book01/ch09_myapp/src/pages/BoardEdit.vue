<template>
  <div class="board-edit">
    <h1>게시글 수정</h1>
    <form @submit.prevent="updateBoard" class="pure-form pure-form-aligned">
      <fieldset>
        <div class="pure-control-group">
          <label>제목:</label>
          <input v-model="state.board.title" required />
        </div>
        <div class="pure-control-group">
          <label>내용:</label>
          <input v-model="state.board.content" required />
        </div>
        <div class="pure-control-group">
          <label>작성자:</label>
          <input v-model="state.board.author" required />
        </div>
        <div class="pure-controls">
          <button type="submit" class="pure-button pure-button-primary">[글 등록]</button>
        </div>
      </fieldset>
    </form>
  </div>
</template>

<script setup>
import { reactive, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const state = reactive({ board: { title: '', content: '', author: '' } })

const updateBoard = async () => {
  try {
    const response = await fetch(`http://localhost:8081/boards/edit/${route.params.no}`, {
      method: 'POST',
      headers: { 'Content-type': 'application/json' },
      body: JSON.stringify(state.board),
    })

    if (!response.ok) {
      throw new Error('Network response was not ok')
    }

    router.push({ path: `/boards/detail/${route.params.no}` })
  } catch (error) {
    console.error('Error fetching board insert:', error)
  }
}

const fetchBoard = async () => {
  try {
    const response = await fetch(`http://localhost:8081/boards/detail/${route.params.no}`)

    if (!response.ok) {
      throw new Error('Network response was not ok')
    }

    state.board = await response.json()
  } catch (error) {
    console.error('Error fetching board detail:', error)
  }
}

onMounted(fetchBoard)
</script>

<style></style>
