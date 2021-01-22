package com.chaoxing.osm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName MyConfig
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 11:44
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "unit")
public class MyConfig {
    //读取上述的map嵌套list
    private Map<String,String> apps;
}
