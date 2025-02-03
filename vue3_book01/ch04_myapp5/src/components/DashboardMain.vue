<template>
  <section>
    <h2>Main Section</h2>
    <form-component />
    <component :is="currentComponent" />
    <button @click="switchComponent">Switch Component</button>
    <async-component />
    <some-async-component />
  </section>
</template>

<script setup>
import { ref, defineAsyncComponent } from 'vue'
import FormComponent from './FormComponent.vue'
import AsyncComponent from './AsyncComponent.vue'

const DynamicComponentA = defineAsyncComponent(() => import('./DynamicComponentA.vue'))
const DynamicComponentB = defineAsyncComponent(() => import('./DynamicComponentB.vue'))
const SomeAsyncComponent = defineAsyncComponent(() => import('./SomeAsyncComponent.vue'))

const currentComponent = ref(DynamicComponentA)

const switchComponent = () => {
  currentComponent.value =
    currentComponent.value === DynamicComponentA ? DynamicComponentB : DynamicComponentA
}
</script>

<style scoped>
button {
  margin-top: 1rem;
}
</style>
