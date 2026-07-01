package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$PostGuildEmoji {
    private final String image;
    private final String name;

    public RestAPIParams$PostGuildEmoji(String str, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "image");
        this.name = str;
        this.image = str2;
    }
}
