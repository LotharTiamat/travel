<template>
  <div class="background">
    <h2>{{ `${cityName}市旅游消费额` }}</h2>
    <div class="chart" id="myEcharts">
      图表的容器
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts"
import axios from "axios";


export default {
  props: ['cityName'],
  data() {
    return {
      showArray: [],
      keyWords: [],
    }
  },
  methods: {
    async initEcharts() {
      this.showArray = []
      this.keyWords = []
      const url = this.$BACK_URL + '/city/monthCostTimesAndTotalCostByName'
      await axios.get(url, {
        params: {
          name: this.cityName
        }
      }).then(response => {
        const temp = response.data.data
        Object.values(temp).forEach(item => {
          this.showArray.push(item.perCost)
        })
      }).catch(error => {
        console.error(error)
      })
      var b = ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
      let myEcharts = echarts.init(document.getElementById('myEcharts'))
      for (let index = 0; index < 12; index++) {
        this.keyWords.push({
          name: b[index],
          value: this.showArray[index],
        });
      }
      console.log(this.keyWords)
      myEcharts.setOption({
        tooltip: {
          trigger: 'item'
        },
        visualMap: {
          show: false,
          min: 0,
          max: Math.max(...this.keyWords.map(item => item.value)) * 1.2,
          inRange: {
            colorLightness: [0, 1]
          }
        },
        series: [
          {
            name: '消费额',
            type: 'pie',
            radius: '90%',
            center: ['50%', '50%'],
            data: this.keyWords,
            roseType: 'radius',
            label: {
              color: 'rgba(0, 0, 0, 0.8)'
            },
            labelLine: {
              lineStyle: {
                color: 'rgba(0, 0, 0, 0.8)'
              },
              smooth: 0.2,
              length: 5,
              length2: 5
            },
            itemStyle: {
              color: '#c23531',
            },
            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
              return Math.random() * 200;
            }
          }
        ]
      })
    }
  },
  watch: {
    async cityName(newValue) {
      await this.initEcharts()
    },
  },
  async mounted() {
    await this.initEcharts()
  }
}
</script>

<style></style>