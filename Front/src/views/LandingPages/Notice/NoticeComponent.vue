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
            <tr v-for="notice in noticeList" v-bind:key="noticeList">
              <td>
                {{notice.articleNo}}
              </td>
              <td>{{notice.userId}}</td>
              <td>{{notice.subject}}</td>
              <td>{{notice.content}}</td>
              <td>{{notice.registerTime}}</td>
              <td>


              <RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
                Detail
              </RouterLink>
              </td>
            </tr>
          </tbody>
        </table>
      </div>


    </div>

  </div>

    <!-- <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script> -->
  <!-- </body> -->
</template>


<script>
import axios from 'axios';

export default {
	data() {
		return{
			noticeList : [],
		}
	},

	created() {
			axios
				.get("http://localhost/happyhouse/notice")
				.then((response)=>{
					this.noticeList = response.data
				})
	},
}
</script>