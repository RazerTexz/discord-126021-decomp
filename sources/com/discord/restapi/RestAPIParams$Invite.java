package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Invite {
    private final int maxAge;
    private final int maxUses;
    private final String regenerate;
    private final boolean temporary;

    public RestAPIParams$Invite(int i, int i2, boolean z2, String str) {
        this.maxAge = i;
        this.maxUses = i2;
        this.temporary = z2;
        this.regenerate = str;
    }
}
