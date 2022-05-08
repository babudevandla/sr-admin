
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
  <h3 class="heading_b uk-margin-bottom">Add Category</h3>

  <div class="md-card">
      <div class="md-card-content large-padding">
          <form id="form_validation" action="${contextPath}/admin/add/language"  method="post" class="uk-form-stacked">
              <div class="uk-grid" data-uk-grid-margin>
                  <div class="uk-width-medium-1-2">
                      <div class="parsley-row">
                          <label for="fullname">Language Name <span class="req">*</span></label>
                          <input type="text" name="language" required class="md-input"   />
                      </div>
                  </div>
                 </div>
                <div class="md-card">
                 <div class="md-card-content"> 
                  <div class="uk-width-medium-1-3">
                    <h3 class="heading_a">Select Type</h3>
                    <div class="uk-grid" data-uk-grid-margin="">
                        <div class="uk-width-medium-1-3 uk-row-first">
                             <select name="type" style="width: 159px;" class="md-input" required="required">
                            	<option	value="">please select type</option>
                           		<option	value="TEXTSTATUS">TEXTSTATUS</option>
                           		<option	value="RINGTONE">RINGTONE</option>
                           		<option	value="HD_WALLPAPERS">HD WALLPAPERS</option>
                           		<option	value="MOBILE_WALLPAPERS">MOBILE WALLPAPERS</option>
                            </select>
                        </div>
                    </div>
                  </div>
            	</div>
            </div>	
             <div class="uk-grid">
                 <div class="uk-width-1-1">
                     <button type="submit" class="md-btn md-btn-primary">Submit</button>
                 </div>
             </div>
          </form>
        </div>
    </div>
</div>
        
 </jsp:body>
 </defaultTemplate:defaultDecorator>       