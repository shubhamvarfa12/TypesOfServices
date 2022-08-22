package com.hotwax.ofbizdemo.service;
import java.util.*;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.util.EntityQuery;

public class PersonRecordService {
    public static final String module = PersonRecordService.class.getName();
    public static Map<String, Object> createPersonRecord(DispatchContext dctx, Map<String, ? extends Object> context) {
        Map<String, Object> result = ServiceUtil.returnSuccess();
        String partyId = (String) context.get("partyId");
        Debug.log("====================1partyId::"+partyId);
        Delegator delegator = dctx.getDelegator();
        try {
            GenericValue personEntity = delegator.makeValue("PersonEntity");
            GenericValue party = EntityQuery.use(delegator).from("Party").where("partyId",partyId).queryOne();
            if(party==null) {
                personEntity.setNextSeqId();
                personEntity.setPKFields(context);
            }else {
                personEntity.put("partyId",partyId);
            }
            personEntity.setNonPKFields(context);
            personEntity = delegator.createOrStore(personEntity);
            result.put("partyId", personEntity.getString("partyId"));
            Debug.log("===============This is my first Java Service implementation in Apache OFBiz "+personEntity.getString("partyId"));
        } catch (GenericEntityException e) {
            Debug.logError(e, module);
            return ServiceUtil.returnError("Error in creating record in OfbizDemo entity ........" +module);
        }
        return result;
    }
}
