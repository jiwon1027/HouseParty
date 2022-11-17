import { createRouter, createWebHistory } from "vue-router";
import PresentationView from "../views/Presentation/PresentationView.vue";
import SignInBasicView from "../views/LandingPages/SignIn/LoginView.vue";
import FindPasswordView from "../views/LandingPages/SignIn/FindPasswordView.vue";
import SignUpView from "../views/LandingPages/SignIn/SignUpView.vue";
import MypageView from "../views/LandingPages/SignIn/MypageView.vue";

import MapView from "../views/LandingPages/Map/Map.vue";
import BoardView from "../views/LandingPages/Board/Board.vue";
import NoticeView from "../views/LandingPages/Notice/Notice.vue";
import NewsView from "../views/LandingPages/News/News.vue";

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
    }
    ,
    {
      path: "/map",
      name: "map",
      component: MapView,
    },
    {
      path: "/notice",
      name: "notice",
      component: NoticeView,
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
    }



  ],
});

export default router;
