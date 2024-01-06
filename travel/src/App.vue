<template>
  <RouterView />
</template>

<script>
import { RouterLink, RouterView } from 'vue-router'
import { provide } from "vue"
import * as echarts from "echarts"
import axios from "axios"

export default {
  setup() {
    // provider("名字随便起","传递的内容")
    provide("echarts", echarts)
    provide("axios", axios)
  }
}
</script>

<style lang="less">
body {
  background: url("./assets/bg.jpg") no-repeat;
  background-size: 100vw 100vh;
}

* {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
}

@font-face {
  font-family: 'Myfont';
  /* 字体名称，自定义 */
  src: url('./assets/font/font1.ttf') format('ttf');
  /* 字体文件的路径和格式 */
  /* 你还可以添加其他属性，如 font-weight 和 font-style，以使字体更灵活 */
}
</style>
