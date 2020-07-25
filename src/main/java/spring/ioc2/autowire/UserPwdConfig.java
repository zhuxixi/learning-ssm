package spring.ioc2.autowire;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhuzh
 * @date 2020.07.25
 */
@Configuration
public class UserPwdConfig {

    /**
     * 开启内存缓存
     */
    private boolean localCacheOn = true;
    /**
     * 缓存长度
     */
    private int cacheLength = 100;

    /**
     * 是否开启 校验用户名是否为纯数字
     */
    private boolean saleNoNumberCheckOn = true;
    /**
     * 校验用户名数字长度
     */
    private int saleNoMaxLength = 14;

    public boolean isLocalCacheOn() {
        return localCacheOn;
    }

    public void setLocalCacheOn(boolean localCacheOn) {
        this.localCacheOn = localCacheOn;
    }

    public int getCacheLength() {
        return cacheLength;
    }

    public void setCacheLength(int cacheLength) {
        this.cacheLength = cacheLength;
    }

    public boolean isSaleNoNumberCheckOn() {
        return saleNoNumberCheckOn;
    }

    public void setSaleNoNumberCheckOn(boolean saleNoNumberCheckOn) {
        this.saleNoNumberCheckOn = saleNoNumberCheckOn;
    }

    public int getSaleNoMaxLength() {
        return saleNoMaxLength;
    }

    public void setSaleNoMaxLength(int saleNoMaxLength) {
        this.saleNoMaxLength = saleNoMaxLength;
    }
}
