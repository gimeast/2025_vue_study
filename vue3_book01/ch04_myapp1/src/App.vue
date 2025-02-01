<template>
  <div @click="handleParentClick" class="container parent">
    Parent
    <button @click.stop="handleButtonClick" class="btn btn-primary child">Click Me</button>
  </div>
</template>

<script>
export default {
  methods: {
    handleParentClick(event) {
      alert('Parent div clicked event:', event)
    },
    handleButtonClick() {
      alert('button clicked')
    },
  },
}
</script>

<style></style>
