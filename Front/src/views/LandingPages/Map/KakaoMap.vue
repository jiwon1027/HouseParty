<template>
  <div>
    <div id="map"></div>
  </div>
</template>


<script setup> 
  defineProps({
    markerPositions1 : {
        type: Object,
        default: [[String,String]]
      }
  })
</script>


<script>
export default {
  name: "KakaoMap",
  data() {
    return {
      latlngArray : [],
      markers: [],
      infowindow: null,
    };
  },

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=0c1bba1ceae5f7ce069ec872fe1f3ba7";
      document.head.appendChild(script);
    }

  },

    beforeUpdate() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    }
  },


  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 4,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);

      this.latlngArray = [];

      const arr = this.markerPositions1.split(',');

      for (let i = 0; i < arr.length/2; i+=2) {
        this.latlngArray.push([arr[i],arr[i+1]])
      }


      if (this.latlngArray[0][0] == ''){
          this.latlngArray.pop()
          this.latlngArray.push([37.499590490909185,127.0263723554437]) 
      }
      console.log("카카오맵@@@@@@@@")
      console.log(this.latlngArray)
      this.displayMarker(this.latlngArray)

    },

    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }



    },



  }
};
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>
#map {
  width: 800px;
  height: 650px;
}
</style>
