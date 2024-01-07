import scrapy
from ..items import RecordItem
import pymysql
import json


# 通过id获取cid
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


# 通过city_id获取title和URL
def getTitleAndUrlByCid(id):
    conn1 = pymysql.connect(host='localhost'  # 连接名称，默认127.0.0.1
                            , user='root'  # 用户名
                            , passwd='111111'  # 密码
                            , port=3306  # 端口，默认为3306
                            , db='visual'  # 数据库名称
                            , charset='utf8'  # 字符编码
                            )
    cur1 = conn1.cursor()  # 生成游标对象
    sql = "select id, title, link from record_list where city_id=" + str(id)
    cur1.execute(sql)
    results = cur1.fetchall()
    return results


class DemoSpider(scrapy.Spider):
    name = "demo"
    allowed_domains = ["you.ctrip.com"]
    start_urls = []

    def start_requests(self):
        for id in range(51, 113):
            cid = getDistrictId(id)
            for result in getTitleAndUrlByCid(cid):
                record_id = result[0]
                title = result[1]
                url = result[2]
                add_params = {}
                add_params['record_id'] = record_id
                add_params['title'] = title
                add_params['city_id'] = cid
                yield scrapy.FormRequest(url=url, callback=self.parse, cb_kwargs=add_params)

    def parse(self, response, record_id, title, city_id):
        recordItem = RecordItem()
        recordItem['city_id'] = city_id
        recordItem['record_id'] = record_id
        recordItem['title'] = title
        recordItem['departure_month'] = ''
        recordItem['period'] = ''
        recordItem['per_cost'] = ''
        recordItem['plays'] = ''
        recordItem['with_who'] = ''

        departure_month = response.xpath('//span/i[@class="times"]/parent::span/text()').extract()  # 出发时间
        period = response.xpath('//span/i[@class="days"]/parent::span/text()').extract()  # 旅游时间段
        per_cost = response.xpath('//span/i[@class="costs"]/parent::span/text()').extract()  # 人均消费
        plays = response.xpath('//span/i[@class="plays"]/parent::span/text()').extract()  # 游玩方式
        with_who = response.xpath('//span/i[@class="whos"]/parent::span/text()').extract()  # 和谁一起出游

        if departure_month: recordItem['departure_month'] = departure_month[0]
        if period: recordItem['period'] = period[0]
        if per_cost: recordItem['per_cost'] = per_cost[0]
        if plays: recordItem['plays'] = plays[0]
        if with_who: recordItem['with_who'] = with_who[0]
        # print(plays[0])

        yield recordItem
