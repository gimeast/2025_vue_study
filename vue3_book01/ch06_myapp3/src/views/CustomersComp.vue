<template>
  <div>
    <h1>고객목록</h1>
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(customer, index) in customers" :key="index">
          <td>{{ customer.name }}</td>
          <td>{{ customer.email }}</td>
          <td>{{ customer.phone }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const customers = ref([
  {
    name: 'user1',
    email: 'user1@example.com',
    phone: '123-123-1234',
  },
  {
    name: 'user2',
    email: 'user2@example.com',
    phone: '222-222-2222',
  },
  {
    name: 'user3',
    email: 'user3@example.com',
    phone: '333-333-3333',
  },
])
</script>

<style scoped>
h1 {
  margin-bottom: 20px;
}
.table {
  width: 100%;
  border-collapse: collapse;
}
.table th,
.table td {
  padding: 10px;
  border: 1px solid #ccc;
  text-align: left;
}
.table th {
  background-color: #f4f4f4;
}
</style>
