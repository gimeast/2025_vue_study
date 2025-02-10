<template>
  <div class="container">
    <h1 class="center-align">User Profile</h1>
    <hr />
    <p class="flow-text">User ID: {{ props.id }}</p>
    <div class="row">
      <div class="col s12 m4 center-align">
        <figure>
          <img
            src="https://via.placeholder.com/150"
            alt="User Profile"
            class="circle responsive-img"
          />
          <figcaption class="flow-text">Profile Picture</figcaption>
        </figure>
      </div>
      <div class="col s12 m8">
        <h5>Basic Information</h5>
        <ul class="collection">
          <li class="collection-item"><strong>Name:</strong></li>
          <li class="collection-item"><strong>Email:</strong></li>
          <li class="collection-item"><strong>Joined:</strong></li>
        </ul>
      </div>
    </div>
    <div class="row">
      <div class="col s12">
        <h5>About</h5>
        <p class="flow-text">나의 소개에 관한 글</p>
      </div>
    </div>
    <div class="row">
      <div class="col s12">
        <h5>Recent Activity</h5>
        <ul class="collection">
          <li class="collection-item">Posted a new article on vue.js Composition API</li>
          <li class="collection-item">Commented on Materialize CSS Overview</li>
          <li class="collection-item">Updated profile picture</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from 'vue'
const props = defineProps({ id: String })
</script>

<style></style>
