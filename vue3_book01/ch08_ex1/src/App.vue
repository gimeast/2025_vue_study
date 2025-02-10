<template>
  <nav>
    <button @click="goHome">goHome</button>
    <router-link to="/user/auser" class="nav-link">A user</router-link>
    /
    <router-link to="/user/buser" class="nav-link">B user</router-link>
    /
    <router-link to="/dashboard" class="nav-link">Dashboard</router-link>
  </nav>
  <main>
    <router-view />
    <router-view name="sidebar" />
  </main>
</template>
<script setup>
import { useRouter } from 'vue-router'

const route = useRouter()

const goHome = () => {
  route.push({ name: 'home' })
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
