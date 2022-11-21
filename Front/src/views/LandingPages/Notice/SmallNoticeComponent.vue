<template>
  <!-- <head>
  	<title>Table 07</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">

	</head> -->
	<!-- <body> -->
		<div class="container">
			<div class="row justify-content-center">
				<div >
					<h4 class="heading-section" >{{title}}</h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-bordered text-dark table-hover">
						  <thead>
						    <tr class="text-center">
						      <th>번호</th>
						      <th>제목</th>
						    </tr>
						  </thead>
						  <tbody class="text-center">
						    <tr v-for="(notice,index) in noticeList" v-bind:key="noticeList">
						      <th scope="row" v-if="index < 5">{{notice.articleNo}}</th>
						      <td v-if="index < 5">
								<RouterLink :to="{ name: 'noticeDetail' , params: {articleNo: `${notice.articleNo}`} }">
									<div>{{notice.subject}}</div>
								</RouterLink>
							  </td>
						    </tr>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	<!-- <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script> -->

	<!-- </body> -->

</template>

<script setup> 
  defineProps({
    title : {
        type: String,
        default: "",
      }
  })
</script>

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
				.get("http://localhost/happyhouse/notice",{
        withCredentials: false,
      })
				.then((response)=>{
					this.noticeList = response.data
				})
	},
}
</script>

