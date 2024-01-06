<!--用来传递点击事件信息的父组件-->
<template>
  <div>
    <map-page @province-clicked="handleProvinceClicked"></map-page>
    <item-one :province="clickedProvince"></item-one>
  </div>
</template>
  
  <script>
  import mapPage from './mapPage.vue';
  import itemOne from './itemOne.vue';
  
  export default {
    components: {
      mapPage,
      itemOne,
    },
    data() {
      return {
        selectedProvince: null,
      };
    },
    methods: {
      handleProvinceClicked(province) {
        this.selectedProvince = province;
        console.log("Parent received province: ", province);
      },
    },
  };
  </script>
  