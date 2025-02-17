import { defineStore } from 'pinia'

export const useProductStore = defineStore('product', {
  state: () => ({ dataList: [], currentData: null, dno: null }),
  actions: {
    async fetchDataList() {
      try {
        const response = await fetch('http://localhost:8081/dataroom/list')

        if (!response.ok) throw new Error('Failed to fetch data list')

        const data = await response.json()
        this.dataList = data
      } catch (error) {
        console.error('자료 목록을 가져오는 중 오류 발생:', error)
      }
    },
    async fetchDataDetail(dno) {
      try {
        const response = await fetch(`http://localhost:8081/dataroom/detail/${dno}`)

        if (!response.ok) throw new Error('Failed to fetch data detail')

        const data = await response.json()
        this.currentData = data
      } catch (error) {
        console.error('자료 상세 정보를 가져오는 중 오류 발생:', error)
      }
    },
    async insertData(formData) {
      try {
        const response = await fetch('http://localhost:8081/dataroom/insert', {
          method: 'POST',
          body: formData,
        })

        if (!response.ok) throw new Error('Failed to insert data')

        const newData = await response.json()
        this.dno = newData.dno
        this.dataList.push(newData)
      } catch (error) {
        console.error('자료를 등록하는 중 오류 발생:', error)
      }
    },
    async updateData(dno, formData) {
      try {
        const response = await fetch(`http://localhost:8081/dataroom/update/${dno}`, {
          method: 'PUT',
          body: formData,
        })

        if (!response.ok) throw new Error('Failed to update data')

        const updatedData = await response.json()
        const index = this.dataList.findIndex((data) => data.dno === updatedData.dno)

        if (index !== -1) {
          this.dataList.splice(index, 1, updatedData)
        }

        this.currentData = updatedData
      } catch (error) {
        console.error('자료를 수정하는 중 오류 발생:', error)
      }
    },
    async deleteData(dno) {
      try {
        const response = await fetch(`http://localhost:8081/dataroom/delete/${dno}`, {
          method: 'DELETE',
        })

        if (!response.ok) throw new Error('Failed to delete data')

        this.dataList = this.dataList.filter((data) => data.dno !== dno)
      } catch (error) {
        console.error('자료를 삭제하는 중 오류 발생:', error)
      }
    },
  },
})
