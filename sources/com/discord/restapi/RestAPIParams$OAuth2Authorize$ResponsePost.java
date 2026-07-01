package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$OAuth2Authorize$ResponsePost {
    private final String location;

    public RestAPIParams$OAuth2Authorize$ResponsePost(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        this.location = str;
    }

    public final String getLocation() {
        return this.location;
    }
}
