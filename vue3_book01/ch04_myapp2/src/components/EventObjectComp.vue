<template>
  <div class="box">
    <h1 class="title">Event Object</h1>
    <input @keyup="handleKeyup" placeholder="Key Events" />
    <hr />
    <button @click="handleClick">Click with Event object</button>
  </div>
</template>

<script setup>
const handleKeyup = (event) => {
  console.log('Event type:', event.type)
  console.log('Key pressed:', event.key)
  console.log('Key pressed value:', event.target.value)
}
const handleClick = (event) => {
  event.preventDefault()
  console.log('Event target:', event.target)
  console.log('Event type:', event.type)
}
</script>

<style></style>
