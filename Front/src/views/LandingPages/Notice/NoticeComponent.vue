<template>

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
            <tr v-for="notice in noticeList" v-bind:key="noticeList">
              <td class="col-md-1 text-center">
              <RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
                {{notice.articleNo}}
              </RouterLink>
              </td>

              <td>
              <RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
                {{notice.userId}}
              </RouterLink>
              </td>

              <td>
              <RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
                {{notice.subject}}
              </RouterLink>
              </td>

              <td>
              <RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
                {{notice.content}}
              </RouterLink>
              </td>
              
              <td>{{notice.registerTime}}</td>
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
    console.log("notice 목록")
			axios
				.get("http://localhost/happyhouse/notice",{
        withCredentials: false,
      })
				.then((response)=>{
          console.log(response)
					this.noticeList = response.data
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