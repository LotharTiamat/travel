<template>
  <div class="item">
    <!-- 设置插槽 -->
    <slot>133</slot>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="less">
.item {
  height: 38vh;
  margin-bottom: .25rem;

  //设置边框样式
  border: 0.375rem solid red;
  border-width: 0.5rem 0.2rem 0.2rem 0.2rem;
  border-image-source: url("@/assets/border1.png");
  border-image-slice: 150 50 50 50;
}

h2 {
  height: 0.6rem;
  color: black;
  line-height: 0.6rem;
  font-size: 0.25rem;
  text-align: center;
  font-family: 'Myfont', sans-serif;
}

.chart {
  height: 30vh;
}

.background {
  background-color: #fff4df;
}
</style>