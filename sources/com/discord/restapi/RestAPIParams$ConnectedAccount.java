package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ConnectedAccount {
    public static final RestAPIParams$ConnectedAccount$Companion Companion = new RestAPIParams$ConnectedAccount$Companion(null);
    private final boolean friend_sync;
    private final String id;
    private final String name;
    private final boolean revoked;
    private final boolean show_activity;
    private final String type;
    private final boolean verified;
    private final int visibility;

    public RestAPIParams$ConnectedAccount(boolean z2, String str, String str2, boolean z3, boolean z4, String str3, boolean z5, int i) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(str3, "type");
        this.friend_sync = z2;
        this.id = str;
        this.name = str2;
        this.revoked = z3;
        this.show_activity = z4;
        this.type = str3;
        this.verified = z5;
        this.visibility = i;
    }
}
