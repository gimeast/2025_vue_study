<template>
  <div :class="$style.container">
    <h1>Vue 3 App with PureCSS</h1>
    <slot></slot>
  </div>
</template>

<script lang="ts" setup></script>

<style module>
.container {
  padding: 20px;
  background-color: #f4f4f4;
}
</style>
