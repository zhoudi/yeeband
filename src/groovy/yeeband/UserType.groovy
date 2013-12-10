package yeeband

/**
 * 用户类型,用来表示用户所属类别
 *
 * Date: 13-12-9
 * Time: 下午10:41
 * Author: judi.zhoud
 */
public enum UserType {

    /**
     * 普通注册用户
     */
    User('1'),

    /**
     * 翻译人员
     */
    Translator('2')


    private UserType(String id){
        this.id = id
    }
    final String id


    public String getValue() {
        return id;
    }

}