<template>
  <div class="card-panel teal lighten-4">
    <h2>Parent Component</h2>
    <ChildComponent @custom-event="handleCustomEvent" :parentMessage="parentMessage" />
    <div class="input-field">
      <input type="text" v-model="parentMessage" placeholder="Parent Message" />
      <label for="parentMessage" class="active" style="padding-top: 12px">Parent Message</label>
    </div>
  </div>
</template>

<script setup>
import ChildComponent from './ChildComponent.vue'
import { ref } from 'vue'

const parentMessage = ref('Hello from Parent')

const handleCustomEvent = (message) => {
  parentMessage.value = message
}
</script>

<style></style>
