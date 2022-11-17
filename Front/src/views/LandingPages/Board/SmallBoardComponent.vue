<template>

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
						    <tr v-for="board in boardList" v-bind:key="boardList">
						      <th scope="row">{{board.articleNo}}</th>
						      <td>{{board.subject}}</td>
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

