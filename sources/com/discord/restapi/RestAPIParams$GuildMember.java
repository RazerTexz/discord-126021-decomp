package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GuildMember {
    public static final RestAPIParams$GuildMember$Companion Companion = new RestAPIParams$GuildMember$Companion(null);
    private final Long channelId;
    private final Boolean deaf;
    private final Boolean mute;
    private final String nick;
    private final List<Long> roles;

    public RestAPIParams$GuildMember() {
        this(null, null, null, null, null, 31, null);
    }

    public RestAPIParams$GuildMember(String str, List<Long> list, Boolean bool, Boolean bool2, Long l) {
        this.nick = str;
        this.roles = list;
        this.mute = bool;
        this.deaf = bool2;
        this.channelId = l;
    }

    public static final RestAPIParams$GuildMember createWithChannelId(long j) {
        return Companion.createWithChannelId(j);
    }

    public static final RestAPIParams$GuildMember createWithDeaf(boolean z2) {
        return Companion.createWithDeaf(z2);
    }

    public static final RestAPIParams$GuildMember createWithMute(boolean z2) {
        return Companion.createWithMute(z2);
    }

    public static final RestAPIParams$GuildMember createWithNick(String str) {
        return Companion.createWithNick(str);
    }

    public static final RestAPIParams$GuildMember createWithRoles(List<Long> list) {
        return Companion.createWithRoles(list);
    }

    public /* synthetic */ RestAPIParams$GuildMember(String str, List list, Boolean bool, Boolean bool2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : l);
    }
}
