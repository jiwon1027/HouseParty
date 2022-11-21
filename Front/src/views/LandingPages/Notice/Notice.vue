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

import NoticeComponent from "@/views/LandingPages/Notice/NoticeComponent.vue";


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

  <div class="container my-auto mt-8">
    <div class="row">
      <div class="col-lg-12 col-md-8 col-12">
        <div class="card z-index-0 fadeIn3 fadeInBottom">
          <div class="card-body">
            <div class="d-flex justify-content-between">
            <h2 class="ms-4">공지사항</h2>
            
            <router-link :to="{ name: 'noticewrite' }">
              <a class="btn btn-outline-secondary me-5" role="button">
                  글쓰기
              </a>
            </router-link>

            </div>
              <NoticeComponent/>
          </div>
        </div>
      </div>
    </div>
  </div>


    </div>
  </Header>
</template>
