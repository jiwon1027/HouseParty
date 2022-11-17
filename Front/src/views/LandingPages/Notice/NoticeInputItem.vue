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

    <button class="ms-4 fs-6 btn btn-outline-success"  @click="noticeCreate()">글 작성</button>
    <button class="ms-4 fs-6 btn btn-outline-danger" type="reset">초기화</button>
</template>

<script>
export default {
  methods: {
    noticeCreate(){
      console.log("notice Create")
        // axios
        //   .post("http://localhost/happyhouse/notice")
        //   .then(()=>{
            
        //   })
    }
  },
}
</script>

<style>

</style>