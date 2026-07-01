package com.discord.restapi;

import b.i.d.j;
import b.i.d.l;
import b.i.d.m;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ChannelPosition$Serializer implements m<RestAPIParams$ChannelPosition> {
    @Override // b.i.d.m
    public /* bridge */ /* synthetic */ JsonElement serialize(RestAPIParams$ChannelPosition restAPIParams$ChannelPosition, Type type, l lVar) {
        return serialize2(restAPIParams$ChannelPosition, type, lVar);
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(RestAPIParams$ChannelPosition src, Type typeOfSrc, l context) {
        if (src == null || (!d0.z.d.m.areEqual(typeOfSrc, RestAPIParams$ChannelPosition.class))) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.i(ModelAuditLogEntry.CHANGE_KEY_ID, Long.valueOf(src.getId()));
        jsonObject.i(ModelAuditLogEntry.CHANGE_KEY_POSITION, Integer.valueOf(src.getPosition()));
        Long parentId = src.getParentId();
        if (parentId != null) {
            long jLongValue = parentId.longValue();
            if (jLongValue == -1) {
                jsonObject.a.put("parent_id", j.a);
            } else {
                jsonObject.i("parent_id", Long.valueOf(jLongValue));
            }
        }
        return jsonObject;
    }
}
