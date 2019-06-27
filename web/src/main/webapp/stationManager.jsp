<%--
  Created by IntelliJ IDEA.
  User: Albert
  Date: 2019/6/25
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Title</title>
    <script  type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript"  src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript"  src="js/jquery.inputbox.js"></script>
    <script type="text/javascript"  src="js/jquery.pager.js"></script>
    <script type="text/javascript"  src="js/jquery.placeholder.js"></script>
    <script type="text/javascript"  src="js/jquery.Slide.2.1.1.js"></script>
    <script src="js/lhgdialog.min.js?skin=iblue"></script>

    <script>
        $(function () {
            // js 获取form表单
            var form_submit = document.getElementById('form-submit');
// js获取按钮
            var go = document.getElementById('delete');
// 当点击go时执行事件
            go.addEventListener('click',function(){
                // 动态给form表单设置请求位置
                form_submit.action="/web/DeleteStation";
                form_submit.active = "/web/DeleteStation";
                // 让form表单提交
                form_submit.submit()

        })
        });
        var editStation = function () {
            var dom = $("#waterdata input[type='checkbox']:checked");
            if (dom.length>1||dom.length==0) {
                $.dialog.alert("请选择一个站点修改!");
                return;
            } else {
                jQuery.dialog({
                    id: 'stAdd',
                    title: '修改站点', min: false, max: false, lock: true, width: '400px', height: '600px',zIndex:50,
                    content: 'url:/web/FindStationServlet?id=' + dom.eq(0).val()
                });
            }
        };
        function DeleteStation() {
            var dom = $("#waterdata input[type='checkbox']:checked");
            if (dom.length==0) {
                $.dialog.alert("请选择一个站点删除!");
                return;
            } else {

            }
        }
 function editStation2() {
     var dom = $("#waterdata input[type='checkbox']:checked");
     if (dom.length>1||dom.length==0) {
         $.dialog.alert("请选择一个站点修改!");
         return;
     } else {
         window.location.href="/web/FindStationServlet?id=" + dom.eq(0).val();
     }
 }
    </script>
</head>
<body >
<div style="width: 100%;height:100%;background-color: #31BA8E" >
    <div id="d1" style="width: 100%;height: 45px">
    <div id="d1-top" style="width: 100%;height: 20px" ><p>站点维护</p></div>
        <div id="d1-mid" style="width: 100%;height: 20px;background-color: #ffffe1">
            <div style="float: right"> <button type="button">查询</button>
                <a id="delete" href="#" >删除</a>
                <a id="add" href="/web/addstation.jsp" >添加</a>
                <a id="edit" href="#" onclick="editStation2()">编辑</a>
                <button type="button" onclick="editStation()">编辑</button></div>
         <div style="clear: both"></div>
        </div>
    </div>
    <div id="d2" style="width: 100%;height: 100%">
        <form id="form-submit" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="bdataGrid">
            <thead>
            <tr bgcolor="#ccffcc" style="font-size:12px;">
                <th height="35" style="text-align:left;padding-left:20px"> 站点创建时间</th>
                <th style="text-align:left">站点编号</th>
                <th style="text-align:left"> 站点区域</th>
                <th style="text-align:left">站点名称 </th>
                 <th style="text-align:left">站点描述</th>
               <th style="text-align:left">站点管理员</th>
                 <th style="text-align:left">站点日处理量</th>
                <th style="text-align:left">站点通信方式</th>
                <th style="text-align:left">站点经度</th>
                <th style="text-align:left">站点纬度</th>
                <th style="text-align:left">操作</th>
                </tr>
            </thead>
            <tbody id="waterdata">
            <c:forEach  items="${stations}" varStatus="s" var="i">
            <tr bgcolor="#ccffcc" style="font-size:12px;">
                <td height="35" style="text-align:left;padding-left:20px;"><input type="checkbox" name="station" value=${i.stationId} />
                    ${i.createTime}</td>
                <td style="text-align:left">
                ${i.stationNum}</td>
                <td style="text-align:left">
                        ${i.location}</td>
               <td style="text-align:left">
                        ${i.stationName}</td>
                <td style="text-align:left">
                        ${i.describe}
                    </td>
                <td style="text-align:left">
                        ${i.manager}
                    </td>
                 <td style="text-align:left">
                        ${i.handlingCapacityPerDay}
                    </td>
               <td style="text-align:left">
                        ${i.communicationMode}
                    </td>
                <td style="text-align:left">
                        ${ i.longitude}
                    </td>
                <td style="text-align:left">
                        ${i.latitude}
                     </td>
                <td style="text-align:left"><a href=\"/index.jsp\">配置设置</a>"
            </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
    </div>
</div>
</body>
</html>
