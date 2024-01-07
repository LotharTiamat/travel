<template>
  <div class="background">
    <h2>{{ `${cityName}市旅游流量` }}</h2>
    <div class="chart" id="myEchartsTwo">图表的容器</div>
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
    }
  },
  watch: {
    async cityName(newValue) {
      const url = this.$BACK_URL + '/city/monthByName'
      await axios.get(url, {
        params: {
          name: newValue
        }
      }).then(response => {
        const temp = response.data.data
        this.showArray = Object.values(temp)
      }).catch(error => {
        console.error(error)
      })
      let myEcharts = echarts.init(document.getElementById('myEchartsTwo'))
      myEcharts.setOption({
        tooltip: {
          trigger: 'axis'
        },
        radar:
        {
          // shape: 'circle',
          indicator: [
            { name: '1月' },
            { name: '2月' },
            { name: '3月' },
            { name: '4月' },
            { name: '5月' },
            { name: '6月' },
            { name: '7月' },
            { name: '8月' },
            { name: '9月' },
            { name: '10月' },
            { name: '11月' },
            { name: '12月' },
          ],
          center: ['50%', '50%'],
          radius: 85,
          axisName: {
            color: 'rgba(0, 0, 0, 0.8)',
          },
          nameGap: 8 //指示器名称和指示器轴的距离。
        },
        series:
        {
          name: '流量',
          type: 'radar',
          areaStyle: {
            color: 'rgba(33, 129, 184, 0.8)'
          },
          tooltip: {
            trigger: 'item'
          },
          data: [
            {
              value: this.showArray,
              itemStyle: {//雷达图每一个焦点的样式
                normal: {
                  color: "rgba(34, 162, 195, 1)",
                  lineStyle: {
                    color: "rgba(34, 162, 195, 1)",
                  },
                },
              },
            },

          ]
        },

      })
    }
  },
  methods: {},
  async mounted() {
    const url = this.$BACK_URL + '/city/monthByName'
    await axios.get(url, {
      params: {
        name: this.cityName
      }
    }).then(response => {
      const temp = response.data.data
      this.showArray = Object.values(temp)
    }).catch(error => {
      console.error(error)
    })
    let myEcharts = echarts.init(document.getElementById('myEchartsTwo'))
    myEcharts.setOption({
      tooltip: {
        trigger: 'axis'
      },
      radar:
      {
        // shape: 'circle',
        indicator: [
          { name: '1月' },
          { name: '2月' },
          { name: '3月' },
          { name: '4月' },
          { name: '5月' },
          { name: '6月' },
          { name: '7月' },
          { name: '8月' },
          { name: '9月' },
          { name: '10月' },
          { name: '11月' },
          { name: '12月' },
        ],
        center: ['50%', '50%'],
        radius: 85,
        axisName: {
          color: 'rgba(0, 0, 0, 0.8)',
        },
        nameGap: 8 //指示器名称和指示器轴的距离。
      },
      series:
      {
        name: '流量',
        type: 'radar',
        areaStyle: {
          color: 'rgba(33, 129, 184, 0.8)',
        },
        tooltip: {
          trigger: 'item'
        },
        data: [
          {
            value: this.showArray,
            itemStyle: {//雷达图每一个焦点的样式
              normal: {
                color: "rgba(34, 162, 195, 1)",
                lineStyle: {
                  color: "rgba(34, 162, 195, 1)",
                },
              },
            },
          },

        ]
      },
    })
  },
}
</script>

<style></style>