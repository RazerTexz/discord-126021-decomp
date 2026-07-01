package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.user.NsfwAllowance;
import com.discord.panels.PanelState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$ViewState {
    private final long guildId;
    private final boolean isChannelNsfw;
    private final boolean isNsfwUnconsented;
    private final PanelState leftPanelState;
    private final NsfwAllowance nsfwAllowed;
    private final PanelState rightPanelState;

    public WidgetHomeViewModel$ViewState(PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
        m.checkNotNullParameter(panelState, "leftPanelState");
        m.checkNotNullParameter(panelState2, "rightPanelState");
        this.leftPanelState = panelState;
        this.rightPanelState = panelState2;
        this.isNsfwUnconsented = z2;
        this.isChannelNsfw = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHomeViewModel$ViewState copy$default(WidgetHomeViewModel$ViewState widgetHomeViewModel$ViewState, PanelState panelState, PanelState panelState2, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            panelState = widgetHomeViewModel$ViewState.leftPanelState;
        }
        if ((i & 2) != 0) {
            panelState2 = widgetHomeViewModel$ViewState.rightPanelState;
        }
        PanelState panelState3 = panelState2;
        if ((i & 4) != 0) {
            z2 = widgetHomeViewModel$ViewState.isNsfwUnconsented;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            z3 = widgetHomeViewModel$ViewState.isChannelNsfw;
        }
        boolean z5 = z3;
        if ((i & 16) != 0) {
            nsfwAllowance = widgetHomeViewModel$ViewState.nsfwAllowed;
        }
        NsfwAllowance nsfwAllowance2 = nsfwAllowance;
        if ((i & 32) != 0) {
            j = widgetHomeViewModel$ViewState.guildId;
        }
        return widgetHomeViewModel$ViewState.copy(panelState, panelState3, z4, z5, nsfwAllowance2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsChannelNsfw() {
        return this.isChannelNsfw;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$ViewState copy(PanelState leftPanelState, PanelState rightPanelState, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
        m.checkNotNullParameter(leftPanelState, "leftPanelState");
        m.checkNotNullParameter(rightPanelState, "rightPanelState");
        return new WidgetHomeViewModel$ViewState(leftPanelState, rightPanelState, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeViewModel$ViewState)) {
            return false;
        }
        WidgetHomeViewModel$ViewState widgetHomeViewModel$ViewState = (WidgetHomeViewModel$ViewState) other;
        return m.areEqual(this.leftPanelState, widgetHomeViewModel$ViewState.leftPanelState) && m.areEqual(this.rightPanelState, widgetHomeViewModel$ViewState.rightPanelState) && this.isNsfwUnconsented == widgetHomeViewModel$ViewState.isNsfwUnconsented && this.isChannelNsfw == widgetHomeViewModel$ViewState.isChannelNsfw && m.areEqual(this.nsfwAllowed, widgetHomeViewModel$ViewState.nsfwAllowed) && this.guildId == widgetHomeViewModel$ViewState.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final PanelState getLeftPanelState() {
        return this.leftPanelState;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final PanelState getRightPanelState() {
        return this.rightPanelState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        PanelState panelState = this.leftPanelState;
        int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
        PanelState panelState2 = this.rightPanelState;
        int iHashCode2 = (iHashCode + (panelState2 != null ? panelState2.hashCode() : 0)) * 31;
        boolean z2 = this.isNsfwUnconsented;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        boolean z3 = this.isChannelNsfw;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        return b.a(this.guildId) + ((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31);
    }

    public final boolean isChannelNsfw() {
        return this.isChannelNsfw;
    }

    public final boolean isNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(leftPanelState=");
        sbU.append(this.leftPanelState);
        sbU.append(", rightPanelState=");
        sbU.append(this.rightPanelState);
        sbU.append(", isNsfwUnconsented=");
        sbU.append(this.isNsfwUnconsented);
        sbU.append(", isChannelNsfw=");
        sbU.append(this.isChannelNsfw);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
