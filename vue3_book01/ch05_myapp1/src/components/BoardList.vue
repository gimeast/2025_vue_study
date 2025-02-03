<template>
  <div class="board-container">
    <h2>Board List</h2>
    <div
      v-for="(post, index) in posts"
      :key="index"
      :class="{ highlighted: selectedIndex === index }"
      @click="selectPost(index)"
      class="post"
    >
      {{ post.title }}
    </div>
    <p :style="descriptionStyle">{{ selectedPostDescription }}</p>
  </div>
</template>

<script>
export default {
  data() {
    const posts = [
      { title: 'Vue.js introduce', description: 'vue.js is frontend framework' },
      { title: 'Component Base Dev', description: 'Component reusability' },
      { title: 'Vue state manage', description: 'vuex using state manage' },
    ]

    const selectedIndex = null

    return { posts, selectedIndex }
  },
  computed: {
    selectedPostDescription() {
      return this.selectedIndex !== null
        ? this.posts[this.selectedIndex].description
        : '게시물을 선택해주세요.'
    },
    descriptionStyle() {
      return {
        color: this.selectedIndex !== null ? 'blue' : 'gray',
        fontSize: '16px',
        padding: '10px',
      }
    },
  },
  methods: {
    selectPost(index) {
      this.selectedIndex = index
    },
  },
}
</script>

<style scoped>
.board-container {
  border: 1px solid #ddd;
  padding: 20px;
  max-width: 500px;
  margin: 0 auto;
  border-radius: 10px;
}
h2 {
  text-align: center;
  color: #333;
}
.post {
  padding: 10px;
  border-bottom: 1px solid #ddd;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.post:hover {
  background-color: #f1f1f1;
}
.highlighted {
  background-color: #d3f9d8;
  font-weight: bold;
}
p {
  margin-top: 20px;
  font-size: 14px;
}
</style>
