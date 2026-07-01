package com.discord.api.channel;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelRecipient.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ChannelRecipient {
    private final long channelId;
    private final String nick;
    private final User user;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelRecipient)) {
            return false;
        }
        ChannelRecipient channelRecipient = (ChannelRecipient) other;
        return Intrinsics3.areEqual(this.nick, channelRecipient.nick) && this.channelId == channelRecipient.channelId && Intrinsics3.areEqual(this.user, channelRecipient.user);
    }

    public int hashCode() {
        String str = this.nick;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.channelId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelRecipient(nick=");
        sbU.append(this.nick);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
