<script setup>
import logoDark from "@/assets/img/titlelogo.png";

defineProps({
  brand: {
    type: Object,
    name: String,
    logo: String,
    route: "",
    default: () => ({
      name: "HouseParty",
      logo: logoDark,
      route: "/"
    })
  },
  socials: {
    type: Array,
    icon: String,
    link: String,
    default: () => [
      {
        icon: '<i class="fab fa-facebook text-lg opacity-8"></i>',
        link: "#"
      },
      {
        icon: '<i class="fab fa-twitter text-lg opacity-8"></i>',
        link: "#"
      },
      {
        icon: '<i class="fab fa-dribbble text-lg opacity-8"></i>',
        link: "#"
      },
      {
        icon: '<i class="fab fa-github text-lg opacity-8"></i>',
        link: "#"
      },
      {
        icon: '<i class="fab fa-youtube text-lg opacity-8"></i>',
        link: "#"
      }
    ]
  },
  menus: {
    type: Array,
    name: String,
    items: {
      type: Array,
      name: String,
      href: String
    },
    default: () => [
            {
        name: "HouseParty",
        items: [
          {
            name: "(주)SSAFY",
            href: "#"
          },
          {
            name: "대표: 조웅희, 이지원 ",
            href: "#"
          },
          {
            name: "주소 : 서울 강남구 테헤란로 212",
            href: "#"
          },
          {
            name: "고객센터 : 02-1234-1234 | 평일 10:00 ~ 18:30, 점심시간 : 12:00 ~ 13:00 (토·일요일, 공휴일 휴무)",
            href: "#"
          },
          {
            name:"팩스 : 02-123-1234     프로모션/사업 제휴문의 : ssafy@ssafy.com",
            href: "#"

          }
        ]
      }

    ]
  }
});
</script>
<template>
  <footer class="footer pt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <div>
            <a :href="brand.route">
              <img :src="brand.logo" class="mb-3 footer-logo" alt="main_logo" />
            </a>
            <h6 class="font-weight-bolder mb-4">{{ brand.name }}</h6>
          </div>
          <div>
            <ul class="d-flex flex-row ms-n3 nav">
              <li
                class="nav-item"
                v-for="{ icon, link } of socials"
                :key="link"
              >
                <a
                  class="nav-link pe-1"
                  :href="link"
                  target="_blank"
                  v-html="icon"
                >
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div
          class="col-md-8 col-sm-8 col-6"
          v-for="{ name, items } of menus"
          :key="name"
        >
          <h6 class="text-sm">{{ name }}</h6>
          <ul class="flex-column ms-n3 nav">
            <li class="nav-item" v-for="item of items" :key="item.name">
              <a class="nav-link" :href="item.href" target="_blank">
                {{ item.name }}
              </a>
            </li>
          </ul>
        </div>

        <div class="col-12">
          <div class="text-center">
            <p class="text-dark my-4 text-sm font-weight-normal">
              All rights reserved. Copyright ©
              {{ new Date().getFullYear() }}
             HappyHouse by
              <a href="https://www.creative-tim.com" target="_blank"
                >JoJi</a
              >.
            </p>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>
