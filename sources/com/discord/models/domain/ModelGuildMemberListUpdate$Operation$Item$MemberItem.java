package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.guildmember.GuildMember;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Item$MemberItem extends ModelGuildMemberListUpdate$Operation$Item {
    private final GuildMember member;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelGuildMemberListUpdate$Operation$Item$MemberItem(GuildMember guildMember) {
        super(null);
        m.checkNotNullParameter(guildMember, "member");
        this.member = guildMember;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Item$MemberItem copy$default(ModelGuildMemberListUpdate$Operation$Item$MemberItem modelGuildMemberListUpdate$Operation$Item$MemberItem, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            guildMember = modelGuildMemberListUpdate$Operation$Item$MemberItem.member;
        }
        return modelGuildMemberListUpdate$Operation$Item$MemberItem.copy(guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    public final ModelGuildMemberListUpdate$Operation$Item$MemberItem copy(GuildMember member) {
        m.checkNotNullParameter(member, "member");
        return new ModelGuildMemberListUpdate$Operation$Item$MemberItem(member);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelGuildMemberListUpdate$Operation$Item$MemberItem) && m.areEqual(this.member, ((ModelGuildMemberListUpdate$Operation$Item$MemberItem) other).member);
        }
        return true;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    public int hashCode() {
        GuildMember guildMember = this.member;
        if (guildMember != null) {
            return guildMember.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberItem(member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }
}
