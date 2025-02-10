<template>
  <div class="container">
    <h1 class="center-align">Welcome to Home Page</h1>
    <hr />
    <figure class="center-align">
      <img
        src="https:/picsum.photos/seed/picsum/800/200"
        alt="Banner Image"
        class="responsive-img"
      />
    </figure>
    <table class="highlight centered responsive-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Date</th>
          <th>Hits</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="post in recentPosts" :key="post.id">
          <td>{{ post.id }}</td>
          <td>{{ post.title }}</td>
          <td>{{ post.resdate }}</td>
          <td>{{ post.hits }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const communityPosts = ref([
  {
    id: 1,
    title: '1 Post',
    contents: 'This is the 1 post.',
    resdate: '2025-02-10',
    hits: 102,
  },
  {
    id: 2,
    title: '2 Post',
    contents: 'This is the 2 post.',
    resdate: '2025-02-10',
    hits: 2,
  },
  {
    id: 3,
    title: '3 Post',
    contents: 'This is the 3 post.',
    resdate: '2025-02-10',
    hits: 1,
  },
  {
    id: 4,
    title: '4 Post',
    contents: 'This is the 4 post.',
    resdate: '2025-02-10',
    hits: 10,
  },
  {
    id: 5,
    title: '5 Post',
    contents: 'This is the 5 post.',
    resdate: '2025-02-10',
    hits: 12,
  },
])
const recentPosts = ref(communityPosts.value.slice(0, 3))
</script>

<style></style>
