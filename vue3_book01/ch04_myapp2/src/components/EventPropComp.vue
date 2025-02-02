<template>
  <div class="box">
    <h1 class="title">Event Propagation</h1>
    <div @click="handleParentClick">
      Parent <button @click.stop="handleChildClick">Child (Stops Propagation)</button>
    </div>
  </div>
</template>

<script setup>
const handleParentClick = () => {
  alert('parent clicked')
}

const handleChildClick = () => {
  alert('Child clicked')
}
</script>

<style></style>
