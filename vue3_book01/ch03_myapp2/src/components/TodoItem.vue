<template>
  <li class="pure-menu-item">
    <span>{{ todo.text }}</span>
    <button @click="remove" class="pure-button pure-button-error">Remove</button>
  </li>
</template>

<script lang="ts" setup>
const props = defineProps({ todo: { type: Object, required: true } })
const emit = defineEmits(['remove'])

const remove = () => {
  console.log('remove call')
  emit('remove')
}
</script>

<style scoped>
.pure-menu-item {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}
</style>
