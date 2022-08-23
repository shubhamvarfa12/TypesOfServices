import org.apache.ofbiz.entity.GenericEntityException;

def PersonRecordService() {
    result = [:];
        String partyId = (String) context.get("partyId");
        try {
            party = from("PersonEntity").where("partyId",partyId).queryOne();
            if(party==null) {
                personEntity = delegator.makeValue("PersonEntity");
                personEntity.setNextSeqId();
                personEntity.setPKFields(context);
                personEntity.setNonPKFields(context);
                personEntity = delegator.create(personEntity);
                partyId= personEntity.partyId;
            }else {
                party.contactMechId = (context.contactMechId);
                party.roleTypeId = (context.roleTypeId);
                party.firstName = (context.firstName);
                party.lastName = (context.lastName);
                party.emailAddress = (context.emailAddress);
                party.contactNumber = (context.contactNumber);
                party.address = (context.address);
                party.comments = (context.comments);
                party = delegator.store(party);
            }
               result.partyId = partyId;
               
            logInfo("========= This partyId use in update the record " +"created successfully with partyId: "+partyId);
    } catch (GenericEntityException e) {
        logError(e.getMessage());
        return error("Error in creating record in OfbizDemo entity ........");
    }
    return result;
} 
