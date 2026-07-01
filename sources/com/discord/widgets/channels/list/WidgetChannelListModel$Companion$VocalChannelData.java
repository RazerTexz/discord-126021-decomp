package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListModel$Companion$VocalChannelData {
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean locked;
    private final int mentionCount;
    private final boolean nsfw;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean textChannelSelected;
    private final boolean unread;
    private final boolean voiceChannelSelected;

    public WidgetChannelListModel$Companion$VocalChannelData(boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6, Long l, int i2, boolean z7, boolean z8) {
        this.voiceChannelSelected = z2;
        this.textChannelSelected = z3;
        this.mentionCount = i;
        this.unread = z4;
        this.locked = z5;
        this.nsfw = z6;
        this.permission = l;
        this.numUsersConnected = i2;
        this.isGuildRoleSubscriptionLockedChannel = z7;
        this.isGuildRoleSubscriptionChannel = z8;
    }

    public static /* synthetic */ WidgetChannelListModel$Companion$VocalChannelData copy$default(WidgetChannelListModel$Companion$VocalChannelData widgetChannelListModel$Companion$VocalChannelData, boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6, Long l, int i2, boolean z7, boolean z8, int i3, Object obj) {
        return widgetChannelListModel$Companion$VocalChannelData.copy((i3 & 1) != 0 ? widgetChannelListModel$Companion$VocalChannelData.voiceChannelSelected : z2, (i3 & 2) != 0 ? widgetChannelListModel$Companion$VocalChannelData.textChannelSelected : z3, (i3 & 4) != 0 ? widgetChannelListModel$Companion$VocalChannelData.mentionCount : i, (i3 & 8) != 0 ? widgetChannelListModel$Companion$VocalChannelData.unread : z4, (i3 & 16) != 0 ? widgetChannelListModel$Companion$VocalChannelData.locked : z5, (i3 & 32) != 0 ? widgetChannelListModel$Companion$VocalChannelData.nsfw : z6, (i3 & 64) != 0 ? widgetChannelListModel$Companion$VocalChannelData.permission : l, (i3 & 128) != 0 ? widgetChannelListModel$Companion$VocalChannelData.numUsersConnected : i2, (i3 & 256) != 0 ? widgetChannelListModel$Companion$VocalChannelData.isGuildRoleSubscriptionLockedChannel : z7, (i3 & 512) != 0 ? widgetChannelListModel$Companion$VocalChannelData.isGuildRoleSubscriptionChannel : z8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getTextChannelSelected() {
        return this.textChannelSelected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getLocked() {
        return this.locked;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getNsfw() {
        return this.nsfw;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public final WidgetChannelListModel$Companion$VocalChannelData copy(boolean voiceChannelSelected, boolean textChannelSelected, int mentionCount, boolean unread, boolean locked, boolean nsfw, Long permission, int numUsersConnected, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        return new WidgetChannelListModel$Companion$VocalChannelData(voiceChannelSelected, textChannelSelected, mentionCount, unread, locked, nsfw, permission, numUsersConnected, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListModel$Companion$VocalChannelData)) {
            return false;
        }
        WidgetChannelListModel$Companion$VocalChannelData widgetChannelListModel$Companion$VocalChannelData = (WidgetChannelListModel$Companion$VocalChannelData) other;
        return this.voiceChannelSelected == widgetChannelListModel$Companion$VocalChannelData.voiceChannelSelected && this.textChannelSelected == widgetChannelListModel$Companion$VocalChannelData.textChannelSelected && this.mentionCount == widgetChannelListModel$Companion$VocalChannelData.mentionCount && this.unread == widgetChannelListModel$Companion$VocalChannelData.unread && this.locked == widgetChannelListModel$Companion$VocalChannelData.locked && this.nsfw == widgetChannelListModel$Companion$VocalChannelData.nsfw && m.areEqual(this.permission, widgetChannelListModel$Companion$VocalChannelData.permission) && this.numUsersConnected == widgetChannelListModel$Companion$VocalChannelData.numUsersConnected && this.isGuildRoleSubscriptionLockedChannel == widgetChannelListModel$Companion$VocalChannelData.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == widgetChannelListModel$Companion$VocalChannelData.isGuildRoleSubscriptionChannel;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getNsfw() {
        return this.nsfw;
    }

    public final int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getTextChannelSelected() {
        return this.textChannelSelected;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    public final boolean getVoiceChannelSelected() {
        return this.voiceChannelSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        boolean z2 = this.voiceChannelSelected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.textChannelSelected;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (((i + r2) * 31) + this.mentionCount) * 31;
        boolean z4 = this.unread;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.locked;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.nsfw;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        Long l = this.permission;
        int iHashCode = (((i5 + (l != null ? l.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
        boolean z7 = this.isGuildRoleSubscriptionLockedChannel;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (iHashCode + r6) * 31;
        boolean z8 = this.isGuildRoleSubscriptionChannel;
        return i6 + (z8 ? 1 : z8);
    }

    public final boolean isGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final boolean isGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public String toString() {
        StringBuilder sbU = a.U("VocalChannelData(voiceChannelSelected=");
        sbU.append(this.voiceChannelSelected);
        sbU.append(", textChannelSelected=");
        sbU.append(this.textChannelSelected);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", unread=");
        sbU.append(this.unread);
        sbU.append(", locked=");
        sbU.append(this.locked);
        sbU.append(", nsfw=");
        sbU.append(this.nsfw);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", numUsersConnected=");
        sbU.append(this.numUsersConnected);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return a.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
