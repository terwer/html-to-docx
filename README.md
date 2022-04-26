# html-to-docx

a simply way of converting from html to docx.

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

Then, write a simple code here

```java
String html = "<html><body><h1>Hello World</h1></body></html>";
String outpath = "/Users/terwer/Downloads/test.docx";
HtmlConverter converter = new HtmlConverter(html, outpath);
converter.convert();
```

have fun!

# doc

[doc](doc)

# todo

* [ ]  Simple converter for text only
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

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/alipay.jpg" alt="alipay" style="zoom:25%;" />

## Wechat

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/wechat.jpg" alt="wechat" style="zoom:25%;" />

# Thanks

thanks third party libs to help making this lib work


| Name              | version | vendor |
| ------------------- | --------- | -------- |
| jdk               | 1.8+    | Oracle |
| poi               | 4.0+    | apache |
| commons-lang      | 3.0     | apache |
| commons-colltions | 4.0     | apache |

# Contact me

Author: terwer

email: [youweics@163.com](mailto:youweics@163.com)

blog: [http://terwergreeen.com](http://terwergreeen.com)
