# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class TrytryItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass

class RecordItem(scrapy.Item):
    record_id=scrapy.Field() #record的id
    city_id=scrapy.Field() #城市id
    title=scrapy.Field() #游记标题
    departure_month=scrapy.Field() #出发时间
    period=scrapy.Field()#旅游时间段
    per_cost=scrapy.Field()#人均消费
    plays=scrapy.Field()#游玩方式
    with_who=scrapy.Field()#和谁一起
