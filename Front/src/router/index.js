import { createRouter, createWebHistory } from "vue-router";
import PresentationView from "../views/Presentation/PresentationView.vue";
import SignInBasicView from "../views/LandingPages/SignIn/LoginView.vue";
import FindPasswordView from "../views/LandingPages/SignIn/FindPasswordView.vue";
import SignUpView from "../views/LandingPages/SignIn/SignUpView.vue";
import MypageView from "../views/LandingPages/SignIn/MypageView.vue";
import LogoutView from "../views/LandingPages/SignIn/LogoutView.vue";

import MapView from "../views/LandingPages/Map/Map.vue";
import BoardView from "../views/LandingPages/Board/Board.vue";
import NoticeView from "../views/LandingPages/Notice/Notice.vue";
import NewsView from "../views/LandingPages/News/News.vue";

import BoardDetailView from "../views/LandingPages/Board/BoardDetailView.vue";
import NoticeDetailView from "../views/LandingPages/Notice/NoticeDetailView.vue";
import Boardwrite from "../views/LandingPages/Board/BoardWrite.vue";
import NoticeWrite from "../views/LandingPages/Notice/NoticeWrite.vue";

//토큰 디코딩
import jwtDecode from "jwt-decode";

//드롭다운 하는데 이게 대체 왜 필요하냐
import AuthorView from "../views/LandingPages/Author/AuthorView.vue";






const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "presentation",
      component: PresentationView,
    },

    {
      path: "/login",
      name: "login",
      component: SignInBasicView,
    },
    {
      path: "/logout",
      name: "logout",
      component: LogoutView,
    },
    {
      path: "/findpw",
      name: "findpw",
      component: FindPasswordView,
    },
    {
      path: "/signup",
      name: "signup",
      component: SignUpView,
    },
    {
      path: "/mypage",
      name: "mypage",
      component: MypageView,
    },
    {
      path: "/map",
      name: "map",
      component: MapView,
    },
    {
      path: "/map/:aptCode",
      name: "mapAptCode",
      component: MapView,
    },


    {
      path: "/notice",
      name: "notice",
      component: NoticeView,
    },
    {
      path: "/notice/:articleNo",
      name: "noticeDetail",
      component: NoticeDetailView,
    },
    {
      path: "/news",
      name: "news",
      component: NewsView,
    },
    {
      path: "/board",
      name: "board",
      component: BoardView,
    },
    {
      path: "/board/:articleNo",
      name: "boardDetail",
      component: BoardDetailView,
    },
    {
      path: "/boardwrite",
      name: "boardwrite",
      component: Boardwrite,
      beforeEnter: (to, from, next) => {
        let token = sessionStorage.getItem("access-token");

        if (token === undefined || token === "null" || token === null) {
          alert("로그인 해주세요.")
          next('login');
        }
        else next()
      }
    },
    {
      path: "/noticewrite",
      name: "noticewrite",
      component: NoticeWrite,
      beforeEnter: (to, from, next) => {
        let token = sessionStorage.getItem("access-token");

        if (token === undefined || token === "null" || token === null) {
          alert("로그인 해주세요.")
          next('login');
        }

        let userIsAdmin = jwtDecode(token).isAdmin;

        if (!userIsAdmin) {
          alert("관리자만 공지사항에 글을 쓸 수 있습니다.")
          next(false);
        }
        else next();
      }
    },
  ],
});

export default router;
