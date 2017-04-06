<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>   
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <%@ include file="/WEB-INF/include/include-header.jspf" %>
    <title>고객관리 로그인</title>
    <script type="text/javascript">
    $(function(){    	
    	$("#user_id").on("focus",function(){
    		$("#checkLogin").empty();
    		$(this).val('');
    		$("#password").val('');
    	});
    	
    	$("#password").on("focus",function(){
    		$("#checkLogin").empty();
    		$(this).val('');    		
    	});
    	
    	$("#LoginBtn").on("click",function(e){
    		e.preventDefault();
    		var userName = $("#user_id").val();
    		var userPass = $("#password").val();
    		$.ajax({
    			type:'post',
    			url:'../sample/UserLoginCheck.do',	    			
    			data : {
    				"userId" : userName,
    				"userPw" : userPass
    			},
    			success : function(data){    				
    				var msg = decodeURIComponent( data.replace(/\+/g, " ") );
    				if(msg=="success"){
    					window.location.href = "/seedProject/sample/openSampleList.do";
    				}else{
    					$("#checkLogin").html("<strong>"+msg+"</strong>").css("color","red");
    				}    				
				}
    		});
    	});    	
    });
    
    
    </script>
  </head>
  <body>
    <div class="container">
      <div class="row" style="text-align: center">
        <div class="page-header">
          <h2>Welcome!!</h2>
        </div>
        <div class="col-md-4 col-md-offset-4" >
          <div class="login-box well" align="center">
        <form id="loginForm">
            <legend>로그인</legend>
            <div class="form-group">
                <label for="username-email">아이디</label>
                <input name="user_id" value='' id="user_id" required placeholder="Username" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input name="password" id="password" value='' placeholder="Password" required type="password" class="form-control" />
            	<div id="checkLogin"></div>
            </div>
            <div class="form-group">
                <Button id="LoginBtn" class="btn btn-default btn-login-submit btn-block m-t-md" >Login</Button>
            </div>
            <div class="form-group">
                <a href="../sample/sampleWrite.do" class="btn btn-default btn-block m-t-md"> 회원가입</a>
            </div>
        </form>
          </div>
        </div>
      </div>
    </div>
<!--  
  jQuery (necessary for Bootstrap's JavaScript plugins)
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  Include all compiled plugins (below), or include individual files as needed
  <script src="js/bootstrap.min.js"></script> -->
  </body>
  </html>