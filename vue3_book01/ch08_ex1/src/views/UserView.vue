<template>
  <div>
    <h1>User Id: {{ userId }}</h1>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const userId = ref(route.params.id)

watch(
  () => route.params.id,
  (newId) => (userId.value = newId)
)
</script>

<style></style>
