<template>
  <div class="board-detail pure-g">
    <div class="pure-u-1">
      <h1>게시글 상세보기</h1>
      <div v-if="board" class="board-content">
        <h2>{{ board.title }}</h2>
        <p><strong>작성자:</strong>{{ board.author }}</p>
        <p><strong>작성일시:</strong>{{ board.resdate }}</p>
        <p><strong>조회수:</strong>{{ board.visited }}</p>
        <p>{{ board.content }}</p>
      </div>
      <div class="button-group">
        <button @click="deleteBoard" class="pure-button pure-button-error">[글 삭제]</button>
        <router-link :to="'/boards/edit/' + board.no" class="pure-button pure-button-primary"
          >[글 수정]</router-link
        >
        <router-link to="/boards" class="pure-button">[글 목록]</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, onMounted, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const state = reactive({ board: {} })

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

const deleteBoard = async () => {
  try {
    const response = await fetch(`http://localhost:8081/boards/delete/${route.params.no}`, {
      method: 'DELETE',
    })

    if (!response.ok) {
      throw new Error('Network response was not ok')
    }

    router.push({ name: 'boards' })
  } catch (error) {
    console.error('Error fetching board delete:', error)
  }
}

onMounted(fetchBoard)
const board = computed(() => state.board)
</script>

<style></style>
