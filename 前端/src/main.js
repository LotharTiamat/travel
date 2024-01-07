import {createApp} from 'vue'
import App from './App.vue'
import router from './router'

// 引用插件
import "lib-flexible/flexible.js"

const app = createApp(App)
const BACK_URL = 'http://47.120.3.86:9393'
app.config.globalProperties.$BACK_URL = BACK_URL
app.use(router)
app.mount('#app')
