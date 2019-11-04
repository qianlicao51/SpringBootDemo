package com.example.demo02.other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Demo01 {

    @Test
    public void downPic() throws Exception {
        URL url = new URL("http://meizitu.bitocean.cn/blog/typecho/006XNEY7gy1fss8lejg87j30b40go75f.jpg");
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get("d:/mzt2.jpg"));

        } catch (IOException e) {
            log.error("出现错误", e);
        }

    }
}
