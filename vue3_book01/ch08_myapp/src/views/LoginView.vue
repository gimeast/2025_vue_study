<template>
  <div class="container">
    <h1>Login</h1>
    <form @submit.prevent="handleLogin">
      <div class="input-field">
        <input type="text" v-model="username" placeholder="Username" required />
      </div>
      <div class="input-field">
        <input type="password" v-model="password" placeholder="Password" required />
      </div>
      <button class="btn" type="submit">Login</button>
    </form>
  </div>
</template>

<script setup>
import { ref, inject } from 'vue'
import { useRouter } from 'vue-router'

const username = ref('')
const password = ref('')
const router = useRouter()

const setLoggedIn = inject('setLoggedIn')

const handleLogin = async () => {
  if (username.value === 'username' && password.value === 'password') {
    localStorage.setItem('token', 'mockToken')
    setLoggedIn(true)
    router.push({ name: 'dashboard', params: { id: username.value } })
  } else {
    alert('Invalid credentials')
  }
}
</script>

<style></style>
