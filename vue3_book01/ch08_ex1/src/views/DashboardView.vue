<template>
  <div>
    <h1>Dashboard</h1>
    <router-link to="profile">Profile</router-link>
    /
    <router-link to="settings">Settings</router-link>
    <p><button @click="logout">Logout</button></p>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const logout = () => {
  localStorage.removeItem('token')
  router.push({ name: 'home' })
}
</script>

<style></style>
