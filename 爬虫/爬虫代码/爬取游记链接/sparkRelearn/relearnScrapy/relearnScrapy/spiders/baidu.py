import threading

import scrapy
from ..items import Record_Num
import pymysql
import json


# 按照顺序获取城市id
def getDistrictId(id):
    conn1 = pymysql.connect(host='localhost'  # 连接名称，默认127.0.0.1
                            , user='root'  # 用户名
                            , passwd='111111'  # 密码
                            , port=3306  # 端口，默认为3306
                            , db='visual'  # 数据库名称
                            , charset='utf8'  # 字符编码
                            )
    cur1 = conn1.cursor()  # 生成游标对象
    sql = "select cid from city where id=" + str(id)
    cur1.execute(sql)
    results = cur1.fetchall()
    return results[0][0]


'''
    # 获取每个城市的游记页数
'''


class BaiduSpider(scrapy.Spider):
    Lock = threading.Lock()
    name = "baidu"
    allowed_domains = ["m.ctrip.com"]
    start_urls = ["https://m.ctrip.com/restapi/soa2/22670/getRecommendTravel"]

    def start_requests(self):
        for district in range(39, 113):  # 修改这里
            nowDis = getDistrictId(district)
            url = self.start_urls[0]
            data = {
                "_fxpcqlniredt": "09031020415125375299",
                "x-traceID": "09031020415125375299-1699173447244-5050444",
                "head": {
                    "cid": "09031020415125375299",
                    "ctok": "",
                    "cver": "1.0",
                    "lang": "01",
                    "sid": "8888",
                    "syscode": "999",
                    "auth": "",
                    "xsid": "",
                    "extension": []
                },
                "districtId": nowDis,
                "sourceFrom": 0,
                "type": 2,
                "pageIndex": 2
            }
            add_params = {}
            add_params['cid'] = nowDis
            yield scrapy.FormRequest(method='POST', url=url, body=json.dumps(data),
                                     headers={'Content-Type': 'application/json'}, callback=self.parse,
                                     cb_kwargs=add_params)

    def parse(self, response, cid):
        records = response.body
        # print(records["pageCount"])
        # print(records)
        body = json.loads(records)
        reNum = Record_Num()
        reNum["cid"] = cid
        reNum["num"] = body["pageCount"]
        yield reNum
