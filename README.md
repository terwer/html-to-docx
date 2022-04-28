# html-to-docx

a simply way for converting from html to docx.

[中文说明](README-zh.md) | [Gitee码云仓库](https://gitee.com/youweics/html-to-docx)

**！！！NOTICE！！！**

**This project is not finished yet, a first worked release may at 2022-5-20** ❤️

# quick start

Include lib to you `pom.xml`

```xml
<dependency>
    <groupId>com.terwergreen.lib</groupId>
    <artifactId>html-to-docx</artifactId>
    <version>1.0.0</version>
</dependency>
```

or download jatr lib from releases and add to your project's lib path

Then, write a simple code here

## linux/macOS

```java
import com.terwergreen.lib.converter.HtmlConverter;

public class Main {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        // change it to your own path
        String outpath = "/opt/tmp/test.docx";
        HtmlConverter converter = new HtmlConverter(html, outpath);
        converter.doConvert();
    }
}
```

or more shorter

```java
import com.terwergreen.lib.HtmlConverterUtil;

public class Main {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        // change it to your own path
        String outpath = "/opt/tmp/test.docx";
        HtmlConverterUtil.convert(html, outpath);
    }
}
```

now open termimel, type

```bash
cd /opt/tmp
open .
```

to see the result

## windows

```java
import com.terwergreen.lib.HtmlConverterUtil;

public class Main {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        // change it to your own path
        String outpath = "C:/test.docx";
        HtmlConverterUtil.convert(html, outpath);
    }
}
```

have fun!

# doc

[doc](doc)

# todo

* [X]  Simple converter for text only
* [ ]  Picture extracting
* [ ]  Hyperlinks processing
* [ ]  uls and ols parsing
* [ ]  Headings form h1 to h6 processing
* [ ]  Single table processing
* [ ]  Multi table processing
* [ ]  hr, strong, br rtc
* [ ]  code blocks, qoutes
* [ ]  fetch url with http/https as html input
* [ ]  chart support

# Contribute

contribute is welcome, please open a issue or email to youweics@163.com

# Donate

If this lib is helpful, you can donate me to buy a cup of coffee.

## Alipay

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/alipay.jpg" alt="alipay" style="width:280px;height:375px;" />

## Wechat

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/wechat.jpg" alt="wechat" style="width:280px;height:375px;" />

# Thanks

thanks third party libs to help making this lib work


| Name              | version | vendor |
| ------------------- | --------- | -------- |
| jdk               | 1.8+    | Oracle |
| poi               | 4.0+    | apache |
| jsoup             | 1.14.3  | jsoup  |
| commons-lang3     | 3.12.0  | apache |
| commons-colltions | 4.2     | apache |

# Contact me

Author: terwer

email: [youweics@163.com](mailto:youweics@163.com)

blog: [http://terwergreeen.com](http://terwergreeen.com)
