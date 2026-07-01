package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens$State;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$GuildInfo {
    private final boolean canManageEvents;
    private final Guild guild;
    private final long guildId;
    private final boolean isLurking;
    private final boolean isNsfwUnconsented;
    private final StoreGuildWelcomeScreens$State welcomeScreenState;

    public WidgetHomeViewModel$GuildInfo(long j, Guild guild, boolean z2, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State, boolean z3, boolean z4) {
        this.guildId = j;
        this.guild = guild;
        this.isLurking = z2;
        this.welcomeScreenState = storeGuildWelcomeScreens$State;
        this.isNsfwUnconsented = z3;
        this.canManageEvents = z4;
    }

    public static /* synthetic */ WidgetHomeViewModel$GuildInfo copy$default(WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo, long j, Guild guild, boolean z2, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State, boolean z3, boolean z4, int i, Object obj) {
        return widgetHomeViewModel$GuildInfo.copy((i & 1) != 0 ? widgetHomeViewModel$GuildInfo.guildId : j, (i & 2) != 0 ? widgetHomeViewModel$GuildInfo.guild : guild, (i & 4) != 0 ? widgetHomeViewModel$GuildInfo.isLurking : z2, (i & 8) != 0 ? widgetHomeViewModel$GuildInfo.welcomeScreenState : storeGuildWelcomeScreens$State, (i & 16) != 0 ? widgetHomeViewModel$GuildInfo.isNsfwUnconsented : z3, (i & 32) != 0 ? widgetHomeViewModel$GuildInfo.canManageEvents : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreGuildWelcomeScreens$State getWelcomeScreenState() {
        return this.welcomeScreenState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final WidgetHomeViewModel$GuildInfo copy(long guildId, Guild guild, boolean isLurking, StoreGuildWelcomeScreens$State welcomeScreenState, boolean isNsfwUnconsented, boolean canManageEvents) {
        return new WidgetHomeViewModel$GuildInfo(guildId, guild, isLurking, welcomeScreenState, isNsfwUnconsented, canManageEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeViewModel$GuildInfo)) {
            return false;
        }
        WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo = (WidgetHomeViewModel$GuildInfo) other;
        return this.guildId == widgetHomeViewModel$GuildInfo.guildId && m.areEqual(this.guild, widgetHomeViewModel$GuildInfo.guild) && this.isLurking == widgetHomeViewModel$GuildInfo.isLurking && m.areEqual(this.welcomeScreenState, widgetHomeViewModel$GuildInfo.welcomeScreenState) && this.isNsfwUnconsented == widgetHomeViewModel$GuildInfo.isNsfwUnconsented && this.canManageEvents == widgetHomeViewModel$GuildInfo.canManageEvents;
    }

    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final StoreGuildWelcomeScreens$State getWelcomeScreenState() {
        return this.welcomeScreenState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        Guild guild = this.guild;
        int iHashCode = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State = this.welcomeScreenState;
        int iHashCode2 = (i + (storeGuildWelcomeScreens$State != null ? storeGuildWelcomeScreens$State.hashCode() : 0)) * 31;
        boolean z3 = this.isNsfwUnconsented;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode2 + r2) * 31;
        boolean z4 = this.canManageEvents;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public final boolean isNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildInfo(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", welcomeScreenState=");
        sbU.append(this.welcomeScreenState);
        sbU.append(", isNsfwUnconsented=");
        sbU.append(this.isNsfwUnconsented);
        sbU.append(", canManageEvents=");
        return a.O(sbU, this.canManageEvents, ")");
    }
}
