<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.0</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="/css/font.css">
        <link rel="stylesheet" href="/css/xadmin.css">
    </head>
    <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">欢迎使用x-admin 后台模版！v2.0官方交流群： 519492808</blockquote>
            <fieldset class="layui-elem-field">
              <legend>我的首页</legend>
              <div class="layui-field-box">
                <table class="layui-table">
                <thead>
                    <tr>
                        <th colspan="3" scope="col">用户信息</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th width="20%">用户账户</th>
                        <td width="30%">${user.account}</td>
                        <td rowspan="4">图片</td>
                    </tr>
                    <tr>
                        <td>用户名</td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>住址</td>
                        <td>${user.address}</td>
                    </tr>
                    <tr>
                        <td>电话号码 </td>
                        <td>${user.phone}</td>
                    </tr>
                    <tr>
                        <td>简介 </td>
                        <td colspan="2">这是简介</td>
                    </tr>

                </tbody>
            </table>
              </div>
            </fieldset>
            <blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本后台系统由X前端框架提供前端技术支持。</blockquote>
            
        </div>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>