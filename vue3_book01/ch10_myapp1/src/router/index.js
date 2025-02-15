import { createRouter, createWebHistory } from 'vue-router'
import MainComp from '../views/MainComp.vue'

const routes = [
  {
    path: '/',
    name: 'main',
    component: MainComp,
  },
  {
    path: '/products',
    name: 'productList',
    component: () => import('../views/ProductList.vue'),
  },
  {
    path: '/products/insert',
    name: 'productInsert',
    component: () => import('../views/ProductInsert.vue'),
  },
  {
    path: '/products/detail/:pno',
    name: 'productDetail',
    component: () => import('../views/ProductDetail.vue'),
    props: true,
  },
  {
    path: '/products/edit/:pno',
    name: 'productEdit',
    component: () => import('../views/ProductEdit.vue'),
    props: true,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
