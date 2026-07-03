package com.discord.api.channel;

import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.nick, channelRecipient.nick) && this.channelId == channelRecipient.channelId && C12238m.areEqual(this.user, channelRecipient.user);
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
        StringBuilder sbM833U = C1643a.m833U("ChannelRecipient(nick=");
        sbM833U.append(this.nick);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", user=");
        sbM833U.append(this.user);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
