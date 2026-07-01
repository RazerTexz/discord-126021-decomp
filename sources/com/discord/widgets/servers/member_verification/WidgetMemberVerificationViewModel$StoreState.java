package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildMemberVerificationForm$MemberVerificationFormData;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetMemberVerificationViewModel$StoreState {
    private final boolean allowAnimatedEmojis;
    private final Map<Long, String> channels;
    private final Guild guild;
    private final MeUser me;
    private final StoreGuildMemberVerificationForm$MemberVerificationFormData memberVerificationFormData;
    private final Map<Long, GuildRole> roles;

    public WidgetMemberVerificationViewModel$StoreState(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z2) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(map2, "roles");
        this.me = meUser;
        this.guild = guild;
        this.memberVerificationFormData = storeGuildMemberVerificationForm$MemberVerificationFormData;
        this.channels = map;
        this.roles = map2;
        this.allowAnimatedEmojis = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetMemberVerificationViewModel$StoreState copy$default(WidgetMemberVerificationViewModel$StoreState widgetMemberVerificationViewModel$StoreState, MeUser meUser, Guild guild, StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Map map, Map map2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = widgetMemberVerificationViewModel$StoreState.me;
        }
        if ((i & 2) != 0) {
            guild = widgetMemberVerificationViewModel$StoreState.guild;
        }
        Guild guild2 = guild;
        if ((i & 4) != 0) {
            storeGuildMemberVerificationForm$MemberVerificationFormData = widgetMemberVerificationViewModel$StoreState.memberVerificationFormData;
        }
        StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData2 = storeGuildMemberVerificationForm$MemberVerificationFormData;
        if ((i & 8) != 0) {
            map = widgetMemberVerificationViewModel$StoreState.channels;
        }
        Map map3 = map;
        if ((i & 16) != 0) {
            map2 = widgetMemberVerificationViewModel$StoreState.roles;
        }
        Map map4 = map2;
        if ((i & 32) != 0) {
            z2 = widgetMemberVerificationViewModel$StoreState.allowAnimatedEmojis;
        }
        return widgetMemberVerificationViewModel$StoreState.copy(meUser, guild2, storeGuildMemberVerificationForm$MemberVerificationFormData2, map3, map4, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreGuildMemberVerificationForm$MemberVerificationFormData getMemberVerificationFormData() {
        return this.memberVerificationFormData;
    }

    public final Map<Long, String> component4() {
        return this.channels;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final WidgetMemberVerificationViewModel$StoreState copy(MeUser me2, Guild guild, StoreGuildMemberVerificationForm$MemberVerificationFormData memberVerificationFormData, Map<Long, String> channels, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(roles, "roles");
        return new WidgetMemberVerificationViewModel$StoreState(me2, guild, memberVerificationFormData, channels, roles, allowAnimatedEmojis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetMemberVerificationViewModel$StoreState)) {
            return false;
        }
        WidgetMemberVerificationViewModel$StoreState widgetMemberVerificationViewModel$StoreState = (WidgetMemberVerificationViewModel$StoreState) other;
        return m.areEqual(this.me, widgetMemberVerificationViewModel$StoreState.me) && m.areEqual(this.guild, widgetMemberVerificationViewModel$StoreState.guild) && m.areEqual(this.memberVerificationFormData, widgetMemberVerificationViewModel$StoreState.memberVerificationFormData) && m.areEqual(this.channels, widgetMemberVerificationViewModel$StoreState.channels) && m.areEqual(this.roles, widgetMemberVerificationViewModel$StoreState.roles) && this.allowAnimatedEmojis == widgetMemberVerificationViewModel$StoreState.allowAnimatedEmojis;
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final Map<Long, String> getChannels() {
        return this.channels;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final StoreGuildMemberVerificationForm$MemberVerificationFormData getMemberVerificationFormData() {
        return this.memberVerificationFormData;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        MeUser meUser = this.me;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData = this.memberVerificationFormData;
        int iHashCode3 = (iHashCode2 + (storeGuildMemberVerificationForm$MemberVerificationFormData != null ? storeGuildMemberVerificationForm$MemberVerificationFormData.hashCode() : 0)) * 31;
        Map<Long, String> map = this.channels;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.roles;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(me=");
        sbU.append(this.me);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", memberVerificationFormData=");
        sbU.append(this.memberVerificationFormData);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", allowAnimatedEmojis=");
        return a.O(sbU, this.allowAnimatedEmojis, ")");
    }
}
