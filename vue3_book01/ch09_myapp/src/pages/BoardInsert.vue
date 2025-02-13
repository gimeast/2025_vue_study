<template>
  <div class="board-insert">
    <h1>게시글 등록</h1>
    <form @submit.prevent="insertBoard" class="pure-form pure-form-aligned">
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
import { reactive } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const state = reactive({ board: { title: '', content: '', author: '' } })

const insertBoard = async () => {
  try {
    const response = await fetch('http://localhost:8081/boards/insert', {
      method: 'POST',
      headers: { 'Content-type': 'application/json' },
      body: JSON.stringify(state.board),
    })

    if (!response.ok) {
      throw new Error('Network response was not ok')
    }

    router.push({ name: 'boards' })
  } catch (error) {
    console.error('Error fetching board insert:', error)
  }
}
</script>
