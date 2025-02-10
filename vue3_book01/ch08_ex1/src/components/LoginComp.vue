<template>
  <div>
    <h1>Login</h1>
    <form @submit.prevent="handleLogin">
      <input type="text" v-model="username" placeholder="Username" required />
      <input type="password" v-model="password" placeholder="Password" required />
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { login } from '@/api/login'

const username = ref('')
const password = ref('')

const router = useRouter()

const handleLogin = async () => {
  try {
    const response = await login(username.value, password.value)
    localStorage.setItem('token', response.token)
    router.push({ name: 'dashboard' })
  } catch (error) {
    alert(error.message)
  }
}
</script>

<style></style>
