<template>
  <div class="board-list pure-g">
    <div class="pure-u-1">
      <h1>게시판 목록</h1>
      <ul class="pure-menu-list">
        <li class="pure-menu-item" v-for="board in state.boards" :key="board.no">
          <router-link class="pure-menu-link" :to="'/boards/detail/' + board.no">
            {{ board.title }}
          </router-link>
        </li>
      </ul>

      <router-link to="/boards/insert" class="pure-button pure-button-primary"
        >[글등록]</router-link
      >
    </div>
  </div>
</template>

<script setup>
import { onMounted, reactive } from 'vue'

const state = reactive({ boards: [] })

const fetchBoards = async () => {
  try {
    const response = await fetch('http://localhost:8081/boards/list')

    if (!response.ok) {
      throw new Error('Network response was not ok')
    }

    state.boards = await response.json()
  } catch (error) {
    console.error('Error fetching boards:', error)
  }
}

onMounted(fetchBoards)
</script>

<style></style>
