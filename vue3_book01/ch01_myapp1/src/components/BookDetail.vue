<template>
  <div>
    <div>
      <h1>{{ book.title }}</h1>
      <button type="button" @click="$emit('closeDetail')">X</button>
    </div>
    <hr />
    <div>
      <p>카테고리: {{ book.cate }} / 출간일: {{ book.pubdate }}</p>
      <p>페이지 수: {{ book.pages }} / 가격: {{ book.price }}</p>
    </div>
    <div>
      <button type="button">Buy</button>
      <button type="button" @click="$emit('closeDetail')">Close</button>
    </div>
  </div>
</template>

<script>
export default { name: 'BookDetail', props: { book: { type: Object, required: true } } }
</script>
