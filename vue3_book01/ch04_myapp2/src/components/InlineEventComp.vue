<template>
  <div class="box">
    <h1 class="title">Inline Events</h1>
    <button @click="showAlert">Click Inline</button>
    <hr />
    <button @click="handleClick('With Data')">Click with Data Binding</button>
    <hr />
    <button @click.prevent="handleClick('With Prevent')">Click with Prevent</button>
  </div>
</template>

<script setup>
const showAlert = () => {
  window.alert('Button clicked!')
}

const handleClick = (message) => {
  alert(message)
}
</script>

<style></style>
