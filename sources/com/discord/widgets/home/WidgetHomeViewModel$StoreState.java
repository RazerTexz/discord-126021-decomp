package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreUserConnections$State;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$StoreState {
    private final StoreUserConnections$State connectedAccountsState;
    private final long guildId;
    private final WidgetHomeViewModel$GuildInfo guildInfo;
    private final boolean isChannelNsfw;
    private final boolean isInEventsUpsellExperiment;
    private final boolean isThreadPeek;
    private final PanelState leftPanelState;
    private final MeUser me;
    private final NsfwAllowance nsfwAllowed;
    private final PanelState rightPanelState;

    public WidgetHomeViewModel$StoreState(PanelState panelState, PanelState panelState2, WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo, MeUser meUser, boolean z2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, long j, StoreUserConnections$State storeUserConnections$State) {
        m.checkNotNullParameter(panelState, "leftPanelState");
        m.checkNotNullParameter(panelState2, "rightPanelState");
        m.checkNotNullParameter(widgetHomeViewModel$GuildInfo, "guildInfo");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(storeUserConnections$State, "connectedAccountsState");
        this.leftPanelState = panelState;
        this.rightPanelState = panelState2;
        this.guildInfo = widgetHomeViewModel$GuildInfo;
        this.me = meUser;
        this.isThreadPeek = z2;
        this.isInEventsUpsellExperiment = z3;
        this.isChannelNsfw = z4;
        this.nsfwAllowed = nsfwAllowance;
        this.guildId = j;
        this.connectedAccountsState = storeUserConnections$State;
    }

    public static /* synthetic */ WidgetHomeViewModel$StoreState copy$default(WidgetHomeViewModel$StoreState widgetHomeViewModel$StoreState, PanelState panelState, PanelState panelState2, WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo, MeUser meUser, boolean z2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, long j, StoreUserConnections$State storeUserConnections$State, int i, Object obj) {
        return widgetHomeViewModel$StoreState.copy((i & 1) != 0 ? widgetHomeViewModel$StoreState.leftPanelState : panelState, (i & 2) != 0 ? widgetHomeViewModel$StoreState.rightPanelState : panelState2, (i & 4) != 0 ? widgetHomeViewModel$StoreState.guildInfo : widgetHomeViewModel$GuildInfo, (i & 8) != 0 ? widgetHomeViewModel$StoreState.me : meUser, (i & 16) != 0 ? widgetHomeViewModel$StoreState.isThreadPeek : z2, (i & 32) != 0 ? widgetHomeViewModel$StoreState.isInEventsUpsellExperiment : z3, (i & 64) != 0 ? widgetHomeViewModel$StoreState.isChannelNsfw : z4, (i & 128) != 0 ? widgetHomeViewModel$StoreState.nsfwAllowed : nsfwAllowance, (i & 256) != 0 ? widgetHomeViewModel$StoreState.guildId : j, (i & 512) != 0 ? widgetHomeViewModel$StoreState.connectedAccountsState : storeUserConnections$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StoreUserConnections$State getConnectedAccountsState() {
        return this.connectedAccountsState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetHomeViewModel$GuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsThreadPeek() {
        return this.isThreadPeek;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsInEventsUpsellExperiment() {
        return this.isInEventsUpsellExperiment;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsChannelNsfw() {
        return this.isChannelNsfw;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$StoreState copy(PanelState leftPanelState, PanelState rightPanelState, WidgetHomeViewModel$GuildInfo guildInfo, MeUser me2, boolean isThreadPeek, boolean isInEventsUpsellExperiment, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId, StoreUserConnections$State connectedAccountsState) {
        m.checkNotNullParameter(leftPanelState, "leftPanelState");
        m.checkNotNullParameter(rightPanelState, "rightPanelState");
        m.checkNotNullParameter(guildInfo, "guildInfo");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(connectedAccountsState, "connectedAccountsState");
        return new WidgetHomeViewModel$StoreState(leftPanelState, rightPanelState, guildInfo, me2, isThreadPeek, isInEventsUpsellExperiment, isChannelNsfw, nsfwAllowed, guildId, connectedAccountsState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeViewModel$StoreState)) {
            return false;
        }
        WidgetHomeViewModel$StoreState widgetHomeViewModel$StoreState = (WidgetHomeViewModel$StoreState) other;
        return m.areEqual(this.leftPanelState, widgetHomeViewModel$StoreState.leftPanelState) && m.areEqual(this.rightPanelState, widgetHomeViewModel$StoreState.rightPanelState) && m.areEqual(this.guildInfo, widgetHomeViewModel$StoreState.guildInfo) && m.areEqual(this.me, widgetHomeViewModel$StoreState.me) && this.isThreadPeek == widgetHomeViewModel$StoreState.isThreadPeek && this.isInEventsUpsellExperiment == widgetHomeViewModel$StoreState.isInEventsUpsellExperiment && this.isChannelNsfw == widgetHomeViewModel$StoreState.isChannelNsfw && m.areEqual(this.nsfwAllowed, widgetHomeViewModel$StoreState.nsfwAllowed) && this.guildId == widgetHomeViewModel$StoreState.guildId && m.areEqual(this.connectedAccountsState, widgetHomeViewModel$StoreState.connectedAccountsState);
    }

    public final StoreUserConnections$State getConnectedAccountsState() {
        return this.connectedAccountsState;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$GuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        PanelState panelState = this.leftPanelState;
        int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
        PanelState panelState2 = this.rightPanelState;
        int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
        WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo = this.guildInfo;
        int iHashCode3 = (iHashCode2 + (widgetHomeViewModel$GuildInfo != null ? widgetHomeViewModel$GuildInfo.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.isThreadPeek;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isInEventsUpsellExperiment;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isChannelNsfw;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iA = (b.a(this.guildId) + ((i3 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31)) * 31;
        StoreUserConnections$State storeUserConnections$State = this.connectedAccountsState;
        return iA + (storeUserConnections$State != null ? storeUserConnections$State.hashCode() : 0);
    }

    public final boolean isChannelNsfw() {
        return this.isChannelNsfw;
    }

    public final boolean isInEventsUpsellExperiment() {
        return this.isInEventsUpsellExperiment;
    }

    public final boolean isThreadPeek() {
        return this.isThreadPeek;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(leftPanelState=");
        sbU.append(this.leftPanelState);
        sbU.append(", rightPanelState=");
        sbU.append(this.rightPanelState);
        sbU.append(", guildInfo=");
        sbU.append(this.guildInfo);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", isThreadPeek=");
        sbU.append(this.isThreadPeek);
        sbU.append(", isInEventsUpsellExperiment=");
        sbU.append(this.isInEventsUpsellExperiment);
        sbU.append(", isChannelNsfw=");
        sbU.append(this.isChannelNsfw);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", connectedAccountsState=");
        sbU.append(this.connectedAccountsState);
        sbU.append(")");
        return sbU.toString();
    }
}
