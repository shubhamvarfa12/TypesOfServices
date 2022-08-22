<div class="screenlet-body">
  <form id="createPersonRecordByXmlService" method="post" action="<@ofbizUrl>createPersonRecordByXmlService</@ofbizUrl>">
    <input type="hidden" name="AddPersonRecordFTL" value="Y"/>
    <fieldset>
     <div>
        <span class="label">${uiLabelMap.PartyPartyId}</span>
        <input type="text" name="partyId" id="partyId"  maxlength="20" />
     </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoRoleTypeId}</span>
        <input type="text" name="roleTypeId" id="roleTypeId" class='required' maxlength="20" />*
      </div>
      <div>
          <span class="label">${uiLabelMap.OfbizDemoContactMechId}</span>
          <input type="text" name="contactMechId" id="contactMechId" class='required' maxlength="20" />*
      </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoFirstName}</span>
        <input type="text" name="firstName" id="firstName" class='required' maxlength="20" />
      </div>
      <div>
        <span class="label">${uiLabelMap.OfbizDemoLastName}</span>
        <input type="text" name="lastName" id="lastName" class='required' maxlength="20" />
      </div>
       <div>
              <span class="label">${uiLabelMap.EmailAddress}</span>
              <input type="text" name="emailAddress" id="emailAddress" maxlength="20" />
            </div>
      <div>
        <span class="label">${uiLabelMap.partyAllPhoneNumbers}</span>
        <input type="text" name="contactNumber" id="contactNumber" class='inputBox' size="60" maxlength="55" />
      </div>
       <div>
        <span class="label">${uiLabelMap.OfbizAddress}</span>
        <input type="text" name="address" id="address" class='inputBox' size="60" maxlength="55" />
      </div>
      <div>
        <span class="label">${uiLabelMap.PartyComments}</span>
        <input type="text" name="comments" id="comments" class='inputBox' size="60" maxlength="55" />
      </div>
    </fieldset>
   <br>&nbsp;&nbsp;<input type="submit" value="${uiLabelMap.CommonAdd}"/>
  </form>
</div>
