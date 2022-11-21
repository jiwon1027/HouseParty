<template>
  <router-view :key="$route.fullPath"/>

  <div class="content">
    
    <div class="container">

      <div class="table-responsive">

        <table class="table table-striped custom-table">
          <thead>
            <tr>
              
              <th scope="col" class="ps-3 col-md-1">articleNo</th>
              <th scope="col" class="col-md-1">ID</th>
              <th scope="col">subject</th>
              <th scope="col" class="col-md-6">content</th>
              <th scope="col">registerTime</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="board in boardList" v-bind:key="boardList">
              <td class="col-md-1 text-center">
                <RouterLink :to="{ name: 'boardDetail' , params: {articleNo: `${board.articleNo}`} }">
                  {{board.articleNo}}
                </RouterLink>
              </td>

              <td>
                <RouterLink :to="{ name: 'boardDetail' , params: {articleNo: `${board.articleNo}`} }">
                  {{board.userId}}
                </RouterLink>
              </td>

              <td>
                <RouterLink :to="{ name: 'boardDetail' , params: {articleNo: `${board.articleNo}`} }">
                  {{board.subject}}
                </RouterLink>
              </td>

              <td>
                <RouterLink :to="{ name: 'boardDetail' , params: {articleNo: `${board.articleNo}`} }">
                  {{board.content}}
                </RouterLink>
              </td>

              <td>
                  {{board.registerTime}}
              </td>

            </tr>
            
          </tbody>
        </table>
      </div>


    </div>

  </div>
</template>

<script>
import axios from 'axios';

export default {
	data() {
		return{
			boardList : [],
		}
	},

	created() {

      console.log("asdfasdfasdfboard 받아옴")

			axios
				.get("http://localhost/happyhouse/board",{
        withCredentials: false,
      })
				.then((response)=>{
          console.log(response)
					this.boardList = response.data
				})
	},
}
</script>

<style scoped>
	table { 
		table-layout: fixed;
	}

	td { 
		overflow:hidden;
		white-space : nowrap;
		text-overflow: ellipsis;
	 }
</style>
