<template>
  <div class="container">
    <h1 class="center-align">Vue 3 Composition API Demo</h1>
    <ParentComponent />
    <SubParentComponent />
  </div>
</template>
<script setup>
import ParentComponent from './components/ParentComponent.vue'
import SubParentComponent from './components/SubParentComponent.vue'
</script>
<style>
.container {
  margin-top: 50px;
}
</style>
