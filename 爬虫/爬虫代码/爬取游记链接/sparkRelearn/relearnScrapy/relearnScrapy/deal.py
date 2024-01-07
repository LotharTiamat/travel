from pyspark.sql import SparkSession
import pymysql
import csv
import pandas as pd

def writeInFile():
    # data1 = (rdd[0], rdd[1], float(rdd[2]), rdd[3], rdd[4])
    try:
        with open('placeAndLink.txt', 'r+', encoding='utf-8') as rf:
            line = rf.readline()
            while line != '':
                # 连接数据库
                conn1 = pymysql.connect(host='localhost'  # 连接名称，默认127.0.0.1
                                        , user='root'  # 用户名
                                        , passwd='111111'  # 密码
                                        , port=3306  # 端口，默认为3306
                                        , db='travel'  # 数据库名称
                                        , charset='utf8'  # 字符编码
                                        )
                cur1 = conn1.cursor()  # 生成游标对象
                sql1 = "INSERT INTO scenicspot(title, place, link) VALUES(%s, %s, %s)"  # SQL语句
                attributes = line.split('/interval/')
                data = (attributes[0], attributes[1], attributes[2])
                sql2 = "SELECT * FROM scenicspot WHERE title like " + str(attributes[0])
                print(attributes)
                if cur1.execute(sql2, ) == '':
                    cur1.execute(sql1, data)  # 执行SQL语句
                line = rf.readline()
                conn1.commit()
                cur1.close()  # 关闭游标
                conn1.close()  # 关闭连接
    finally:
        rf.close()

def splitNum(str):
    if str=='': return ''
    newStr = str.split('：')
    return newStr[1].split(' ')[0]
def splitString(str):
    if str=='': return ''
    return str.split('：')[1]

def replaceFile():
    csv_reader = csv.reader(open("trip_records_202311142122.csv",encoding='utf-8'))
    path = 'trip_records_202311142122.csv'
    # data = pd.read_csv(path)
    # # data为结构体
    # # 读取某两列
    # x = data[['period', 'left']]
    # print(x)
    # # 读取某一列
    # y = data[['top']]
    # print(y)

    a=0
    # 1. 创建文件对象（指定文件名，模式，编码方式）a模式 为 下次写入在这次的下一行
    with open("newData.csv", "w", encoding="utf-8", newline="") as f:
        for row in csv_reader:
            a+=1
            # 2. 基于文件对象构建 csv写入对象
            csv_writer = csv.writer(f)
            # if a > 50: break
            if a==1:
                csv_writer.writerow(row)
                continue
            # print(row)
            # print(row[0])
            row[4] = splitNum(row[4])
            row[5] = splitNum(row[5])
            row[6] = splitNum(row[6])
            row[7] = splitString(row[7])
            row[8] = splitString(row[8])
            csv_writer.writerow(row)
        # 3. 构建列表头
        # name = ['top', 'left']
        # csv_writer.writerow(name)
        # # 4. 写入csv文件内容
        # z = [
        #     [0, 31],
        #     [1, 30],
        #     [2, 32]
        # ]
        # csv_writer.writerow(z)
        print("写入数据成功")
        # 5. 关闭文件
        f.close()

if __name__ == "__main__":
    replaceFile()