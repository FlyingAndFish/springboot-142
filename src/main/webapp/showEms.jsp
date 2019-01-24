<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/17
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>--%>
    <script type="text/javascript">
        var uid="";
        $(function(){
            $('#userTable').datagrid({
                url:'${pageContext.request.contextPath}/ems/showAll',
                fitColumns:true,
                columns:[[
                    {field:'id',title:'id',width:1},
                    {field:'name',title:'Name',width:1},
                    {field:'tel',title:'tel',width:1},
                    {field:'address',title:'address',width:1},
                    {field:'birthday',title:'birthday',width:1},
                    {field:'operate',title:'operate',formatter:myFormatter},
                ]]
            });

            $("#addEmsForm").form({
                url:"${pageContext.request.contextPath}/ems/addEms",
                onSubmit:function(){
                    return $(this).form("validate");
                },
                success:function(data){
                    $('#userTable').datagrid("load");
                    $("#addEmsForm").form("reset");
                }
            });
            $("#addEmsFormName").textbox({
                required:true
            });
            $("#addEmsFormTel").textbox({
                required:true
            });
            $("#addEmsFormAddress").textbox({
                required:true
            });
            $("#addEmsFormBirthday").datebox({
                editable:false
            });

            $("#modifyDialog").dialog({
                title:"修改信息",
                width:300,
                height:200,
                modal:true,
                cache:false,
                closed:true,
                href:"${pageContext.request.contextPath}/modify.jsp"
            });
        });
        function myFormatter(value,row,index){
            return "<a href='javascript:void(0)' onclick='modify(\""+row.id+"\")'>修改</a> <a href='javascript:void(0)' onclick='del(\""+row.id+"\")'>删除</a>";
        }

        function modify(id) {
            uid=id;
            $("#modifyDialog").dialog("open");
        }
        function del(id) {
            $.post("${pageContext.request.contextPath}/ems/removeEms",{"id":id},function(){
                location.href="${pageContext.request.contextPath}/showEms.jsp";
            },"text");
        }

    </script>
</head>
<body>
    <form method="post" id="addEmsForm">
        名字<input id="addEmsFormName" name="name"><br/>
        电话<input id="addEmsFormTel" name="tel"><br/>
        地址<input id="addEmsFormAddress" name="address"><br/>
        生日<input id="addEmsFormBirthday" name="birthday"><br/>
        <input type="submit"><br/>
    </form>
    <hr/>
    <table id="userTable" border="1px"></table>
    <div id="modifyDialog"></div>
</body>
</html>
