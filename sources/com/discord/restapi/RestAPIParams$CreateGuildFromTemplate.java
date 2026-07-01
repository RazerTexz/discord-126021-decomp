package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$CreateGuildFromTemplate {
    private final String icon;
    private final String name;

    public RestAPIParams$CreateGuildFromTemplate(String str, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.icon = str2;
    }
}
