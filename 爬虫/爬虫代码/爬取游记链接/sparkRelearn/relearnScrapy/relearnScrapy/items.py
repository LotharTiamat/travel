# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class RelearnscrapyItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass

class Record_Num(scrapy.Item):
    num=scrapy.Field()
    cid=scrapy.Field()

class Record_Link(scrapy.Item):
    city_id=scrapy.Field() #城市id
    page=scrapy.Field() #该链接所在页码
    title=scrapy.Field() #游记标题
    link=scrapy.Field() #对应游记链接