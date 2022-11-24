<script setup>
import { ref, watch } from "vue";
import { useWindowsWidth } from "../../assets/js/useWindowsWidth";

//login 확인
import checkToken from "@/api/checkToken";

// images
import ArrDark from "@/assets/img/down-arrow-dark.svg";
import DownArrWhite from "@/assets/img/down-arrow-white.svg";
const props = defineProps({
  action: {
    type: Object,
    route: String,
    color: String,
    label: String,
  },
  transparent: {
    type: Boolean,
    default: false,
  },
  light: {
    type: Boolean,
    default: false,
  },
  dark: {
    type: Boolean,
    default: false,
  },
  sticky: {
    type: Boolean,
    default: false,
  },
  darkText: {
    type: Boolean,
    default: false,
  },
});

// set arrow  color
function getArrowColor() {
  if (props.transparent && textDark.value) {
    return ArrDark;
  } else if (props.transparent) {
    return DownArrWhite;
  } else {
    return ArrDark;
  }
}

// set text color
const getTextColor = () => {
  let color;
  if (props.transparent && textDark.value) {
    color = "text-dark";
  } else if (props.transparent) {
    color = "text-white";
  } else {
    color = "text-dark";
  }

  return color;
};

// set nav color on mobile && desktop
let textDark = ref(props.darkText);
const { type } = useWindowsWidth();

if (type.value === "mobile") {
  textDark.value = true;
} else if (type.value === "desktop" && textDark.value == false) {
  textDark.value = false;
}

watch(
  () => type.value,
  (newValue) => {
    if (newValue === "mobile") {
      textDark.value = true;
    } else {
      textDark.value = false;
    }
  }
);
</script>
<template>
  <nav
    class="navbar navbar-expand-lg top-0"
    :class="{
      'z-index-3 w-100 shadow-none navbar-transparent position-absolute my-3': props.transparent,
      'my-3 blur border-radius-lg z-index-3 py-2 shadow py-2 start-0 end-0 mx-4 position-absolute mt-4':
        props.sticky,
      'navbar-dark bg-black py-3': props.light,
      ' navbar-dark bg-gradient-dark z-index-3 py-3': props.dark,
    }"
  >
    <div :class="'container'">
      <RouterLink
        class="navbar-brand d-none d-md-block"
        :to="{ name: 'presentation' }"
        rel="tooltip"
        title="Home으로 이동"
        data-placement="bottom"
      >
        <div>
          <div>
            <img src="@/assets/img/logo.png" width="180" height="60" style="float: left" />
          </div>

          <h3 style="padding-top: 15px"></h3>
        </div>
      </RouterLink>

      <button
        class="navbar-toggler shadow-none ms-2"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navigation"
        aria-controls="navigation"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon mt-2">
          <span class="navbar-toggler-bar bar1"></span>
          <span class="navbar-toggler-bar bar2"></span>
          <span class="navbar-toggler-bar bar3"></span>
        </span>
      </button>
      <div class="collapse navbar-collapse w-100 pt-3 py-lg-0" id="navigation">
        <ul class="navbar-nav navbar-nav-hover ms-auto" style="ve">
          <li class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'notice' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">NOTICE</h4>
              </RouterLink>
            </a>
          </li>

          <li class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'board' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">BOARD</h4>
              </RouterLink>
            </a>
          </li>

          <li class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'map' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">MAP</h4>
              </RouterLink>
            </a>
          </li>

          <li v-if="!this.isLogin" class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'login' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">LOGIN</h4>
              </RouterLink>
            </a>
          </li>

          <li v-if="this.isLogin" class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'logout' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">LOGOUT</h4>
              </RouterLink>
            </a>
          </li>

          <li v-if="this.isLogin" class="nav-item dropdown dropdown-hover mx-4">
            <a
              role="button"
              class="nav-link ps-2 d-flex cursor-pointer align-items-center"
              :class="getTextColor()"
            >
              <RouterLink :to="{ name: 'mypage' }">
                <h4 style="margin-block-end: 0px; color: #d9d9d9">MYPAGE</h4>
              </RouterLink>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->
</template>

<script>
export default {
  data() {
    return {
      isLogin: null,
    };
  },
  methods: {
    async onlyAuthUser() {
      let token = sessionStorage.getItem("access-token");

      if (token === "null" || token === null) {
        return;
      }

      this.isLogin = await checkToken(token);
    },
  },
  mounted() {
    this.onlyAuthUser();
  },
};
</script>
