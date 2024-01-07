# myvue

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).


## 运行项目
首先你电脑上装了node.js

在终端中
1.cd myvue
2. npm install 安装依赖包
3.npm run dev 此时可以查看网页

更改响应式设置
  需在下载的默认包中修改：在node_modules->lib-flexible->flexible.js的69行开始改为
      function refreshRem() {
        var width = docEl.getBoundingClientRect().width;
        if (width / dpr < 400) {
            width = 400 * dpr;
        } else if (width / dpr > 2560) {
            width = 2560 * dpr;
        }
        var rem = width / 24;
        docEl.style.fontSize = rem + 'px';
        flexible.rem = win.rem = rem;
    }


