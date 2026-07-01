package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ChannelPosition {
    public static final RestAPIParams$ChannelPosition$Companion Companion = new RestAPIParams$ChannelPosition$Companion(null);
    public static final long PARENT_ID_NONE = -1;
    private final long id;
    private final Long parentId;
    private final int position;

    public RestAPIParams$ChannelPosition(long j, int i, Long l) {
        this.id = j;
        this.position = i;
        this.parentId = l;
    }

    public final long getId() {
        return this.id;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final int getPosition() {
        return this.position;
    }
}
