# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymysql

def splitNum(str):
    if str=='': return None
    newStr = str.split('：')
    return newStr[1].split(' ')[0]

def splitString(str):
    if str=='': return None
    return str.split('：')[1]

class TrytryPipeline:
    def process_item(self, item, spider):
        # 连接数据库
        conn1 = pymysql.connect(host='localhost'  # 连接名称，默认127.0.0.1
                                , user='root'  # 用户名
                                , passwd='111111'  # 密码
                                , port=3306  # 端口，默认为3306
                                , db='visual'  # 数据库名称
                                , charset='utf8'  # 字符编码
                                )
        cur1 = conn1.cursor()  # 生成游标对象
        sql1 = "INSERT INTO trip_records(city_id, record_id, departure_month, title, period, per_cost, play, with_who) VALUES(%s, %s, %s, %s, %s, %s, %s, %s)"  # 插入列表的SQL语句
        newDepartureMonth = splitNum(item['departure_month'])
        newPeroid = splitNum(item['period'])
        newPeroidCost = splitNum(item['per_cost'])
        newWith_who = splitString(item['with_who'])
        newPlays = splitString(item['plays'])
        data = (int(item["city_id"]), item["record_id"], newDepartureMonth, item['title'], newPeroid, newPeroidCost, newPlays, newWith_who)
        # print(data)
        cur1.execute(sql1, data)  # 执行SQL语
        conn1.commit()
        cur1.close()  # 关闭游标
        conn1.close()  # 关闭连接