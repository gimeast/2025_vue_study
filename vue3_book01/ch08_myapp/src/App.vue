<template>
  <div id="app">
    <nav>
      <div class="nav-wrapper">
        <a href="/" class="brand-logo">My App</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li>
            <router-link to="/">Home</router-link>
          </li>
          <li>
            <router-link to="/community">Community</router-link>
          </li>
          <li>
            <router-link to="/dashboard">Dashboard</router-link>
          </li>
          <li v-if="isLoggedIn">
            <a href="#" @click.prevent="handleLogout">Logout</a>
          </li>
          <li v-else>
            <router-link to="/login">Login</router-link>
          </li>
        </ul>
      </div>
    </nav>
    <router-view />
  </div>
</template>

<script setup>
import { ref, provide } from 'vue'
import { useRouter } from 'vue-router'

const isLoggedIn = ref(!!localStorage.getItem('token'))
const router = useRouter()

provide('isLoggedIn', isLoggedIn)
provide('setLoggedIn', (value) => {
  isLoggedIn.value = value
})

const handleLogout = () => {
  localStorage.removeItem('token')
  isLoggedIn.value = false
  router.push('/')
}
</script>
