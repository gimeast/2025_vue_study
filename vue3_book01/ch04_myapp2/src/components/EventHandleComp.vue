<template>
  <div class="box">
    <h1 class="title">Event Handlers</h1>
    <hr />
    <button @click="handleClick">Method Handler</button>
    <hr />
    <button @click="showInlineAlert">Inline Handler</button>
    <hr />
    <input @input="handleInput" placeholder="Event Object Handling" />
  </div>
</template>

<script setup>
const handleClick = () => {
  alert('Method Handler Clicked!')
}
const showInlineAlert = () => {
  window.alert('Inline Handler')
}
const handleInput = (event) => {
  console.log('Input event:', event.target.value)
}
</script>

<style></style>
