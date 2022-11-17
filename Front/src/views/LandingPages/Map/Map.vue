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
          <div class="col-lg-4" >
            <div class="card z-index-0 fadeIn3 fadeInBottom"  style="height:700px;">
              <div class="card-body">
                <div class="border-right h-100" id="sidebar-wrapper">
                    <div class="list-group list-group-flush overflow-auto h-50">
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>  
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
                      </div>     
                      <div class="list-group-item list-group-item-action">
                        <h3>ㅇㅇ아파트</h3>
                        거래금액 : 21000만원<br>
                        면적 : 76.66
                        2018.4.6
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
