package com.discord.widgets.stage;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCardSpeaker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageCardSpeaker {
    private final String displayName;
    private final GuildMember guildMember;
    private final User user;

    public StageCardSpeaker(User user, GuildMember guildMember) {
        String nick;
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        this.displayName = (guildMember == null || (nick = guildMember.getNick()) == null) ? user.getUsername() : nick;
    }

    public static /* synthetic */ StageCardSpeaker copy$default(StageCardSpeaker stageCardSpeaker, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = stageCardSpeaker.user;
        }
        if ((i & 2) != 0) {
            guildMember = stageCardSpeaker.guildMember;
        }
        return stageCardSpeaker.copy(user, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final StageCardSpeaker copy(User user, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        return new StageCardSpeaker(user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCardSpeaker)) {
            return false;
        }
        StageCardSpeaker stageCardSpeaker = (StageCardSpeaker) other;
        return m.areEqual(this.user, stageCardSpeaker.user) && m.areEqual(this.guildMember, stageCardSpeaker.guildMember);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StageCardSpeaker(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
