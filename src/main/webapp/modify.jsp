<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/1/18
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#modifyEmsForm").form("load","${pageContext.request.contextPath}/ems/showOne?id="+uid);
        $("#modifyEmsForm").form({
            url:"${pageContext.request.contextPath}/ems/modifyEms",
            onSubmit:function(){
                return $(this).form("validate");
            },
            success:function(data){
                $("#modifyDialog").dialog("close");
                $('#userTable').datagrid("load");
            }
        });
        $("#modifyEmsFormName").textbox({
            required:true
        });
        $("#modifyEmsFormTel").textbox({
            required:true
        });
        $("#modifyEmsFormAddress").textbox({
            required:true
        });
        $("#modifyEmsFormBirthday").datebox({
            editable:false
        });
    });
    
</script>
<form method="post" id="modifyEmsForm">
    <input type="hidden" name="id"><br/>
    名字<input id="modifyEmsFormName" name="name"><br/>
    电话<input id="modifyEmsFormTel" name="tel"><br/>
    地址<input id="modifyEmsFormAddress" name="address"><br/>
    生日<input id="modifyEmsFormBirthday" name="birthday"><br/>
    <input type="submit"><br/>
</form>
