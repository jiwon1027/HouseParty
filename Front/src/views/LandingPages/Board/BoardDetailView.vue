<script setup>
import { onMounted } from "vue";

// example components

import DefaultNavbar from "@/examples/navbars/NavbarDefault.vue";
import Header from "@/examples/Header.vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/MaterialInput.vue";
import MaterialSwitch from "@/components/MaterialSwitch.vue";
import MaterialButton from "@/components/MaterialButton.vue";

//board
import BoardComponent from "@/views/LandingPages/Board/BoardComponent.vue";

</script>
<template>
  <div class="container position-sticky z-index-sticky top-0">
          <DefaultNavbar transparent />
  </div>
  <Header>
    <div
      class="page-header align-items-start min-vh-100"
      :style="{
        backgroundImage:
          'url(http://localhost:8080/src/assets/img/bg1.jpg)'
      }"
      loading="lazy"
    >
      <span class="mask bg-gradient-dark opacity-6"></span>

      <div class="container my-auto mt-8">
        <div class="row">
          <div class="col-lg-12 col-md-8 col-12">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div class="card-body">
                <h2 class="ms-4">상세보기</h2>
                  <table class="table table-striped custom-table">
                    <thead>
                      <tr>      
                        <th scope="col">articleNo</th>
                        <th scope="col">ID</th>
                        <th scope="col">subject</th>
                        <th scope="col">content</th>
                        <th scope="col">registerTime</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-bind="boardInfo">
                        <td>
                          {{boardInfo.articleNo}}
                        </td>
                        <td>{{boardInfo.userId}}</td>
                        <td>{{boardInfo.subject}}</td>
                        <td>{{boardInfo.content}}</td>
                        <td>{{boardInfo.registerTime}}</td>
                      </tr>  
                    </tbody>
                  </table>
               
                  <MaterialButton
                    variant="gradient"
                    color="secondary">
                    수정
                    </MaterialButton>
                
                  <MaterialButton
                    variant="gradient"
                    color="secondary"
                    @click="boardDelete()">
                    삭제
                    </MaterialButton>


                  
              </div>
            </div>
          </div>
        </div>
      </div>


    </div>
  </Header>

</template>

<script>
import axios from 'axios';

export default {
	data() {
		return{
			boardInfo : [],
		}
	},
  methods: {
    boardDelete(){
      console.log("asdfasdfasd")
			// axios
			// 	.delete(`http://localhost/happyhouse${this.$route.path}`)
			// 	.then((response)=>{
			// 		this.boardInfo = response.data
			// 	})
    }
  },

	created() {
			axios
				.get(`http://localhost/happyhouse${this.$route.path}`)
				.then((response)=>{
					this.boardInfo = response.data
				})
	},
}
</script>