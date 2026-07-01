package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ChannelPermissionOverwrites {
    public static final RestAPIParams$ChannelPermissionOverwrites$Companion Companion = new RestAPIParams$ChannelPermissionOverwrites$Companion(null);
    private final Long allow;
    private final Long deny;
    private final String id;
    private final Integer type;

    private RestAPIParams$ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2) {
        this.type = num;
        this.id = str;
        this.allow = l;
        this.deny = l2;
    }

    public static final RestAPIParams$ChannelPermissionOverwrites createForMember(long j, Long l, Long l2) {
        return Companion.createForMember(j, l, l2);
    }

    public static final RestAPIParams$ChannelPermissionOverwrites createForRole(long j, Long l, Long l2) {
        return Companion.createForRole(j, l, l2);
    }

    public /* synthetic */ RestAPIParams$ChannelPermissionOverwrites(Integer num, String str, Long l, Long l2, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, l, l2);
    }
}
