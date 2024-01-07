# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymysql


class RelearnscrapyAcountPipeline: #record_amount获取pipeline
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
        sql1 = "INSERT INTO record_amount(record_amount_page, city_id) VALUES(%s, %s)"  # SQL语句
        data = (int(item["num"]), int(item["cid"]))
        # print(sql1)
        cur1.execute(sql1, data)  # 执行SQL语句
        conn1.commit()
        cur1.close()  # 关闭游标
        conn1.close()  # 关闭连接

class RelearnscrapyPipeline:
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
        sql1 = "INSERT INTO record_list(city_id, page, link, title) VALUES(%s, %s, %s, %s)"  # 插入列表的SQL语句
        data = (int(item["city_id"]), int(item["page"]), item['link'], item['title'])
        cur1.execute(sql1, data)  # 执行SQL语
        conn1.commit()
        cur1.close()  # 关闭游标
        conn1.close()  # 关闭连接