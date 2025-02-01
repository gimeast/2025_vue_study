<script>
import TodoList from './components/TodoList.vue'
export default {
  components: { TodoList },
}
</script>

<template>
  <div class="app pure-g">
    <div class="pure-u-1-3">
      <TodoList></TodoList>
    </div>
  </div>
</template>

<style>
.app {
  padding: 20px;
  font-family: Arial, sans-serif;
}
</style>
