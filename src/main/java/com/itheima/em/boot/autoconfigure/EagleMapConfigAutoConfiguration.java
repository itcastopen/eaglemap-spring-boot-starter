package com.itheima.em.boot.autoconfigure;

import cn.itcast.em.sdk.EagleMapTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * EagleMap与SpringBoot整合
 *
 * @author zzj
 * @version 1.0
 * @date 2022/3/22
 */
@Configuration
@ConditionalOnClass(EagleMapTemplate.class)
@ConditionalOnProperty(prefix = "eagle", value = "enable", matchIfMissing = true)
@EnableConfigurationProperties(EagleMapProperties.class)
public class EagleMapConfigAutoConfiguration {

    @Resource
    private EagleMapProperties eagleMapProperties;

    @Bean
    @ConditionalOnMissingBean
    public EagleMapTemplate eagleMapTemplate() {
        return new EagleMapTemplate(this.eagleMapProperties.getHost(),
                this.eagleMapProperties.getPort(), this.eagleMapProperties.getTimeout());
    }

}
