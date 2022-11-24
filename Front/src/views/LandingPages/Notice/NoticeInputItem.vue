<template> 
    <div>
      <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">제목</label>
      <input type="email" class="form-control border border-dark ms-4 ps-2 w-95" id="title" @input="noticeInfo.subject=$event.target.value" :value=noticeInfo.subject placeholder="제목을 입력해주세요">
    </div>
    <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">글 작성</label>
      <textarea class="form-control border border-dark mx-4 ps-2 w-95" id="content" rows="10" @input="noticeInfo.content=$event.target.value" :value=noticeInfo.content placeholder="글을 입력하세요"></textarea>
    </div>
    </div>

      <button class="ms-4 fs-6 btn btn-outline-success"  @click="noticeCreate()">글 작성</button>

    <button class="ms-4 fs-6 btn btn-outline-danger" type="reset" @click="reset()">초기화</button>
</template>

<script>
import axios from 'axios';
import jwtDecode from "jwt-decode";

export default {
	data() {
		return{
			noticeInfo : [],
		}
	},
  methods: {
    noticeCreate(){
        let token = sessionStorage.getItem("access-token");

        if (token === undefined || token === "null" || token === null) {
          return;
        }

        this.noticeInfo.userId = jwtDecode(token).userid

        console.log("notice create")
        console.log(this.noticeInfo)

        axios
          .post("http://localhost/happyhouse/notice",{
            userId : this.noticeInfo.userId,
            subject : this.noticeInfo.subject,
            content : this.noticeInfo.content
        },{
        withCredentials: false,
      }).then(()=>{
          this.$router.push({ name: "notice" });
				})
    },
    reset(){
      this.noticeInfo.subject = "",
      this.noticeInfo.content = ""
    }



  },
}
</script>

<style>

</style>