# html-to-docx

一个简单方式实现html转docx。

[Gitee码云仓库](https://gitee.com/youweics/html-to-docx)

**！！！注意！！！**

**本项目还未完成，第一个可使用版本将在2022-5-20发布，敬请期待** ❤️

# 快速上手

添加本项目的maven坐标到你的 `pom.xml`

```xml
<dependency>
    <groupId>com.terwergreen.lib</groupId>
    <artifactId>html-to-docx</artifactId>
    <version>1.0.0</version>
</dependency>
```

或者从发行版下载jar包添加到你项目的依赖中

然后，添加下面简单的的测试代码即可

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

或者更简单的代码

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

现在，打开终端输入命令，查看转换结果吧

```bash
cd /opt/tmp
open .
```

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

开始使用吧！

# doc

[文档](doc)

# 开发计划

* [X]  简单的文本转换
* [ ]  图片提取
* [ ]  超链接处理
* [ ]  解析有序列表和无序列表
* [ ]  标题1到标题6的处理
* [ ]  单个表格处理
* [ ]  跨行跨列复杂表格处理
* [ ]  水平线、加粗、换行处理
* [ ]  代码块、引用处理
* [ ]  远程抓取url，然后将返回的html作为输入
* [ ]  图标支持

# 贡献

欢迎各位一起开发，如果你想加入一起开发，可新建问题或者联系 youweics@163.com

# 捐赠

如果这个项目对你有用，你可以捐赠，让我买一杯咖啡。

## 支付宝

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/alipay.jpg" alt="alipay" style="width:280px;height:375px;" />

## 微信

<img src="https://cdn.jsdelivr.net/gh/terwer/upload/img/wechat.jpg" alt="wechat" style="width:280px;height:375px;" />

# 感谢

感谢第三方框架对本项目底层的支持


| Name              | version | vendor          |
| ------------------- | --------- | ----------------- |
| jdk               | 1.8+    | Oracle          |
| poi               | 4.0+    | apache          |
| jsoup             | 1.14.3  | Jonathan Hedley |
| commons-lang3     | 3.12.0  | apache          |
| commons-colltions | 4.2     | apache          |

联系我

作者: terwer

邮箱: [youweics@163.com](mailto:youweics@163.com)

博客: [http://terwergreeen.com](http://terwergreeen.com)
