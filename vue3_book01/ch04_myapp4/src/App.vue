<template>
  <div>
    <Base></Base>

    <ProviderComponent>
      <InjectedComponent></InjectedComponent>
    </ProviderComponent>

    <DynamicComponent></DynamicComponent>
    <TeleportComponent></TeleportComponent>
    <AsyncComponent></AsyncComponent>
  </div>
</template>

<script setup>
import Base from './components/BaseComponent.vue'
import ProviderComponent from './components/ProviderComponent.vue'
import InjectedComponent from './components/InjectedComponent.vue'
import DynamicComponent from './components/DynamicComponent.vue'
import TeleportComponent from './components/TeleportComponent.vue'
import AsyncComponent from './components/AsyncComponent.vue'
</script>

<style>
body {
  font-family: Arial, sans-serif;
}
</style>
