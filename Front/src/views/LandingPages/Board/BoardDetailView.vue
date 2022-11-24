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
                  <div>
                      <div class="mb-3 my-4">
                      <label class="form-label ms-4 fs-4">제목</label>
                      <input type="text" class="form-control border border-dark ms-4 ps-2 w-95" @input="boardInfo.subject=$event.target.value" :value="boardInfo.subject">
                      
                      </div>
                    <div class="mb-3 my-4">
                      <label class="form-label ms-4 fs-4">내용</label>
                      <textarea class="form-control border border-dark mx-4 ps-2 w-95" id="content" rows="10"  @input="boardInfo.content=$event.target.value" :value="boardInfo.content"></textarea>
                    </div>
                  </div>

                    <button v-if="this.isLogin" class="ms-4 fs-6 btn btn-outline-success" @click="boardUpdate()" >수정</button>
                    <button v-if="this.isLogin" class="ms-4 fs-6 btn btn-outline-danger" @click="boardDelete()" >삭제</button>

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
import jwtDecode from "jwt-decode";

// axios.defaults.headers['Access-Control-Allow-Origin'] = '*';
// axios.defaults.withCredentials = true;

export default {
	data() {
		return{
			boardInfo : [],
      isLogin: false,
		}
	},
  methods: {
    boardUpdate(){

			axios.put(`http://localhost/happyhouse/board`,{
            articleNo : this.boardInfo.articleNo,
            userId : this.boardInfo.userId,
            subject : this.boardInfo.subject,
            content : this.boardInfo.content
        },{
        withCredentials: false,
      }).then(()=>{
          this.$router.push({ name: "board" });
				})



    },


    boardDelete(){
      console.log("boardDelete")

      axios.delete(`http://localhost/happyhouse${this.$route.path}`,{
        withCredentials: false,
      }).then(()=>{
          this.$router.push({ name: "board" });
				})


    },

    check() {
        let token = sessionStorage.getItem("access-token");

        if (token === undefined || token === "null" || token === null) {
          return;
        }

        let userId = jwtDecode(token).userid

        if (userId != this.boardInfo.userId) {
          return;
        }

        return this.isLogin = true;
      }

  },

	created() {

			axios.get(`http://localhost/happyhouse${this.$route.path}`,{
        withCredentials: false,
      }).then((response)=>{
					this.boardInfo = response.data
          this.check();
			})
	},
}
</script>