package com.discord.utilities.lazy.memberlist;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum MemberListRow$StatusHeader$Type {
    ONLINE(0),
    OFFLINE(1);

    private final long id;

    MemberListRow$StatusHeader$Type(long j) {
        this.id = j;
    }

    public final long getId() {
        return this.id;
    }
}
