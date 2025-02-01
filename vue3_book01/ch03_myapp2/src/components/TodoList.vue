<template>
  <div>
    <h2>Vue 3 Todo List</h2>
    <form @submit.prevent="addTodo" class="pure-form">
      <input type="text" v-model="newTodo" placeholder="Add new todo" class="pure-input-rounded" />
      <button type="submit" class="pure-button pure-button-primary">Add</button>
    </form>
    <ul>
      <TodoItem
        v-for="(todo, index) in todos"
        :key="todo.id"
        :todo="todo"
        @remove="removeTodo(index)"
      ></TodoItem>
    </ul>
  </div>
</template>

<script lang="ts">
import { ref } from 'vue'
import TodoItem from './TodoItem.vue'

export default {
  components: {
    TodoItem,
  },
  setup() {
    const todos = ref([
      { id: 1, text: 'vue 3 Composition API 배우기' },
      { id: 2, text: 'TodoList 만들기' },
    ])

    const newTodo = ref('')

    const addTodo = () => {
      if (newTodo.value.trim() !== '') {
        todos.value.push({ id: todos.value.length + 1, text: newTodo.value })
        newTodo.value = ''
      }
    }

    const removeTodo = (index) => {
      console.log('index=', index)
      todos.value.splice(index, 1)
    }

    return { todos, newTodo, addTodo, removeTodo }
  },
}
</script>

<style>
ul {
  list-style-type: none;
  padding: 0;
}
</style>
