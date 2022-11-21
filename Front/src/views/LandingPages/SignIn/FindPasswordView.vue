<script setup>
import { onMounted } from "vue";

// example components

import DefaultNavbar from "@/examples/navbars/NavbarDefault.vue";
import Header from "@/examples/Header.vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/MaterialInput.vue";
import MaterialSwitch from "@/components/MaterialSwitch.vue";
import MaterialButton from "@/components/MaterialButton.vue";

// material-input
import setMaterialInput from "@/assets/js/material-input";
onMounted(() => {
  setMaterialInput();
});
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
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-4 col-md-8 col-12 mx-auto">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div
                class="card-header p-0 position-relative mt-n4 mx-3 z-index-2"
              >
                <div
                  class="bg-gradient-success shadow-success border-radius-lg py-3 pe-1"
                >
                  <h4
                    class="text-white font-weight-bolder text-center mt-2 mb-0"
                  >
                    비밀번호 찾기
                  </h4>

                </div>
              </div>
              <div class="card-body">
                  <MaterialInput
                    id="id"
                    class="input-group-outline my-3"
                    v-on:input="setUserId($event.target.value)"
                    :label="{ text: 'ID', class: 'form-label' }"
                    @keyup.enter="findPw()"
                    color="#000000"
                  />

                  <div class="text-center">
                    <MaterialButton
                      class="my-4 mb-2"
                      variant="gradient"
                      color="success"
                      @click="findPw()"
                      fullWidth
                      >비밀번호 찾기</MaterialButton
                    >
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </Header>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      userId: null,
    };
  },
  methods: {
    findPw() {
      axios
        .post(`http://localhost/happyhouse/users/findpw/${this.userId}`)
        .then((response) => {
          if (response.data.message === "success") {
            alert("이메일의 임시 패스워드를 확인해주세요.")
          }
        })
    },
    setUserId(id) {
      this.userId = id;
    },
  },
}
</script>