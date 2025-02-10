<template>
  <div>
    <nav>
      <router-link to="/about" class="btn">about</router-link>
      /
      <router-link to="/current" class="btn">currentRoute Object</router-link>
      <h1>Current Route</h1>
      <p>Route Name: {{ route.name }}</p>
      <p>Route Path: {{ route.path }}</p>
    </nav>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
const route = useRoute()
</script>

<style></style>
