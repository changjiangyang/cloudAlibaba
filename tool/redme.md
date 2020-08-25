[toc]
### TimeHelp 时间工具类
##### getCurrentTime()
* 描述: 获得当前日期
* 返回: String yyyy-MM-dd HH:mm:ss
* 返回示例: 2019-08-27 14:12:40
##### getSystemTime()
* 描述: 获取系统当前时间戳
* 返回: long
* 返回示例: 1566889186583
##### convertTimestamp2Date()
* 描述: 时间戳按指定格式转化为日期
* 参数:
    | 参数名称 | 参数类型 | 参数描述 |
    | :----: | :----: | :----: |
    | timestamp  | Long | 时间戳 |
    | pattern  | String | 时间格式 |
* 返回: String 
##### getDateByString()
* 描述: 获取当前日期
* 返回: String
* 返回示例: 2020-09-08
##### dateSubtraction(String start, String end)
* 描述: 获取两个时间差
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | start  | String | 开始时间 | 2019-08-27 14:12:40 |
    | end  | String | 结束时间 | 2019-06-27 14:12:40 |
* 返回: long
* 返回示例: 5270400000
##### dateTogether(Date start, Date end)
* 描述: 获取两个时间差
* 参数:
    | 参数名称 | 参数类型 | 参数描述 |
    | :----: | :----: | :----:  |
    | start  | Date | 开始时间 |
    | end  | Date | 结束时间 |
* 返回: long
* 返回示例: 5270400000
##### transferLongToDate()
* 描述: 转化long值的日期为yyyy-MM-dd  HH:mm:ss.SSS格式的日期
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | millSec  | long | 时间戳 | 5270400000 |
* 返回: 日期，以yyyy-MM-dd  HH:mm:ss.SSS
* 返回示例: 1970-03-03  08:00:00.000
##### getDayOfWeek()
* 描述: 获取当前日期是一个星期的第几天
* 返回: int 
* 返回示例: 2
##### isEffectiveDate(Date nowTime, String dateSection)
* 描述: 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | nowTime | Date | 当前时间 | new Date() |
    | dateSection| String | 时间区间 | 2018-01-08,2019-09-09|
* 返回: boolean
##### getCurrentHour()
* 描述: 获取当前小时
* 返回: String
* 返回示例: 2019-08-27 17
##### getCurrentHourBefore()
* 描述: 获取当前时间一个小时前
* 返回: String
* 返回示例: 2019-08-27 17
##### getBeforeDay()
* 描述: 获取当前日期前一天
* 返回: String
* 返回示例: 2019-08-27
##### getServen()
* 描述: 获取最近七天
* 返回: String
* 返回示例: 2019-08-27
##### getOneMonth()
* 描述: 获取最近一个月
* 返回: String
* 返回示例: 2019-08-27
##### getThreeMonth()
* 描述: 获取最近三个月
* 返回: String
* 返回示例: 2019-05-27
##### getOneYear()
* 描述: 获取最近一年
* 返回: String
* 返回示例: 2018-08-27
##### getMonthList()
* 描述: 获取今年月份数据
* 返回: List<Integer>
* 返回示例: [1, 2, 3, 4, 5, 6, 7]
##### getQuartList()
* 描述: 当前年度季度list  本年度截止目前共三个季度，然后根据1,2,3分别查询相关起止时间
* 返回: List<Integer>
* 返回示例: [1, 2, 3]
### Img2Base64Util 图片与 Base64 互转
##### getImgStr()
* 描述: 图片转base64
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | in | InputStream | 待处理图片的二进制流 | new FileInputStream(imgFile) |
* 返回: String 
##### generateImage(String imgStr, String imgFilePath)
* 描述: 图片转base64
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | imgStr | String | Base64字符串 |  |
    | imgFilePath | String | 图片保存路径 |  |
* 返回: boolean 
### Encription 加密工具类
##### md5()
* 描述: md5 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | str | String | 待加密内容 |  |
* 返回 String
##### sha1ToBytes(String str)
* 描述: sha 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | str | String | 待加密内容 |  |
* 返回 String
##### createkey()
* 描述: 产生 des 加密密匙
* 返回: String
##### encryptDes(String data)
* 描述: des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | data | String | 待加密内容 |  |
* 返回: Map<String,String >
##### encryptDes(String data, String key)
* 描述: des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | data | String | 待加密内容 |  |
    | key | String | 密匙 |  |
* 返回: String
##### encryptDes(byte[] src,String key)
* 描述: des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | src | byte[] | 待加密内容 |  |
    | key | String | 密匙 |  |
* 返回: byte[]
##### encryptDes(byte[] src)
* 描述: des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | src | byte[] | 待加密内容 |  |
* 返回: Map<String,Object >
##### decrypt(String data, String key )
* 描述: des 解密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | data | String | 密文 |  |
    | key | String | 密匙 |  |
* 返回: String
##### decrypt(byte[] src, String password)
* 描述: des 解密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | src | byte[] | 密文 |  |
    | password | String | 密匙 |  |
* 返回: byte[]
##### encode3Des(String key,String srcStr,String type)
* 描述: 3des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | key | String | 密匙 |  |
    | srcStr | String | 待加密内容 |  |
    | type | String | 加密方式 |  |
* 返回: String
##### decode3Des(String key,String srcStr,String type)
* 描述: 3des 解密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | key | String | 密匙 |  |
    | srcStr | String | 密文 |  |
    | type | String | 加密方式 |  |
* 返回: String
##### encode3Desbyte(String key, String srcStr, String type)
* 描述: 3des 加密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | key | String | 密匙 |  |
    | srcStr | String | 待加密内容 |  |
    | type | String | 加密方式 |  |
* 返回: byte[]
##### decode3Desbyte(String key, byte[] src,String type)
* 描述: 3des 解密
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | key | String | 密匙 |  |
    | src | byte[] | 密文 |  |
    | type | String | 加密方式 |  |
* 返回: String
### UtilValidator 正则验证工具
##### isChinaMobilePhoneNum(String tel)
* 描述: 查询电话属于哪个运营商
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | tel | String | 手机号 |  |
* 返回: Integer
* 返回说明: 0：不属于任何一个运营商，1:移动，2：联通，3：电信
##### isMobile(String mobile)
* 描述: 校验手机号
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | mobile | String | 手机号 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isEmail(String email)
* 描述: 校验email
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | email | String | 手机号 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isChinese(String chinese)
* 描述: 校验汉字
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | chinese | String | 待校验字符串 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isIDCard(String idCard)
* 描述: 校验身份证
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | idCard | String | 身份证号 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isUrl(String url)
* 描述: 校验URL
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 待校验url |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isIPAddr(String ipAddr)
* 描述: 校验IP地址
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | uipAddrrl | String | 待校验字符 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### isPositiveNumber(String num)
* 描述: 校验正数(0也返回true)
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | num | String | 待校验字符 |  |
* 返回: boolean
* 返回说明: 校验通过返回true，否则返回false
##### hideCardNo(String cardNo)
* 描述: 隐藏银行卡号中间的字符串（使用*号），显示前四后四
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | cardNo | String | 银行卡号 |  |
* 返回: String
##### hidePhoneNo(String phoneNo)
* 描述: 隐藏手机号中间位置字符，显示前三后四个字符
* 参数:
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | phoneNo | String | 手机号 |  |
* 返回: String
### VerificationCode 生成验证码工具类
##### getrandom(Integer lentgh)
* 描述: 产生指定位数的随机数
* 参数: 
    | 参数名 | 参数类型 | 参数说明 | 参数示例 |
    | :---: | :---: | :---: | :---: |
    | lentgh | Integer | 随机数的长度 | 3 |
#### ImageVerificationCode 图片验证码
##### getImage() 
* 描述: 获取图片二维码
* 使用示例: 以ssm示例
    ```java
    VerificationCode.ImageVerificationCode imageVerificationCode=new VerificationCode.ImageVerificationCode();     //用我们的验证码类，生成验证码类对象
    BufferedImage image = ivc.getImage();  //获取验证码
    request.getSession().setAttribute("text", ivc.getText()); //将验证码的文本存在session中
    ivc.output(image, response.getOutputStream());//将验证码图片响应给客户端
    ```
##### getText()
* 描述: 获取图片中的文本
* 返回: String
### HttpUtils post,get工具类
##### HttpUtils(Integer timeout)
* 描述: 构造方法 设置超时时间
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | timeout | Integer | 超时时间（单位: 秒） | 10 |
##### sendGet(String url, Map<String,String> map,Map<String,String> hand)
* 描述: 发送Get 请求 
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  | 
    | map | Map<String,String> | 参数集合 |  | 
    | hand | Map<String,String> | 消息头集合 |  |
* 返回: String
#####  sendGet(String url, Map<String,String> map)
* 描述: 发送Get 请求 
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  | 
    | map | Map<String,String> | 参数集合 |  | 
* 返回: String
#####  sendGet(String url)
* 描述: 发送Get 请求 
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
* 返回: String
##### sendGetAsync(String url,final DataCallBack dataCallBack)
* 描述: 异步发送 Get 请求 
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | dataCallBack | DataCallBack | 请求返回处理 |  |
* 使用示例:
    ```java
    HttpUtils httpUtils=new HttpUtils(30);
    httpUtils.sendGetAsync("https://api.xxx.com/", new HttpUtils.DataCallBack() {
        public void requestFailure(Request request, IOException e) {
            System.out.println(e.toString());
        }

        public void requestSuccess(String result) throws Exception {
            System.out.println(result);
        }
    });
    ```
##### sendPost(String url)
* 描述: 发送post请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
* 返回: String
##### sendPost(String url,Map<String,String> map)
* 描述: 发送post请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | map | Map<String,String> | 请求参数 |  |
* 返回: String
##### sendPost(String url,Map<String,String> maps,Map<String,String> header)
* 描述: 发送post请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | maps | Map<String,String> | 请求参数 |  |
    | header | Map<String,String> | 请求消息头参数 |  |
* 返回: String
##### sendPostAsync(String url,final DataCallBack dataCallBack)
* 描述: 异步发送 post 请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | dataCallBack | DataCallBack | 请求结果处理 |  |
* 使用示例:
    ```java
        HttpUtils httpUtils=new HttpUtils(30);
        httpUtils.sendPostAsync("https://api.xxx.com/", new HttpUtils.DataCallBack() {
            public void requestFailure(Request request, IOException e) {
                System.out.println(e.toString());
            }
    
            public void requestSuccess(String result) throws Exception {
                System.out.println(result);
            }
        });
    ```
##### sendPostAsync(String url,Map<String,String> params,final DataCallBack dataCallBack)
* 描述: 异步发送 post 请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | params | Map<String,String> | 请求参数 |  |
    | dataCallBack | DataCallBack | 请求结果处理 |  |
* 使用示例:
    ```java
        HttpUtils httpUtils=new HttpUtils(30);
        Map<String,String> map=new HashMap<String,String>();
        map.put("id","123456");
        httpUtils.sendPostAsync("https://api.xxx.com/", map, new HttpUtils.DataCallBack() {
            public void requestFailure(Request request, IOException e) {
                System.out.println(e.toString());
            }
    
            public void requestSuccess(String result) throws Exception {
                System.out.println(result);
            }
        });
    ```
##### sendPostAsync(String url,Map<String,String> params,Map<String ,String> headers,final DataCallBack dataCallBack)
* 描述: 异步发送 post 请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | params | Map<String,String> | 请求参数 |  |
    | headers | Map<String,String> | 消息头参数 |  |
    | dataCallBack | DataCallBack | 请求结果处理 |  |
* 使用示例:
    ```java
        HttpUtils httpUtils=new HttpUtils(30);
        Map<String,String> map=new HashMap<String,String>();
        map.put("id","123456");
        httpUtils.sendPostAsync("https://api.xxx.com/", map, new HttpUtils.DataCallBack() {
            public void requestFailure(Request request, IOException e) {
                System.out.println(e.toString());
            }
    
            public void requestSuccess(String result) throws Exception {
                System.out.println(result);
            }
        });
    ```
##### sendPostAsyncJson(String url,String json,final DataCallBack dataCallBack)
* 描述: 异步发送post请求
* 参数: 
    | 参数名称 | 参数类型 | 参数描述 | 参数示例 |
    | :----: | :----: | :----: | :----: |
    | url | String | 请求地址 |  |
    | json | String | 请求参数 |  |
    | dataCallBack | DataCallBack | 请求结果处理 |  |
* 使用示例
    ```java
        HttpUtils httpUtils=new HttpUtils(30);
        Map<String,String> map=new HashMap<String,String>();
        map.put("id","123456");
        httpUtils.sendPostAsync("https://api.xxx.com/",  com.alibaba.fastjson.JSON.toJSONString(map), new HttpUtils.DataCallBack() {
            public void requestFailure(Request request, IOException e) {
                System.out.println(e.toString());
            }
    
            public void requestSuccess(String result) throws Exception {
                System.out.println(result);
            }
        });
    ```





