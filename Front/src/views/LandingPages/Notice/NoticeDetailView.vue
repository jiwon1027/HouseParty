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
                      <input  type="text" class="form-control border border-dark ms-4 ps-2 w-95" @input="noticeInfo.subject=$event.target.value" :value="noticeInfo.subject">
                      
                      </div>
                    <div class="mb-3 my-4">
                      <label class="form-label ms-4 fs-4">내용</label>
                      <textarea class="form-control border border-dark mx-4 ps-2 w-95" id="content" rows="10" @input="noticeInfo.content=$event.target.value" :value="noticeInfo.content"></textarea>
                    </div>
                  </div>

                    <button class="ms-4 fs-6 btn btn-outline-success" @click="noticeUpdate()" >수정</button>
                    <button class="ms-4 fs-6 btn btn-outline-danger" @click="noticeDelete()" >삭제</button>
            
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
			noticeInfo : [],
		}
	},
  methods: {
    noticeUpdate(){
      console.log("notice update함")
      console.log(this.noticeInfo)

			axios.put(`http://localhost/happyhouse/notice`,{
            articleNo : this.noticeInfo.articleNo,
            userId : this.noticeInfo.userId,
            subject : this.noticeInfo.subject,
            content : this.noticeInfo.content
        },{
        withCredentials: false,
      }).then(()=>{
          this.$router.push({ name: "notice" });
				})
    },


    noticeDelete(){
      console.log("notice delete함")
      axios.delete(`http://localhost/happyhouse${this.$route.path}`,{
        withCredentials: false, 
      }).then(()=>{
          this.$router.push({ name: "notice" });
				})
    }
  },
	created() {
			axios
				.get(`http://localhost/happyhouse${this.$route.path}`)
				.then((response)=>{
					this.noticeInfo = response.data
				})
	},
}
</script>