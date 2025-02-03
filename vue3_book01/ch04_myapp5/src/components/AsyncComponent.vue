<template>
  <div>
    <p>Loading async component...</p>
    <async-content v-if="AsyncContent" />
  </div>
</template>

<script setup>
import { defineAsyncComponent } from 'vue'

const AsyncContent = defineAsyncComponent(() => import('./AsyncContent.vue'))
</script>

<style scoped>
p {
  color: gray;
}
</style>
