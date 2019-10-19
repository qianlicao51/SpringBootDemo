package com.example.demo02.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2HttpMessageConverter());
    }
    //TODO 没生效

    /**
     * 解决ie responsebody返回json的时候提示下载问题
     * https://blog.csdn.net/u010520912/article/details/80196710
     *
     * @return
     */
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        MediaType media = new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8"));
        supportedMediaTypes.add(media);
        jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
        return jsonConverter;
    }
}
