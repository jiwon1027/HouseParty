<script setup>
import { onMounted } from "vue";

import KakaoMap from "./KakaoMap.vue";


import DefaultNavbar from "@/examples/navbars/NavbarDefault.vue";
import Header from "@/examples/Header.vue";

import MaterialInput from "@/components/MaterialInput.vue";
import MaterialSwitch from "@/components/MaterialSwitch.vue";
import MaterialButton from "@/components/MaterialButton.vue";

import RotatingCard from "../../../examples/cards/rotatingCards/RotatingCard.vue";
import RotatingCardFront from "../../../examples/cards/rotatingCards/RotatingCardFront.vue";
import RotatingCardBack from "../../../examples/cards/rotatingCards/RotatingCardBack.vue";

import SearchView from "@/views/Presentation/Components/SearchView.vue"
import setMaterialInput from "@/assets/js/material-input";
import Typed from "typed.js";

onMounted(()=>{
    setMaterialInput();
})


</script>

<script>
import {useRoute} from 'vue-router';
import axios from 'axios';



export default {
  data() {
    return {
      aptList: [],
    };
  },

  methods: {
    selectByAptName(){
      axios.post(`http://localhost/happyhouse/apts`,{
            apartmentName : this.$route.query.aptName
          },{
          withCredentials: false,
        })
          .then((response)=>{
            console.log(response)
            this.aptList = response.data

          })
    },

    selectByAptCode(){
      console.log("selectByAptCode")
      

      axios.get(`http://localhost/happyhouse/apts/${this.$route.query.aptCode}`,
        {
        withCredentials: false,
      })
        .then((response)=>{
          console.log(response)
          this.aptList = response.data
        })
    }

  },
  
  created() {
    console.log("응애")
    console.log(this.$route.query.aptCode)
    console.log(this.$route.query.aptName)



    if (this.$route.query.aptName != null){
      this.selectByAptName();

    }
    else if(this.$route.query.aptCode != null){
      this.selectByAptCode();

      }
  },
};
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


      <div class="container mt-10">
        <div class="row">
            <div class = "d-flex flex-row justify-content-between">
              <div class="item mt-2">
                <SearchView/>
                <router-view :key="$route.fullPath"></router-view>

              </div>
              <div class="item w-50 ">
                <MaterialInput
                  class="input-group-outline mt-2"
                  :label="{ text: '아파트 이름 검색', class: 'form-label' }"
                    @input="aptName=$event.target.value"
                  @keyup.enter="this.$router.push({ name: 'map', query: {aptName: aptName} });"
                />     
                        <router-view :key="$route.fullPath"></router-view>

              </div>




            </div>
          <div class="col-lg-4" >
            <div class="card z-index-0 fadeIn3 fadeInBottom"  style="height:700px;">
              <div class="card-body">
                <div class="border-right h-100" id="sidebar-wrapper">
                    <div class="list-group list-group-flush overflow-auto" style="height:600px;">
                      <div v-for="(apt,index) in aptList" class="list-group-item list-group-item-action" >
                        <h4>{{apt.apartmentName}}</h4>
                        거래금액 : {{apt.dealAmount}}<br>
                        면적 : {{apt.area}}<br>
                        {{apt.dealyear}}.{{apt.dealmonth}}.{{apt.dealday}}
                      </div>
                    </div>
                </div>                 
              </div>
            </div>
          </div>
          <div class="col-lg-8" >
            <div class="card z-index-0 fadeIn3 fadeInBottom"  style="height:700px;">
              <div class="card-body">
                  <KakaoMap/>
              </div>
            </div>
          </div>

        </div>
      </div>



    </div>
  </Header>
</template>
