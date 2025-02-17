import { createRouter, createWebHistory } from 'vue-router'
import MapinComp from '../views/MapinComp.vue'

const routes = [
  {
    path: '/',
    name: 'Main',
    component: MapinComp,
  },
  {
    path: '/datalist',
    name: 'DataList',
    component: () => import('../views/DataList.vue'),
  },
  {
    path: '/datainsert',
    name: 'DataInsert',
    component: () => import('../views/DataInsert.vue'),
  },
  {
    path: '/datadetail/:dno',
    name: 'DataDetail',
    component: () => import('../views/DataDetail.vue'),
    props: true,
  },
  {
    path: '/dataedit/:dno',
    name: 'DataEdit',
    component: () => import('../views/DataEdit.vue'),
    props: true,
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
