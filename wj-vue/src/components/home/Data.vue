<template>
  <div>
    <table>
      <tr>
        <td>id</td>
        <td>name</td>
        <td>author</td>
      </tr>
      <tr v-for="book in books">
        <td>{{ book.id }}</td>
        <td>{{ book.name }}</td>
        <td>{{ book.author }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "Data",
  data() {
    return {
      books:[
        {
          id:1,
          name:"",
          author:""
        }
      ]
    }
  },
  created() {
    const _this = this;
    this.$axios.get('/ESData/findAll').then(function (resp){
      console.log(resp)
      _this.books = resp.data
    })
  }
}
</script>

<style scoped>

</style>
