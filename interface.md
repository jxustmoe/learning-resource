# 学习资料后端接口

# 目录

## 添加(GET/POST)

### 参数

1. name 目录的名字
2. pid 父目录，如果为0，那么表示父目录，否则就是子目录

### 示例

1. http://localhost:8080/category/add?name=计算机网络4&pid=1 

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "添加成功",
    "data": null
}
```



## 删除(GET/POST)

### 参数

1. categoryId 目录id

### 示例

1. http://localhost:8080/category/delete?categoryId=17

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "删除成功",
    "data": null
}
```



## 修改(GET/POST)

### 参数

1. id 目录的id
2. name 目录的新名字
3. pid 父目录的id，如果为0表示父目录

### 示例

1.  http://localhost:8080/category/update?id=1&name=修改的子目录4&pid=25

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "修改成功",
    "data": null
}
```



## 查询(GET/POST)

### 参数  

1. 无参数

### 示例

1. http://localhost:8080/category/show

### JSON结果

```json
{
    {
    "statusCode": 200,
    "statusMessage": "查询成功",
    "data": [
        [
            {"id": 1,"name": "网络工程","pid": 0},//父目录
            {"id": 5,"name": "网络管理与维护","pid": 1},//它的子目录
            {"id": 6,"name": "无线网络技术","pid": 1},
            {"id": 7,"name": "综合楼布线","pid": 1}
        ],
        [
            {"id": 2,"name": "通信工程","pid": 0},
            {"id": 8,"name": "通信工程1","pid": 2},
            {"id": 9,"name": "通信工程2","pid": 2},
            {"id": 10,"name": "通信工程3","pid": 2},
            {"id": 11,"name": "通信工程4","pid": 2}
        ]
	]
}
```

# 学习资源

## 添加(GET/POST)

### 参数

1. name 学习资源名称
2. categoryId 学习资源所属目录
3. link 学习资源的链接
4. uploadTime 学习资源的上传时间 (字符串)

### 示例

1. http://localhost:8080/studyRes/add?name=新添加的资源1&categoryId=15&link=baidu.com&uploadTime=1998

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "添加成功",
    "data": null
}
```



## 修改(GET/POST)

### 参数

1. id 学习资源的id
2. name 学习资源名称
3. categoryId 学习资源所属目录
4. link 学习资源的链接
5. uploadTime 学习资源的上传时间 (字符串)

### 示例

1. http://localhost:8080/studyRes/update?name=Java最新基础教程盗版&categoryId=15&link=baidu.com&uploadTime=1998&id=13

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "修改成功",
    "data": null
}
```



## 删除(GET/POST)

### 参数

1. resourceId：学习资源的id

### 示例

1. http://localhost:8080/studyRes/delete?resourceId=14

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "删除成功",
    "data": null
}
```



## 查询

### 参数

1. categoryId 如果这个参数有，就查询
2. page 页码，可以不传，默认为第一页
3. keyword 如果这个参数有，模糊查询

### 示例

   模糊查询

1. http://localhost:8080/studyRes/delete?resourceId=14

### JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "",
    "data": {
        "pageNum": 0,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "data": [
            {"id": 1,"name": "网络管理与维护考试答案","categoryId": 5,"link": "baidu.com",
                "uploadTime": "1998"},
            {"id": 2,"name": "无线网络技术考试答案","categoryId": 6,"link": "baidu.com",
                "uploadTime": "1998"
            },
            {"id": 3,"name": "综合楼布线考试答案","categoryId": 7,"link": "baidu.com",
                "uploadTime": "1998"
            }
        ]
    }
}
```

### 示例2

根据目录查询

1. http://localhost:8080/studyRes/show?categoryId=15

JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "",
    "data": {
        "pageNum": 0,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "data": [
            {"id": 11,"name": "软件维护考试答案","categoryId": 15,"link": "baidu.com",
                "uploadTime": "1998"
            },
            {"id": 13,"name": "Java最新基础教程盗版","categoryId": 15,"link": "baidu.com",
                "uploadTime": "1998"
            }
        ]
    }
}
```

示例3

获取所有

1. http://localhost:8080/studyRes/show

JSON结果

```json
{
    "statusCode": 200,
    "statusMessage": "",
    "data": {
        "pageNum": 0,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "data": [
            {"id": 1,"name": "网络管理与维护考试答案","categoryId": 5,"link": "baidu.com",
                "uploadTime": "1998"},
            {"id": 2,"name": "无线网络技术考试答案","categoryId": 6,"link": "baidu.com",
                "uploadTime": "1998"
            },
            {"id": 3,"name": "综合楼布线考试答案","categoryId": 7,"link": "baidu.com",
                "uploadTime": "1998"
            }
        ]
    }
}
//太多了
```



异常情况

```json
{    
    "statusCode": 666,    
    "statusMessage": "服务器打盹了",    
    "data": null
}
```

出现这个666错误码请马上通知我。

受管辖的异常情况

```json
{    
    "statusCode": 500,    
    "statusMessage": "修改的目录不存在了",    
    "data": null
}
//如果添加的时候目录已存在，为了防止添加重复的目录就会有这个
{    
    "statusCode": 500,    
    "statusMessage": "目录已存在",    
    "data": null
}
//如果修改目录的时候，目录不存在(就在你想要修改的时候被别人删了)，就会有这个
{    
    "statusCode": 500,    
    "statusMessage": "目录不存在",    
    "data": null
}
//修改资源同理，因为网上重复的资源太多，所以没有资源已存在这个异常
{    
    "statusCode": 500,    
    "statusMessage": "资源不存在",    
    "data": null
}
//参数有问题
{    
    "statusCode": 500,    
    "statusMessage": "参数为空或者非法",    
    "data": null
}
```

500是意料之中的异常，一般是参数输入错了，或者，目录不存在什么的。都是这个错误码。