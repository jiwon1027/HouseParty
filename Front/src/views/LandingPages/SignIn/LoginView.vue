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

defineProps({
  kind: {
    type: String,
    default: "",
  },
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
        backgroundImage: 'url(http://localhost:8080/src/assets/img/bg1.jpg)',
      }"
      loading="lazy"
    >
      <span class="mask bg-gradient-dark opacity-6"></span>
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-4 col-md-8 col-12 mx-auto">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div class="bg-gradient-success shadow-success border-radius-lg py-3 pe-1">
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">로그인</h4>
                  <div class="row mt-3">
                   
                  </div>
                </div>
              </div>
              <div class="card-body">
                <material-input
                  id="id"
                  v-on:input="setUserId($event.target.value)"
                  v-on:click="setMessage()"
                  @keyup.enter="login()"
                  class="input-group-outline my-3"
                  :label="{ text: 'ID', class: 'form-label' }"
                  color="#000000"
                />
                <material-input
                  id="password"
                  v-on:input="setUserPw($event.target.value)"
                  v-on:click="setMessage()"
                  @keyup.enter="login()"
                  class="input-group-outline mb-3"
                  :label="{ text: 'Password', class: 'form-label' }"
                  type="password"
                  color="#000000"
                />

                <!-- 에러 메세지 -->
                <div class="text-danger mb-3">{{ message }}</div>



                <div class="text-center">
                  <MaterialButton
                    class="my-4 mb-2"
                    variant="gradient"
                    color="success"
                    fullWidth
                    @click="login()"
                    >로그인</MaterialButton
                  >
                </div>

                <div style="text-align: center">
                  <p class="pe-6 text-sm fa fa-lock">
                    <RouterLink :to="{ name: 'findpw' }">
                      <a href="#" class="text-success text-gradient"> 비밀번호 찾기</a>
                    </RouterLink>
                  </p>

                  <p class="mt-4 text-sm fa fa-lock">
                    <RouterLink :to="{ name: 'signup' }">
                      <a href="#" class="text-success text-gradient"> 회원가입</a>
                    </RouterLink>
                  </p>
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
      userPw: null,
      message: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    login() {
      console.log("login success");
      axios
        .post("http://localhost/happyhouse/users/login", {
          userId: this.userId,
          userPw: this.userPw,
        })
        .then((response) => {
          if (response.data.message === "success") {
            let accessToken = response.data["access-token"];
            let refreshToken = response.data["refresh-token"];
            sessionStorage.setItem("access-token", accessToken);
            sessionStorage.setItem("refresh-token", refreshToken);
          }
          this.$router.push({ name: "presentation" });
        })
        .catch((error) => {
          this.message = error.response.data;
        });
    },
    setUserPw(password) {
      this.userPw = password;
    },
    setUserId(id) {
      this.userId = id;
    },
    setMessage() {
      this.message = "";
    },
  },
};
</script>
