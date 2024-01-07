<template>
  <div class="realspace">
    <header>
      <div class="title"></div>
      <div class="source">本网站所用旅游数据获取自<a href="https://www.ctrip.com/">携程旅行网</a></div>
      <div class="icon"></div>
    </header>
    <!-- 大容器 -->
    <section class="container">
      <!-- 左容器 -->
      <section class="itemLeft">
        <ItemPage>
          <ItemOne :province="provinceId" @cityChange="handleCityChange"></ItemOne>
        </ItemPage>
        <ItemPage>
          <ItemTwo :cityName="cityName"></ItemTwo>
        </ItemPage>
      </section>
      <!-- 中容器 -->
      <section class="itemCenter">
        <MapPage :province_id="provinceId" @provinceClicked="setProvinceId"></MapPage>
      </section>
      <!-- 右容器 -->
      <section class="itemRight">
        <ItemPage>
          <ItemThree :cityName="cityName"></ItemThree>
        </ItemPage>
        <ItemPage>
          <ItemFour :cityName="cityName"></ItemFour>
        </ItemPage>
      </section>
    </section>
  </div>
</template>

<script>
import ItemPage from "@/components/itemPage.vue";

import ItemOne from "@/components/itemOne.vue"
import ItemTwo from "@/components/itemTwo.vue"
import ItemThree from "@/components/itemThree.vue"
import ItemFour from "@/components/itemFour.vue"
import MapPage from "@/components/mapPage.vue"

import { inject } from "vue"

export default {
  data() {
    return {
      provinceId: 13,
      cityName: '成都',
    }
  },
  components: {
    ItemPage, ItemOne, ItemTwo, ItemThree, ItemFour, MapPage
  },
  setup() {
    let $echarts = inject("echarts")
    let $http = inject("axios")
    console.log($echarts)
    console.log($http)
  },
  methods: {
    cityNameDisplace(cityName) {
      if (cityName[cityName.length - 1] === '市') {
        return cityName.slice(0, cityName.length - 1)
      } else {
        return cityName
      }
    },
    idDisplace(provinceId) {
      switch (provinceId) {
        case 33:
          return 23
        case 13:
          return 25
        case 9:
          return 9
        case 7:
          return 22
        case 22:
          return 1
        case 20:
          return 33
        case 0:
          return 11
        case 23:
          return 6
        case 5:
          return 14
        case 17:
          return 15
        case 2:
          return 17
        case 18:
          return 20
        case 15:
          return 34
        case 16:
          return 26
        case 6:
          return 27
        case 4:
          return 12
        case 12:
          return 7
        case 19:
          return 10
        case 29:
          return 3
        case 27:
          return 30
        case 14:
          return 31
        case 28:
          return 28
        case 24:
          return 4
        case 3:
          return 2
        case 25:
          return 5
        case 32:
          return 24
        case 10:
          return 13
        case 31:
          return 29
        case 30:
          return 32
        case 8:
          return 21
        case 11:
          return 18
        case 1:
          return 19
        case 21:
          return 16
        case 26:
          return 8
      }

    },
    handleCityChange(newCityName) {
      this.cityName = this.cityNameDisplace(newCityName)
    },
    setProvinceId(newId) {
      this.provinceId = this.idDisplace(newId)
    }
  }
};
</script>

<style lang="less">
.realspace {
  margin: 5.5vh 7vw;
}

.title {
  background: url("@/assets/title.png") no-repeat;
  background-size: contain;
  height: 100%;
  width: 8rem;
}

.icon {
  background: url("@/assets/airplane.png") no-repeat;
  background-size: contain;
  height: 100%;
  width: 2rem;
}

.source {
  position: absolute;
  top: 1.3rem;
  left: 19rem;
  height: 0.6rem;
  color: white;
  line-height: 0.6rem;
  font-size: 0.25rem;
  text-align: bottom;
  font-family: 'Myfont', sans-serif;

  a {
    color: rgba(34, 162, 195, 1),
  }
}

header {
  height: 8vh;
  width: 100%;
  padding: 0.125rem;

  display: flex;
  justify-content: space-between;
  /* 将子元素推到容器的两边 */
}

// 大容器的样式
.container {
  // 容器样式
  // background: rgba(255, 255, 255, .5);
  // box-shadow: 0 0 20px rgba(0, 0, 0, .25);
  // border-radius: 10px;

  padding: 0.125rem;
  // background-color: gray;
  display: flex;

  // 设置左右在页面的份数
  .itemLeft,
  .itemRight {
    flex: 3;
  }

  .itemCenter {
    flex: 5;
    height: 71vh;
    margin: .5rem .25rem;

    //设置边框样式
    border: 0.375rem solid red;
    border-width: 1rem .2rem .2rem .2rem;
    border-image-source: url("@/assets/border2.png");
    border-image-slice: 140 60 85 85;
  }
}
</style>