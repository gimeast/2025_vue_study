<template>
  <div>
    <div>
      <div>
        <h2>상품정보</h2>
        <ul>
          <li v-for="(book, i) in data" :key="i">
            <div>
              <div>
                <h4 :style="rtext">{{ book.title }}</h4>
                <p>카테고리: {{ book.cate }}</p>
                <div>
                  <div class="btn-group">
                    <button @click="increseUp(i)" class="btn btn-sm btn-outline-secondary">
                      추천
                    </button>
                    <button
                      @click="
                        isDetail = true
                        selectedBook = i
                      "
                    >
                      상세보기
                    </button>
                  </div>
                  <small
                    >추천수: <span>{{ book.sug }}</span></small
                  >
                </div>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <div v-if="isDetail">
      <div>
        <div>
          <BookDetail :book="data[selectedBook]" @closeDetail="isDetail = false"></BookDetail>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BookDetail from './BookDetail.vue'
import { data } from '../assets/books'

export default {
  name: 'ServiceList',
  components: { BookDetail },
  data() {
    return {
      rtext: 'color: red',
      isDetail: false,
      data: data,
      selectedBook: 0,
    }
  },
  methods: {
    increseUp(i) {
      this.data[i].sug += 1
    },
  },
}
</script>
