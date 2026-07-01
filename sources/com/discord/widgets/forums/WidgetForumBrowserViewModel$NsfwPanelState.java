package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.user.NsfwAllowance;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumBrowserViewModel$NsfwPanelState {
    private final long guildId;
    private final boolean isChannelNsfw;
    private final boolean isNsfwUnconsented;
    private final NsfwAllowance nsfwAllowed;

    public WidgetForumBrowserViewModel$NsfwPanelState(boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
        this.isNsfwUnconsented = z2;
        this.isChannelNsfw = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.guildId = j;
    }

    public static /* synthetic */ WidgetForumBrowserViewModel$NsfwPanelState copy$default(WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetForumBrowserViewModel$NsfwPanelState.isNsfwUnconsented;
        }
        if ((i & 2) != 0) {
            z3 = widgetForumBrowserViewModel$NsfwPanelState.isChannelNsfw;
        }
        boolean z4 = z3;
        if ((i & 4) != 0) {
            nsfwAllowance = widgetForumBrowserViewModel$NsfwPanelState.nsfwAllowed;
        }
        NsfwAllowance nsfwAllowance2 = nsfwAllowance;
        if ((i & 8) != 0) {
            j = widgetForumBrowserViewModel$NsfwPanelState.guildId;
        }
        return widgetForumBrowserViewModel$NsfwPanelState.copy(z2, z4, nsfwAllowance2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsChannelNsfw() {
        return this.isChannelNsfw;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetForumBrowserViewModel$NsfwPanelState copy(boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
        return new WidgetForumBrowserViewModel$NsfwPanelState(isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumBrowserViewModel$NsfwPanelState)) {
            return false;
        }
        WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState = (WidgetForumBrowserViewModel$NsfwPanelState) other;
        return this.isNsfwUnconsented == widgetForumBrowserViewModel$NsfwPanelState.isNsfwUnconsented && this.isChannelNsfw == widgetForumBrowserViewModel$NsfwPanelState.isChannelNsfw && m.areEqual(this.nsfwAllowed, widgetForumBrowserViewModel$NsfwPanelState.nsfwAllowed) && this.guildId == widgetForumBrowserViewModel$NsfwPanelState.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        boolean z2 = this.isNsfwUnconsented;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
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
        StringBuilder sbU = a.U("NsfwPanelState(isNsfwUnconsented=");
        sbU.append(this.isNsfwUnconsented);
        sbU.append(", isChannelNsfw=");
        sbU.append(this.isChannelNsfw);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
