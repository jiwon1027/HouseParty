<script setup>
import { onMounted } from "vue";

// example components

import DefaultNavbar from "@/examples/navbars/NavbarDefault.vue";
import Header from "@/examples/Header.vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/MaterialInput.vue";
import MaterialInputreadOnly from "@/components/MaterialInputreadOnly.vue";
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
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">마이페이지</h4>
                </div>
              </div>
              <div class="card-body">
                <MaterialInputreadOnly
                  id="id"
                  :value= "`${this.userId}`"
                  readonly
                  class="input-group input-group-outline my-3 isfocused is-filled"
                  :label="{ text: 'ID', class: 'form-label' }"
                  color="#000000"
                />
                <MaterialInputreadOnly
                  id="password"
                  :value= "`${this.userPw}`"
                  class="input-group input-group-outline my-3 isfocused is-filled"
                  :label="{ text: 'Password', class: 'form-label' }"
                  type="password"
                  color="#000000"
                />

                <MaterialInput
                  id="email"
                  :value= "`${this.userEmail}`"
                  v-on:input="setUserEmail($event.target.value)"
                  class="input-group input-group-outline my-3 isfocused is-filled"
                  :label="{ text: 'email', class: 'form-label' }"
                  type="email"
                  color="#000000"
                />

                <MaterialInput
                  id="name"
                  :value= "`${this.userName}`"
                  v-on:input="setUserName($event.target.value)"
                  class="input-group input-group-outline my-3 isfocused is-filled"
                  :label="{ text: 'name', class: 'form-label' }"
                  type="text"
                  color="#000000"
                />

                <div class="d-flex justify-content-between">
                  <MaterialButton
                    class="my-4 mb-2 w-45"
                    variant="gradient"
                    color="secondary"
                    @click="UpdateUser()"
                    >회원 수정</MaterialButton
                  >
                  <MaterialButton
                    class="my-4 mb-2 w-45"
                    variant="gradient"
                    color="danger"
                    @click="deleteUser()"
                    >회원 탈퇴</MaterialButton
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
import jwtDecode from "jwt-decode";

export default {
  data() {
    return {
      userId: null,
      userPw: null,
      userName: null,
      userEmail: null,
      message: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    deleteUser() {
      let token = sessionStorage.getItem("access-token");
      let userid = jwtDecode(token).userid;

      axios
        .delete(`http://localhost/happyhouse/users/${userid}`)
        .then((response) => {
          if (response.data.message === "success") {
            sessionStorage.setItem("access-token", null);
            sessionStorage.setItem("refresh-token", null);
            console.log("회원탈퇴 성공");
          }
          this.$router.push({ name: "presentation" });
        })
        .catch((error) => {
          this.message = error.response.data;
        });
    },
    UpdateUser() {
      axios
        .put(`http://localhost/happyhouse/users`, {
          userId: this.userId,
          userPw: this.userPw,
          name: this.userName,
          email: this.userEmail,
        })
        .then((response) => {
          if (response.data.message === "success") {
            alert(`정보 수정이 완료되었습니다.`);
          }
          this.$router.push({ name: "presentation" });
        })
    },
    getUserInfo() {
      let token = sessionStorage.getItem("access-token");
      let userid = jwtDecode(token).userid;

      axios
        .get(`http://localhost/happyhouse/users/${userid}`)
        .then((response) => {
          this.userId = response.data.userId;
          this.userPw = response.data.userPw;
          this.userName = response.data.name;
          this.userEmail = response.data.email;
        })
    },
    setUserEmail(email) {
      this.userEmail = email;
    },
    setUserName(name) {
      this.userName = name;
    },
    
  },
  mounted() {
    this.getUserInfo();
  },
};
</script>
