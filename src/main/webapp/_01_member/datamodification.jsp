<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<! DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料更新</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<script type="text/javascript">
//由<body>的onLoad事件處理函數觸發此函數
function setFocusToUserId(){   
	 document.forms[0].mid.focus();   // 將游標放在mid欄位內
}
</script>
</head>
<body onLoad="setFocusToUserId()" >
<c:set var="funcName" value="REG" scope="session"/>
  <div align='center' id="content"> 
  
  <form method="POST" action="<c:url value='/_01_register/register.do' />" enctype='multipart/form-data'>
  
  <Table  style="width:900px ;background-color: #E7CDFF; cellspacing:0; border:2px solid black; " >
	<tr height="40" >
		<td colspan='4' style="text-align: center; vertical-align: middle;">
			<Font color="#006600" size='6' face="標楷體">${AppName}</Font>
		</td>
	</tr>
	<tr height="36" >		
        
		<td colspan='4' style="text-align: center; vertical-align: middle;">
        	<Font color="#006600" size='5' face="標楷體">加入會員</Font>
		</td>
	</tr>                    
    <tr height="16" >
    <td colspan='4'  style="text-align: center; vertical-align: middle;">
	    	<div class="error">${errorSaveData}<br>
	    	</div>
    </td>
    </tr>
       
     <tr height="52">
     	<td style="width: 90px;">
        	<label class="fontSize" >帳號：</label><br>&nbsp;
        </td>
        <td style="width: 290px;">
      		<input type='text' name='memberId' value="${param.memberId}" class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorIdEmpty}${MsgMap.errorIdDup}</font> 
      	</td>
      	<td>
      	 	<label class="fontSize" >姓名：</label><br>&nbsp;
      	</td>
      	<td>
      		<input type='text' name='name'  value="${param.name}" class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorName}</font>      
      	</td>
      <tr height="52">
        <td> 
      		<label class="fontSize" >密碼：</label><br>&nbsp;
      	</td>
      	<td>
      		<input type='text' name='password' class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorPasswordEmpty}${MsgMap.passwordError}</font> 
      	</td>
        <td>
      		<label class="fontSize" >密碼確認：</label><br>&nbsp;
      	</td>
      	<td>	
      		<input type='text' name='password1' class="fieldWidth" style="width: 200px;"/><br>&nbsp;
 			<font color="red" size="-1">${MsgMap.errorPassword1Empty}</font>       		      
      	</td>
      
     </tr>
     <tr height="52">
     	<td>
      		<label class="fontSize" >地址：</label><br>&nbsp;
      	</td>
      	<td>	
      		<input type='text' name='address' value="${param.address}"  class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorAddr}</font> 
        </td>
      	<td>
      		<label class="fontSize" >電話：</label><br>&nbsp;
      	</td>
      	<td>	
      		<input type='text' name='tel' value="${param.tel}" class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorTel}</font> 
		</td>
      </tr>
      <tr height="52">
      	<td>
      		<label class="fontSize" >電子郵件：</label><br>&nbsp;
      	</td>
      	<td>	
      		<input type='text' name='email' value="${param.email}"  class="fieldWidth" style="width: 200px;"/><br>&nbsp;
      		<font color="red" size="-1">${MsgMap.errorEmail}</font> 
      	</td>
      	<td>
      		<label class="fontSize" >照片：</label><br>&nbsp;
      	</td>
      	<td>	
      		<input name='memberMultipartFile' type='file' /><br>&nbsp;
        </td>
     </tr>
     <tr height="42">
        <td colspan='4'>
      		<div id="btnArea" align="center">
        	 	<input type="submit" name="submit" id="submit" value="儲存"/>
         		<input type="reset" name="cancel" id="cancel" value="重填">
      		</div>
		</td>
	</tr>
</Table>
</form>
</div>
</body>
</html>