package com.hltx.tool;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * User: ycj
 * Date: 2020/7/30
 * Time: 18:18
 * Description: 正则验证工具类
 */
public class UtilValidator {

    /**
     * 正则表达式：验证手机号(国内)
     */
    public static final String REGEX_MOBILE = "0?(13|14|15|18|17)[0-9]{9}";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    /**
     *
     * 匹配正数
     *
     */
    public static final String POSITIVE_NUMBER = "^(0\\.0*[1-9]+[0-9]*$|[1-9]+[0-9]*\\.[0-9]*[0-9]$|[1-9]+[0-9]*$)";

    /**
     *
     * 匹配整数
     *
     */
    public static final String INTEGER_REGEXP = "-?[1-9]\\d*";

    /**
     *
     * 匹配正整数
     *
     */
    public static final String POSITIVE_INTEGER_REGEXP = "[1-9]\\d*";

    /**
     * 匹配非负整数（正整数 + 0)
     */
    public static final String NON_NEGATIVE_INTEGERS_REGEXP = "^\\d+$";

    /**
     *
     * 匹配负整数
     *
     */
    public static final String NEGATIVE_INTEGERS_REGEXP = "-[1-9]\\d*";

    /**
     *
     * 匹配正浮点数
     *
     */
    public static final String POSITIVE_RATIONAL_NUMBERS_REGEXP = "[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*";

    /**
     *
     * 匹配负浮点数
     *
     */
    public static final String NEGATIVE_RATIONAL_NUMBERS_REGEXP = "-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)";

    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173,199
     **/
    private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|73|99|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /**
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
     **/
    private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
     **/
    private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";

    /**
     * 查询电话属于哪个运营商
     *
     * @param tel 手机号码
     * @return 0：不属于任何一个运营商，1:移动，2：联通，3：电信
     */
    public Integer isChinaMobilePhoneNum(String tel) {
        boolean b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_MOBILE_PATTERN, tel);
        if (b1) {
            return 1;
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_UNICOM_PATTERN, tel);
        if (b1) {
            return 2;
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_TELECOM_PATTERN, tel);
        if (b1) {
            return 3;
        }
        return 0;
    }

    /**
     * 匹配函数
     * @param regex
     * @param tel
     * @return
     */
    private static boolean match(String regex, String tel) {
        return Pattern.matches(regex, tel);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    /**
     * 校验正数(0也返回true)
     *
     * @param num
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPositiveNumber(String num) {
        if("0".equals(num)){
            return true;
        }else{
            return Pattern.matches(POSITIVE_NUMBER, num);
        }
    }

    /**
     *
     * @param source
     *           匹配的源字符串
     * @param regexp
     *           匹配的正规表达式
     * @return 如果源字符串符合要求返回真true,否则返回假false
     */
    public static boolean isHardRegexpValidate(String source, String regexp) {
        return Pattern.matches(regexp,source);
    }

    /**
     * 方法描述 隐藏银行卡号中间的字符串（使用*号），显示前四后四
     * @param cardNo
     * @return
     * @date 2018年4月3日 上午10:37:00
     */
    public static String hideCardNo(String cardNo) {
        if(StringUtils.isBlank(cardNo)) {
            return cardNo;
        }
        int length = cardNo.length();
        int beforeLength = 4;
        int afterLength = 4;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++) {
            if(i < beforeLength || i >= (length - afterLength)) {
                sb.append(cardNo.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }

        return sb.toString();
    }

    /**
     * 方法描述 隐藏手机号中间位置字符，显示前三后四个字符
     * @param phoneNo
     * @return
     * @date 2018年4月3日 上午10:38:51
     */
    public static String hidePhoneNo(String phoneNo) {
        if(StringUtils.isBlank(phoneNo)) {
            return phoneNo;
        }
        int length = phoneNo.length();
        int beforeLength = 3;
        int afterLength = 4;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++) {
            if(i < beforeLength || i >= (length - afterLength)) {
                sb.append(phoneNo.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }
        return sb.toString();
    }


}
