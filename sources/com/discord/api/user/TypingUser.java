package com.discord.api.user;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.m;

/* JADX INFO: compiled from: TypingUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TypingUser {
    private final long channelId;
    private final long guildId;
    private final GuildMember member;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TypingUser)) {
            return false;
        }
        TypingUser typingUser = (TypingUser) other;
        return this.userId == typingUser.userId && this.guildId == typingUser.guildId && this.channelId == typingUser.channelId && m.areEqual(this.member, typingUser.member);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.channelId;
        int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        GuildMember guildMember = this.member;
        return i2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TypingUser(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }
}
