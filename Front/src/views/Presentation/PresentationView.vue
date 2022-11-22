


<script setup>
import { onMounted, onUnmounted } from "vue";

//example components
import NavbarDefault from "../..//examples/navbars/NavbarDefault.vue";
import DefaultFooter from "../../examples/footers/FooterDefault.vue";
import Header from "../../examples/Header.vue";

import MaterialSocialButton from "@/components/MaterialSocialButton.vue";
import DefaultNavbar from "@/examples/navbars/NavbarDefault.vue";

// sections
import MainBanner from "./Components/MainBanner.vue";
import PresentationInformation from "./Components/PresentationInformation.vue";

//images
import vueMkHeader from "@/assets/img/temp_bg5.jpg";


//Temp import
import SearchView from "@/views/Presentation/Components/SearchView.vue"
import MaterialInput from "@/components/MaterialInput.vue";
import MaterialButton from "@/components/MaterialButton.vue";
import setMaterialInput from "@/assets/js/material-input";
import Typed from "typed.js";

import axios from 'axios';

const aptName = '';

//hooks
const body = document.getElementsByTagName("body")[0];
onMounted(() => {
  setMaterialInput();
  body.classList.add("presentation-page");
  body.classList.add("bg-gray-200");
  if (document.getElementById("typed")) {
    // eslint-disable-next-line no-unused-vars
    var typed = new Typed("#typed", {
      stringsElement: "#typed-strings",
      typeSpeed: 90,
      backSpeed: 120,
      backDelay: 200,
      startDelay: 500,
      loop: true,
    });
  }
});
onUnmounted(() => {
  body.classList.remove("presentation-page");
  body.classList.remove("bg-gray-200");
});
</script>






<template>
  <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
          <DefaultNavbar transparent />
      </div>
    </div>
  </div>
  <Header>
    <div id="header"
      class="page-header min-vh-100"
      :style="`background-image: url(${vueMkHeader})`"
      loading="lazy"
    >
      <div class="container">
        <div class="row">
          <div class="col-lg-7 text-center mx-auto position-relative">

            <p class="lead text-black px-5 mt-3" :style="{ fontWeight: '500' }">
              <h3>
                 <span style="color: #fff;" id="typed"></span>
              </h3>
              <div id="typed-strings">
                <h1> #내집마련</h1>
                <h1> #집찾아줘</h1>
                <h1> #구해줘홈즈</h1>
                <h1> #가격실화냐</h1>
              </div>          
            </p>
            <SearchView/>

          <br><br><br>
            <!-- 아파트 이름으로 검색하는 input창인데 쓸지 안쓸지 모름-->
              <div>
                <MaterialInput
                  class="input-group-outline mt-2"
                  :label="{ text: '아파트 이름 검색', class: 'form-label' }"
                   @input="aptName=$event.target.value"
                  @keyup.enter="this.$router.push({ name: 'map', query: {aptName: aptName} });"
                />
                
              </div>
        

          </div>
        </div>
      </div>
    </div>
  </Header>

  <div class="card card-body blur shadow-blur mx-3 mx-md-4 mt-n6">
    <MainBanner/> 
    <PresentationInformation />
  </div>

  <DefaultFooter />
</template>

<style>
#header{
    background-size: cover;
}
</style>
