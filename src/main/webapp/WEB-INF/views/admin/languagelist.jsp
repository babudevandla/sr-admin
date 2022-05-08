<%@ page pageEncoding="ISO-8859-1"  contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@taglib prefix="defaultTemplate" tagdir="/WEB-INF/tags"%>
. 
<defaultTemplate:defaultDecorator>
<jsp:attribute name="title">Status Raja</jsp:attribute>
<jsp:body>

<div id="page_content_inner">
  <h4 class="heading_a uk-margin-bottom">Language List</h4>
  <div  align="right">
      <a class="md-btn md-btn-primary md-btn-wave-light waves-effect waves-button waves-light" href="${contextPath}/admin/add/language">Add Language</a>
  </div>
  <br/>
  <div class="md-card uk-margin-medium-bottom">
      <div class="md-card-content">
          <table id="dt_colVis" class="uk-table" cellspacing="0" width="100%">
              <thead>
              <tr>
               	  <th>Action</th>
                  <th>Language</th>
                  <th>Status</th>
              </tr>
              </thead>
              <tbody>
              	<c:forEach items="${languages}" var="language" varStatus="status">
	               <tr>
	                   <td>
	                   		<a href="#" class="ts_remove_row"><i class="md-icon material-icons">edit</i></a>
	                   		<a href="#" class="ts_remove_row"><i class="material-icons md-color-green-500 md-24">remove_red_eye</i></a>
	                   		<a href="#" class="ts_remove_row"><i class="md-icon material-icons">delete</i></a>
	                   </td>
	                   <td>${language.name}</td>
	                   <td>
	                   	<span class="uk-badge uk-badge-success">${language.enablestatus}</span>
	                   </td>
	               </tr>
              </c:forEach>
              </tbody>
          </table>
      </div>
  </div>
</div>
</jsp:body>
</defaultTemplate:defaultDecorator>