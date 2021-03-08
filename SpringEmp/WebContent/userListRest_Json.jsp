<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/js/json.min.js"></script>
<script type="text/javascript" >
	$(function(){
		userList();

		userSelect();
		
		userDelete();
		
		userInsert();
	
		userUpdate();
		
		init();
	});
	
	//초기화
	function init() {
		//초기화 버튼 클릭
		$('#btnInit').on('click',function(){
			$('#form1').each(function(){
				this.reset();
			});
		});
	}//init
	
	//사용자 삭제 요청
	function userDelete() {
		//삭제 버튼 클릭
		$('body').on('click','#btnDelete',function(){
			if(! confirm('삭제할까요?')) {
				return; // 아니면 밑의 구문 실행하지 않는다.
			}
			var tr = $(this).closest('tr');
			var userId = $(this).closest('tr').find('#hidden_userId').val();

				$.ajax({
					url:'user/'+userId,  
					type:'DELETE',
					//contentType:'application/json;charset=utf-8',          pathValue를 쓸거면 contentType은 쓸 필요 없다
					dataType:'json',
					error:function(xhr,status,msg){
						console.log("상태값 :" + status + " Http에러메시지 :"+msg);
					}, 
					success:function(response) {
						if(response.cnt == 1) {
							tr.remove();
						} else {
							alert('삭제오류');	
						}
					}
				});  
		}); //삭제 버튼 클릭
	}//userDelete
	
	//사용자 조회 요청
	function userSelect() {
		//조회 버튼 클릭
		$('body').on('click','#btnSelect',function(){ 							//#btnSelect: 그룹이벤트(실제로 이벤트가 발생하는 태그), 부모에 있는 클릭 이벤트가 실행
			var userId = $(this).closest('tr').find('#hidden_userId').val(); 	// val 값을 읽어온다
			//특정 사용자 조회, 읽어온 아디값으로 단건 조회
			$.ajax({
				url:'user/'+userId,
				type:'GET',
				contentType:'application/json;charset=utf-8', 					// 보낼 데이터가 json 타입, get 방식일때는 생략
				dataType:'json', 
				error:function(xhr,status,msg){
					alert("상태값 :" + status + " Http에러메시지 :"+msg);
				},
				success:userSelectResult 										// 서버에서 응답이 오면 해당 메소드 실행
			});
		}); //조회 버튼 클릭
	}//userSelect
	
	//사용자 조회 응답
	function userSelectResult(user) {
		$('input:text[name="id"]').val(user.id);
		$('input:text[name="name"]').val(user.name);
		$('input:text[name="password"]').val(user.password);
		$('select[name="role"]').val(user.role).attr("selected", "selected");
	}//userSelectResult
	
	//사용자 수정 요청
	function userUpdate() {
		//수정 버튼 클릭
		$('#btnUpdate').on('click',function(){ 							// 직접 이벤트를 실행
			// id 값을 가지고 tr 태그에서 처리한다.
			$.ajax({		
				url : "user",
				method : "PUT",
				data : JSON.stringify($('#form1').serializeObject()),
				contentType : "application/json", 						// 보낼 데이터 타입과 contentType이 서로 동일해야 한다.
				dataType : "json",
				success : function(response) {
					// 폼 필드 초기화
					document.form1.reset();
					// tr 태그 부분을 수정된 데이터로 교체(replace), 또는 데이터 전체 조회 
					// 기존 tr 태그와 교체
					var tr = makeTr(response);
					var oldTr = $('td:contains("'+ response.id +'")').parent(); // response가 넘겨받은 id 값이 td 태그에 포함 된다.
					oldTr.replaceWith(tr); 
					// oldTr의 id 값을 찾아서 new tr로 교체
					// filterContains 태그 안에 있는 단어가 있으면 contains를 실행한다.
					// contains(response.id) => true | false 를 리턴한다.
				}
			})
		});//수정 버튼 클릭
	}//userUpdate
	
	//사용자 등록 요청
	function userInsert(){
		//등록 버튼 클릭
		$('#btnInsert').on('click',function(){
			/* var param = {id: $('[name=id]').val(), 
						name: $('[name=name]').val(), 
						password: $('[name=password]').val(), 
						role: $('[name=role]').val()}; */ 				  // 제이슨 구조(=객체)로 생성
			
			$.ajax({
				url : 'user',
				method : 'post', 				 						  // post 방식의 url을 부를 것 이다.
				data : JSON.stringify($('#form1').serializeObject()), 	  // 넘겨줄 데이터, 넘겨 받을 때 스트링으로 변환
			    contentType : 'application/json', 						  // 보낼 데이터가 json -> @requestBody
				dataType : 'json', 				  						  // 응답 결과가 json = JSON.parse()
				success : function(response) { 							  // 다시 parsing -> 자바스크립트 객체로 변환
					console.table(response);
				}
				
			});
		});//등록 버튼 클릭
	}//userInsert
	
	//사용자 목록 조회 요청
	function userList() {
		$.ajax({
			url:'user',
			type:'GET',
			dataType:'json',
			error:function(xhr,status,msg){
				alert("상태값 :" + status + " Http에러메시지 :"+msg);
			},
			success:userListResult
		});
	}//userList
	
	//사용자 목록 조회 응답
	function userListResult(data) {
		$("tbody").empty();
		$.each(data,function(idx,item){
			var tr = makeTr(item);
			tr.appendTo('tbody');
		});//each
	}//userListResult
	
	function makeTr(item) {
		 return $('<tr>')
		.append($('<td>').html(item.id))
		.append($('<td>').html(item.name))
		.append($('<td>').html(item.password))
		.append($('<td>').html(item.role))
		.append($('<td>').html('<button id=\'btnSelect\'>조회</button>'))
		.append($('<td>').html('<button id=\'btnDelete\'>삭제</button>'))
		.append($('<input type=\'hidden\' id=\'hidden_userId\'>').val(item.id))
	}
</script>
</head>
<body>
<div class="container">
	<form id="form1"  name="form1" class="form-horizontal">
		<h2>사용자 등록 및 수정</h2>
		<div class="form-group">		
			<label >아이디:</label>
			<input type="text"  class="form-control" name="id" >
		</div>	
		<div class="form-group">
			<label>이름:</label>
			<input type="text"  class="form-control"  name="name" >
		</div>	
		<div class="form-group">
			<label>패스워드:</label>
			<input type="text"  class="form-control"  name="password" >
		</div>			
<!-- 		<div class="form-group">
			<label >성별:</label>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="남">남</label>
			</div>
			<div class="radio">
				<label><input type="radio"  name="gender"  value="여">여</label>
			</div>	
		</div>	 -->    
		<div class="form-group">   
			<label>역할:</label>
				<select class="form-control" name="role">
					   		<option value="Admin">관리자</option>
					   		<option value="User">사용자</option>
				</select>
		</div>  
		<div class="btn-group">      
				<input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
				<input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
				<input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
		</div>
	</form>
</div>		
<hr/>		
<div class="container">	
	<h2>사용자 목록</h2>
	<table class="table text-center">
		<thead>
		<tr>
			<th class="text-center">아이디</th>
			<th class="text-center">이름</th>
			<th class="text-center">성별</th>
			<th class="text-center">거주지</th>
		</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>	
</body>
</html>