<template>
  <div class="background">
    <h2>{{ `${cityName}旅游关键词云` }}</h2>
    <div class="chart" id="myEchartsFour">图表的容器</div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import "echarts-wordcloud";
import axios from "axios";

export default {
  props: ['cityName'],
  data() {
    return {
      chart: null,
      showValue: [],
    }
  },
  async mounted() {
    await this.initChart();
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  watch: {
    async cityName(newValue) {
      await this.initChart()
    },
  },
  methods: {
    async initChart() {
      var b = []
      var a = []
      const url = this.$BACK_URL + '/city/playsByName'
      await axios.get(url, {
        params: {
          name: this.cityName
        }
      }).then(response => {
        const temp = response.data.data
        console.log('词云：')
        console.log(temp)
        b = Object.keys(temp)
        a = Object.values(temp)
      })
      let myEcahrts = echarts.init(document.getElementById('myEchartsFour'));

      var keywords = [];
      for (let index = 0; index < b.length; index++) {
        keywords.push({
          name: b[index],
          value: a[index],
        });
      }
      //按照colorList指定颜色的数据进行随机
      const colorList = ['#e29426', '#c23531', '#396f5e', '#22a2c3']
      var option = {
        series: [
          {
            type: "wordCloud",
            sizeRange: [20, 50],
            rotationRange: [0, 0],
            rotationStep: 45,
            gridSize: 0,
            shape: "circle",
            width: "100%",
            height: "100%",
            drawOutOfBound: false,
            textStyle: {
              color: function () {
                let index = Math.floor(Math.random() * colorList.length)
                return colorList[index]
              }
            },
            emphasis: {
              textStyle: {
                shadowBlur: 10,
                shadowColor: "#333",
                color: "red",
              },
            },
            data: keywords,
          },
        ],
      };
      myEcahrts.setOption(option);
    },
  },
};
</script>

<style></style>