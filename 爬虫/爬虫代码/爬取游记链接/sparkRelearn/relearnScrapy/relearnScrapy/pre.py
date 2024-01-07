import pymysql

def getTitleAndUrlByCid(id):
    conn1 = pymysql.connect(host='localhost'  # 连接名称，默认127.0.0.1
                            , user='root'  # 用户名
                            , passwd='111111'  # 密码
                            , port=3306  # 端口，默认为3306
                            , db='visual'  # 数据库名称
                            , charset='utf8'  # 字符编码
                            )
    cur1 = conn1.cursor()  # 生成游标对象
    sql = "select title,link from record_list where city_id=" + str(id)
    cur1.execute(sql)
    results = cur1.fetchall()
    return results

if __name__ == "__main__":
    print(getTitleAndUrlByCid(16))
    # for num in range(1,39):
        # print(getDistrictId(num))