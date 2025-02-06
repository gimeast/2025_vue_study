<template>
  <div>
    <div class="flex mb-4">
      <input
        type="text"
        v-model="newTodo"
        @keyup.enter="addTodo"
        placeholder="새로운 Todo를 입력하세요"
        class="flex-grow p-2 border rounded-1"
      />
      <button @click="addTodo" class="bg-blue-500 text-white p-2 rounded-r">추가</button>
    </div>
    <ul>
      <TodoItem v-for="todo in todos" :key="todo.id" :todo="todo" @remove="removeTodo" />
    </ul>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import TodoItem from './TodoItem.vue'

//변수
const newTodo = ref('')
const todos = reactive([])

//이벤트 함수
const addTodo = () => {
  if (newTodo.value.trim === '') return

  todos.push({ id: Date.now(), text: newTodo.value.trim() })
  newTodo.value = ''
}

const removeTodo = (id) => {
  const todoFindIndex = todos.findIndex((todo) => todo.id === id)
  todos.splice(todoFindIndex, 1)
}
</script>
