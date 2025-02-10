<template>
  <div class="container">
    <h1>환영합니다</h1>
    <p>메인 페이지 입니다.</p>
    <button @click="goToAbout">go to about</button>
    <router-link to="about" class="btn">To About Page</router-link>
    /
    <router-link to="current" class="btn">currentRoute Object</router-link>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const route = useRouter()

const goToAbout = () => {
  route.push({ name: 'about' })
}
</script>
