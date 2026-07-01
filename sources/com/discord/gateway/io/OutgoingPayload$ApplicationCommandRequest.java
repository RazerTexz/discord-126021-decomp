package com.discord.gateway.io;

import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$ApplicationCommandRequest extends OutgoingPayload {
    private final boolean applications;
    private final List<String> commandIds;
    private final long guildId;
    private final Integer limit;
    private final String nonce;
    private final Integer offset;
    private final String query;

    public /* synthetic */ OutgoingPayload$ApplicationCommandRequest(long j, String str, Integer num, Integer num2, boolean z2, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z2, str2, (i & 64) != 0 ? null : list);
    }

    public final boolean getApplications() {
        return this.applications;
    }

    public final List<String> getCommandIds() {
        return this.commandIds;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final Integer getLimit() {
        return this.limit;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final String getQuery() {
        return this.query;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$ApplicationCommandRequest(long j, String str, Integer num, Integer num2, boolean z2, String str2, List<String> list) {
        super(null);
        m.checkNotNullParameter(str2, "nonce");
        this.guildId = j;
        this.query = str;
        this.offset = num;
        this.limit = num2;
        this.applications = z2;
        this.nonce = str2;
        this.commandIds = list;
    }
}
