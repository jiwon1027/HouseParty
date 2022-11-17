<template>

  <div class="content">
    
    <div class="container">

      <div class="table-responsive">

        <table class="table table-striped custom-table">
          <thead>
            <tr>
              
              <th scope="col">articleNo</th>
              <th scope="col">ID</th>
              <th scope="col">subject</th>
              <th scope="col">content</th>
              <th scope="col">registerTime</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="board in boardList" v-bind:key="boardList">
              <td>
                {{board.articleNo}}
              </td>
              <td>{{board.userId}}</td>
              <td>{{board.subject}}</td>
              <td>{{board.content}}</td>
              <td>{{board.registerTime}}</td>
              <td>
              <RouterLink :to="{ name: 'boardDetail' , params: {articleNo: `${board.articleNo}`} }">
                Detail
              </RouterLink>
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
			axios
				.get("http://localhost/happyhouse/board")
				.then((response)=>{
					this.boardList = response.data
				})
	},
}
</script>
