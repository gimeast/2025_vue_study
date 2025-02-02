<template>
  <div>
    <h2>Dynamic Component</h2>
    <component :is="currentComponent" />
    <h2>Dynamic Component</h2>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import BaseComponent from './BaseComponent.vue'

const currentComponent = ref(BaseComponent)
</script>

<style scoped>
h2 {
  background-color: red;
}
</style>
