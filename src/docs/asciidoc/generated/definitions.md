
<a name="definitions"></a>
## 定义

<a name="category"></a>
### Category

|名称|说明|类型|
|---|---|---|
|**categoryAlias**  <br>*可选*|分类别名  <br>**样例** : `"string"`|string|
|**categoryName**  <br>*可选*|分类名称  <br>**样例** : `"string"`|string|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**createUser**  <br>*可选*|**样例** : `0`|integer (int32)|
|**id**  <br>*可选*|**样例** : `0`|integer (int32)|
|**updateTime**  <br>*可选*|更新时间  <br>**样例** : `"string"`|string (date-time)|


<a name="result"></a>
### Result
返回响应数据


|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="b47a60eaea668ca45a059f22ebfdcc21"></a>
### Result«List«Category»»
返回响应数据


|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `[ "[category](#category)" ]`|< [Category](#category) > array|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="54e87c9d45da45de0ebe8369dbf7cba2"></a>
### Result«用户»
返回响应数据


|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"[1fd02a90c38333badc226309fea6fecb](#1fd02a90c38333badc226309fea6fecb)"`|[用户](#1fd02a90c38333badc226309fea6fecb)|
|**msg**  <br>*可选*|**样例** : `"string"`|string|


<a name="1fd02a90c38333badc226309fea6fecb"></a>
### 用户
用户信息


|名称|说明|类型|
|---|---|---|
|**createTime**  <br>*可选*|创建时间  <br>**样例** : `"string"`|string (date-time)|
|**email**  <br>*可选*|邮箱  <br>**样例** : `"string"`|string|
|**id**  <br>*可选*|**样例** : `0`|integer (int32)|
|**nickname**  <br>*可选*|昵称  <br>**样例** : `"string"`|string|
|**updateTime**  <br>*可选*|更新时间  <br>**样例** : `"string"`|string (date-time)|
|**userPic**  <br>*可选*|用户头像地址  <br>**样例** : `"string"`|string|
|**username**  <br>*可选*|用户名  <br>**样例** : `"string"`|string|



