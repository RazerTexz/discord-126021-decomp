package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Report {
    private final Long channelId;
    private final Long messageId;
    private final int reason;

    public RestAPIParams$Report(int i, Long l, Long l2) {
        this.reason = i;
        this.channelId = l;
        this.messageId = l2;
    }

    public /* synthetic */ RestAPIParams$Report(int i, Long l, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? null : l2);
    }
}
