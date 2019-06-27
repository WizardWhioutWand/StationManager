<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap HelloWorld</title>

    <!-- Bootstrap -->


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <title>嘉科新能源水务</title>
    <script >
        function stationManager() {
            document.getElementById("mid-if").src="/web/findByPage";

        }
    </script>
</head>
<body>
<div style="width: 1200px;height: 800px;background-color: #0c5291">
    <div id="top" style="height: 90px;width: 100%;background-color: #31BA8E">
        <div></div>
    </div>
    <div id="mid" style="height: 600px;width: 100%;background-color: #8f9094">
        <div id="mid-left" style="width: 200px;height:100%;float: left;background-color: #343F4B">
            <ul class="mNav" id="menu">
                <li class="on" title="站点监控">
                    <a href="#">站点监控</a>

                    <ul class="sub hide_nav">
                        <li> <a href="/home/index">设备操作</a> </li>

                        <li> <a href="/Station/Vedio">实时视频</a> </li>
                    </ul>
                </li>
                <li title="运行报表">
                    <a href="#">运行报表</a>

                    <ul class="sub hide_nav">
                        <li> <a href="/Station/WaterQuanlityInput">水质检测录入</a> </li>
                        <li> <a href="/Station/TimeCheckRecord">考勤记录</a> </li>
                        <li> <a href="/Station/WaterQuanlityCheck">水质检测</a> </li>
                        <li> <a href="/Station/DeviceReport">设备运行报表</a> </li>
                    </ul>

                </li>
                <li title="警报管理">
                    <a href="#">警报管理</a>
                    <ul class="sub hide_nav">
                        <li> <a href="/Warning/Manage">告警管理</a> </li>


                    </ul>
                </li>

                <li title="站点管理">
                    <a href="#">站点管理</a>
                    <ul class="sub hide_nav">
                        <li> <a href="/Manager/StationReport">站点统计</a> </li>
                        <li> <a href="#" onclick="stationManager()">站点维护</a> </li>
                    </ul>
                </li>
            </ul>

        </div>
    <div id="mid-right" style="width: 980px;height:100%;float: left;background-color: #8f9094">
        <iframe id="mid-if" style="width: 100%;height: 100%" src="/web/findByPage">

        </iframe>
    </div>
        <div style="clear: both">

        </div>

    </div>
    <div id="bottom" style="height: 100px;width: 100%;background-color: #31BA8E">

    </div>
</div>
</body>
</html>
