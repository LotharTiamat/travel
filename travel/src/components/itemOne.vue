<template>
  <div class="background">
    <h2>{{ `${localProvince}旅游热度` }}</h2>

    <div class="chart" ref="oneChart" @click="handleChartClick"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import { AnhuiMap } from "../assets/ProvinceMap/Anhui";
import { AomenMap } from "../assets/ProvinceMap/Aomen";
import { BeijingMap } from "../assets/ProvinceMap/Beijing";
import { ChongqingMap } from "../assets/ProvinceMap/Chongqing";
import { FujianMap } from "../assets/ProvinceMap/Fujian";
import { GansuMap } from "../assets/ProvinceMap/Gansu";
import { GuangdongMap } from "../assets/ProvinceMap/Guangdong";
import { GuangxiMap } from "../assets/ProvinceMap/Guangxi";
import { GuizhouMap } from "../assets/ProvinceMap/Guizhou";
import { HainanMap } from "../assets/ProvinceMap/Hainan";
import { HebeiMap } from "../assets/ProvinceMap/Hebei";
import { HeilongjiangMap } from "../assets/ProvinceMap/Heilongjiang";
import { HenanMap } from "../assets/ProvinceMap/Henan";
import { HubeiMap } from "../assets/ProvinceMap/Hubei";
import { HunanMap } from "../assets/ProvinceMap/Hunan";
import { JiangsuMap } from "../assets/ProvinceMap/Jiangsu";
import { JiangxiMap } from "../assets/ProvinceMap/Jiangxi";
import { JilinMap } from "../assets/ProvinceMap/Jilin";
import { LiaoningMap } from "../assets/ProvinceMap/Liaoning";
import { NeimengguMap } from "../assets/ProvinceMap/Neimenggu";
import { NingxiaMap } from "../assets/ProvinceMap/Ningxia";
import { QinghaiMap } from "../assets/ProvinceMap/Qinghai";
import { ShandongMap } from "../assets/ProvinceMap/Shandong";
import { ShanghaiMap } from "../assets/ProvinceMap/Shanghai";
import { ShannxiMap } from "../assets/ProvinceMap/Shannxi";
import { ShanxiMap } from "../assets/ProvinceMap/Shanxi";
import { SichuanMap } from "../assets/ProvinceMap/Sichuan";
import { TaiwanMap } from "../assets/ProvinceMap/Taiwan";
import { TianjinMap } from "../assets/ProvinceMap/Tianjin";
import { XianggangMap } from "../assets/ProvinceMap/Xianggang";
import { XinjiangMap } from "../assets/ProvinceMap/Xinjiang";
import { XizangMap } from "../assets/ProvinceMap/Xizang";
import { YunnanMap } from "../assets/ProvinceMap/Yunnan";
import { ZhejiangMap } from "../assets/ProvinceMap/Zhejiang";
import axios from "axios";


export default {
  props: ['province'],

  data() {
    return {
      localProvince: '四川省', // 默认值
      cityNoteArray: [],
    };
  },
  async mounted() {
    this.localProvince = this.getProvinceNameById(this.province);
    await this.renderProvinceMap();
  },

  watch: {
    province(newProvince) {
      this.localProvince = this.getProvinceNameById(newProvince); // 更新localProvince数据
      console.log("newProvince: ", this.localProvince);
      this.renderProvinceMap();
    },
  },

  methods: {
    showMessage(message, type) {
      const div = document.createElement('div');
      div.innerText = message;
      div.style.position = 'fixed';
      div.style.top = '10%';
      div.style.left = '50%';
      div.style.transform = 'translate(-50%, -50%)';
      div.style.padding = '10px 20px';
      div.style.backgroundColor = type === 'success' ? '#52c41a' : type === 'error' ? '#f5222d' : '#faad14';
      div.style.color = '#fff';
      div.style.fontSize = '16px';
      div.style.borderRadius = '5px';
      document.body.appendChild(div);
      setTimeout(() => {
        document.body.removeChild(div);
      }, 3000);
    },
    getProvinceNameById(provinceId) {
      switch (provinceId) {
        case 1:
          return '北京市'
        case 2:
          return '上海市'
        case 3:
          return '辽宁省'
        case 4:
          return '山东省'
        case 5:
          return '陕西省'
        case 6:
          return '甘肃省'
        case 7:
          return '江苏省'
        case 8:
          return '浙江省'
        case 9:
          return '安徽省'
        case 10:
          return '江西省'
        case 11:
          return '福建省'
        case 12:
          return '湖南省'
        case 13:
          return '四川省'
        case 14:
          return '广东省'
        case 15:
          return '广西壮族自治区'
        case 16:
          return '云南省'
        case 17:
          return '贵州省'
        case 18:
          return '新疆维吾尔自治区'
        case 19:
          return '西藏自治区'
        case 20:
          return '海南省'
        case 21:
          return '香港特别行政区'
        case 22:
          return '澳门特别行政区'
        case 23:
          return '山西省'
        case 24:
          return '黑龙江省'
        case 25:
          return '吉林省'
        case 26:
          return '河南省'
        case 27:
          return '湖北省'
        case 28:
          return '青海省'
        case 29:
          return '台湾省'
        case 30:
          return '内蒙古自治区'
        case 31:
          return '宁夏回族自治区'
        case 32:
          return '天津市'
        case 33:
          return '重庆市'
        case 34:
          return '河北省'
        default:
          return null
      }
    },
    async renderProvinceMap() {
      const provinceMapData = this.getProvinceMapData(this.localProvince);
      const url = this.$BACK_URL + '/province/citynote'
      await axios.get(url, {
        params: {
          id: this.province,
        },
      }).then(response => {
        this.cityNoteArray = response.data.data
        this.cityNoteArray.forEach(item => {
          if (item.data) {
            item.selected = true;
          } else {
            // 如果该地区没有数据，设置 selected 为 false，表示不可点击
            item.selected = false;
          }
          if (item.name === '成都') {
            item.selected = true;
          }
          if (item.name[item.name.length - 1] !== '州' || item.name.length <= 2) {
            item.name = item.name + '市'
          }
        })
      }).catch(error => {
        console.error('获取各city游记数量失败')
        console.log(error)
      })
      if (provinceMapData) {
        let myChart = echarts.init(this.$refs.oneChart);
        echarts.registerMap(this.localProvince, provinceMapData);
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
              map: this.localProvince,
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
              layoutCenter: ["50%", "50%"],
              layoutSize: "100%",
              data: this.cityNoteArray,
            },
          ],
          visualMap: {
            min: 0,
            max: 2000,
            text: ["高", "低"],
            realtime: false,
            calculable: true,
            inRange: {
              color: ["#eeeeab", "#e9c54e", "#e29426", "#e56c02"], // 调整这些颜色
            },
            seriesIndex: [0], // 确保映射到正确的 series 索引
          },
        };
        myChart.setOption(option);
        myChart.on("click", (params) => {
          if (this.cityNoteArray.find(item => item.name === params.name)) {
            const cityName = params.name
            this.$emit('cityChange', cityName)
          } else {
            this.showMessage('抱歉，该城市没有数据', 'error')
          }
        }
        );
      } else {
        console.error('Province map data not found!');
      }
    },
    getProvinceMapData(province) {
      switch (province) {
        case '安徽省':
          return AnhuiMap;
        case '澳门特别行政区':
          return AomenMap;
        case '北京市':
          return BeijingMap;
        case '重庆市':
          return ChongqingMap;
        case '福建省':
          return FujianMap;
        case '甘肃省':
          return GansuMap;
        case '广东省':
          return GuangdongMap;
        case '广西壮族自治区':
          return GuangxiMap;
        case '贵州省':
          return GuizhouMap;
        case '海南省':
          return HainanMap;
        case '河北省':
          return HebeiMap;
        case '黑龙江省':
          return HeilongjiangMap;
        case '河南省':
          return HenanMap;
        case '湖北省':
          return HubeiMap;
        case '湖南省':
          return HunanMap;
        case '江苏省':
          return JiangsuMap;
        case '江西省':
          return JiangxiMap;
        case '吉林省':
          return JilinMap;
        case '辽宁省':
          return LiaoningMap;
        case '内蒙古自治区':
          return NeimengguMap;
        case '宁夏回族自治区':
          return NingxiaMap;
        case '青海省':
          return QinghaiMap;
        case '山东省':
          return ShandongMap;
        case '上海市':
          return ShanghaiMap;
        case '陕西省':
          return ShannxiMap;
        case '山西省':
          return ShanxiMap;
        case '四川省':
          return SichuanMap;
        case '台湾省':
          return TaiwanMap;
        case '天津省':
          return TianjinMap;
        case '香港特别行政区':
          return XianggangMap;
        case '新疆维吾尔自治区':
          return XinjiangMap;
        case '西藏自治区':
          return XizangMap;
        case '云南省':
          return YunnanMap;
        case '浙江省':
          return ZhejiangMap;
      }
    },
  },
};
</script>

<style scoped>
.background {
  background-color: rgb(255, 244, 223);
  position: relative;
}
</style>
