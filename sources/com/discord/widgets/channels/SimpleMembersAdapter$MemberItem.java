package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SimpleMembersAdapter$MemberItem implements MGRecyclerDataPayload {
    public static final SimpleMembersAdapter$MemberItem$Companion Companion = new SimpleMembersAdapter$MemberItem$Companion(null);
    public static final int TYPE_MEMBER = 0;
    private final GuildMember guildMember;
    private final String key;
    private final int type;
    private final User user;

    public SimpleMembersAdapter$MemberItem(User user, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ SimpleMembersAdapter$MemberItem copy$default(SimpleMembersAdapter$MemberItem simpleMembersAdapter$MemberItem, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = simpleMembersAdapter$MemberItem.user;
        }
        if ((i & 2) != 0) {
            guildMember = simpleMembersAdapter$MemberItem.guildMember;
        }
        return simpleMembersAdapter$MemberItem.copy(user, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final SimpleMembersAdapter$MemberItem copy(User user, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        return new SimpleMembersAdapter$MemberItem(user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleMembersAdapter$MemberItem)) {
            return false;
        }
        SimpleMembersAdapter$MemberItem simpleMembersAdapter$MemberItem = (SimpleMembersAdapter$MemberItem) other;
        return m.areEqual(this.user, simpleMembersAdapter$MemberItem.user) && m.areEqual(this.guildMember, simpleMembersAdapter$MemberItem.guildMember);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
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
        StringBuilder sbU = a.U("MemberItem(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
