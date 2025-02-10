import { createStore } from 'vuex'

export default createStore({
  state: {
    communityPosts: [
      { id: 1, title: 'Welcome to our Community', resdate: '2024-10-20', hits: 150 },
      { id: 2, title: 'Vue.js Tips and Tricks', resdate: '2024-11-21', hits: 120 },
      { id: 3, title: 'Materialize CSS for Beginners', resdate: '2024-12-22', hits: 10 },
      { id: 4, title: 'Understanding Composition API', resdate: '2025-01-11', hits: 50 },
      { id: 5, title: 'Community Guidlines', resdate: '2024-02-22', hits: 30 },
      { id: 5, title: 'Q&A Session', resdate: '2024-03-13', hits: 80 },
    ],
  },
  getters: {
    getCommunityPosts(state) {
      return state.communityPosts
    },
  },
  mutations: {},
  actions: {},
  modules: {},
})
