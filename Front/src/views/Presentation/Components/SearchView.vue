<script>
import axios from 'axios';


export default {
    data(){
        return{
          sidoLabel: '도시 선택',
          gugunLabel: '구 선택',
          dongLabel: '동 선택',

          aptCode:"",

          sidoList:[],
          gugunList:[],
          dongList:[],
        }
    },
    methods: {
      changeSido(inputSido) {
        return this.sidoLabel = inputSido;
      },
      changeGugun(inputGugun) {
        return this.gugunLabel = inputGugun;
      },
      changeDong(inputDong) {
        return this.dongLabel = inputDong;
      },

      selectGugun(regCode){
        axios
          .get(`http://localhost/happyhouse/region/gugun/${regCode}`,{
        withCredentials: false,
      })
          .then((response)=>{
            this.gugunList = response.data
          })
      },

      selectDong(regCode){
        axios
          .get(`http://localhost/happyhouse/region/dong/${regCode}`,{
        withCredentials: false,
      })
          .then((response)=>{
            this.dongList = response.data
          })
      },
      selectApt(regCode){
        this.aptCode = regCode;
      },
      searchAptList(){
        console.log("아파트 리스트 불러올꺼임")
        if (this.$route.name === "presentation") {
            this.$router.push({ name: 'map', query: {aptCode: this.aptCode} });
        }
        else{
          this.$emit('selectByAptCode', this.aptCode)
          this.$router.push({ name: 'map', query: {aptCode: this.aptCode} });
        }

    },

    },

    created() {
        axios
          .get("http://localhost/happyhouse/region/sido",{
        withCredentials: false,
      })
          .then((response)=>{
            this.sidoList = response.data
          })
    },
    
}
</script>


<script setup>
import MaterialButton from "@/components/MaterialButton.vue";
</script>

<template>
          <div id = "selectSido" class="d-inline p-4">
          <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdown }"
              @focusout="showDropdown = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdown"
              @click="showDropdown = !showDropdown"
            >
              {{sidoLabel}}
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdown }"
              aria-labelledby="dropdownMenuButton"
            >
              <li v-for="sido in sidoList" v-bind:key="sido">
                <a class="dropdown-item border-radius-md" href="javascript:;" @click="selectGugun(`${sido.dongCode}`),changeSido(`${sido.name}`)">
                  {{sido.name}}
                  </a>
              </li>
            </ul>
        </div>

        <div id = "selectGugun" class="d-inline p-4">
          <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdown }"
              @focusout="showDropdown = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdown"
              @click="showDropdown = !showDropdown"
            >
              {{gugunLabel}}
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdown }"
              aria-labelledby="dropdownMenuButton"
            >
              <li v-for="gugun in gugunList" v-bind:key="gugun">
                <a class="dropdown-item border-radius-md" href="javascript:;" @click="selectDong(`${gugun.dongCode}`), changeGugun(`${gugun.name}`)">
                  {{gugun.name}}
                  </a>
              </li>
            </ul>
        </div>

        <div id = "selectDong" class="d-inline p-4">
          <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdown }"
              @focusout="showDropdown = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdown"
              @click="showDropdown = !showDropdown"
            >
              {{dongLabel}}
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdown }"
              aria-labelledby="dropdownMenuButton"
            >

          <li v-for="dong in dongList" v-bind:key="dong">
                <a class="dropdown-item border-radius-md" href="javascript:;"  @click="changeDong(`${dong.name}`), selectApt(`${dong.dongCode}`)">
                  {{dong.name}}
                  </a>
          </li>



            </ul>
        </div>

        <div id = "searchButton" class="d-inline p-4">
          <MaterialButton
            variant="gradient"
            color="secondary"
            @click="searchAptList()">
            검색
            </MaterialButton>
            <router-view :key="$route.fullPath"></router-view>

        </div>
</template>