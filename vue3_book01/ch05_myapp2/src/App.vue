<template>
  <HeaderComp />
  <div class="container-fluid">
    <div class="row">
      <main class="col-12 p-4">
        <DashboardComp />
      </main>
    </div>
    <footer class="bg-dark text-white text-center py-3">
      @2024 My Admin Dashboard. All rights reserved
    </footer>
  </div>
</template>

<script setup>
import HeaderComp from './components/HeaderComp.vue'
import DashboardComp from './components/DashboardComp.vue'
</script>

<style>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}
</style>
