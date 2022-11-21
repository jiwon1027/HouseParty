<script setup>
import RotatingCard from "../../../examples/cards/rotatingCards/RotatingCard.vue";
import RotatingCardFront from "../../../examples/cards/rotatingCards/RotatingCardFront.vue";
import RotatingCardBack from "../../../examples/cards/rotatingCards/RotatingCardBack.vue";
import BannerImg from "@/assets/img/banner_img.jpg"

//smallBoard
import SmallBoardComponent from "@/views/LandingPages/Board/SmallBoardComponent.vue";
import SmallNoticeComponent from "@/views/LandingPages/Notice/SmallNoticeComponent.vue";

</script>

<template>
  <section class="py-5">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-4 ms-auto me-auto p-lg-4 mt-lg-0 mt-4 ">
          <!-- <RotatingCard>
            <RotatingCardFront
              :image="`${BannerImg}`"
              title="추천 프로그램<br><br>"
              description="description description description description

              description description description description"
            /> -->

            <!-- <RotatingCardBack
              image="https://images.unsplash.com/photo-1498889444388-e67ea62c464b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1365&q=80"
              title="TV 프로그램<br><br>"
              description="
              '뭘 좋아할지 몰라 이집저집 준비 해봤어'
              바쁜 현대인들의 집찾기를 위해 직접 나선 스타들!
              그들의 리얼한 발품중개배틀 〈구해줘! 홈즈〉"
              :action="[
                {
                  route: 'https://program.imbc.com/WhrereisMyHome',
                  label: 'MOVE',
                },
              ]"
            />
          </RotatingCard> -->
        </div>
            <!-- 여기 공지사항, 게시판 작게 들어갈꺼임-->

            <div class="d-flex justify-content-center">
                  <SmallNoticeComponent title="공지사항"></SmallNoticeComponent>
                  <SmallBoardComponent title="게시판"></SmallBoardComponent>
            </div>

      </div>
    </div>
  </section>
</template>
