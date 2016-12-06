function gfn_isNull(str) {
	if (str == null)
		return true;
	if (str == "NaN")
		return true;
	if (new String(str).valueOf() == "undefined")
		return true;
	var chkStr = new String(str);
	if (chkStr.valueOf() == "undefined")
		return true;
	if (chkStr == null)
		return true;
	if (chkStr.toString().length == 0)
		return true;
	return false;
}

function ComSubmit(opt_formId) {
	this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
	this.url = "";

	if (this.formId == "commonForm") {
		$("#commonForm")[0].reset();
	}

	this.addParam = function addParam(key, value) {
		$("#" + this.formId).append(
				$("<input type='hidden' name='" + key + "' id='" + key
						+ "' value='" + value + "' >"));
	};

	this.submit = function submit() {
		var form = $("#" + this.formId)[0];
		form.action = this.url;
		form.method = "post";
		form.submit();
	};
}

function page_back() {
	history.go(-1)();
}
function blackList(row) {
	$("#body").empty();
	var html = '';
	html += '	<table class="table">                                 '
	html += '	<colgroup>                                            '
	html += '		<col width="5%" style="border: 1px" />            '
	html += '	</colgroup>                                           '
	html += '		<tr>                                              '
	html += '			<th scope="col">ListID</th>                   '
	html += '			<th scope="col">SENDER</th>				      '
	html += '			<th scope="col">REC_Name</th>                 '
	html += '			<th scope="col">RECEIVED</th>                 '
	html += '			<th scope="col">INST_DATE</th>                '
	html += '		</tr>                                             '
	html += '	<tbody>													'

	$.each(row, function(k, v) {
		html += '<tr>'
		html += '<td>' + v.listId + '</td>';
		html += '<td>' + v.sender + '</td>';
		html += '<td>' + v.recName + '</td>';
		html += '<td>' + v.received + '</td>';
		html += '<td>' + v.instDate + '</td>';
		html += "</tr>"
	});

	html += '	</tbody>                                              '
	html += '</table>'

	$("#body").html(html);

}
function fn_openSampleWrite(){
	location.href= 'sampleWrite.do';
}

function fn_sampleWrite() {
	var comSubmit = new ComSubmit("sampleWrite");
	comSubmit.url = "<c:url value='/sample/sampleWrite.do' />";
	comSubmit.submit();
}

function autocomplete(id,select) {
	$("#"+id).autocomplete({
		// 최소 몇자 이상되면 통신을 시작하겠다라는 옵션
		minLength : 2,
		matchContains: true,
		matchContains: false,
		autoFocus: true,
		source : function(request, response) {
			$.ajax({
				type : "post",
				url : "autoComplete.do",
				dataType : "json",
				data : {
					key : select,
					value : request.term
				},
				success : function(result) {					
					var data = result
					response(data);
				}
			})
		},
		// 자동완성 목록에서 특정 값 선택시 처리하는 동작 구현
		// 구현없으면 단순 text태그내에 값이 들어간다.
		select : function(event, ui) {
		}
	});
}

 /*페이징을 위한 Ajax*/
var gfv_ajaxCallback = "";
function ComAjax(opt_formId){
    this.url = "";      
    this.formId = gfn_isNull(opt_formId) == true ? "commonForm" : opt_formId;
    this.param = "";
     
    if(this.formId == "commonForm"){
        var frm = $("#commonForm");
        if(frm.length > 0){
            frm.remove();
        }
        var str = "<form id='commonForm' name='commonForm'></form>";
        $('#body').append(str);
    }
     
    this.setUrl = function setUrl(url){
        this.url = url;
    };
     
    this.setCallback = function setCallback(callBack){
        fv_ajaxCallback = callBack;
    };
 
    this.addParam = function addParam(key,value){ 
        this.param = this.param + "&" + key + "=" + value; 
    };
     
    this.ajax = function ajax(){
        if(this.formId != "commonForm"){
            this.param += "&" + $("#" + this.formId).serialize();
        }
        $.ajax({
            url : this.url,    
            type : "POST",   
            data : this.param,
            async : false, 
            success : function(data, status) {
                if(typeof(fv_ajaxCallback) == "function"){
                    fv_ajaxCallback(data);
                }
                else {
                    eval(fv_ajaxCallback + "(data);");
                }
            }
        });
    };
}

/*페이징 태그*/
var gfv_pageIndex = null;
var gfv_eventName = null;
function gfn_renderPaging(params){
    var divId = params.divId; //페이징이 그려질 div id
    gfv_pageIndex = params.pageIndex; //현재 위치가 저장될 input 태그
    var totalCount = params.totalCount; //전체 조회 건수
    var currentIndex = $("#"+params.pageIndex).val(); //현재 위치
    if($("#"+params.pageIndex).length == 0 || gfn_isNull(currentIndex) == true){
        currentIndex = 1;
    }
     
    var recordCount = params.recordCount; //페이지당 레코드 수
    if(gfn_isNull(recordCount) == true){
        recordCount = 20;
    }
    var totalIndexCount = Math.ceil(totalCount / recordCount); // 전체 인덱스 수
    gfv_eventName = params.eventName;
    $("#"+divId).empty();
    var preStr = "";
    var postStr = "";
    var str = "";
    var first = (parseInt((currentIndex-1) / 10) * 10) + 1;
    var last = (parseInt(totalIndexCount/10) == parseInt((currentIndex)/10)) ? totalIndexCount%10 : 10;
    var prev = (parseInt((currentIndex-1)/10)*10) - 9 > 0 ? (parseInt((currentIndex-1)/10)*10) - 9 : 1; 
    var next = (parseInt((currentIndex-1)/10)+1) * 10 + 1 < totalIndexCount ? (parseInt((currentIndex-1)/10)+1) * 10 + 1 : totalIndexCount;
    
    if(totalIndexCount > 10){ //전체 인덱스가 10이 넘을 경우, 맨앞, 앞 태그 작성
        preStr += "<a href='#this' class='btn_common_red_2' onclick='_movePage(1)'>[<<]</a>" +
                "<a href='#this' class='btn_common_red_2' onclick='_movePage("+prev+")'>[<]</a>";
    }
    else if(totalIndexCount <=10 && totalIndexCount > 1){ //전체 인덱스가 10보다 작을경우, 맨앞 태그 작성
        preStr += "<a href='#this' class='btn_common_red_2' onclick='_movePage(1)'>[<<]</a>";
    }
     
    if(totalIndexCount > 10){ //전체 인덱스가 10이 넘을 경우, 맨뒤, 뒤 태그 작성
        postStr += "<a href='#this' class='btn_common_red_2' onclick='_movePage("+next+")'>[>]</a>" +
                    "<a href='#this' class='btn_common_red_2' onclick='_movePage("+totalIndexCount+")'>[>>]</a>";
    }
    else if(totalIndexCount <=10 && totalIndexCount > 1){ //전체 인덱스가 10보다 작을경우, 맨뒤 태그 작성
        postStr += "<a href='#this' class='btn_common_red_2' onclick='_movePage("+totalIndexCount+")'>[>>]</a>";
    }
     
    for(var i=first; i<(first+last); i++){    	
        if(i != currentIndex){
            str += "<a href='#this' class='btn_common_red_2' onclick='_movePage("+i+")'>"+i+"</a>";
        }
        else{
            str += "<b><a href='#this' class='btn_common_red_2' onclick='_movePage("+i+")'>"+i+"</a></b>";
        }
    }
    $("#"+divId).append(preStr + str + postStr);
}

 
function _movePage(value){
    $("#"+gfv_pageIndex).val(value);
    $("#"+gfv_pageIndex).attr("class","active");
    if(typeof(gfv_eventName) == "function"){
    	gfv_eventName(value);
    }
    else {
        eval(gfv_eventName + "(value);");
    }
}

/*Alert 레이어*/
function msg(str){
	$("#popup").text(str).bPopup({
		autoClose: 1000
	})
}