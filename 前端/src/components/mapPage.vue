<template>
  <h3>全国旅游热度</h3>
  <div class="map" ref="demoh" id="map"></div>

  <!-- <div v-if="tooltipVisible" class="tooltip" :style="{ top: tooltipTop + 'px', left: tooltipLeft + 'px' }">
    游记数量: {{ currentProvinceNoteNum }}
  </div> -->
</template>

<script>
import * as echarts from "echarts";
import itemOne from '../components/itemOne.vue'
import { Chinamap } from "../assets/Chinamap.js";
import axios from "axios";

export default {
  data() {
    return {
      selectedProvince: '',
      noteNumbers: {}, // 初始化为空对象
      currentProvinceNoteNum: 0,
      tooltipVisible: false,
      tooltipLeft: 0,
      tooltipTop: 0,
    };
  },
  props: ['province_id'],
  methods: {
    handleProvinceClicked(provinceIndex) {
      this.$emit('provinceClicked', provinceIndex); // 更新选定的省份
    },
  },

  components: {
    itemOne,
  },


  async mounted() {
    const url = this.$BACK_URL + '/province/noteNum'
    await axios.get(url).then(response => {
      this.noteNumbers = response.data.data
    }).catch(error => {
      console.error(error)
    })

    let myChart = echarts.init(this.$refs.demoh);
    echarts.registerMap("ChinaMap", Chinamap);

    let option = {
      tooltip: {
        trigger: 'item',
        showDelay: 0,
        transitionDuration: 0.2,
        // formatter: function (params) {
        //   var name = params[0].name;
        //   var value = params[0].value;
        //   return name + '<br />' + "游记数量：" + value;
        // }
      },
      series: [
        {
          name: '游记数量',
          type: "map",
          map: "ChinaMap",
          roam: true,
          layoutCenter: ["50%", "63%"],
          layoutSize: "120%",
          itemStyle: {
            normal: {
              borderColor: "#fff",
              areaColor: "#bdbdbd",
            },
            emphasis: {
              areaColor: "#f0f0f0",
            },
          },
          selectedMode: "single", //选择模式，单选，只能选中一个地市
          select: {//这个就是鼠标点击后，地图想要展示的配置
            disabled: false,//可以被选中
            itemStyle: {//相关配置项很多，可以参考echarts官网
              areaColor: "#d04a46"//选中
            }
          },
          data: Object.keys(this.noteNumbers).map((province) => ({
            name: province,
            value: this.noteNumbers[province],
            selected: province === '四川省', // 将四川省设为默认选中
          })),
        },
      ],
      visualMap: {
        min: 0,
        max: 2000,
        text: ["高", "低"],
        realtime: false,
        calculable: true,
        inRange: {
          color: ["#bdf0e2", "#62bf95", "#396f5e", "#254838"], // 调整这些颜色
        },
        seriesIndex: [0], // 确保映射到正确的 series 索引
      },
    };
    myChart.setOption(option);

    // 监听鼠标移动事件
    myChart.on("mousemove", (params) => {

      const provinceName = params.name;
      // 添加额外的检查以确保显示为 0
      this.currentProvinceNoteNum = this.noteNumbers[provinceName] !== undefined ? this.noteNumbers[provinceName] : 0;
      const chartDom = this.$refs.demoh;
      const rect = chartDom.getBoundingClientRect();
      this.tooltipVisible = true;
      this.tooltipLeft = params.event.clientX - rect.left + window.scrollX;
      this.tooltipTop = params.event.clientY - rect.top + window.scrollY;
    }
    );


    //监听鼠标点击事件
    myChart.on("click", (params) => {
      console.log(params)
      if (params.componentType === "series" && params.seriesType === "map") {
        const provinceIndex = params.dataIndex;
        this.handleProvinceClicked(provinceIndex); // 调用处理点击省份的方法
      }
    });

    myChart.on("mouseout", () => {
      this.tooltipVisible = false;
    });

  },

};
</script>

<style scoped>
.map {
  width: 100%;
  height: 94%;
  background-color: rgb(255, 255, 255);
}

h3 {
  background-color: rgb(255, 255, 255);

  height: 0.6rem;
  color: black;
  line-height: 0.6rem;
  font-size: 0.35rem;
  text-align: center;
  font-family: 'Myfont', sans-serif;
}

/* .tooltip {
  position: absolute;
  background-color: white;
  padding: 5px;
  border: 1px solid #ccc;
} */
</style>
