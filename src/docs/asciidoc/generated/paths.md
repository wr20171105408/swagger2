
<a name="paths"></a>
## 资源

<a name="2644d9c2a39b316f4eea7a18bd3dccfe"></a>
### 分类管理的相关接口
Category Controller


<a name="categoryusingget"></a>
#### 获取分类列表
```
GET /category
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|用户 TOKEN参数|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|成功|[Result«List«Category»»](#b47a60eaea668ca45a059f22ebfdcc21)|
|**400**|参数没填好|无内容|
|**401**|token过期或者没登录|无内容|


##### 生成

* `\*/*`


##### 安全

|类型|名称|作用域|
|---|---|---|
|**未知**|**[Authorization](#authorization)**|global|


##### HTTP请求示例

###### 请求 path
```
/category
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "code" : 0,
  "data" : [ {
    "categoryAlias" : "string",
    "categoryName" : "string",
    "createTime" : "string",
    "createUser" : 0,
    "id" : 0,
    "updateTime" : "string"
  } ],
  "msg" : "string"
}
```


<a name="d7fef7aa7ddfa5eded711e3544df450f"></a>
### 用户管理的相关接口
User Controller


<a name="getusersusingget"></a>
#### 获取用户列表
```
GET /user/getUsers
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|用户 TOKEN参数|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|


##### 生成

* `\*/*`


##### 安全

|类型|名称|作用域|
|---|---|---|
|**未知**|**[Authorization](#authorization)**|global|


##### HTTP请求示例

###### 请求 path
```
/user/getUsers
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="loginusingpost"></a>
#### 登录
```
POST /user/login
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|用户 TOKEN参数|string|
|**Query**|**passWord**  <br>*必填*|密码|string|
|**Query**|**userName**  <br>*必填*|用户名|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Result](#result)|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### 安全

|类型|名称|作用域|
|---|---|---|
|**未知**|**[Authorization](#authorization)**|global|


##### HTTP请求示例

###### 请求 path
```
/user/login?passWord=string&userName=string
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "code" : 0,
  "data" : "object",
  "msg" : "string"
}
```


<a name="updatepwdusingpatch"></a>
#### 更新密码
```
PATCH /user/updatePwd
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Header**|**token**  <br>*可选*|用户 TOKEN参数|string|
|**Body**|**params**  <br>*必填*|参数集|[map](#map)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|成功|[Result«用户»](#54e87c9d45da45de0ebe8369dbf7cba2)|
|**400**|参数没填好|无内容|
|**401**|token过期或者没登录|无内容|


##### 消耗

* `application/json`


##### 生成

* `\*/*`


##### 安全

|类型|名称|作用域|
|---|---|---|
|**未知**|**[Authorization](#authorization)**|global|


##### HTTP请求示例

###### 请求 path
```
/user/updatePwd
```


###### 请求 header
```json
"string"
```


##### HTTP响应示例

###### 响应 200
```json
{
  "code" : 0,
  "data" : {
    "createTime" : "string",
    "email" : "string",
    "id" : 0,
    "nickname" : "string",
    "updateTime" : "string",
    "userPic" : "string",
    "username" : "string"
  },
  "msg" : "string"
}
```



