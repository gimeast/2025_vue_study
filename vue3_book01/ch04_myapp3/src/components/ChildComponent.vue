<template>
  <div class="card-panel teal lighten-2">
    <h3>Child Component</h3>
    <p>Parent Message: {{ parentMessage }}</p>
    <div class="input-field">
      <input type="text" v-model="childMessage" placeholder="Child Message" />
      <label for="childMessage" class="active" style="color: #fff">Child Message</label>
    </div>
    <button class="btn" @click="emitCustomEvent">Send to Parent</button>
  </div>
</template>

<script setup>
import { ref, defineProps, defineEmits } from 'vue'

const props = defineProps({ parentMessage: String })
console.log('props:', props)

const emit = defineEmits(['custom-event'])
const childMessage = ref('')
const emitCustomEvent = () => {
  emit('custom-event', childMessage.value)
}
</script>

<style></style>
