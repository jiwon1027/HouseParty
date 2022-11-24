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

import jwtDecode from "jwt-decode";




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
      area_count : 0,
      count : [],
      fav_apt : [],
      aptList: [],
      aptLatLng: [],
      fav_area : [],
      fav_apt : []
    };
  },
  methods: {
    insertFavApt(idx){

      let token = sessionStorage.getItem("access-token");




      axios.post("http://localhost/happyhouse/apts/fav-apt",{
          userId : jwtDecode(token).userid,
          aptCode : this.aptList[idx].aptCode,
          dealAmount : this.aptList[idx].dealAmount,
          dealyear : this.aptList[idx].dealyear,
          dealmonth : this.aptList[idx].dealmonth,
          dealday : this.aptList[idx].dealday,
          area : this.aptList[idx].area,
          apartmentName : this.aptList[idx].apartmentName
      },{
      withCredentials: false,
    }).then(()=>{

      })
    },

    deleteFavApt(idx){
      let token = sessionStorage.getItem("access-token");

      axios.delete(`http://localhost/happyhouse/apts/fav-apt/${jwtDecode(token).userid}/${this.fav_apt[idx].aptCode}/${this.fav_apt[idx].dealAmount}/${this.fav_apt[idx].dealyear}/${this.fav_apt[idx].dealmonth}/${this.fav_apt[idx].dealday}/${this.fav_apt[idx].area}`
        ,{
        withCredentials: false,
      }).then(()=>{
          this.$router.go();
          
        })
    },

    insertFavArea(){
            let token = sessionStorage.getItem("access-token");

          axios.post("http://localhost/happyhouse/apts/fav-area",{
          userId : jwtDecode(token).userid,
          dongCode : this.$route.query.aptCode
        },{
        withCredentials: false,
      }).then(()=>{

        })
    },

    deleteFavArea(){
            let token = sessionStorage.getItem("access-token");

        axios.delete(`http://localhost/happyhouse/apts/fav-area/${jwtDecode(token).userid}/${this.$route.query.aptCode}`,{
        },{
        withCredentials: false,
      }).then(()=>{
        this.$router.go();
        })
      },

    deleteFavAreaInList(idx){

        let token = sessionStorage.getItem("access-token");

        axios.delete(`http://localhost/happyhouse/apts/fav-area/${jwtDecode(token).userid}/${this.fav_area[idx].dongCode}`,{
        },{
        withCredentials: false,
      }).then(()=>{
        this.$router.go();
        })
      },

    area_star_fun(){
      this.area_count += 1;

      if (this.area_count %2 == 1){
        this.insertFavArea();
      }
      else{
        console.log("관심지역 삭제")
        this.deleteFavArea()
      }
    },

    star_fun(idx){

      this.count[idx] += 1;

      if (this.count[idx] %2 == 1){
        console.log("관심지역 추가")
        this.insertFavApt(idx)


      }
      else{
        console.log("관심지역 삭제")
        this.deleteFavApt(idx)
      }

    },

    selectByAptName(aptName){
      this.area_count = 0
      this.count = []

      axios.post(`http://localhost/happyhouse/apts`,{
            apartmentName : aptName
          },{
          withCredentials: false,
        })
          .then((response)=>{
            this.aptList = response.data
            this.aptLatLng = [];

            for (let i = 0; i < response.data.length; i++) {
              this.aptLatLng.push([response.data[i].lat, response.data[i].lng])
              this.count.push(0)

            }

          })
    },

    selectByAptCode(aptCode){
      this.area_count = 0
      this.count = []

      axios.get(`http://localhost/happyhouse/apts/${aptCode}`,
        {
        withCredentials: false,
      })
        .then((response)=>{
          this.aptList = response.data
          this.aptLatLng = [];

          for (let i = 0; i < response.data.length; i++) {
            this.aptLatLng.push([response.data[i].lat, response.data[i].lng])
            this.count.push(0)
          }

        })
    },

    selectFavArea(){


      let token = sessionStorage.getItem("access-token");



      if (token === null || token === "null" || token === undefined){
        return;
      }
      axios.get(`http://localhost/happyhouse/apts/fav-area/${jwtDecode(token).userid}`,{
      },{
      withCredentials: false,
    }).then((response)=>{
        this.fav_area = response.data
        console.log(this.fav_area)
      })

    },

    selectFavApt(){
      let token = sessionStorage.getItem("access-token");



      if (token === null || token === "null" || token === undefined){

        return;
      }



      console.log(this.$route.query.aptCode)
      axios.get(`http://localhost/happyhouse/apts/fav-apt/${jwtDecode(token).userid}`,{
      },{
      withCredentials: false,
    }).then((response)=>{
          this.fav_apt = response.data
          //console.log(this.fav_apt)

      })
    },
  },
  
  created() {


    if (this.$route.query.aptName != null){
      this.selectByAptName(this.$route.query.aptName);

    }
    else if(this.$route.query.aptCode != null){
      this.selectByAptCode(this.$route.query.aptCode);
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
                <SearchView @selectByAptCode="selectByAptCode" />
                <router-view :key="$route.fullPath"></router-view>
              </div>
              
              <div>
                <label class="mt-2">
                    <input type="checkbox" hidden @click="area_star_fun()">
                    <img src="../../../assets/img/star_true.png" v-if="`${area_count}`%2 == 1" name="star" width="30" height="30">
                    <img src="../../../assets/img/star_false.png" v-if="`${area_count}`%2 == 0" name="star" width="30" height="30">
                </label>
              </div>
              <div class="item w-50 ">
                <MaterialInput
                  class="input-group-outline mt-2"
                  :label="{ text: '아파트 이름 검색', class: 'form-label' }"
                    @input="aptName=$event.target.value"
                    @keyup.enter="this.selectByAptName(this.aptName)"
                />
                        <router-view :key="$route.fullPath"></router-view>
              </div>
            </div>
          <div class="col-lg-4" >
            <div class="card z-index-0 fadeIn3 fadeInBottom mb-5"  style="height:700px;">
              <div class="card-header">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                  <li class="nav-item" role="presentation">
                    <button class="nav-link active text-dark"  id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">검색 결과</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link text-dark" @click="selectFavArea()" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">관심 지역</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link text-dark" @click="selectFavApt()" id="messages-tab" data-bs-toggle="tab" data-bs-target="#messages" type="button" role="tab" aria-controls="messages" aria-selected="false">관심 아파트</button>
                  </li>
                </ul>

                <div class="tab-content" id="myTabContent">
                  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <div class="list-group list-group-flush overflow-auto" style="height:600px;">
                      <div v-for="(apt,index) in this.aptList" :key="apt" class="list-group-item list-group-item-action" >
                          <h4>{{apt.apartmentName}}</h4>
                          거래금액 : {{apt.dealAmount}}<br>
                          면적 : {{apt.area}}<br>
                          {{apt.dealyear}}.{{apt.dealmonth}}.{{apt.dealday}}
                          <label>
                            <input type="checkbox" hidden @click="star_fun(index)">
                            <img src="../../../assets/img/star_true.png" v-if="`${count[index]}`%2 == 1" width="30" height="30">
                            <img src="../../../assets/img/star_false.png" v-if="`${count[index]}`%2 == 0" width="30" height="30">
                          </label>
                        </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <div class="list-group list-group-flush overflow-auto" style="height:600px;">
                      <div v-for="(area,index) in this.fav_area" :key="area" class="list-group-item list-group-item-action" >
                            <h5  @click="selectByAptCode(area.dongCode)">{{area.sidoName}} {{area.gugunName}} {{area.dongName}}</h5>
                            <label>
                              <input type="checkbox" hidden @click="deleteFavAreaInList(index)">
                              <img src="../../../assets/img/star_true.png" width="30" height="30">
                            </label>
                      </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="messages" role="tabpanel" aria-labelledby="contact-tab">
                      <div class="list-group list-group-flush overflow-auto" style="height:600px;">

                      <div v-for="(favApt, index) in this.fav_apt" :key="favApt" class="list-group-item list-group-item-action" >
                          <h4>{{favApt.apartmentName}}</h4>
                          거래금액 : {{favApt.dealAmount}}<br>
                          면적 : {{favApt.area}}<br>
                          {{favApt.dealyear}}.{{favApt.dealmonth}}.{{favApt.dealday}}
                          <label>
                            <input type="checkbox" hidden @click="deleteFavApt(index)">
                            <img src="../../../assets/img/star_true.png" width="30" height="30">
                          </label>
                        </div>
                      </div>

                </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-8" >
            <div class="card z-index-0 fadeIn3 fadeInBottom"  style="height:700px;">
              <div class="card-body">
                  <KakaoMap :markerPositions1="`${aptLatLng}`"/>
              </div>
            </div>
          </div>

        </div>
      </div>



    </div>
  </Header>
</template>