package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GuildMember$Companion {
    private RestAPIParams$GuildMember$Companion() {
    }

    public final RestAPIParams$GuildMember createWithChannelId(long channelId) {
        return new RestAPIParams$GuildMember(null, null, null, null, Long.valueOf(channelId), 15, null);
    }

    public final RestAPIParams$GuildMember createWithDeaf(boolean deaf) {
        return new RestAPIParams$GuildMember(null, null, null, Boolean.valueOf(deaf), null, 23, null);
    }

    public final RestAPIParams$GuildMember createWithMute(boolean mute) {
        return new RestAPIParams$GuildMember(null, null, Boolean.valueOf(mute), null, null, 27, null);
    }

    public final RestAPIParams$GuildMember createWithNick(String nick) {
        return new RestAPIParams$GuildMember(nick, null, null, null, null, 30, null);
    }

    public final RestAPIParams$GuildMember createWithRoles(List<Long> roles) {
        return new RestAPIParams$GuildMember(null, roles, null, null, null, 29, null);
    }

    public /* synthetic */ RestAPIParams$GuildMember$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
