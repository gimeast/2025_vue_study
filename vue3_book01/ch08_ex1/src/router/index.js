import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    components: { default: HomeView, sidebar: import('../components/SidebarComp.vue') },
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../components/LoginComp.vue'),
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue'),
  },
  {
    path: '/current',
    name: 'current',

    component: () => import('../views/CurrentView.vue'),
  },
  {
    path: '/user/:id',
    name: 'user',
    component: () => import('../views/UserView.vue'),
  },
  {
    path: '/userProfile/:id',
    name: 'userProfile',
    props: true,
    component: () => import('../views/UserProfileView.vue'),
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: () => import('../views/DashboardView.vue'),
    meta: { requiresAuth: true },
    children: [
      {
        path: '/profile',
        component: import('../views/ProfileView.vue'),
      },
      {
        path: '/settings',
        component: import('../views/SettingsView.vue'),
      },
    ],
  },
  {
    path: '/profile',
    component: import('../views/ProfileView.vue'),
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'not-found',
    component: import('../views/NotFoundView.vue'),
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')

  if (to.meta.requiresAuth && !token) {
    next({ name: 'login' })
  } else {
    next()
  }
})

export default router
