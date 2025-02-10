<template>
  <div class="sidebar">
    <h2>Sidebar Menu</h2>
    <ul>
      <li><router-link to="/home">home</router-link></li>
      <li><router-link to="/about">about</router-link></li>
      <li><router-link to="/services">services</router-link></li>
    </ul>
  </div>
</template>

<script lang="ts" setup></script>

<style>
.sidebar {
  width: 200px;
  padding: 20px;
  background-color: #eee;
  border-right: 1px solid #ccc;
}
</style>
