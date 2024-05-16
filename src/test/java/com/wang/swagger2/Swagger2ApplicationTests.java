package com.wang.swagger2;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.nio.file.Paths;

@SpringBootTest
class Swagger2ApplicationTests {

    @Test
    void contextLoads() {
    }

    // 生成api文档
    @Test
    public void generateMarkDown() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN) // 指定生成文档格式
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS) // 排序规则 一般用tags排序
                .withGeneratedExamples() // 生成HTTP请求和响应示例
                .withoutInlineSchema() // 参数内联
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs")) // 指定了生成静态部署文档的源头配置
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/asciidoc/generated")); // 指定最终生成文件的具体目录位置
        /**
         * 不想分割结果文件，也可以通过替换
         * toFolder(Paths.get("src/docs/asciidoc/generated")
         * 为toFile(Paths.get("src/docs/asciidoc/generated/all"))
         */
    }
}
