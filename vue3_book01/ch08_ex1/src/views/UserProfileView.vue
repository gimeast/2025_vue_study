<template>
  <div>
    <h1>User Profile</h1>
    <p>User ID: {{ props.id }}</p>
  </div>
</template>

<script setup>
import { defineProps } from 'vue'

const props = defineProps({ id: String })
</script>

<style></style>
