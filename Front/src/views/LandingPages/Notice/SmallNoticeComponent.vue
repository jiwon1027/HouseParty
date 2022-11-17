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
						    <tr v-for="notice in noticeList" v-bind:key="noticeList">
						      <th scope="row">{{notice.articleNo}}</th>
						      <td>{{notice.subject}}</td>
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
				.get("http://localhost/happyhouse/notice")
				.then((response)=>{
					this.noticeList = response.data
				})
	},
}
</script>

