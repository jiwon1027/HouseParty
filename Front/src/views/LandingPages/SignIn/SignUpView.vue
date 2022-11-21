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
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">회원가입</h4>
                </div>
              </div>
              <div class="card-body">
                <MaterialInput
                  id="id"
                  v-on:input="setUserId($event.target.value), setIdMessage()"
                  @keyup.enter="checkAndSend()"
                  class="input-group-outline my-3"
                  :label="{ text: 'ID', class: 'form-label' }"
                  color="#000000"
                />
                <div class="text-danger mb-3">{{ idMessage }}</div>

                <MaterialInput
                  id="password"
                  v-on:input="setAndCheckUserPw($event.target.value)"
                  @keyup.enter="checkAndSend()"
                  class="input-group-outline mb-3"
                  :label="{ text: 'Password', class: 'form-label' }"
                  type="password"
                  color="#000000"
                />
                <div class="text-danger mb-3">{{ pwMessage }}</div>

                <MaterialInput
                  id="email"
                  v-on:input="setUserEmail($event.target.value)"
                  v-on:click="setEmailMessage()"
                  @keyup.enter="checkAndSend()"
                  class="input-group-outline mb-3"
                  :label="{ text: 'email', class: 'form-label' }"
                  type="email"
                  color="#000000"
                />
                <div class="text-danger mb-3">{{ emailMessage }}</div>

                <MaterialInput
                  id="name"
                  v-on:input="setUserName($event.target.value)"
                  v-on:click="setNameMessage()"
                  @keyup.enter="checkAndSend()"
                  class="input-group-outline mb-3"
                  :label="{ text: 'name', class: 'form-label' }"
                  type="text"
                  color="#000000"
                />
                <div class="text-danger mb-3">{{ nameMessage }}</div>

                <div class="text-center">
                  <MaterialButton
                    class="my-4 mb-2"
                    variant="gradient"
                    color="success"
                    fullWidth
                    @click="checkAndSend()"
                    >회원가입</MaterialButton
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
      userPw: "",
      userEmail: null,
      userName: null,
      idMessage: "",
      pwMessage: "",
      emailMessage: "",
      nameMessage: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
    },
    signup() {
      console.log("login success");
      axios
        .post("http://localhost/happyhouse/users", {
          userId: this.userId,
          userPw: this.userPw,
          email: this.userEmail,
          name: this.userName,
        })
        .then((response) => {
          alert(`회원가입을 환영합니다!`);
          this.$router.push({ name: "presentation" });
        })
        .catch((error) => {
          this.message = error.response.data;
        });
    },
    setAndCheckUserPw(password) {
      this.userPw = password;
      if (this.userPw.length < 5 || 10 < this.userPw.length) {
        this.pwMessage = "패스워드는 5 ~ 10자로 입력해주세요";
      } else this.pwMessage = "";
    },
    setUserId(id) {
      this.userId = id;
    },
    setUserEmail(email) {
      this.userEmail = email;
    },
    setUserName(name) {
      this.userName = name;
    },
    setMessage() {
      this.message = "";
    },
    checkAndSend() {
      let can = true;
      if (this.userId === null || this.userId.trim() === "") {
        this.idMessage = "아이디를 입력해주세요";
        can = false;
      }
      if (this.userPw.trim().length < 5 || 10 < this.userPw.trim().length) {
        this.pwMessage = "패스워드는 5 ~ 10자로 입력해주세요";
        can = false;
      }
      if (this.userEmail === null || this.userEmail.trim() === "") {
        this.emailMessage = "이메일을 입력해주세요";
        can = false;
      }
      if (this.userName === null || this.userName.trim() === "") {
        this.nameMessage = "이름을 입력해주세요";
        can = false;
      }
      if (can) this.signup();
    },
    setIdMessage() {
      this.idMessage = "";
    },
    setEmailMessage() {
      this.emailMessage = "";
    },
    setNameMessage() {
      this.nameMessage = "";
    },
  },
};
</script>
