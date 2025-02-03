<template>
  <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button
        type="button"
        data-bs-target="#carouselExample"
        data-bs-slide-to="0"
        class="active"
        aria-current="true"
        aria-label="슬라이드1"
      ></button>
      <button
        type="button"
        data-bs-target="#carouselExample"
        data-bs-slide-to="1"
        aria-label="슬라이드2"
      ></button>
      <button
        type="button"
        data-bs-target="#carouselExample"
        data-bs-slide-to="2"
        aria-label="슬라이드3"
      ></button>
    </div>
    <div class="carousel-inner">
      <div
        class="carousel-item"
        v-for="(slide, index) in slides"
        :key="slide.id"
        :class="{ active: index === 0 }"
      >
        <img :src="slide.image" class="d-block w-100" :alt="slide.title" />
        <div class="carousel-caption d-none d-md-block">
          <h5>{{ slide.title }}</h5>
          <p>{{ slide.description }}</p>
          <a href="#" class="btn btn-primary">더보기</a>
        </div>
      </div>
    </div>
    <button
      class="carousel-control-prev"
      type="button"
      data-bs-target="#carouselExample"
      data-bs-slide="prev"
    >
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">이전</span>
    </button>
    <button
      class="carousel-control-next"
      type="button"
      data-bs-target="#carouselExample"
      data-bs-slide="next"
    >
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">다음</span>
    </button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const slides = ref([
  {
    id: 1,
    title: '첫번째 슬라이드',
    description: '이것은 첫번째 슬라이드',
    image: require('@/assets/slide1.jpg'),
  },
  {
    id: 2,
    title: '두번째 슬라이드',
    description: '이것은 두번째 슬라이드',
    image: require('@/assets/slide1.jpg'),
  },
  {
    id: 3,
    title: '세번째 슬라이드',
    description: '이것은 세번째 슬라이드',
    image: require('@/assets/slide1.jpg'),
  },
])
</script>

<style scoped>
.carousel-item img {
  height: 400px;
  object-fit: cover;
}
</style>
