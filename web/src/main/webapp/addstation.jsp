<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 2019/6/26
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <script  type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript"  src="js/jquery.inputbox.js"></script>
    <script type="text/javascript"  src="js/jquery.pager.js"></script>
    <script type="text/javascript"  src="js/jquery.placeholder.js"></script>
    <script type="text/javascript"  src="js/jquery.Slide.2.1.1.js"></script>
    <script type="text/javascript" src="js/WdatePicker.js"></script>
    <script src="js/lhgdialog.min.js?skin=iblue"></script>
    <style type="text/css">
        .tabStyle {
            background-color: #0D75AE;
            font-size:14px;
            margin:0 auto;
        }
        .tabStyle tr {
            height:25px;
        }
        .tipSp {
            color:red;
            font-size:12px;
        }
    </style>
<script>
    function  checkinfo() {
        if ($("#txt_bianhao").val() == "") {
            $.dialog.alert("站点编号不能为空!");
            return false;
        }
        if ($("#txt_quyu").val() == "") {
            $.dialog.alert("区域不能为空!");
            return false;
        }
        if ($("#txt_name").val() == "") {
            $.dialog.alert("名称不能为空!");
            return false;
        }
        if ($("#txt_shijian").val() == "") {
            $.dialog.alert("创建时间不能为空!");
            return;
        }
        return true;
    }

    (function () {
        var checkPoint = function () {
            jQuery.dialog({
                id: 'mapPoint',
                title: '地图选点', min: false, max: false, lock: true, width: '760px', height: 460, zIndex: 100,
                content: 'url:/web/MapPoint.html'
            });
        };
    var cancelAdd = function(){
        window.location.href="/web/findByPage"
    }
        var checkDevice = function () {
            jQuery.dialog({
                id: 'checkDevice',
                title: '配置设备', min: false, max: false, lock: true, width: '400px', height:300, zIndex: 100,
                content: 'url:/Device/DeviceManage'
            });
        };

        return window.St = {
            cancelAdd:cancelAdd,
            checkPoint: checkPoint,
            checkDevice:checkDevice
        };
    })();

    $(function () {
        $("#btn_cancel").bind("click",window.St.cancelAdd);
        $("#checkPoint").bind("click", window.St.checkPoint);
        $("#setDevice").bind("click", window.St.checkDevice);
    });

</script>

</head>

</head>
<body>

<form id="form_add" action="${pageContext.request.contextPath}/updateServlet" method="post" onsubmit="return checkinfo()">
<input id="hidId" type="hidden" name="stationId" value="-1"  />
<table class="tabStyle">
    <tr>
        <td align="right">编号：</td>
        <td><input type="text" id="txt_bianhao" value="" name="stationNum" style="width:130px;"  /><span class="tipSp">&nbsp;*</span> </td>
    </tr>
    <tr>
        <td align="right">区域：</td>
        <td><input type="text" value="" name="location" id="txt_quyu" style="width:130px;"  /><span class="tipSp">&nbsp;*</span></td>
    </tr>
    <tr>
        <td align="right">名称：</td>
        <td><input type="text" value="" name="stationName" id="txt_name" style="width:130px;"  /><span class ="tipSp">&nbsp;*</span></td>
    </tr>

    <tr rowspan="2">
        <td align="right">描述：</td>
        <td><textarea value="" name="describe" id="txt_miaoshu" rows="2" cols="25" style="background-color:#e3e3e3"></textarea></td>
    </tr>
    <tr>
        <td align="right">日处理量：</td>
        <td><input value="" name="handlingCapacityPerDay" type="text" id="txt_rcll" style="width:130px"  /> </td>
    </tr>
    <tr>
        <td align="right">通讯方式：</td>
        <td><input type="text" value="" name="communicationMode" id="txt_txfs" style="width:150px"  /></td>
    </tr>
    <tr>
        <td align="right">经度：</td>
        <td><input type="text" value="" name="longitude" id="txt_long" style="width:90px;text-align:left"  /> </td><td rowspan="2"><span ><a id="checkPoint" class="abtn" style=" background-color: #266EEE;">地图选点</a></span></td>
    </tr>
    <tr>
        <td align="right">纬度：</td>
        <td><input type="text" value="" name="latitude" id="txt_lati" style="width:90px;text-align:left"  /> </td>
    </tr>
    <tr>
        <td align="right">创建时间：</td>
        <td><input type="date" value="" id="txt_shijian" name="createTime" style="width:130px;text-align:left" /></td>
    </tr>
    <tr>
        <td  style="line-height:40px">
        <input  id="btn_AddStation" type="submit" value="确认" style="width:80px"/>
    </td>
        <td   style="line-height:40px">
            <input  id="btn_cancel" type="button" value="取消" style="width:80px"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
