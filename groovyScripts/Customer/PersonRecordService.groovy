import org.apache.ofbiz.entity.GenericEntityException;

def PersonRecordService() {
    result = [:];
        String partyId = (String) context.get("partyId");
        try {
            personEntity = delegator.makeValue("PersonEntity");
            party = from("Party").where("partyId",partyId).queryOne();

            if(party==null) {
                personEntity.setNextSeqId();
                personEntity.setPKFields(context);
                Debug.log("=========================================" + personEntity.getString("firstName"));
            }else {
                personEntity.put("partyId",partyId);
            }
            personEntity.setNonPKFields(context);
            personEntity = delegator.createOrStore(personEntity);

        result.partyId = personEntity.partyId;
        logInfo("==========This is my first Groovy Service implementation in Apache OFBiz. OfbizDemo record " +"created successfully with ofbizDemoId: "+personEntity.getString("partyId"));
    } catch (GenericEntityException e) {
        logError(e.getMessage());
        return error("Error in creating record in OfbizDemo entity ........");
    }
    return result;
} 