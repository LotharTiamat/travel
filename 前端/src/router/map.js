// recordRoutes.js

const express = require('express');
const router = express.Router();

// 处理跨域请求
router.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
  next();
});

// 处理前端请求的API端点
router.get('/getRecordAmount', (req, res) => {
  const provinceName = req.query.province; // 获取前端传递的省份名称参数

  // 在这里处理连接数据库查询游记数量的逻辑
  // 这里是一个伪代码示例
  // ...

  // 假设从数据库中获取游记数量为 recordAmount
  const recordAmount = 100; // 假设游记数量为 100，你需要从数据库中查询

  // 将数据作为 JSON 发送回前端
  res.json({ recordAmount });
});

module.exports = router;
