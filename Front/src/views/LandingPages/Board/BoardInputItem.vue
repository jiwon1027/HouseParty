<template> 
    <div>
      <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">제목</label>
      <input type="email" class="form-control border border-dark ms-4 ps-2 w-95" id="title" placeholder="제목을 입력해주세요">
    </div>
    <div class="mb-3 my-4">
      <label class="form-label ms-4 fs-4">글 작성</label>
      <textarea class="form-control border border-dark mx-4 ps-2 w-95" id="content" rows="3" placeholder="글을 입력하세요"></textarea>
    </div>
    </div>

    <button class="ms-4 fs-6 btn btn-outline-success" v-if="this.kind === 'post'" @click="boardCreate()" >글 작성</button>
    <button class="ms-4 fs-6 btn btn-outline-success" v-if="this.kind === 'put'" @click="boardUpdate()" >글 작성</button>

    <button class="ms-4 fs-6 btn btn-outline-danger" type="reset">초기화</button>
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
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    boardCreate(){
        console.log("board create")

        // axios
        //   .put("http://localhost/happyhouse/board/sido")
        //   .then((response)=>{
        //     this.sidoList = response.data
        //   })
    },
    boardUpdate(){
        console.log("board update")

        // axios
        //   .put("http://localhost/happyhouse/board/sido")
        //   .then((response)=>{
        //     this.sidoList = response.data
        //   })
    }

  },
}
</script>

<style>

</style>