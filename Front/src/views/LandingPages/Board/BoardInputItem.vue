<template> 
    <div>
      <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">제목</label>
      <input type="email" class="form-control border border-dark ms-4 ps-2 w-95" id="title" @input="boardInfo.subject=$event.target.value" :value=boardInfo.subject placeholder="제목을 입력해주세요">
    </div>
    <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">글 작성</label>
      <textarea class="form-control border border-dark mx-4 ps-2 w-95" id="content" rows="10" @input="boardInfo.content=$event.target.value" :value=boardInfo.content placeholder="내용을 입력해주세요"></textarea>
    </div>
    </div>

      <button class="ms-4 fs-6 btn btn-outline-success" @click="boardCreate()" >글 작성</button>

    <button class="ms-4 fs-6 btn btn-outline-danger"  @click="reset()">초기화</button>
</template>

<script setup> 
  defineProps({
    kind : {
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
			boardInfo : [],
		}
	},
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    boardCreate(){
        console.log("board create")
        console.log(this.boardInfo)

        axios
          .post("http://localhost/happyhouse/board",{
            userId : this.boardInfo.userId,
            subject : this.boardInfo.subject,
            content : this.boardInfo.content
        },{
        withCredentials: false,
      }).then(()=>{
          this.$router.push({ name: "board" });
				})

    },
    reset(){
      this.boardInfo.subject = "",
      this.boardInfo.content = ""
    }


  },
}
</script>