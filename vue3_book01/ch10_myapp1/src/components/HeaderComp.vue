<template>
  <header class="top-bar">
    <div class="top-bar-left">
      <ul class="dropdown menu" data-dropdown-menu>
        <li>
          <router-link to="/">메인으로 이동</router-link>
        </li>
        <li>
          <router-link to="/products">상품으로 이동</router-link>
        </li>
        <li>
          <router-link to="/products/insert">상품 등록</router-link>
        </li>
      </ul>
    </div>
  </header>
</template>

<script setup></script>
