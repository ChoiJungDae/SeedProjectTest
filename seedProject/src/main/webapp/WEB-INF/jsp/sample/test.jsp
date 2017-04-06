<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table class="table_list">
		<colgroup>
			<col width="5%" style="border: 1px" />
		</colgroup>
			<tr>
				<th scope="col">ListID</th>
				<th scope="col">SENDER</th>				
				<th scope="col">REC_Name</th>
				<th scope="col">RECEIVED</th>
				<th scope="col">INST_DATE</th>
			</tr>
		<tbody>
			<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.listId       }</td>
							<td>${row.sender      }</td>
							<td>${row.recName     }</td>
							<td>${row.received     }</td>							
							<td>${row.instDate      }</td>
						</tr>
					</c:forEach>
		</tbody>
	</table>
