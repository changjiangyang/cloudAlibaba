[toc]
### 接口文档
#### 注意
* 图片请求路径：http:(https:)//域名:端口号(8014)/img/返回的图片地址
* 视频请求路径：http:(https:)//域名:端口号(8014)/video/返回的视频地址
#### 落地页组件接口
##### 获取所有组件
* 地址: formAssembly/getAllFormAssembly
* 方式: get
* 返回:
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | string | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | array | 数据集合 | |
    | -id | number | 组件id | 1 |
    | -name | string | 组件名称 | 表单 |
    | -icon | string | 组件图标 | 6a14fbce286742a88aa4f27b381c8b65icon.png |
* 返回示例
    ```json
        {
            "code": "10000",
            "data": [
                {
                    "id": "1",
                    "name": "表单",
                    "icon": null
                },
                {
                    "id": "15838e35556f45de8a20e84fdcd47253",
                    "name": "按钮",
                    "icon": null
                },
                {
                    "id": "4bb5ecdf74a247f9be6573ae6079d413",
                    "name": "分享",
                    "icon": "6a14fbce286742a88aa4f27b381c8b65icon.png"
                }
            ],
            "message": "SUCCESS"
        }
    ```
##### 添加组件
* 地址: formAssembly/addFormAssembly
* 方式: post 
* 参数 
     | 参数名称 | 参数类型 | 参数说明  | 示例 | 必传 |
     | :---: | :---: | :---: | :---: | :---: |
     | name | String | 组件名称 | 姓名 | ✔ |
     | icon | img | 组件图标 |  | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | object | | |
    | -id | String | 组件id | 5d44bb50069040d2b6edefd6848ed515 |
    | -name | String | 组件名称 | 姓名 |
    | -icon | img | 组件图标 |  |
 * 返回示例
     ```json
        {
            "code": "10000",
            "data": {
                "id": "5d44bb50069040d2b6edefd6848ed515",
                "name": "文字,",
                "icon": "f72610e7bfa0404fba436450823211e1icon.png"
            },
            "message": "SUCCESS"
        }
     ```
##### 删除组件
* 地址: formAssembly/deleteFormAssembly
* 方式: get
* 参数:
    | 参数名称 | 参数类型 | 参数说明  | 示例 | 必传 |
    | :---: | :---: | :---: | :---: | :---: |
    | id | String | 组件id | 5d44bb50069040d2b6edefd6848ed515 | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | String |  | SUCCESS |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": "SUCCESS",
        "message": "SUCCESS"
    }
    ```
##### 添加落地页
* 地址:  formPage/insertFormPage
* 方式：POST
* 参数：
  |  参数名称  | 参数类型  | 参数说明 | 必传 |
  | :--------: | :-------: | :------: | :--: |
  | companyid  |  number   |  企业id  |  ✔   |
  |   parid    |  number   |  部门id  |  ✔   |
  | createuser |  String   |  创建人  |  ✔   |
  |  columns   |  String   |   内容   |  ✔   |
  |    name    |  String   |   标题   |  ✔   |
  |   title    |  String   |  副标题  |  ✔   |
  |   status   | number(1) |   状态固定为1   |  ✔   |
* 返回

  | 参数名称 | 参数类型 | 参数说明 |  示例   |
  | :------: | :------: | :------: | :-----: |
  |   code   |  String  |  返回码  |  10000  |
  | message  |  String  | 返回说明 | SUCCESS |
  |   data   |  String  |          | SUCCESS |

* 返回示例

  ```json
  {
      "code": "10000",
      "data": "SUCCESS",
      "message": "SUCCESS"
  }
  ```
##### 删除落地页
* 地址：formPage/deleteFormPage
* 方式：get
* 参数：
|  参数名称  | 参数类型  | 参数说明 | 必传 |
| :--------: | :-------: | :------: | :--: |
| id  |  String   |  企业id  |  ✔   |
* 返回
| 参数名称 | 参数类型 | 参数说明 |  示例   |
| :------: | :------: | :------: | :-----: |
|   code   |  String  |  返回码 |  10000  |
| message  |  String  | 返回说明 | SUCCESS |
|   data   |  String  |        | SUCCESS |
* 返回示例
```json
{
    "code": "10000",
    "data": "SUCCESS",
    "message": "SUCCESS"
}
```
##### 获取落地页详情
* 地址：formPage/getByid
* 方式：get
* 参数：
|  参数名称  | 参数类型  | 参数说明 | 必传 |
| :--------: | :-------: | :------: | :--: |
| id  |  String   |  落地页id  |  ✔   |
* 返回
| 参数名称 | 参数类型 | 参数说明 |  示例   |
| :------ | :------: | :------: | :-----: |
|   code   |  String  |  返回码  |  10000  |
| message  |  String  | 返回说明 | SUCCESS |
|   data   |  String  |          | SUCCESS |
|   -id   |  String  | 落地页id | 2efd2ced0d314e69abb2ac1d51b7c0a8 |
|   -companyid   |  String  |  企业id        | 1 |
|   -parid   |  String  |    部门id      | 1 |
|  -createtime   |  String  |   添加时间       | 2020-08-24T17:36:22.000+00:00 |
|   -columns   |  String  |     内容     | 测试 |
|   -name   |  String  |   名称  | 测试 |
|   -title   |  String  |  副标题        | 测试 |
|   -updateTime   |  String  | 上次修改时间 | 2020-08-24T17:36:22.000+00:00 |
|   -status   |  String  |   状态       | 1 |
* 返回示例
```json
    "code": "10000",
    "data": {
        "id": "2efd2ced0d314e69abb2ac1d51b7c0a8",
        "companyid": 1,
        "parid": 1,
        "createtime": "2020-08-24T17:36:22.000+00:00",
        "createuser": "1",
        "columns": "的发射点",
        "name": "123 为大是大非",
        "title": "1",
        "updateTime": null,
        "status": 1
    },
    "message": "SUCCESS"
}
```
##### 获取企业已创建落地页
* 地址：formPage/getByPage
* 方式：get
* 参数：
|  参数名称  | 参数类型  | 参数说明 | 必传 |
| :--------: | :-------: | :------: | :--: |
| companyid  |  String   |  企业id  |  ✔   |
| index  |  number   |  偏移量  |     |
| pagesize  |  number   |  每页条数  |     |
| key  |  String   | 查询关键字 |     |
* 返回
| 参数名称 | 参数类型 | 参数说明 |  示例   |
| :------ | :------: | :------: | :-----: |
|   code   |  String  |  返回码  |  10000  |
| message  |  String  | 返回说明 | SUCCESS |
|   data   |  String  |          | SUCCESS |
|   -id   |  String  | 落地页id | 2efd2ced0d314e69abb2ac1d51b7c0a8 |
|   -companyid   |  String  |  企业id        | 1 |
|   -parid   |  String  |    部门id      | 1 |
|  -createtime   |  String  |   添加时间       | 2020-08-24T17:36:22.000+00:00 |
|   -columns   |  String  |     内容     | 测试 |
|   -name   |  String  |   名称  | 测试 |
|   -title   |  String  |  副标题        | 测试 |
|   -updateTime   |  String  | 上次修改时间 | 2020-08-24T17:36:22.000+00:00 |
|   -status   |  String  |   状态       | 1 |
* 返回示例
```json
    "code":"10000",
    "data": {
        "id": "2efd2ced0d314e69abb2ac1d51b7c0a8",
        "companyid": 1,
        "parid": 1,
        "createtime": "2020-08-24T17:36:22.000+00:00",
        "createuser": "1",
        "columns": "的发射点",
        "name": "123 为大是大非",
        "title": "1",
        "updateTime": null,
        "status": 1
    },
    "message": "SUCCESS"
}
```
##### 修改落地页
* 地址：formPage/updateFormStatus
* 方式：POST
* 参数：
    |  参数名称  | 参数类型  | 参数说明 | 必传 |
    | :---: | :---: | :---: | :---: |
    | id | String | 落地页id | √ |
    | name | String | 落地页名称 | √ |
    | title | String | 落地页标题 | √ |
    | columns | String | 落地页内容 | √ |
* 返回
      |  参数名称  | 参数类型  | 参数说明 | 示例 |
      | :---: | :---: | :---: | :---: |
      |   code   |  String  |  返回码  |  10000  |
      | message  |  String  | 返回说明 | SUCCESS |
      |   data   |  String  |  |  |  
* 返回示例
```json
{
    "code": "10100",
    "data": "已经发布的页面不能修改",
    "message": "other fail"
}
```
##### 图片上传
* 地址：formPage/uploadimg
* 方式：POST
* 参数：
    |  参数名称  | 参数类型  | 参数说明 | 必传 |
    | :---: | :---: | :---: | :---: |
    | file | file | 图片 | √ |
* 返回
    |  参数名称  | 参数类型  | 参数说明 | 示例 |
    | :---: | :---: | :---: | :---: |
    |   code   |  String  |  返回码  |  10000  |
    | message  |  String  | 返回说明 | SUCCESS |
    |   data   |  String  | 图片地址 | 432c351537cb4234b6e28c59f7e3ff92.jpg |
* 返回示例
```json
{
    "code": "10000",
    "data": "432c351537cb4234b6e28c59f7e3ff92.jpg",
    "message": "SUCCESS"
}
```
##### 视频上传
* 地址：formPage/uploadvideo
* 方式：POST
* 参数：
    |  参数名称  | 参数类型  | 参数说明 | 必传 |
    | :---: | :---: | :---: | :---: |
    | file | file | 图片 | √ |
* 返回
    |  参数名称  | 参数类型  | 参数说明 | 示例 |
    | :---: | :---: | :---: | :---: |
    |   code   |  String  |  返回码  |  10000  |
    | message  |  String  | 返回说明 | SUCCESS |
    |   data   |  String  | 图片地址 | 432c351537cb4234b6e28c59f7e3ff92.jpg |
* 返回示例
```json
{
    "code": "10000",
    "data": "432c351537cb4234b6e28c59f7e3ff92.jpg",
    "message": "SUCCESS"
}
```
#### 表单

###### 组件
* 姓名组件
    * title: (String)姓名
    * type: name
    * placeholder: (String)提示信息
    * ismust: (boolean) ture 必选 
* 电话
    * title: (String)电话
    * type: phone
    * placeholder: (String)提示信息
    * ismust: (boolean) ture 必选
    * isonly: (boolean) ture 唯一
    * verification: (boolean) ture 发送短信验证   
* 性别
    * title: (String)性别
    * type: sex
    * ismust: (boolean) ture 必选
* 单行文本
     * title: (String)自定义
     * type: singleline
     * placeholder: (String)提示信息
     * ismust: (boolean) ture 必选
* 多行文本         
     * title: (String)自定义
     * type: manyline 
     * placeholder: (String)提示信息
     * ismust: (boolean) ture 必选         
     * maxlines: (number)多行文本 
* 单选
    * title: (String)自定义
    * type: singlechoice
    * ismust: (boolean) ture 必选
    * option ([{"text ":"","value ":""}])选项
        * text (String) 选项名称
        * value (String) 选项值  
* 多选
    * title: (String)自定义
    * type: morechoice
    * ismust: (boolean) ture 必选
    * option ([{"text ":"","value ":""}])选项
        * text (String) 选项名称
        * value (String) 选项值        
* 下拉菜单
    * title: (String)自定义
    * type: menu
    * ismust: (boolean) ture 必选
    * option ([{"text ":"","value ":""}])选项
        * text (String) 选项名称
        * value (String) 选项值         
* 城市
    * title: (String) 城市
    * type: city
    * ismust: (boolean) ture 必选
* 统计
    * name: (String) 统计
    * type: statistics
    * text1: (String)文本1
    * number: (number)计数
    * text2: (String)文本2
    * status: (number) 计数方式 1 递增 2递减
    * icon: (String)图标路径 
* 信息墙
    * name: (String)信息墙
    * type: information
    * style: (number) 样式索引
    * icon: (String)图标路径 
##### 接口
###### 添加表单
* 地址: formModel/addModel
* 请求方式: post
* 参数
   | 参数名称 | 参数类型 | 参数说明 | 示例 | 必传 |
   | :---: | :---: | :---: | :---: | :---: |
   | name | String | 表单名称 | | ✔ |
   | createuser | String | 创建人id | | ✔ |
   | columns | String | 表单组件的json数组 | | ✔ |
   | companyid | number | 企业id | | ✔ |
   | deartmentid | number | 部门id | | ✔ |
* columns示例
    ```json
    [
        {
            "title":"姓名",
            "type":"name",
            "placeholder":"请输入姓名",
            "columns":true
        },
        {
            "title":"电话",
            "type":"phone",
            "placeholder":"请输入电话",
            "ismust":true,
            "isonly":true,
            "verification":true
        },
        {
            "title":"性别",
            "type":"sex",
            "ismust":true
        }
    ]
    ```
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | String |  | SUCCESS |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": "SUCCESS",
        "message": "SUCCESS"
    }
    ```
###### 删除表单
* 地址: formModel/deleteModel
* 方式: Get
* 参数: 
    | 参数名称 | 参数类型 | 参数说明  | 示例 | 必传 |
    | :---: | :---: | :---: | :---: | :---: |
    | id | String | 表单id | 1 | ✔ |
    | pid | number | 企业id | 1 | ✔ |
* 返回:
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | String |  | SUCCESS |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": "SUCCESS",
        "message": "SUCCESS"
    }
    ```
###### 获取企业表单列表
* 地址: formModel/getModelByCompany
* 方式: get
* 参数: 
    | 参数名称 | 参数类型 | 参数说明  | 示例 | 必传 |
    | :---: | :---: | :---: | :---: | :---: |
    | id | String | 企业id | 1 | ✔ |
    | keys | String | 模板名称 | | |
    | index | number | 偏移量（默认0） | 1 | |
    | pagesize | number | 条数 | 10(默认10) | |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | [] | 组件数组 | |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": [{
                    "title": "姓名",
                    "type": "name",
                    "placeholder": "请输入姓名",
                    "columns": true
                }, {
                    "title": "电话",
                    "type": "phone",
                    "placeholder": "请输入电话",
                    "ismust": true,
                    "isonly": true,
                    "verification": true
                }, {
                    "title": "性别",
                    "type": "sex",
                    "ismust": true
                }],
        "message": "SUCCESS"
    }
    ```
###### 获取企业表单总数
* 地址: formModel/getCountByCompany
* 方式: get
* 参数: 
    | 参数名称 | 参数类型 | 参数说明  | 示例 | 必传 |
    | :---: | :---: | :---: | :---: | :---: |
    | id | number | 企业id | 1 | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | number | 企业表单总数 | 6 |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": 6,
        "message": "SUCCESS"
    }
    ```
###### 修改表单内容
* 地址: formModel/updateModel
* 方式: post
* 参数: 
     | 参数名称 | 参数类型 | 参数说明 | 示例 | 必传 |
     | :---: | :---: | :---: | :---: | :---: |
     | id | String | 表单id | | ✔ |
     | columns | String | 表单组件的json数组 | | ✔ |
     | name | String | 表单名称 | | ✔ |
     | pid | number | 企业id | | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | number | 企业表单总数 | 6 |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": 6,
        "message": "SUCCESS"
    }
    ```
###### 获取表单属性
* 地址: formModel/getModelByid
* 方式: get
* 参数
     | 参数名称 | 参数类型 | 参数说明 | 示例 | 必传 |
     | :---: | :---: | :---: | :---: | :---: |
     | id | String | 表单id | | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data | [] | 组件数组 | |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": {
            "createtime": "2020-08-12T18:06:25.000+00:00",
            "columns": [{
                "title": "姓名",
                "type": "name",
                "placeholder": "请输入姓名",
                "columns": true
            }, {
                "title": "电话",
                "type": "phone",
                "placeholder": "请输入电话",
                "ismust": true,
                "isonly": true,
                "verification": true
            }, {
                "title": "性别",
                "type": "sex",
                "ismust": true
            }],
            "name": "电话",
            "id": "ddcc9047d4484c26b9f8a1c89a47b96b",
            "updatetime": "2020-08-13T12:16:31.000+00:00"
        },
        "message": "SUCCESS"
    }
    ```
###### 获取验证码
* 地址: formvalue/getVerificationCode
* 方式: get
* 参数
     | 参数名称 | 参数类型 | 参数说明 | 示例 | 必传 |
     | :---: | :---: | :---: | :---: | :---: |
     | phone | String | 电话号码 | | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明  | 示例 |
    | :---: | :---: | :---: | :---: |
    | code | String | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data |  | 返回数据 | |
    | formvalueid | String | 表单值id | 680d2c13a3eb4830b1fb19964558b642 |
    | timeout | number | 验证码超时时间(以秒为单位) | 300 |
* 返回示例
   ```json
    {
        "code": "10000",
        "data": {
            "formvalueid": "680d2c13a3eb4830b1fb19964558b642",
            "timeout": 300
        },
        "message": "SUCCESS"
    }
   ```
* **注意: 这里产生的表单值id为临时id 表单提交后废弃。真实的id会在提交表单时返回。**
###### 提交表单
* 地址: formvalue/addvalue
* 方式: post
* 参数
   | 参数名称 | 参数类型 | 参数说明 | 必传 |
   | :---: | :---: | :---: | :---: | :---: |
   | filluserid | number | 填写人id | ✔ |
   | filusername | String | 填写人姓名 | ✔ |
   | fillcontent | String | 填写的内容 | ✔ |
   | modelid | String | 电话号码 | ✔ |
   | id | String | 表单值id(表单电话必填时此值必传) |  |
   | vlicode | String | 验证码(表单电话必填时此值必传) |  |
* 返回  ​      
    | 参数名称 | 参数类型 | 参数说明 |
    | :---: | :---: | :---: | :---: |
    | code | Sting | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data |  | 返回数据 | |
    | id | String | 表单值存放id | |
    | filluserid | number | 填写人id | |
    | filusername | number | 填写人姓名 | |
    | filltime | number | 填写时间 | |
    | fillcontent | number | 填写内容 | |
    | modelid | number | 模板id | |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": {
            "id": "d4c7dbc920c047dea031bfd539bb6470",
            "filluserid": 123,
            "filusername": "测试",
            "filltime": "2020-08-14T23:59:46.940+00:00",
            "fillcontent": "{\"name\":\"ceshi\"}",
            "modelid": "3eeba6d841df47bb9e889ded375b748f"
        },
        "message": "SUCCESS"
    }
    ```
###### 获取表单模板的所有提交
* 地址: formvalue/getFormvalueBymodelID
* 方式: get
* 参数: 
   | 参数名称 | 参数类型 | 参数说明 | 必传 |
   | :---: | :---: | :---: | :---: | :---: |
   | mid | String | 模板id | ✔ |
   | index | number | 偏移量 | ✔ |
   | pagesize | number | 每页条数 | ✔ |
* 返回
    | 参数名称 | 参数类型 | 参数说明 |
    | :---: | :---: | :---: | :---: |
    | code | Sting | 返回码 | 10000 |
    | message | String | 返回说明 | SUCCESS |
    | data |  | 返回数据 | |
    | -id | String | 表单值存放id | |
    | -filluserid | number | 填写人id | |
    | -filusername | number | 填写人姓名 | |
    | -filltime | number | 填写时间 | |
    | -fillcontent | number | 填写内容 | |
    | -modelid | number | 模板id | |
* 返回示例
    ```json
    {
        "code": "10000",
        "data": [
            {
                "id": "d4c7dbc920c047dea031bfd539bb6470",
                "filluserid": 123,
                "filusername": "测试",
                "filltime": "2020-08-14T23:59:46.940+00:00",
                "fillcontent": "{\"name\":\"ceshi\"}",
                "modelid": "3eeba6d841df47bb9e889ded375b748f"
            },
            {
                "id": "d4c7dbc920c047dea031bfd539bb6470",
                "filluserid": 123,
                "filusername": "测试",
                "filltime": "2020-08-14T23:59:46.940+00:00",
                "fillcontent": "{\"name\":\"ceshi\"}",
                "modelid": "0acd2daea4ef4208b506ca490c5bf957"
            }
        ]
        "message": "SUCCESS"
    }
    ```








​    







